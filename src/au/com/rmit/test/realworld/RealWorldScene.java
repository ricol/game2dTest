/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.realworld;

import au.com.rmit.Game2dEngine.physics.gravity.Gravity;
import au.com.rmit.Game2dEngine.sprite.Sprite;
import au.com.rmit.test.scene.WallScene;
import java.awt.event.MouseEvent;

/**
 *
 * @author ricolwang
 */
public class RealWorldScene extends WallScene
{

    Gravity g = new Gravity(0, 1000);

    @Override
    public void mousePressed(MouseEvent e)
    {
        super.mousePressed(e);

        float maxmass = 1000;
        float size = 100;

        if (e.getButton() == MouseEvent.BUTTON3)
        {
            Sprite aCircle = new Rectangle();

            aCircle.setBlue(255);

            aCircle.setCentreX(e.getX());
            aCircle.setCentreY(e.getY());

            aCircle.setMass(500);
            aCircle.setWidth((aCircle.getMass() / maxmass) * size);
            aCircle.setHeight(aCircle.getWidth());

            addSprite(aCircle);
            aCircle.applyGravity(g);

        } else if (e.getButton() == MouseEvent.BUTTON1)
        {
            Sprite aCircle = new Circle();

            aCircle.setRed(255);

            aCircle.setCentreX(e.getX());
            aCircle.setCentreY(e.getY());

            aCircle.setMass(1000);
            aCircle.setWidth((aCircle.getMass() / maxmass) * size);
            aCircle.setHeight(aCircle.getWidth());

            addSprite(aCircle);
            aCircle.applyGravity(g);
        }
    }
}
