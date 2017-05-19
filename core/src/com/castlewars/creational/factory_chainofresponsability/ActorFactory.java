package com.castlewars.creational.factory_chainofresponsability;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.castlewars.Constants;
import com.castlewars.actors.KnightActor;
import com.castlewars.creational.builder.ActorBuilder;
import com.castlewars.structural.flyweight.FlyweightFactory;

/**
 * Created by Daniel Gutierrez on 7/05/2017.
 */

public abstract class ActorFactory {

    protected ActorFactory nextFactory;
    protected ActorBuilder actorBuilder;
    protected FlyweightFactory flyweightFactory;
    protected World world;


    protected double rangeStart;
    protected  double rangeEnd;

    public ActorFactory(double rangeStart, World world){
        this.world = world;
        this.rangeStart = rangeStart * Constants.KNIGHT_SELECTION_RATIO;
        this.rangeEnd = (rangeStart + 1) * Constants.KNIGHT_SELECTION_RATIO;
    }




    /*Metodo encargado de verificar si se puede crear el objeto en esta factory, sino lo delega a la siguiente*/
    public KnightActor createActor(double counter, Vector2 position,String key){
        if((rangeStart <= counter && counter < rangeEnd) || nextFactory==null){
            Gdx.app.log("VERF", "Y position: "+position.y);
            Gdx.app.log("VERF", "height: "+Constants.HEIGHT/2);

            if((Constants.HEIGHT/2)>(position.y*Constants.PIXELS_IN_METER)){
                return requestBuildInferior(counter, position, key);
            }else {
                return requestBuildSuperior(counter, position, key);
            }
        }else{
            return nextFactory.createActor(counter, position, key);
        }
    }

    public KnightActor requestBuildSuperior(double counter, Vector2 pos, String key) {
        requestBuild(counter,pos,key);
        actorBuilder.setDirection(-(Constants.PLAYER_SPEED));
        Gdx.app.log("DEPLOY", "actor superior");
        return actorBuilder.getActor();

    }

    public KnightActor requestBuildInferior(double counter, Vector2 pos, String key) {
        requestBuild(counter,pos, key);
        actorBuilder.setDirection(Constants.PLAYER_SPEED);
        Gdx.app.log("DEPLOY", "actor inferior");
        return actorBuilder.getActor();

    }
    public abstract void requestBuild(double counter, Vector2 pos,String key) ;

    public ActorFactory getNextFactory() {
        return nextFactory;
    }

    public void setNextFactory(ActorFactory nextFactory) {
        this.nextFactory = nextFactory;
    }

    public ActorBuilder getActorBuilder() {
        return actorBuilder;
    }

    public void setActorBuilder(ActorBuilder actorBuilder) {
        this.actorBuilder = actorBuilder;
    }
}
