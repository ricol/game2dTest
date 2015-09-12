/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.realworld;

import au.com.rmit.Game2dEngine.math.Vector;
import au.com.rmit.Game2dEngine.physics.gravity.Gravity;
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

    Gravity g = new Gravity(0, 0);

    @Override
    public void mousePressed(MouseEvent e)
    {
        super.mousePressed(e);

        float maxmass = 1000;
        float size = 100;

        if (e.getButton() == MouseEvent.BUTTON3)
        {
            Sprite aShape = new Polygon();

            aShape.setBlue(255);
            aShape.setMass(500);
            aShape.setWidth(100);
            aShape.setHeight(100);

            aShape.applyGravity(g);
//            float vx = abs(theRandom.nextInt()) % 200 + 100;
//            float vy = abs(theRandom.nextInt()) % 200 + 100;
//            aShape.setVelocity(new Vector(vx, vy));

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

            aCircle.applyGravity(g);

            float vx = abs(theRandom.nextInt()) % 100 + 50;
            float vy = abs(theRandom.nextInt()) % 100 + 50;
            aCircle.setVelocity(new Vector(vx, vy));

            aCircle.setCentreX(e.getX());
            aCircle.setCentreY(e.getY());
            addSprite(aCircle);
        }
    }
}
