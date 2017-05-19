package com.castlewars.structural.decorator;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public abstract class ComponentDecorator extends Actor{

    protected String key;

    public abstract double getDamage();
    public abstract float getSpeed();
    public abstract double getHealth();

    public abstract void setDamage(double damage);
    public abstract void setSpeed(float speed);
    public abstract void setHealth(double health);

    public abstract TextureRegion getKnight();
    public abstract void collision(boolean state, double damage);
    public abstract void toggleAttack(boolean state);


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
