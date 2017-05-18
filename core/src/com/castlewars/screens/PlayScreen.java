package com.castlewars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.castlewars.CastleWars;
import com.castlewars.actors.KnightActor;
import com.castlewars.actors.LordActor;
import com.castlewars.creational.factory_chainofresponsability.ActorFactory;
import com.castlewars.creational.factory_chainofresponsability.DragonFactory;
import com.castlewars.creational.factory_chainofresponsability.DragonRiderFactory;
import com.castlewars.creational.factory_chainofresponsability.LordFactory;
import com.castlewars.creational.factory_chainofresponsability.SpikesmanFactory;
import com.castlewars.processors.InferiorProcessor;
import com.castlewars.processors.SuperiorProcessor;
import com.castlewars.structural.decorator.ActorDecorator;
import com.castlewars.structural.decorator.DamageDecorator;
import com.castlewars.structural.decorator.ComponentDecorator;
import com.castlewars.structural.decorator.ShieldDecorator;
import com.castlewars.structural.decorator.SpeedDecorator;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class PlayScreen extends GameScreenObserver {

    private int superiorCounter = 0;
    private boolean superiorPress = false;
    private boolean superiorPressed = false;

    private int inferiorCounter = 0;
    private boolean inferiorPress = false;
    private boolean inferiorPressed = false;

    public PlayScreen(CastleWars game) {
        super(game);

        this.superiorProcessor = new SuperiorProcessor();
        this.inferiorProcessor = new InferiorProcessor();
        superiorProcessor.attachObserver(this);
        inferiorProcessor.attachObserver(this);

    }



    @Override
    public void update() {
        superiorPressed = superiorProcessor.getPressed();
        superiorPress = superiorProcessor.getState();

        inferiorPressed = inferiorProcessor.getPressed();
        inferiorPress = inferiorProcessor.getState();
    }
    public void accumulate(){

        if(superiorPressed){
            if(superiorPress){
                superiorCounter++;
            }else{
                if(superiorCounter>0){
                    Gdx.app.log("DEPLOY", "SOLDIER WITH superior" +superiorCounter);

                    /*ComponentDecorator soldado= new LordActor();
                    Gdx.app.log("DEPLOY", "caracteristicas"+soldado.mostrarCaracteristicas());

                    ActorDecorator damageDecorador= new DamageDecorator(soldado);
                    Gdx.app.log("DEPLOY", "ataque :"+damageDecorador.getDamage());

                    ActorDecorator velocidadDecorador= new SpeedDecorator(soldado);
                    Gdx.app.log("DEPLOY", "velocidad : "+velocidadDecorador.getSpeed());

                    ActorDecorator escudoDecorador= new ShieldDecorator(soldado);
                    Gdx.app.log("DEPLOY", "escudo : "+escudoDecorador.getShield());*/

                    superiorCounter = 0;
                }
                superiorPressed = false;

            }
        }

        if(inferiorPressed){
            if(inferiorPress){
                inferiorCounter++;
            }else{
                if(inferiorCounter> 0){
                    Gdx.app.log("DEPLOY", "SOLDIER inferior" +inferiorCounter);

                    KnightActor newActor = factory.createActor(inferiorCounter, new Vector2(inferiorProcessor.getLastX(), inferiorProcessor.getLastY()));
                    stage.addActor(newActor);
                    listActorInferior.addLast(newActor);

                    inferiorCounter = 0;
                }
                inferiorPressed = false;
            }
        }

    }


}
