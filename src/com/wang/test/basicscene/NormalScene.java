/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.basicscene;

import com.wang.Game2dEngine.scene.Scene;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author ricolwang
 */
public class NormalScene extends Scene implements MouseListener
{

    public NormalScene()
    {
        super();
        this.enableCollisionDetect();
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
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
}
