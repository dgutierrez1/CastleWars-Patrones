package com.castlewars.structural.decorator;

import com.castlewars.Constants;
import com.castlewars.actors.KnightActor;

/**
 * Created by Esteban Aguirre on 16/05/2017.
 */

public class SpeedDecorator extends ActorDecorator {


    public SpeedDecorator(ComponentDecorator decorable) {
        super(decorable);
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
    public double getSpeed() {
        return decorable.getSpeed()* Constants.KNIGHT_DECORATOR_SPEED;
    }
}
