/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.universe

import com.wang.test.basicscene.WallScene
import com.wang.test.common.TestCommon
import java.awt.event.MouseEvent
import java.util.*

/**
 * @author ricolwang
 */
class GravityDemoScene : WallScene()
{
    var MassOfStar = 10.0f * Math.pow(10.0, 17.0)
    override fun mousePressed(e: MouseEvent)
    {
        super.mousePressed(e)
        if (e.button == MouseEvent.BUTTON3)
        {
            val aStar = Star()
            aStar.bCollisionDetect = true
            aStar.collisionCategory = TestCommon.CATEGORY_CIRCLE
            aStar.addTargetCollisionCategory(TestCommon.CATEGORY_WALL)
            aStar.bCollisionArbitrary = true
            aStar.mass = MassOfStar
            aStar.width = 50.0
            aStar.height = aStar.width
            aStar.centreX = e.x.toDouble()
            aStar.centreY = e.y.toDouble()
            aStar.layer = 1
            addSprite(aStar)
            val all = allEntities
            for (aEntity in all)
            {
                if (aEntity is Planet)
                {
                    aEntity.addEntity(aStar)
                }
            }
        } else if (e.button == MouseEvent.BUTTON1)
        {
            val MaxMassOfPlanet = MassOfStar / 200000.0f
            val MaxWidthPlanet = 50.0
            val aPlanet = Planet()
            val mass = Math.abs(theRandom.nextInt()) * 1.0f / Int.MAX_VALUE * MaxMassOfPlanet
            aPlanet.mass = mass
            aPlanet.width = 8.0
            aPlanet.height = aPlanet.width
            aPlanet.centreX = e.x.toDouble()
            aPlanet.centreY = e.y.toDouble()
            aPlanet.velocityY = 500.0
            aPlanet.layer = 2
            aPlanet.addEntities(allEntities)
            addSprite(aPlanet)
        }
    }

    val allEntities: Set<Entity>
        get()
        {
            val allEntities: MutableSet<Entity> = HashSet()
            val all = this.allSprites
            for (aSprite in all)
            {
                if (aSprite is Entity)
                {
                    allEntities.add(aSprite)
                }
            }
            return allEntities
        }
}