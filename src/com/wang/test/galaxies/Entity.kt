/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.galaxies

import com.wang.Game2dEngine.painter.interfaces.IEngineGraphics
import com.wang.Game2dEngine.physics.gravity.Gravity
import com.wang.Game2dEngine.sprite.Sprite
import com.wang.math.vector.Vector
import java.awt.Color

/**
 * @author ricolwang
 */
open class Entity : Sprite(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
{
    var allOtherObjects: MutableSet<Entity?>? = null
        get()
        {
            if (field == null) field = (theScene as GalaxiesDemoScene).allEntities as? MutableSet<Entity?>
            return field
        }
        private set

    override fun onCustomDraw(theEngineGraphics: IEngineGraphics)
    {
        super.onCustomDraw(theEngineGraphics) //To change body of generated methods, choose Tools | Templates.
        theEngineGraphics.setColor(this.color)
        theEngineGraphics.fillArc(0, 0, width.toInt() - 1, height.toInt() - 1, 0, 360)
    }

    override fun updateState(currentTime: Double)
    {
        super.updateState(currentTime) //To change body of generated methods, choose Tools | Templates.
        if (gravityEnabled())
        {
            adjustGravity()
        }
    }

    fun adjustGravity()
    {
        var GRAVITY_TOTAL = Vector(0.0, 0.0)
        val all: Set<Entity?>? = allOtherObjects
        for (aObject in all!!)
        {
            if (aObject == null)
            {
                continue
            }
            if (aObject == this)
            {
                continue
            }
            val delX = aObject.centreX - this.centreX
            val delY = aObject.centreY - this.centreY
            val G = 6.67384 * 1e-11
            val M = aObject.mass
            val DISTANCE = Vector(delX, delY)
            val distanceAbsolute = DISTANCE.theMagnitude
            val absoluteGravity = G * M / (distanceAbsolute * distanceAbsolute)
            val GRAVITY = DISTANCE.theUnitVector.multiplyNumber(absoluteGravity)
            GRAVITY_TOTAL = GRAVITY.addVector(GRAVITY_TOTAL)
        }
        val g = Gravity(GRAVITY_TOTAL.x, GRAVITY_TOTAL.y)
        applyGravity(g)
    }

    init
    {
        bCustomDrawing = true
        theColorOfTheShape = Color.green
        bCollisionArbitrary = true
        bCollisionDetect = true
        //        this.bDrawVelocityVector = true;
        DrawVelocityBase = 0.1
        //        this.bDrawGravityVector = true;
        DrawGravityBase = 0.05
    }
}