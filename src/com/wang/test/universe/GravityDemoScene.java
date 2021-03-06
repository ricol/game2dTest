/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.universe;

import com.wang.Game2dEngine.sprite.Sprite;
import com.wang.test.basicscene.WallScene;
import com.wang.test.common.TestCommon;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

/**
 * @author ricolwang
 */
public class GravityDemoScene extends WallScene
{

    double MassOfStar = 10.0f * pow(10, 17);

    @Override
    public void mousePressed(MouseEvent e)
    {
        super.mousePressed(e);

        if (e.getButton() == MouseEvent.BUTTON3)
        {
            Star aStar = new Star();
            aStar.bCollisionDetect = true;
            aStar.setCollisionCategory(TestCommon.CATEGORY_CIRCLE);
            aStar.addTargetCollisionCategory(TestCommon.CATEGORY_WALL);
            aStar.bCollisionArbitrary = true;
            aStar.setMass(MassOfStar);
            aStar.setWidth(50);
            aStar.setHeight(aStar.getWidth());
            aStar.setCentreX(e.getX());
            aStar.setCentreY(e.getY());
            aStar.setLayer(1);

            addSprite(aStar);

            Set<Entity> all = getAllEntities();

            for (Entity aEntity : all)
            {
                if (aEntity instanceof Planet)
                {
                    Planet aPlanet = (Planet) aEntity;
                    aPlanet.addEntity(aStar);
                }
            }

        } else if (e.getButton() == MouseEvent.BUTTON1)
        {
            double MaxMassOfPlanet = MassOfStar / 200000.0f;
            double MaxWidthPlanet = 50;

            Planet aPlanet = new Planet();
            double mass = ((abs(theRandom.nextInt()) * 1.0f) / Integer.MAX_VALUE) * MaxMassOfPlanet;
            aPlanet.setMass(mass);
            aPlanet.setWidth(8);
            aPlanet.setHeight(aPlanet.getWidth());
            aPlanet.setCentreX(e.getX());
            aPlanet.setCentreY(e.getY());
            aPlanet.setVelocityY(500);
            aPlanet.setLayer(2);

            aPlanet.addEntities(getAllEntities());

            addSprite(aPlanet);
        }
    }

    public Set<Entity> getAllEntities()
    {
        Set<Entity> allEntities = new HashSet<>();
        ArrayList<Sprite> all = this.getAllSprites();
        for (Sprite aSprite : all)
        {
            if (aSprite instanceof Entity)
            {
                allEntities.add((Entity) aSprite);
            }
        }

        return allEntities;
    }

}
