package com.myap.tankstars;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.myap.tankstars.Control;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle(Control.Title + Control.Version);
		config.setWindowedMode(Control.V_Width, Control.V_Height);
		new Lwjgl3Application(new Control(), config);
	}
}
