/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.fireworks

/**
 * @author ricolwang
 */
class BigFirework : Firework
{
    var subFireworks = Math.abs(theRandom.nextInt()) % 50

    constructor(x: Double, y: Double, width: Double, height: Double, mass: Double, velocityX: Double, velocityY: Double) : super(x, y, width, height, mass, velocityX, velocityY)
    {
        bShouldBlast = true
        blastTime = Math.abs(theRandom.nextInt()) % 3 + 1.toDouble()
    }

    constructor() : super("resource/starBig.png")
    {
        bShouldBlast = true
        blastTime = Math.abs(theRandom.nextInt()) % 3 + 1.toDouble()
    }

    override fun updateState(currentTime: Double)
    {
        super.updateState(currentTime) //To change body of generated methods, choose Tools | Templates.
        if (!isAlive)
        {
            return
        }
        if (bDidBlast)
        {
            for (i in 0 until subFireworks)
            {
                var aObject: Firework
                val tmpMass = theRandom.nextFloat() / 3.0f.toDouble()
                val tmpVelocityX = Math.pow(-1.0, theRandom.nextInt() % 10.toDouble()) * theRandom.nextFloat() * 500.0f + this.velocityX
                val tmpVelocityY = -1 * theRandom.nextFloat() * 500.0f + this.velocityY
                if (Math.abs(theRandom.nextInt() % 10) > 8)
                {
                    aObject = BigFirework()
                    aObject.x = x
                    aObject.y = y
                    aObject.velocityX = tmpVelocityX
                    aObject.velocityY = tmpVelocityY
                    aObject.setLifeTime(1.0)
                    aObject.blastTime = Math.abs(theRandom.nextInt()) % 100 / 100.0 + 0.5
                    aObject.subFireworks = 10
                } else
                {
                    aObject = SmallFirework()
                    aObject.x = x
                    aObject.y = y
                    aObject.velocityX = tmpVelocityX
                    aObject.velocityY = tmpVelocityY
                    aObject.setLifeTime(Math.abs(theRandom.nextInt()) % 5 + 1.toDouble())
                }
                aObject.applyGravity(this.gravity)
                val redValue = Math.abs(theRandom.nextInt()) % 255
                val greenValue = Math.abs(theRandom.nextInt()) % 255
                val blueValue = Math.abs(theRandom.nextInt()) % 255
                aObject.red = redValue
                aObject.green = greenValue
                aObject.blue = blueValue
                theScene!!.addSprite(aObject)
            }
            setShouldDie()
        }
    }
}