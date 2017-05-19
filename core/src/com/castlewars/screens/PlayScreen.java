package com.castlewars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.castlewars.CastleWars;
import com.castlewars.Constants;
import com.castlewars.actors.KnightActor;

import com.castlewars.behavior.Memento.Caretaker;

import com.castlewars.processors.InferiorProcessor;
import com.castlewars.processors.SuperiorProcessor;
import com.castlewars.structural.decorator.ComponentDecorator;
import com.castlewars.structural.decorator.DamageDecorator;
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

    private int actorKeyCounter;

    public ComponentDecorator decoratorTemp;


    public PlayScreen(CastleWars game) {
        super(game);

        this.superiorProcessor = new SuperiorProcessor();
        this.inferiorProcessor = new InferiorProcessor();
        superiorProcessor.attachObserver(this);
        inferiorProcessor.attachObserver(this);

        actorKeyCounter = 0;

    }

    @Override
    public void setCare(Caretaker care) {
        this.care=care;
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
                    //Gdx.app.log("DEPLOY", "SOLDIER WITH superior" +superiorCounter);

                    Vector2 v = new Vector2(superiorProcessor.getLastX()/PIXELS_IN_METER, HEIGHT/PIXELS_IN_METER-0.5f);

                    //Gdx.app.log("DEPLOY", "SOLDIER inferior" +superiorCounter +" x: "+v.x+" y: "+v.y);

                    String strActorKey =  "superior-actor"+actorKeyCounter;
                    final ComponentDecorator newActor = factory.createActor(superiorCounter,v , strActorKey);

                    newActor.addCaptureListener(new InputListener(){

                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            System.out.print("input listener");

                            if(healthDeco){
                                System.out.print("decorador de vida antes :"+newActor.getHealth());
                                decoratorTemp = new ShieldDecorator(newActor);
                                decoratorTemp.setKey(newActor.getKey());
                                stage.addActor(decoratorTemp);
                                actorMap.put(decoratorTemp.getKey(),decoratorTemp);
                                newActor.remove();
                                System.out.print("decorador de vida despues : "+decoratorTemp.getHealth());
                                healthDeco = false;
                            }else if(speedDeco){
                                System.out.print("decorador de velocidad antes : "+newActor.getSpeed());
                                decoratorTemp = new SpeedDecorator(newActor);
                                decoratorTemp.setKey(newActor.getKey());
                                stage.addActor(decoratorTemp);
                                actorMap.put(decoratorTemp.getKey(),decoratorTemp);
                                newActor.remove();
                                System.out.print("decorador de velocidad antes : "+decoratorTemp.getSpeed());
                                speedDeco = false;
                            }else if(attackDeco){
                                System.out.print("decorador de ataque antes : "+newActor.getDamage());
                                decoratorTemp = new DamageDecorator(newActor);
                                decoratorTemp.setKey(newActor.getKey());
                                stage.addActor(decoratorTemp);
                                actorMap.put(decoratorTemp.getKey(),decoratorTemp);
                                newActor.remove();
                                System.out.print("decorador de ataque antes : "+decoratorTemp.getDamage());
                                attackDeco = false;
                            }
                            return true;
                        }
                    });

                    stage.addActor(newActor);
                    actorMap.put(strActorKey,newActor);

                    actorKeyCounter++;
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
                    Vector2 v = new Vector2(inferiorProcessor.getLastX()/PIXELS_IN_METER, 0.5f);
                    Gdx.app.log("DEPLOY", "SOLDIER inferior" +inferiorCounter +" x: "+v.x+" y: "+v.y);

                    String strActorKey =  "inferior-actor"+actorKeyCounter;
                    final ComponentDecorator newActor = factory.createActor(inferiorCounter,v , strActorKey);

                    newActor.addCaptureListener(new InputListener(){


                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            System.out.print("input listener");

                            if(healthDeco){
                                System.out.print("decorador de vida antes :"+newActor.getHealth());
                                decoratorTemp = new ShieldDecorator(newActor);
                                decoratorTemp.setKey(newActor.getKey());
                                stage.addActor(decoratorTemp);
                                actorMap.put(decoratorTemp.getKey(),decoratorTemp);
                                newActor.remove();
                                System.out.print("decorador de vida despues : "+decoratorTemp.getHealth());
                                healthDeco = false;
                            }else if(speedDeco){
                                System.out.print("decorador de velocidad antes : "+newActor.getSpeed());
                                decoratorTemp = new SpeedDecorator(newActor);
                                decoratorTemp.setKey(newActor.getKey());
                                stage.addActor(decoratorTemp);
                                actorMap.put(decoratorTemp.getKey(),decoratorTemp);
                                newActor.remove();
                                System.out.print("decorador de velocidad antes : "+decoratorTemp.getSpeed());
                                speedDeco = false;
                            }else if(attackDeco){
                                System.out.print("decorador de ataque antes : "+newActor.getDamage());
                                decoratorTemp = new DamageDecorator(newActor);
                                decoratorTemp.setKey(newActor.getKey());
                                stage.addActor(decoratorTemp);
                                actorMap.put(decoratorTemp.getKey(),decoratorTemp);
                                newActor.remove();
                                System.out.print("decorador de ataque antes : "+decoratorTemp.getDamage());
                                attackDeco = false;
                            }
                            return true;
                        }
                    });

                    stage.addActor(newActor);
                    newActor.setKey(strActorKey);
                    actorMap.put(newActor.getKey(),newActor);


                    actorKeyCounter++;
                    inferiorCounter = 0;
                }
                inferiorPressed = false;
            }
        }

    }




}
