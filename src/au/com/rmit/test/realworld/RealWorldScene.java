/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.realworld;

import au.com.rmit.Game2dEngine.math.Vector;
import au.com.rmit.Game2dEngine.sprite.Sprite;
import au.com.rmit.test.scene.WallScene;
import java.awt.event.MouseEvent;
import static java.lang.Math.abs;

/**
 *
 * @author ricolwang
 */
public class RealWorldScene extends WallScene
{

    @Override
    public void mousePressed(MouseEvent e)
    {
        super.mousePressed(e);

        float maxmass = 1000;
        float size = 100;

        if (e.getButton() == MouseEvent.BUTTON3)
        {
            Sprite aShape = new Rectangle();
            aShape.setBlue(255);
            aShape.setMass(500);
            aShape.setWidth(100);
            aShape.setHeight(100);
            float vx = (abs(theRandom.nextInt()) % 200 + 100) * (theRandom.nextBoolean() ? 1 : -1);
            float vy = (abs(theRandom.nextInt()) % 200 + 100) * (theRandom.nextBoolean() ? 1 : -1);
            aShape.setVelocity(new Vector(vx, vy));
            aShape.setCentreX(e.getX());
            aShape.setCentreY(e.getY());
            addSprite(aShape);
        } else if (e.getButton() == MouseEvent.BUTTON1)
        {
            Sprite aCircle = new Circle();
            aCircle.setRed(255);
            aCircle.setMass(1000);
            aCircle.setWidth((aCircle.getMass() / maxmass) * size);
            aCircle.setHeight(aCircle.getWidth());
            float vx = (abs(theRandom.nextInt()) % 200 + 100) * (theRandom.nextBoolean() ? 1 : -1);
            float vy = (abs(theRandom.nextInt()) % 200 + 100) * (theRandom.nextBoolean() ? 1 : -1);
            aCircle.setVelocity(new Vector(vx, vy));
            aCircle.setCentreX(e.getX());
            aCircle.setCentreY(e.getY());
            addSprite(aCircle);
        }
    }
}
