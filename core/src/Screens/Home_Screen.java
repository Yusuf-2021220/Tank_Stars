package Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.myap.tankstars.Control;

public class Home_Screen implements Screen{
    private final Control ctrl;

    private Stage stage;

    private Image BackgroundImg;

    private Skin skin;

    private TextButton New_Game;

    private TextButton Load_Game;

    private TextButton Settings;

    private TextButton Exit;

    public Home_Screen(final Control ctrl)
    {
        this.ctrl = ctrl;
        this.stage = new Stage(new StretchViewport(Control.V_Width, Control.V_Height, ctrl.camera));
        Gdx.input.setInputProcessor(stage);

        this.skin = new Skin(Gdx.files.internal("ui/star-soldier/skin/star-soldier-ui.json"));

        Texture BackgroundTex = new Texture(Gdx.files.internal("img/background_for_buttons.png"));
        BackgroundImg = new Image(BackgroundTex);
        BackgroundImg.setPosition(0, 0);
        BackgroundImg.setSize(stage.getWidth(), stage.getHeight());

        New_Game = new TextButton("New Game", skin);
        New_Game.setSize(300, 100);
        New_Game.setPosition(stage.getWidth()/2-100, stage.getHeight()/2 + 100);

        Load_Game = new TextButton("Load Game", skin);
        Load_Game.setSize(300, 100);
        Load_Game.setPosition(stage.getWidth()/2-100, stage.getHeight()/2);

        Settings = new TextButton("Settings", skin);
        Settings.setSize(300, 100);
        Settings.setPosition(stage.getWidth()/2-100, stage.getHeight()/2 - 100);

        Exit = new TextButton("Exit", skin);
        Exit.setSize(300, 100);
        Exit.setPosition(stage.getWidth()/2-100, stage.getHeight()/2 - 200);
    }

    @Override
    public void show() {
        stage.addActor(BackgroundImg);
        stage.addActor(New_Game);
        stage.addActor(Load_Game);
        stage.addActor(Settings);
        stage.addActor(Exit);

        New_Game.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new Choosing_Tank_Screen(ctrl));
            }
        });

        Load_Game.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new Load_Screen(ctrl));
            }
        });

        Settings.addListener(new ClickListener()
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
                Gdx.app.exit();
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
