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
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.myap.tankstars.Control;

public class Loading_Screen implements Screen{
    private final Control ctrl;

    private Stage stage;

    private Image BackgroundImg;

    //private ImageButton Next_Button;

    public Loading_Screen(final Control ctrl)
    {
        this.ctrl = ctrl;
        this.stage = new Stage(new StretchViewport(Control.V_Width, Control.V_Height, ctrl.camera));
        Gdx.input.setInputProcessor(stage);

        Texture BackgroundTex = new Texture(Gdx.files.internal("img/main_screen.png"));
        BackgroundImg = new Image(BackgroundTex);
        BackgroundImg.setPosition(0, 0);
        BackgroundImg.setSize(stage.getWidth(), stage.getHeight());
    }

    @Override
    public void show() {
        stage.addActor(BackgroundImg);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();

        ctrl.batch.begin();
        ctrl.font.draw(ctrl.batch, "Click Anywhere to begin", stage.getWidth()/2-80, 100);
        ctrl.batch.end();

        if (Gdx.input.isTouched()) {
            ctrl.setScreen(new Home_Screen(ctrl));
            dispose();
        }

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
