/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.fireworks

import com.wang.Game2dEngine.physics.gravity.Gravity
import com.wang.Game2dEngine.scene.Scene
import javax.swing.Timer

/**
 * @author ricolwang
 */
class FireworksScene : Scene()
{
    var g = Gravity(0, 500)
    var theTimer = Timer(200) { createParticles(1, (width * (2.0 / 4.0)).toInt(), (height * (3.5 / 4.0)).toInt(), g) }
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
            var aObject: Firework
            val velocityX = Math.pow(-1.0, theRandom.nextInt() % 10.toDouble()) * theRandom.nextFloat() * 50.0f
            val velocityY = -1 * theRandom.nextFloat() * 50.0f - 600.0f.toDouble()
            if (Math.abs(theRandom.nextInt() % 10) > 5)
            {
                aObject = BigFirework()
                aObject.x = x.toDouble()
                aObject.y = y.toDouble()
                aObject.velocityX = velocityX
                aObject.velocityY = velocityY
                aObject.setLifeTime(100.0)
                aObject.blastTime = Math.abs(theRandom.nextInt()) % 100 / 80.0 + 0.5
                aObject.subFireworks = 20
            } else
            {
                aObject = SmallFirework()
                aObject.x = x.toDouble()
                aObject.y = y.toDouble()
                aObject.velocityX = velocityX
                aObject.velocityY = velocityY
                aObject.setLifeTime(Math.abs(theRandom.nextInt()) % 5 + 1.toDouble())
                aObject.setImage("resource/starSmall.png")
            }
            val redValue = Math.abs(theRandom.nextInt()) % 255
            val greenValue = Math.abs(theRandom.nextInt()) % 255
            val blueValue = Math.abs(theRandom.nextInt()) % 255
            aObject.red = redValue
            aObject.green = greenValue
            aObject.blue = blueValue
            aObject.applyGravity(g)
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