package com.castlewars.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.castlewars.CastleWars;
import com.castlewars.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = (int )Constants.WIDTH;
		config.height = (int) Constants.HEIGHT;
		new LwjglApplication(new CastleWars(), config);
	}
}
