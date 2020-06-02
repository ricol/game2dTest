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
import static java.lang.Math.pow;
import java.util.Random;

/**
 *
 * @author ricolwang
 */
public class Galaxy
{

    private Scene theScene;

    double MassOfStar = 10.0f * pow(10, 17);
    protected Random theRandom = new Random();

    public Galaxy(Scene scene, double x, double y)
    {
        super();
        this.theScene = scene;
        this.createStar(x, y);
        this.createPlanets(x, y);
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
            aPlanet.setCentreX((x + getPercentage() * 100));
            aPlanet.setCentreY((y + getPercentage() * 100));
            aPlanet.setVelocityY(600 + getPercentage() * 20);
            aPlanet.setLayer(2);
            theScene.addSprite(aPlanet);
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
        aStar.setWidth(10);
        aStar.setHeight(aStar.getWidth());
        aStar.setCentreX(x);
        aStar.setCentreY(y);
        aStar.setLayer(1);
        aStar.setVelocity(new Vector(getSymbol() * getPercentage() * 50, getSymbol() * getPercentage() * 50));
        theScene.addSprite(aStar);
    }

    private double getPercentage()
    {
        return (abs(theRandom.nextInt()) * 1.0f) / Integer.MAX_VALUE;
    }

    private double getSymbol()
    {
        return theRandom.nextBoolean() ? 1 : -1;
    }
}
