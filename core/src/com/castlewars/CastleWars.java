package com.castlewars;

import com.badlogic.gdx.Game;
import com.castlewars.screens.BaseScreen;
import com.castlewars.screens.GameScreenObserver;
import com.castlewars.screens.MenuScreen;
import com.castlewars.screens.PlayScreen;

public class CastleWars extends Game {
	public BaseScreen menuScreen;
	public GameScreenObserver  playScreen;


	@Override
	public void create () {
		menuScreen = new MenuScreen(this);
		playScreen = new PlayScreen(this);
		setScreen(menuScreen);
	}


	public BaseScreen getMenuScreen() {
		return menuScreen;
	}

	public void setMenuScreen(BaseScreen menuScreen) {
		this.menuScreen = menuScreen;
	}

	public GameScreenObserver getPlayScreen() {
		return playScreen;
	}

	public void setPlayScreen(GameScreenObserver playScreen) {
		this.playScreen = playScreen;
	}

	public void startGame(){

	}


}
