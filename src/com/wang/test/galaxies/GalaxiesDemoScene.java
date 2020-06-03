/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.galaxies;

import com.wang.Game2dEngine.sprite.Sprite;
import com.wang.test.basicscene.NormalScene;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ricolwang
 */
public class GalaxiesDemoScene extends NormalScene
{

    public GalaxiesDemoScene()
    {
        super();
        this.setFps(100);
        this.setModelFps(100);
    }

    public Set<Entity> getAllEntities()
    {
        Set<Entity> allEntities = new HashSet<>();
        ArrayList<Sprite> all = this.getAllSprites();
        for (Sprite aSprite : all)
        {
            if (aSprite instanceof Entity)
            {
                allEntities.add((Entity) aSprite);
            }
        }

        return allEntities;
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (e.getButton() == MouseEvent.BUTTON1)
        {
            new Galaxy(this, e.getX(), e.getY());
        } else if (e.getButton() == MouseEvent.BUTTON3)
        {
            for (Sprite s : this.getAllSprites())
            {
                s.setLifeTime(0);
            }
        }
    }

}
