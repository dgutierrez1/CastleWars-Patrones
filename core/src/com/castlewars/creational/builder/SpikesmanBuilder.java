package com.castlewars.creational.builder;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.castlewars.actors.KnightActor;
import com.castlewars.actors.SpikesmanActor;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class SpikesmanBuilder extends ActorBuilder {


    public SpikesmanBuilder(World world) {
        super(world);
    }

    @Override
    public void buildActor(Vector2 position) {
        actor = new SpikesmanActor();
        actor.setWord(world);
        actor.setPosition(new Vector2(1,1));
        actor.setTexture(new Texture("badlogic.jpg"));
        Gdx.app.log("CREATION", "Spikesman");

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
        return actor;
    }
}
