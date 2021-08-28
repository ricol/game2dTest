/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.basicscene

import com.wang.Game2dEngine.physics.sprites.WallSprite
import com.wang.test.basicsprites.Wall
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import java.awt.event.MouseEvent

/**
 * @author ricolwang
 */
open class WallScene : NormalScene()
{
    var theWallTop: Wall? = null
    var theWallLeft: Wall? = null
    var theWallBottom: Wall? = null
    var theWallRight: Wall? = null
    var startX = 5
    var startY = 5
    var wallSize = 20
    fun resizeWalls()
    {
        if (theWallTop != null)
        {
            theWallTop!!.x = startX.toDouble()
            theWallTop!!.y = startY.toDouble()
            theWallTop!!.width = width - 2 * startX.toDouble()
            theWallTop!!.height = wallSize.toDouble()
        }
        if (theWallBottom != null)
        {
            theWallBottom!!.x = startX.toDouble()
            theWallBottom!!.y = height - wallSize - startX.toDouble()
            theWallBottom!!.width = width - 2 * startX.toDouble()
            theWallBottom!!.height = wallSize.toDouble()
        }
        if (theWallLeft != null)
        {
            theWallLeft!!.x = startX.toDouble()
            theWallLeft!!.y = startY.toDouble()
            theWallLeft!!.width = wallSize.toDouble()
            theWallLeft!!.height = height - 2 * startY.toDouble()
        }
        if (theWallRight != null)
        {
            theWallRight!!.x = width - wallSize - startX.toDouble()
            theWallRight!!.y = startY.toDouble()
            theWallRight!!.width = wallSize.toDouble()
            theWallRight!!.height = height - 2 * startY.toDouble()
        }
    }

    override fun mousePressed(e: MouseEvent)
    {
        if (theWallTop == null)
        {
            theWallTop = Wall()
            theWallTop!!.blue = 255
            theWallTop!!.wallType = WallSprite.WALLTYPE.TOP
            addSprite(theWallTop!!)
        }
        if (theWallBottom == null)
        {
            theWallBottom = Wall()
            theWallBottom!!.blue = 255
            theWallBottom!!.wallType = WallSprite.WALLTYPE.BOTTOM
            addSprite(theWallBottom!!)
        }
        if (theWallLeft == null)
        {
            theWallLeft = Wall()
            theWallLeft!!.blue = 255
            theWallLeft!!.wallType = WallSprite.WALLTYPE.LEFT
            addSprite(theWallLeft!!)
        }
        if (theWallRight == null)
        {
            theWallRight = Wall()
            theWallRight!!.blue = 255
            theWallRight!!.wallType = WallSprite.WALLTYPE.RIGHT
            addSprite(theWallRight!!)
        }
        resizeWalls()
    }

    init
    {
        addComponentListener(object : ComponentAdapter()
        {
            override fun componentResized(evt: ComponentEvent)
            {
                resizeWalls()
            }
        })
    }
}