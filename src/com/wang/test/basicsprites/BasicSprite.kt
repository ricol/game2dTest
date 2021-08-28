/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.basicsprites

import com.wang.Game2dEngine.action.AlphaToAction
import com.wang.Game2dEngine.sprite.Sprite
import com.wang.test.navigate.MovingObject

/**
 * @author ricolwang
 */
open class BasicSprite : Sprite
{
    constructor(imagename: String?) : super(imagename)
    {
    }

    constructor() : super()
    {
    }

    protected fun explode(total: Int, x: Int, y: Int)
    {
        val number = Math.abs(theRandom.nextInt()) % 10 + total
        for (i in 0 until number)
        {
            val tmpX: Double = Math.pow(-1.0, theRandom.nextInt() % 10.toDouble()) * theRandom.nextFloat() * MovingObject.Companion.SPEED_EXPLODE_PARTICLE
            val tmpY: Double = Math.pow(-1.0, theRandom.nextInt() % 10.toDouble()) * theRandom.nextFloat() * MovingObject.Companion.SPEED_EXPLODE_PARTICLE
            val aFire = ExpodeParticle()
            aFire.x = x.toDouble()
            aFire.y = y.toDouble()
            aFire.velocityX = tmpX
            aFire.velocityY = tmpY
            aFire.red = 255
            aFire.green = 255
            aFire.blue = 255
            aFire.bDeadIfNoActions = true
            val aAction = AlphaToAction(aFire)
            aAction.alphaTo(0f, 0.1f)
            aFire.addAction(aAction)
            if (theScene == null)
            {
                break
            }
            theScene.addSprite(aFire)
        }
    }
}