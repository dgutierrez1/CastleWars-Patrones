package com.castlewars.structural.decorator;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.castlewars.Constants;
import com.castlewars.actors.KnightActor;

/**
 * Created by Esteban Aguirre on 16/05/2017.
 */

public class DamageDecorator extends ActorDecorator {

    public DamageDecorator(ComponentDecorator decorable) {
        super(decorable);
        setDamage( decorable.getDamage()*Constants.KNIGHT_DECORATOR_ATTACK);
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
    public void collision(boolean state, double damage) {
        decorable.collision(state,damage);
    }

    @Override
    public void toggleAttack(boolean state) {
        decorable.toggleAttack(state);
    }


    @Override
    public float getSpeed() {
        return decorable.getSpeed();
    }


}
