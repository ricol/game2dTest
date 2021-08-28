/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.galaxies

import com.wang.Game2dEngine.scene.Scene
import com.wang.math.vector.Vector
import com.wang.test.common.TestCommon
import java.util.*

/**
 * @author ricolwang
 */
class Galaxy(private val theScene: Scene, x: Double, y: Double)
{
    var MassOfStar = 1e17
    protected var theRandom = Random()
    private fun createPlanets(x: Double, y: Double)
    {
        val MaxMassOfPlanet = MassOfStar / 200000.0f
        for (i in 0..99)
        {
            val aPlanet = Planet()
            val mass = Math.abs(theRandom.nextInt()) * 1.0f / Int.MAX_VALUE * MaxMassOfPlanet
            aPlanet.mass = mass
            aPlanet.width = 8.0
            aPlanet.height = aPlanet.width
            aPlanet.centreX = x + percentage * 1e2 + 1e2 / 2.0
            aPlanet.centreY = y
            aPlanet.velocityY = 1e2 + percentage * 1e2 * 1.5
            aPlanet.layer = 2
            addSprite(aPlanet)
        }
    }

    private fun createStar(x: Double, y: Double)
    {
        val aStar = Star()
        aStar.bCollisionDetect = true
        aStar.collisionCategory = TestCommon.CATEGORY_CIRCLE
        aStar.addTargetCollisionCategory(TestCommon.CATEGORY_WALL)
        aStar.bCollisionArbitrary = true
        aStar.mass = MassOfStar
        aStar.width = 20.0
        aStar.height = aStar.width
        aStar.centreX = x
        aStar.centreY = y
        aStar.layer = 1
        aStar.velocity = Vector(symbol * percentage * 1e2 / 1.5, symbol * percentage * 1e2 / 1.5)
        addSprite(aStar)
    }

    private val percentage: Double
        private get() = (Math.abs(theRandom.nextInt()) * 1.0f / Int.MAX_VALUE).toDouble()
    private val symbol: Double
        private get() = if (theRandom.nextBoolean()) 1.0 else -1.0

    private fun addSprite(aEntity: Entity)
    {
        val allOtherEntity = (theScene as GalaxiesDemoScene).allEntities
        for (entity in allOtherEntity!!)
        {
            entity.allOtherObjects?.add(aEntity)
        }
        theScene.addSprite(aEntity)
    }

    init
    {
        createStar(x, y)
        createPlanets(x, y)
    }
}