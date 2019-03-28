/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.navigate;

import com.wang.Game2dEngine.physics.gravity.Gravity;
import com.wang.Game2dEngine.scene.Scene;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author ricolwang
 */
public class NavigateScene extends Scene implements MouseListener, KeyListener
{

    public static int CATEGORY_MY_SPACESHIP = 1;
    public static int CATEGORY_METEORITE = 2;

    Myspaceship ship = Myspaceship.getInstance();
    Gravity g = new Gravity(0, 600);

    public NavigateScene()
    {
        super();

        this.enableCollisionDetect();
        this.addMouseListener(this);
        this.getComponent().addKeyListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (e.getButton() == MouseEvent.BUTTON3)
        {
            //right button
            ship.rightEngine(true);
        } else if (e.getButton() == MouseEvent.BUTTON1)
        {
            //left button
            ship.leftEngine(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if (e.getButton() == MouseEvent.BUTTON3)
        {
            //right button
            ship.rightEngine(false);
        } else if (e.getButton() == MouseEvent.BUTTON1)
        {
            //left button
            ship.leftEngine(false);
        }
    }

    @Override
    public void didStart()
    {
        super.didStart(); //To change body of generated methods, choose Tools | Templates.

        ship.setCentreX(this.getWidth() / 2.0);
        ship.setCentreY(this.getHeight() / 2.0);
        ship.applyGravity(g);
        this.addSprite(ship);
        
        this.getComponent().requestFocus();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == com.sun.glass.events.KeyEvent.VK_LEFT)
        {
            ship.leftEngine(true);
        }else if (e.getKeyCode() == com.sun.glass.events.KeyEvent.VK_RIGHT)
        {
            ship.rightEngine(true);
        }else if (e.getKeyCode() == com.sun.glass.events.KeyEvent.VK_UP || e.getKeyCode() == com.sun.glass.events.KeyEvent.VK_SPACE)
        {
            ship.middleEngine(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == com.sun.glass.events.KeyEvent.VK_LEFT)
        {
            ship.leftEngine(false);
        }else if (e.getKeyCode() == com.sun.glass.events.KeyEvent.VK_RIGHT)
        {
            ship.rightEngine(false);
        }else if (e.getKeyCode() == com.sun.glass.events.KeyEvent.VK_UP || e.getKeyCode() == com.sun.glass.events.KeyEvent.VK_SPACE)
        {
            ship.middleEngine(false);
        }
    }

}
