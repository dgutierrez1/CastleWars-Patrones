package com.castlewars.structural.decorator;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.castlewars.Constants;
import com.castlewars.actors.KnightActor;

/**
 * Created by Esteban Aguirre on 16/05/2017.
 */

public class SpeedDecorator extends ActorDecorator {


    public SpeedDecorator(ComponentDecorator decorable) {
        super(decorable);
        setSpeed( (float)(decorable.getSpeed()* Constants.KNIGHT_DECORATOR_SPEED) );
    }

    @Override
    public double getDamage() {
        return decorable.getDamage();
    }



    @Override
    public double getHealth() {
        return decorable.getHealth();
    }

    @Override
    public void setDamage(double damage) {
        decorable.setDamage(damage);
    }

    @Override
    public void setSpeed(float speed) {
        decorable.setSpeed(speed);
    }

    @Override
    public void setHealth(double health) {
        decorable.setHealth(health);
    }


    @Override
    public TextureRegion getKnight() {
        return decorable.getKnight();
    }



    @Override
    public float getSpeed() {
        return decorable.getSpeed();
    }
    @Override
    public void collision(boolean state, double damage) {
        decorable.collision(state,damage);
    }

    @Override
    public void toggleAttack(boolean state) {
        decorable.toggleAttack(state);
    }
}
