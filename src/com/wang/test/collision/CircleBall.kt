/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.collision

import com.wang.Game2dEngine.Shape.ECircleShape
import com.wang.Game2dEngine.painter.interfaces.IEngineGraphics
import com.wang.Game2dEngine.physics.collision.PhysicsCollisionProcess
import com.wang.Game2dEngine.sprite.Sprite
import com.wang.math.vector.Vector
import com.wang.test.basicscene.WallScene
import com.wang.test.basicsprites.BasicSprite
import com.wang.test.common.TestCommon
import java.awt.Color

/**
 * @author ricolwang
 */
class CircleBall(x: Int, y: Int) : BasicSprite()
{
    private val t = 1
    private val MASS_RANGE = 50
    private val MASS_BASE = 50
    private val VELOCITY_RANGE = 200
    private val VELOCITY_BASE = 20
    override fun onCustomDraw(theEngineGraphics: IEngineGraphics)
    {
        super.onCustomDraw(theEngineGraphics) //To change body of generated methods, choose Tools | Templates.

//        theEngineGraphics.setColor(this.getColor());
//        theEngineGraphics.drawArc(0, 0, (int) this.getWidth(), (int) this.getHeight(), 0, 360);
    }

    override fun didUpdateState()
    {
        super.didUpdateState()
        val theWallScene = theScene as WallScene
        val top = theWallScene.theWallTop
        val left = theWallScene.theWallLeft
        val right = theWallScene.theWallRight
        val bottom = theWallScene.theWallBottom
        if (y <= top!!.y + top.height) y = top.y + top.height
        if (y >= bottom!!.y - height) y = bottom.y - height
        if (x <= left!!.x + left.width) x = left.x + left.width
        if (x >= right!!.x - width) x = right.x - width
    }

    override fun onCollideWith(target: Sprite)
    {
        super.onCollideWith(target) //To change body of generated methods, choose Tools | Templates.
        if (theShape is ECircleShape && target.theShape is ECircleShape)
        {
            val A = theShape as ECircleShape
            val B = target.theShape as ECircleShape
            val points = PhysicsCollisionProcess.getCollisionPointsForCircle(A, B)
            for (p in points)
            {
                val aCircleSprite = Circle()
                aCircleSprite.centreX = p.x
                aCircleSprite.centreY = p.y
                theScene.addSprite(aCircleSprite)
                //                this.explode(5, (int)p.x, (int)p.y);
            }
        }
    }

    init
    {
        bCollisionArbitrary = true
        bCollisionDetect = true
        bEnablePhysics = true
        bCustomDrawing = true
        bDrawShape = true
        theColorOfTheShape = Color.orange
        red = 255
        val mass = Math.abs(theRandom.nextInt()) % MASS_RANGE + MASS_BASE
        this.mass = mass.toDouble()
        width = mass * t.toDouble()
        height = mass * t.toDouble()
        val vx = (Math.abs(theRandom.nextInt()) % VELOCITY_RANGE + VELOCITY_BASE) * (if (theRandom.nextBoolean()) 1 else -1).toFloat()
        val vy = (Math.abs(theRandom.nextInt()) % VELOCITY_RANGE + VELOCITY_BASE) * (if (theRandom.nextBoolean()) 1 else -1).toFloat()
        velocity = Vector(vx.toDouble(), vy.toDouble())
        addTargetCollisionCategory(TestCommon.CATEGORY_WALL)
        bDrawVelocityVector = true
        DrawVelocityBase = 0.3
        this.centreX = x.toDouble()
        this.centreY = y.toDouble()
    }
}