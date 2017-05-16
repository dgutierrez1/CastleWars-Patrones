package com.castlewars.structural.decorator;

import com.castlewars.Constants;
import com.castlewars.actors.KnightActor;

/**
 * Created by Esteban Aguirre on 16/05/2017.
 */

public class AttackDecorator extends ActorDecorator {

    public AttackDecorator(ComponentDecorator decorable) {
        super(decorable);
    }

    @Override
    public double getDamage() {
        return getDecorable().getDamage()*Constants.KNIGHT_DECORATOR_ATTACK;
    }

    @Override
    public double getAttack() {
        return 0;
    }

    @Override
    public double getShield() {
        return 0;
    }

    @Override
    public double getSpeed() {
        return 0;
    }


}
