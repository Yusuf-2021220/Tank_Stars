package Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.myap.tankstars.Control;
import utils.TiledObjectUtill;

public class Game_Dynamic_Screen implements Screen {
    private final Control ctrl;
    private Stage stage;

    private ImageButton Back_Img;

    private Skin skin;

    private TextButton Fire;

    private World world;
    private Box2DDebugRenderer b2dr;
    private Body Player1 , Player2;
    private Texture Texture1, Texture2;
    private TiledMap map;
    private OrthogonalTiledMapRenderer tmr;

    private boolean flip;

    public Game_Dynamic_Screen(final Control ctrl)
    {
        this.ctrl = ctrl;

        this.stage = new Stage(new StretchViewport(Control.V_Width, Control.V_Height, ctrl.camera));
        Gdx.input.setInputProcessor(stage);

        this.skin = new Skin(Gdx.files.internal("ui/star-soldier/skin/star-soldier-ui.json"));

        Back_Img = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("img/back.jpg"))));
        Back_Img.setSkin(skin);
        Back_Img.setSize(40, 40);
        Back_Img.setPosition(50, stage.getHeight()-100);

        Fire = new TextButton("Fire", skin);
        Fire.setSize(180, 100);
        Fire.setPosition(stage.getWidth()-200, stage.getHeight()/2-150);

        world = new World(new Vector2(0f, -25f), false);
        b2dr = new Box2DDebugRenderer();

        map = new TmxMapLoader().load("Maps/groundlast.tmx");
        tmr = new OrthogonalTiledMapRenderer(map);
        TiledObjectUtill.parseTiledObjectLayer(world, map.getLayers().get("Object Layer 1").getObjects());

        Player1 =  createBox(500, 400, 200, 200, 1, true);
        Player2 =  createBox(1000, 400, 200, 200, 1, true);

        Texture1 = new Texture("Img/Tank1.png");
        Texture2 = new Texture("Img/Tank3.png");
        flip = true;
    }

    @Override
    public void show() {
        stage.addActor(Back_Img);
        stage.addActor(Fire);
        Fire.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                flip = !flip;
            }
        });

        Back_Img.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new Pause_Menu_Screen(ctrl));
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();

        ctrl.batch.begin();
        ctrl.batch.draw(Texture1, Player1.getPosition().x - 100, Player1.getPosition().y -100, 200, 200);
        ctrl.batch.draw(Texture2, Player2.getPosition().x -100, Player2.getPosition().y -100, 200, 200);
        ctrl.batch.end();

        b2dr.render(world, ctrl.camera.combined);
        tmr.render();
        update(delta);
    }

    private void update(float delta) {
        stage.act(delta);

        world.step(1/60f, 6, 2);
        tmr.setView(ctrl.camera);
        inputUpdate(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        world.dispose();
        b2dr.dispose();
        tmr.dispose();
        map.dispose();
    }

    public void inputUpdate(float delta)
    {
        int velocity = 0;
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            velocity-=1;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            velocity +=1;
        }

        if(flip)
            Player1.setLinearVelocity(velocity * 50, Player1.getLinearVelocity().y);
        else
            Player2.setLinearVelocity(velocity * 50, Player2.getLinearVelocity().y);
    }

    public Body createBox(int x, int y,  int width, int height, int type, boolean rotation){
        Body pBody;
        BodyDef def = new BodyDef();
        if(type==0)
            def.type = BodyDef.BodyType.StaticBody;
        else if(type==1)
            def.type = BodyDef.BodyType.DynamicBody;
        else
            def.type = BodyDef.BodyType.KinematicBody;

        def.position.set(x, y);
        def.fixedRotation = rotation;
        pBody = world.createBody(def);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width/2, height/2);

        pBody.createFixture(shape, 1.0f);
        shape.dispose();
        return pBody;
    }
}
