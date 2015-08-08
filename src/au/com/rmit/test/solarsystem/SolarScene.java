/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.solarsystem;

import au.com.rmit.Game2dEngine.sprite.Sprite;
import au.com.rmit.test.scene.WallScene;
import au.com.rmit.test.universe.Entity;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ricolwang
 */
public class SolarScene extends WallScene
{

    Sun theSun;

    @Override
    public void mousePressed(MouseEvent e)
    {
        super.mousePressed(e);

        if (e.getButton() == MouseEvent.BUTTON3)
        {
            if (theSun == null)
            {
                theSun = new Sun();
                theSun.setCentreX(e.getX());
                theSun.setCentreY(e.getY());

                addSprite(theSun);
            }

        } else if (e.getButton() == MouseEvent.BUTTON1)
        {

            Earth theEarth = new Earth();
            theEarth.setCentreX(e.getX());
            theEarth.setCentreY(e.getY());
            theEarth.addEntity(theSun);
            addSprite(theEarth);

            Moon theMoon = new Moon();
            theMoon.setCentreX(theEarth.getCentreX() + theMoon.getWidth() * 3 + theEarth.getWidth() / 2 + theMoon.getWidth() / 2);
            theMoon.setCentreY(theEarth.getCentreY());
            theMoon.addEntity(theEarth);
            addSprite(theMoon);
        }
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
}
