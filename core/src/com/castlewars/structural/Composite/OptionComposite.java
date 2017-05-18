package com.castlewars.structural.Composite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.ArrayList;

/**
 * Created by Esteban Aguirre on 17/05/2017.
 */

public class OptionComposite extends MenuComponent {


    private ArrayList<MenuComponent> options;



    public OptionComposite() {
        options= new ArrayList<MenuComponent>();


    }

    public OptionComposite(String nombre,Skin skin) {
        options= new ArrayList<MenuComponent>();
        button= new TextButton(nombre,skin);

    }

    @Override
    public void addComponente(MenuComponent option) {
        options.add(option);
    }

    @Override
    public TextButton getButton() {
        return button;
    }

    @Override
    public void setButton(TextButton button) {
        this.button=button;
    }

    @Override
    public void evento(ChangeListener listener) {
        button.addCaptureListener(listener);
    }

    @Override
    public void removeComponente(MenuComponent option) {
        options.remove(option);
    }
}
