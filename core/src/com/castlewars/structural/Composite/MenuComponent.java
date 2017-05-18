package com.castlewars.structural.Composite;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

/**
 * Created by Esteban Aguirre on 17/05/2017.
 */

public abstract class MenuComponent {
    protected TextButton button;

    public abstract void addComponente(MenuComponent option);
    public abstract void removeComponente(MenuComponent option);
    public abstract TextButton getButton();
    public abstract void setButton(TextButton button);
    public abstract void evento(ChangeListener listener);


}
