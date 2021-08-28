/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.navigate

import com.wang.Game2dEngine.physics.gravity.Gravity
import com.wang.Game2dEngine.scene.Scene
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.awt.event.MouseEvent
import java.awt.event.MouseListener

/**
 * @author ricolwang
 */
class NavigateScene : Scene(), MouseListener, KeyListener
{
    var ship: Myspaceship = Myspaceship.Companion.instance
    var g = Gravity(0, 600)
    override fun mousePressed(e: MouseEvent)
    {
        if (e.button == MouseEvent.BUTTON3)
        {
            //right button
            ship.rightEngine(true)
        } else if (e.button == MouseEvent.BUTTON1)
        {
            //left button
            ship.leftEngine(true)
        }
    }

    override fun mouseReleased(e: MouseEvent)
    {
        if (e.button == MouseEvent.BUTTON3)
        {
            //right button
            ship.rightEngine(false)
        } else if (e.button == MouseEvent.BUTTON1)
        {
            //left button
            ship.leftEngine(false)
        }
    }

    override fun didStart()
    {
        super.didStart() //To change body of generated methods, choose Tools | Templates.
        ship.centreX = this.width / 2.0
        ship.centreY = this.height / 2.0
        ship.applyGravity(g)
        this.addSprite(ship)
        this.component.requestFocus()
    }

    override fun mouseClicked(e: MouseEvent)
    {
    }

    override fun mouseEntered(e: MouseEvent)
    {
    }

    override fun mouseExited(e: MouseEvent)
    {
    }

    override fun keyTyped(e: KeyEvent)
    {
    }

    override fun keyPressed(e: KeyEvent)
    {
        if (e.keyCode == KeyEvent.VK_LEFT)
        {
            ship.leftEngine(true)
        } else if (e.keyCode == KeyEvent.VK_RIGHT)
        {
            ship.rightEngine(true)
        } else if (e.keyCode == KeyEvent.VK_UP || e.keyCode == KeyEvent.VK_SPACE)
        {
            ship.middleEngine(true)
        }
    }

    override fun keyReleased(e: KeyEvent)
    {
        if (e.keyCode == KeyEvent.VK_LEFT)
        {
            ship.leftEngine(false)
        } else if (e.keyCode == KeyEvent.VK_RIGHT)
        {
            ship.rightEngine(false)
        } else if (e.keyCode == KeyEvent.VK_UP || e.keyCode == KeyEvent.VK_SPACE)
        {
            ship.middleEngine(false)
        }
    }

    companion object
    {
        var CATEGORY_MY_SPACESHIP = 1
        var CATEGORY_METEORITE = 2
    }

    init
    {
        enableCollisionDetect()
        addMouseListener(this)
        this.component.addKeyListener(this)
    }
}