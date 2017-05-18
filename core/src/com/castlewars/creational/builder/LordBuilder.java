package com.castlewars.creational.builder;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.castlewars.actors.LordActor;
import com.castlewars.actors.KnightActor;
import com.castlewars.actors.SpikesmanActor;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class LordBuilder extends ActorBuilder {


    public LordBuilder(World world) {
        super(world);
    }

    @Override
    public void buildActor(Vector2 pos) {
        actor = new LordActor();
        actor.setWord(world);
        actor.setPosition(pos);
        actor.setTexture(new Texture("badlogic.jpg"));
        Gdx.app.log("CREATION", "Lord");

    }

    @Override
    public void buildAnimations() {

    }

    @Override
    public void buildMusic() {

    }

    @Override
    public void buildTextures() {

    }

    @Override
    public KnightActor getActor() {
        return null;
    }
}
