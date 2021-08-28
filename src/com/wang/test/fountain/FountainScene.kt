/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.fountain

import com.wang.Game2dEngine.physics.gravity.Gravity
import com.wang.Game2dEngine.scene.Scene
import javax.swing.Timer

/**
 * @author ricolwang
 */
class FountainScene : Scene()
{
    var g = Gravity(0, 500)
    var theTimer = Timer(10) { createParticles(10, (width * (2.0 / 4.0)).toInt(), (height * (3.5 / 4.0)).toInt(), g) }
    override fun start()
    {
        super.start()
        this.theTimer.start()
    }

    override fun pause()
    {
        super.pause()
        if (this.isScenePaused)
        {
            this.theTimer.stop()
        } else
        {
            this.theTimer.start()
        }
    }

    override fun stop()
    {
        this.theTimer.stop()
        super.stop()
    }

    fun createParticles(number: Int, x: Int, y: Int, g: Gravity?)
    {
        for (i in 0 until number)
        {
            var aObject: FountainSprite
            val mass = theRandom.nextFloat() / 3.0f.toDouble()
            val velocityX = Math.pow(-1.0, theRandom.nextInt() % 10.toDouble()) * theRandom.nextFloat() * 200.0f
            val velocityY = -1 * theRandom.nextFloat() * 50.0f - 500.0f.toDouble()
            val size = Math.abs(theRandom.nextInt()) % 7 + 3.toFloat()
            aObject = FountainSprite(x.toDouble(), y.toDouble(), size.toDouble(), size.toDouble(), mass, velocityX, velocityY)
            aObject.setLifeTime(Math.abs(theRandom.nextInt()) % 100 / 50.0)
            val redValue = Math.abs(theRandom.nextInt()) % 255
            val greenValue = Math.abs(theRandom.nextInt()) % 255
            val blueValue = Math.abs(theRandom.nextInt()) % 255
            aObject.red = redValue
            aObject.green = greenValue
            aObject.blue = blueValue
            aObject.applyGravity(g)
            aObject.bEnableGravity = true

//            if (abs(theRandom.nextInt()) % 100 > 50)
//            {
//                aObject.setImage("starSmall.png");
//            } else
//            {
//                aObject.setImage("starBig.png");
//            }
            this.addSprite(aObject)
        }
    }

    init
    {
        red = 0
        green = 0
        blue = 0
    }
}