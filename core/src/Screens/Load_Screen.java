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

public class Load_Screen implements Screen{
    private final Control ctrl;

    private Stage stage;

    private Image BackgroundImg;

    private Skin skin;

    private TextButton Game1;

    private TextButton Game2;

    private TextButton Game3;

    private TextButton Game4;

    private TextButton Game5;

    private ImageButton Back_Img;


    public Load_Screen(final Control ctrl)
    {
        this.ctrl = ctrl;
        this.stage = new Stage(new StretchViewport(Control.V_Width, Control.V_Height, ctrl.camera));
        Gdx.input.setInputProcessor(stage);

        this.skin = new Skin(Gdx.files.internal("ui/star-soldier/skin/star-soldier-ui.json"));

        Texture BackgroundTex = new Texture(Gdx.files.internal("img/load_screen.png"));
        BackgroundImg = new Image(BackgroundTex);
        BackgroundImg.setPosition(0, 0);
        BackgroundImg.setSize(stage.getWidth(), stage.getHeight());

        Game1 = new TextButton("Game 1", skin);
        Game1.setSize(300, 100);
        Game1.setPosition(stage.getWidth()/2-150, stage.getHeight()/2 + 200);

        Game2 = new TextButton("Game 2", skin);
        Game2.setSize(300, 100);
        Game2.setPosition(stage.getWidth()/2-150, stage.getHeight()/2 + 100);

        Game3 = new TextButton("Game 3", skin);
        Game3.setSize(300, 100);
        Game3.setPosition(stage.getWidth()/2-150, stage.getHeight()/2);

        Game4 = new TextButton("Game 4", skin);
        Game4.setSize(300, 100);
        Game4.setPosition(stage.getWidth()/2-150, stage.getHeight()/2 -100);

        Game5 = new TextButton("Game 5", skin);
        Game5.setSize(300, 100);
        Game5.setPosition(stage.getWidth()/2-150, stage.getHeight()/2 -200);

        Back_Img = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("img/back.jpg"))));
        Back_Img.setSkin(skin);
        Back_Img.setSize(40, 40);
        Back_Img.setPosition(50, stage.getHeight()-100);
    }

    @Override
    public void show() {
        stage.addActor(BackgroundImg);
        stage.addActor(Game1);
        stage.addActor(Game2);
        stage.addActor(Game3);
        stage.addActor(Game4);
        stage.addActor(Game5);
        stage.addActor(Back_Img);

        Back_Img.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new Home_Screen(ctrl));
            }
        });

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
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
