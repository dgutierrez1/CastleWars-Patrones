package com.castlewars.actors;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.castlewars.Constants;
import com.castlewars.actors.animations.Animation;
import com.castlewars.structural.decorator.ComponentDecorator;

import java.awt.Component;

import static com.castlewars.Constants.*;

/**
 * Created by Daniel Gutierrez on 7/05/2017.
 */

public abstract class KnightActor extends ComponentDecorator implements Cloneable {

    //Atributos para Box2d
    private World world;
    private Body body;
    private Fixture fixture;

    //Atributos de estado del soldado
    private boolean alive;
    private boolean attacking;
    private double health;
    private double damage;
    private double shield;
    private float speed;

    //Atributos de colision
    private boolean colliding;
    private double damageTaken;

    //Animaciones
    private Animation animation;
    private Animation walkAnimation;
    private Animation attackAnimation;

    //Sound
    private Sound sound;


    public KnightActor() {
        alive = true;
        attacking = false;
        colliding = false;
        setSize(PIXELS_IN_METER, PIXELS_IN_METER);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition((body.getPosition().x - 0.5f) * PIXELS_IN_METER,
                (body.getPosition().y - 0.5f) * PIXELS_IN_METER);
        batch.draw(getKnight(), getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {
        if(colliding){
            health = health - damageTaken;
        }
        if(health <= 0){
            detach();
            remove();
        }else{
            animation.update(delta);
            body.setLinearVelocity( 0,speed);
        }
    }

    public void detach() {
        //animation.dispose();
        //attackAnimation.dispose();
        //walkAnimation.dispose();
        //attackAnimation = null;
        //animation = null;
        //walkAnimation = null;
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }

    public void setWord(World world) {
        this.world = world;
    }




    public void setPosition(Vector2 position, String actorName) {
        BodyDef def = new BodyDef();                // (1) Create the body definition.
        def.position.set(position);                 // (2) Put the body in the initial position.
        def.type = BodyDef.BodyType.DynamicBody;    // (3) Remember to make it dynamic.
        body = world.createBody(def);               // (4) Now create the body.


        PolygonShape box = new PolygonShape();      // (1) Create the shape.
        box.setAsBox(0.5f, 0.5f);                   // (2) 1x1 meter box.
        fixture = body.createFixture(box, 3);       // (3) Create the fixture.
        fixture.setUserData(actorName);              // (4) Set the user data.
        box.dispose();
    }

    public void buildExtrinsicAtributtes(double counter,Vector2 position, String actorName ){

        shield = (counter)/10;
        health = KNIGHT_HEALTH * shield;
        damage = (KNIGHT_DAMAGE * shield)/KNIGHT_DAMAGE_RATIO;
        System.out.print("DAMAGE: "+damage);

        setPosition(position, actorName);

    }

    public void collision(boolean colliding, double damage) {
        this.colliding = colliding;
        this.damageTaken = damage;
    }

    public void toggleAttack(boolean attacking){
        if(attacking){
            animation = attackAnimation;
            sound.play();
        }else{
            animation = walkAnimation;
        }
    }

    public void setSpeed(float speed){
        this.speed = speed;
    }

    public TextureRegion getKnight() {
        return animation.getFrame();
    }

    public Object clone(){
        Object clone = null;

        try{
            clone = super.clone();
        }catch (CloneNotSupportedException e){
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return clone;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isColliding() {
        return colliding;
    }

    @Override
    public double getDamage() {
        return damage;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Animation getWalkAnimation() {
        return walkAnimation;
    }


    public void setWalkAnimation(Animation walkAnimation) {
        this.walkAnimation = walkAnimation;
    }

    public void setAttackAnimation(Animation attackAnimation) {
        this.attackAnimation = attackAnimation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public double getHealth() {
        return health;
    }


}
