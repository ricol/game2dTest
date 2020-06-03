/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.galaxies;

import com.wang.Game2dEngine.scene.Scene;
import com.wang.math.vector.Vector;
import com.wang.test.common.TestCommon;
import static java.lang.Math.abs;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author ricolwang
 */
public class Galaxy
{

    private Scene theScene;

    double MassOfStar = 1e17;
    protected Random theRandom = new Random();

    public Galaxy(Scene scene, double x, double y)
    {
        super();
        this.theScene = scene;
        synchronized (scene)
        {
            this.createStar(x, y);
            this.createPlanets(x, y);
        }
    }

    private void createPlanets(double x, double y)
    {
        double MaxMassOfPlanet = MassOfStar / 200000.0f;

        for (int i = 0; i < 100; i++)
        {
            Planet aPlanet = new Planet();
            double mass = ((abs(theRandom.nextInt()) * 1.0f) / Integer.MAX_VALUE) * MaxMassOfPlanet;
            aPlanet.setMass(mass);
            aPlanet.setWidth(8);
            aPlanet.setHeight(aPlanet.getWidth());
            aPlanet.setCentreX((x + getPercentage() * 1e2 + 1e2 / 2.0));
            aPlanet.setCentreY(y);
            aPlanet.setVelocityY(1e2 + getPercentage() * 1e2 * 1.5);
            aPlanet.setLayer(2);
            this.addSprite(aPlanet);
        }
    }

    private void createStar(double x, double y)
    {
        Star aStar = new Star();
        aStar.bCollisionDetect = true;
        aStar.setCollisionCategory(TestCommon.CATEGORY_CIRCLE);
        aStar.addTargetCollisionCategory(TestCommon.CATEGORY_WALL);
        aStar.bCollisionArbitrary = true;
        aStar.setMass(MassOfStar);
        aStar.setWidth(20);
        aStar.setHeight(aStar.getWidth());
        aStar.setCentreX(x);
        aStar.setCentreY(y);
        aStar.setLayer(1);
        aStar.setVelocity(new Vector(getSymbol() * getPercentage() * 1e2 / 1.5, getSymbol() * getPercentage() * 1e2 / 1.5));
        this.addSprite(aStar);
    }

    private double getPercentage()
    {
        return (abs(theRandom.nextInt()) * 1.0f) / Integer.MAX_VALUE;
    }

    private double getSymbol()
    {
        return theRandom.nextBoolean() ? 1 : -1;
    }

    private void addSprite(Entity aEntity)
    {
        Set<Entity> allOtherEntity = ((GalaxiesDemoScene) theScene).getAllEntities();
        for (Entity entity : allOtherEntity)
        {
            entity.getAllOtherObjects().add(aEntity);
        }
        theScene.addSprite(aEntity);
    }
}
