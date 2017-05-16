package com.castlewars.structural.decorator;

import com.castlewars.Constants;
import com.castlewars.actors.KnightActor;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class ShieldDecorator extends ActorDecorator {


    public ShieldDecorator(ComponentDecorator decorable) {
        super(decorable);
    }

    @Override
    public double getDamage() {
        return 0;
    }

    @Override
    public double getAttack() {
        return 0;
    }

    @Override
    public double getShield() {
        return getDecorable().getShield()* Constants.KNIGHT_DECORATOR_SHIELD;
    }

    @Override
    public double getSpeed() {
        return 0;
    }




}
