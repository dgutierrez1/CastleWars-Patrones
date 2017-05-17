package com.castlewars.structural.decorator;

import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public abstract class ComponentDecorator extends Actor{

    public abstract double getDamage();
    public abstract double getSpeed();
    public abstract double getShield();
    public abstract String mostrarCaracteristicas();






}
