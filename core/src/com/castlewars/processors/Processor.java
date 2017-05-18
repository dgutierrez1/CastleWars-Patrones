package com.castlewars.processors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.compression.lzma.Base;
import com.castlewars.screens.GameScreenObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public abstract class Processor extends InputAdapter {

    private List<GameScreenObserver> observers;
    boolean pressState = false;
    boolean pressed = false;
    int lastX;
    int lastY;

    public Processor(){
        observers = new ArrayList<GameScreenObserver>();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(pointer == 0){
            if(isInRegion(screenY)){
                pressState = true;
                pressed = true;
                notifyObservers();
                return true;
            }else{
                return false;
            }
        }
        return false;

    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(pointer == 0){
            if(isInRegion((screenY))){
                pressState = false;
                lastX = screenX;
                lastY = screenY;
                notifyObservers();
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public void attachObserver(GameScreenObserver screen){
        this.observers.add(screen);
    }

    public abstract boolean isInRegion(int screenY);

    public void notifyObservers(){
        for (GameScreenObserver observer : observers){
            observer.update();
        }
    }
    public boolean getState(){
        return pressState;
    }

    public boolean getPressed(){
        return pressed;
    }

    public int getLastX() {
        return lastX;
    }

    public int getLastY() {
        return lastY;
    }
}
