/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.collision

import com.wang.Game2dEngine.physics.gravity.Gravity
import com.wang.Game2dEngine.sprite.Sprite
import com.wang.test.basicscene.WallScene
import java.awt.event.MouseEvent

/**
 * @author ricolwang
 */
class CollisionScene : WallScene()
{
    var g = Gravity(0.0, 500.0)
    override fun mousePressed(e: MouseEvent)
    {
        super.mousePressed(e)
        val x = e.x
        val y = e.y
        val aBall: Sprite = CircleBall(x, y)
        aBall.bEnableGravity = true
        aBall.applyGravity(g)
        addSprite(aBall)
    }
}