package Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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

public class Choosing_Tank_Screen2 implements Screen{
    private final Control ctrl;

    private Stage stage;

    private Image BackgroundImg;

    private Skin skin;

    private ImageButton Tank1_Img;
    private ImageButton Tank2_Img;
    private ImageButton Tank3_Img;
    private ImageButton Back_Img;

    public Choosing_Tank_Screen2(final Control ctrl)
    {
        this.ctrl = ctrl;
        this.stage = new Stage(new StretchViewport(Control.V_Width, Control.V_Height, ctrl.camera));
        Gdx.input.setInputProcessor(stage);

        this.skin = new Skin(Gdx.files.internal("ui/star-soldier/skin/star-soldier-ui.json"));

        Texture BackgroundTex = new Texture(Gdx.files.internal("img/Choosing_Tanks.jpg"));
        BackgroundImg = new Image(BackgroundTex);
        BackgroundImg.setPosition(0, 0);
        BackgroundImg.setSize(stage.getWidth(), stage.getHeight());

        Tank1_Img = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("img/Tank1.png"))));
        Tank1_Img.setSkin(skin);
        Tank1_Img.setSize(400, 700);
        Tank1_Img.setPosition(100, 0);

        Tank2_Img = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("img/Tank2.png"))));
        Tank2_Img.setSkin(skin);
        Tank2_Img.setSize(400, 700);
        Tank2_Img.setPosition(700, 0);

        Tank3_Img = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("img/Tank3.png"))));
        Tank3_Img.setSkin(skin);
        Tank3_Img.setSize(400, 700);
        Tank3_Img.setPosition(1200, 0);

        Back_Img = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("img/back.jpg"))));
        Back_Img.setSkin(skin);
        Back_Img.setSize(40, 40);
        Back_Img.setPosition(50, stage.getHeight()-100);
    }

    @Override
    public void show() {
        stage.addActor(BackgroundImg);
        stage.addActor(Tank1_Img);
        stage.addActor(Tank2_Img);
        stage.addActor(Tank3_Img);
        stage.addActor(Back_Img);

        Tank1_Img.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new Game_Dynamic_Screen(ctrl));
            }
        });

        Tank2_Img.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new Game_Dynamic_Screen(ctrl));
            }
        });

        Tank3_Img.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new Game_Dynamic_Screen(ctrl));
            }
        });

        Back_Img.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new Choosing_Tank_Screen2(ctrl));
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        ctrl.batch.begin();
        ctrl.font.draw(ctrl.batch, "Choose Tank for Player 2", stage.getWidth() /2, stage.getHeight()-100);
        ctrl.batch.end();
        update(delta);
    }

    private void update(float delta) {
        stage.act(delta);
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

    }
}
