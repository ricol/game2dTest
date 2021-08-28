/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.fireworks

import com.wang.Game2dEngine.action.RotateByAction
import com.wang.Game2dEngine.sprite.Sprite

/**
 * @author ricolwang
 */
abstract class Firework : Sprite
{
    var bShouldBlast = false
    var bDidBlast = false
    var blastTime = Math.abs(theRandom.nextInt()) % 10.toDouble()

    constructor(x: Double, y: Double, width: Double, height: Double, mass: Double, velocityX: Double, velocityY: Double) : super(x, y, width, height, mass, velocityX, velocityY)
    {
    }

    constructor(imagename: String?) : super(imagename)
    {
        val aAction = RotateByAction()
        aAction.rotateBy(Math.PI * 2 * if (theRandom.nextBoolean()) 1 else -1, 2.0)
        addAction(aAction)
        bEnableGravity = true
    }

    override fun updateState(currentTime: Double)
    {
        super.updateState(currentTime) //To change body of generated methods, choose Tools | Templates.
        if (isAlive && bShouldBlast && !bDidBlast)
        {
            if (currentTime - this.startTime >= blastTime * 1000)
            {
                bDidBlast = true
            }
        }
    }
}