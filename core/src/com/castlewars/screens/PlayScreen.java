package com.castlewars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.castlewars.CastleWars;
import com.castlewars.Constants;
import com.castlewars.actors.KnightActor;
import com.castlewars.actors.LordActor;
import com.castlewars.creational.factory_chainofresponsability.ActorFactory;
import com.castlewars.creational.factory_chainofresponsability.DragonFactory;
import com.castlewars.creational.factory_chainofresponsability.DragonRiderFactory;
import com.castlewars.creational.factory_chainofresponsability.LordFactory;
import com.castlewars.creational.factory_chainofresponsability.SpikesmanFactory;
import com.castlewars.processors.InferiorProcessor;
import com.castlewars.processors.SuperiorProcessor;
import com.castlewars.structural.Composite.CreadorMenu;
import com.castlewars.structural.Composite.MenuComponent;
import com.castlewars.structural.Composite.OptionComposite;
import com.castlewars.structural.decorator.ActorDecorator;
import com.castlewars.structural.decorator.DamageDecorator;
import com.castlewars.structural.decorator.ComponentDecorator;
import com.castlewars.structural.decorator.ShieldDecorator;
import com.castlewars.structural.decorator.SpeedDecorator;

import java.util.ArrayList;

import static com.castlewars.Constants.*;

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

    private int actoKeyCounter;



    public PlayScreen(CastleWars game) {
        super(game);

        this.superiorProcessor = new SuperiorProcessor();
        this.inferiorProcessor = new InferiorProcessor();
        superiorProcessor.attachObserver(this);
        inferiorProcessor.attachObserver(this);

        actoKeyCounter = 0;

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

                    Vector2 v = new Vector2(superiorProcessor.getLastX()/PIXELS_IN_METER, HEIGHT/PIXELS_IN_METER);
                    Gdx.app.log("DEPLOY", "SOLDIER inferior" +superiorCounter +" x: "+v.x+" y: "+v.y);

                    String strActorKey =  "superior-actor"+actoKeyCounter;
                    KnightActor newActor = factory.createActor(superiorCounter,v , strActorKey);
                    stage.addActor(newActor);
                    actorMap.put(strActorKey,newActor);

                    actoKeyCounter++;
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
                    Vector2 v = new Vector2(inferiorProcessor.getLastX()/PIXELS_IN_METER, -0.5f);
                    Gdx.app.log("DEPLOY", "SOLDIER inferior" +inferiorCounter +" x: "+v.x+" y: "+v.y);

                    String strActorKey =  "inferior-actor"+actoKeyCounter;
                    KnightActor newActor = factory.createActor(inferiorCounter,v , strActorKey);
                    stage.addActor(newActor);
                    actorMap.put(strActorKey,newActor);

                    actoKeyCounter++;
                    inferiorCounter = 0;
                }
                inferiorPressed = false;
            }
        }

    }


}
