package com.castlewars.screens;

import com.badlogic.gdx.Screen;
import com.castlewars.CastleWars;
import com.castlewars.actors.KnightActor;
import com.castlewars.behavior.Memento.Caretaker;

import java.util.HashMap;

/**
 * Created by Daniel Gutierrez on 7/05/2017.
 */

public abstract class BaseScreen implements Screen {

    protected CastleWars game;
    protected Caretaker care= new Caretaker();

    public BaseScreen(CastleWars game) {
        this.game = game;
    }
    public abstract void setCare(Caretaker care);

    @Override
    public void render(float delta) {

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
