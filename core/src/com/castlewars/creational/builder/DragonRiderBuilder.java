package com.castlewars.creational.builder;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.castlewars.actors.DragonRiderActor;
import com.castlewars.actors.KnightActor;
import com.castlewars.actors.SpikesmanActor;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class DragonRiderBuilder extends ActorBuilder {


    public DragonRiderBuilder(World world) {
        super(world);
    }

    @Override
    public void buildActor(Vector2 position) {
        actor = new DragonRiderActor();
        actor.setWord(world);
        actor.setPosition(position);
        actor.setTexture(new Texture("badlogic.jpg"));
        Gdx.app.log("CREATION", "Dragon Rider");
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


}
