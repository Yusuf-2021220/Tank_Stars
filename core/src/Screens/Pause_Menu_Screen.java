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

public class Pause_Menu_Screen implements Screen{
    private final Control ctrl;

    private Stage stage;

    private Image BackgroundImg;

    private Skin skin;

    private TextButton Resume;// resume

    private TextButton Save; // save

    private TextButton Exit;  //exit


    public Pause_Menu_Screen(final Control ctrl)
    {
        this.ctrl = ctrl;
        this.stage = new Stage(new StretchViewport(Control.V_Width, Control.V_Height, ctrl.camera));
        Gdx.input.setInputProcessor(stage);

        this.skin = new Skin(Gdx.files.internal("ui/star-soldier/skin/star-soldier-ui.json"));

        Texture BackgroundTex = new Texture(Gdx.files.internal("img/load_screen.png"));
        BackgroundImg = new Image(BackgroundTex);
        BackgroundImg.setPosition(0, 0);
        BackgroundImg.setSize(stage.getWidth(), stage.getHeight());

        Resume = new TextButton("Resume", skin);
        Resume.setSize(300, 100);
        Resume.setPosition(stage.getWidth()/2-150, stage.getHeight()/2 + 200);

        Save = new TextButton("Save", skin);
        Save.setSize(300, 100);
        Save.setPosition(stage.getWidth()/2-150, stage.getHeight()/2 + 100);

        Exit = new TextButton("Exit", skin);
        Exit.setSize(300, 100);
        Exit.setPosition(stage.getWidth()/2-150, stage.getHeight()/2);
    }

    @Override
    public void show() {
        stage.addActor(BackgroundImg);
        stage.addActor(Resume);
        stage.addActor(Save);
        stage.addActor(Exit);

        Resume.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                ((Game)Gdx.app.getApplicationListener()).setScreen( new Game_Dynamic_Screen(ctrl));
            }
        });
        Save.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
            }
        });
        Exit.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                ((Game)Gdx.app.getApplicationListener()).setScreen( new Home_Screen(ctrl));
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