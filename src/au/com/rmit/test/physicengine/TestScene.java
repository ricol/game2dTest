/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.physicengine;

import au.com.rmit.Game2dEngine.geometry.shape.CircleShape;
import au.com.rmit.Game2dEngine.sprite.Sprite;
import au.com.rmit.test.scene.WallScene;
import java.awt.event.MouseEvent;
import static java.lang.Math.abs;

/**
 *
 * @author ricolwang
 */
public class TestScene extends WallScene
{

    @Override
    public void mousePressed(MouseEvent e)
    {
        super.mousePressed(e);
        
        float maxmass = 1000;
        float size = 100;

        if (e.getButton() == MouseEvent.BUTTON3)
        {
            Sprite aCircle = new CircleSprite();

            aCircle.setBlue(255);

            aCircle.setCentreX(e.getX());
            aCircle.setCentreY(e.getY());

//                    aCircle.setMass(abs(theRandom.nextInt()) % 900 + 100);
            aCircle.setMass(500);
            aCircle.setVelocityX(abs(theRandom.nextInt()) % 200 + 200);
            aCircle.setVelocityY(abs(theRandom.nextInt()) % 200 + 200);
            aCircle.setWidth((aCircle.getMass() / maxmass) * size);
            aCircle.setHeight(aCircle.getWidth());

            aCircle.setTheShape(new CircleShape(aCircle.getCentreX(), aCircle.getCentreY(), aCircle.getWidth() > aCircle.getHeight() ? aCircle.getWidth() / 2.0f : aCircle.getHeight() / 2.0f));

            addSprite(aCircle);

        } else if (e.getButton() == MouseEvent.BUTTON1)
        {
            Sprite aCircle = new CircleSprite();

            aCircle.setRed(255);

            aCircle.setCentreX(e.getX());
            aCircle.setCentreY(e.getY());

//                    aCircle.setMass(abs(theRandom.nextInt()) % 900 + 100);
            aCircle.setMass(1000);
            aCircle.setVelocityX(abs(theRandom.nextInt()) % 200 + 200);
            aCircle.setVelocityY(abs(theRandom.nextInt()) % 200 + 200);
            aCircle.setWidth((aCircle.getMass() / maxmass) * size);
            aCircle.setHeight(aCircle.getWidth());

            aCircle.setTheShape(new CircleShape(aCircle.getCentreX(), aCircle.getCentreY(), aCircle.getWidth() > aCircle.getHeight() ? aCircle.getWidth() / 2.0f : aCircle.getHeight() / 2.0f));

            addSprite(aCircle);
        }
    }

}
