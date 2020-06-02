/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.galaxies;

import com.wang.Game2dEngine.sprite.Sprite;
import com.wang.test.basicscene.WallScene;
import java.awt.event.MouseEvent;

/**
 *
 * @author ricolwang
 */
public class GalaxiesDemoScene extends WallScene
{

    @Override
    public void mousePressed(MouseEvent e)
    {
        super.mousePressed(e);

        if (e.getButton() == MouseEvent.BUTTON1)
        {
            new Galaxy(this, e.getX(), e.getY());
        }else if (e.getButton() == MouseEvent.BUTTON3)
        {
            for (Sprite s : this.getAllSprites())
            {
                s.setLifeTime(0);
            }
        }
    }

}
