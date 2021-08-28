/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.basicscene

import com.wang.Game2dEngine.scene.Scene
import java.awt.event.MouseEvent
import java.awt.event.MouseListener

/**
 * @author ricolwang
 */
open class NormalScene : Scene(), MouseListener
{
    override fun mouseClicked(e: MouseEvent)
    {
    }

    override fun mousePressed(e: MouseEvent)
    {
    }

    override fun mouseReleased(e: MouseEvent)
    {
    }

    override fun mouseEntered(e: MouseEvent)
    {
    }

    override fun mouseExited(e: MouseEvent)
    {
    }

    init
    {
        enableCollisionDetect()
        addMouseListener(this)
    }
}