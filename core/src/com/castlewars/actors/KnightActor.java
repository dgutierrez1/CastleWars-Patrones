package com.castlewars.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.castlewars.Constants;
import com.castlewars.structural.decorator.ComponentDecorator;

import java.awt.Component;

/**
 * Created by Daniel Gutierrez on 7/05/2017.
 */

public abstract class KnightActor extends ComponentDecorator {

    private Texture texture;
    private Texture attack;
    private Texture walk;
    private Texture hit;

    private World world;
    private Body body;
    private Fixture fixture;
    private boolean alive;
    private boolean attacking;
    private double health;
    private double damage;
    private double shield;
    private double speed;

    private com.castlewars.actors.animations.Animation attackAnimation;
    private com.castlewars.actors.animations.Animation walkAnimation;


    public KnightActor() {
        alive = true;
        attacking = false;

        // Create the player body.


        // Give it some shape.
        PolygonShape box = new PolygonShape();      // (1) Create the shape.
        box.setAsBox(0.5f, 0.5f);                   // (2) 1x1 meter box.


//        fixture = body.createFixture(box, 3);       // (3) Create the fixture.
//        fixture.setUserData("player");              // (4) Set the user data.
        box.dispose();                              // (5) Destroy the shape.

        setSize(Constants.PIXELS_IN_METER, Constants.PIXELS_IN_METER);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition((body.getPosition().x - 0.5f) * Constants.PIXELS_IN_METER,
                (body.getPosition().y - 0.5f) * Constants.PIXELS_IN_METER);
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    public void setPosition(Vector2 position) {
        BodyDef def = new BodyDef();                // (1) Create the body definition.
        def.position.set(position);                 // (2) Put the body in the initial position.
        def.type = BodyDef.BodyType.DynamicBody;    // (3) Remember to make it dynamic.
        body = world.createBody(def);               // (4) Now create the body.
    }

    public void setWord(World world) {
        this.world = world;
    }

    public void setTexture(Texture tex){
        this.texture=tex;
    }


    @Override
    public void act(float delta) {
        //float speedY = body.getLinearVelocity().y;
        body.setLinearVelocity( 0, Constants.PLAYER_SPEED);
    }

    public void detach() {
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }

    // Getter and setter festival below here.

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String mostrarCaracteristicas(){
        return "ataque :"+getDamage()+" velocidad: "+getSpeed()+" escudo: "+getShield();
    }


}
