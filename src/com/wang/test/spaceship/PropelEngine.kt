/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.spaceship

import com.wang.Game2dEngine.action.AlphaToAction
import com.wang.Game2dEngine.sprite.Sprite
import com.wang.test.fireworks.FireSprite
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.Timer

/**
 * @author ricolwang
 */
class PropelEngine : Sprite(), ActionListener
{
    var theTimerForEngine = Timer(10, this)
    override fun onDead()
    {
        super.onDead() //To change body of generated methods, choose Tools | Templates.
        theTimerForEngine.stop()
        parent = null
        theScene = null
    }

    fun propel()
    {
        val number = Math.abs(theRandom.nextInt()) % 5 + 10
        for (i in 0 until number)
        {
            val tmpVelocityX = Math.pow(-1.0, theRandom.nextInt() % 10.toDouble()) * theRandom.nextFloat() * 20 * 4
            val tmpVelocityY = theRandom.nextFloat() * 100 * 10.toDouble()
            val size = 6
            val aFire: Sprite = FireSprite(0.0, 0.0, size.toDouble(), size.toDouble(), 0.0, 0.0, 0.0)
            aFire.centreX = this.centreX
            aFire.centreY = this.centreY
            aFire.velocityX = tmpVelocityX
            aFire.velocityY = tmpVelocityY
            aFire.red = 255
            aFire.green = 255
            aFire.blue = 255
            aFire.width = size.toDouble()
            aFire.height = size.toDouble()
            aFire.bDeadIfNoActions = true
            val aAction = AlphaToAction(aFire)
            aAction.alphaTo(0f, 0.1f)
            aFire.addAction(aAction)
            if (parent == null)
            {
                break
            }
            parent.addAChild(aFire)
        }
    }

    override fun actionPerformed(e: ActionEvent)
    {
        if (e.source == theTimerForEngine)
        {
            propel()
        }
    }

    init
    {
//        RotateByAction aAction = new RotateByAction();
//        aAction.rotateBy(-Math.PI * 20, 20);
//        this.addAction(aAction);
        theTimerForEngine.start()
    }
}