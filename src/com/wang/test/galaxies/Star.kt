/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.galaxies

import com.wang.Game2dEngine.action.AlphaToAction
import com.wang.Game2dEngine.scene.Layer
import com.wang.Game2dEngine.sprite.Sprite
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.Timer

/**
 * @author Philology
 */
class Star : Entity(), ActionListener
{
    var theTimer = Timer(100, this)

    override fun actionPerformed(e: ActionEvent)
    {
        val number = Math.abs(theRandom.nextInt()) % 20 + 20
        val v = 15.0
        for (i in 0 until number)
        {
            val tmpVelocityX = Math.pow(-1.0, theRandom.nextInt() % 10.toDouble()) * theRandom.nextFloat() * v * Math.sin(i.toDouble())
            val tmpVelocityY = Math.pow(-1.0, theRandom.nextInt() % 10.toDouble()) * theRandom.nextFloat() * v * Math.cos(i.toDouble())
            val size = 5
            val aFire: Sprite = Flame()
            aFire.width = size.toDouble()
            aFire.height = size.toDouble()
            aFire.centreX = this.centreX
            aFire.centreY = this.centreY
            aFire.velocityX = tmpVelocityX
            aFire.velocityY = tmpVelocityY
            aFire.red = 255
            aFire.blue = 255
            aFire.green = 255
            aFire.bDeadIfNoActions = true
            val aAction = AlphaToAction(aFire)
            aAction.alphaTo(0f, 4f)
            aFire.addAction(aAction)
            if (theScene != null)
            {
                theScene!!.addSprite(aFire)
            }
        }
    }

    init
    {
        red = 255
        bEnableGravity = true
    }
}