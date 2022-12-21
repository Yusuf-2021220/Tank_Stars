package com.myap.tankstars;

import Screens.Loading_Screen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public class Control extends Game {

	public static final String Title = "Tank Stars";
	public static final float Version = 0.1f;
	public static final int V_Width = 1900;
	public static final int V_Height = 900;

	public OrthographicCamera camera;
	public SpriteBatch batch;

	public BitmapFont font;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 700, 1000);

		this.setScreen(new Loading_Screen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
