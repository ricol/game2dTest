/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.realworld;

import au.com.rmit.Game2dEngine.geometry.Line;
import au.com.rmit.Game2dEngine.geometry.PolygonShape;
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

            aShape.setCentreX(e.getX());
            aShape.setCentreY(e.getY());

            aShape.setMass(500);
            aShape.setWidth((aShape.getMass() / maxmass) * size);
            aShape.setHeight(aShape.getWidth());

            addSprite(aShape);
            aShape.applyGravity(g);
            float vx = abs(theRandom.nextInt()) % 200 + 100;
            float vy = abs(theRandom.nextInt()) % 200 + 100;
            aShape.setVelocity(new Vector(vx, vy));
            
            PolygonShape aPolygon = new PolygonShape();
            double centreX = aShape.getCentreX();
            double centreY = aShape.getCentreY();
            double radius = aShape.getWidth();
            Line line1 = new Line(centreX - radius, centreY - radius, centreX + radius, centreY - radius);
            Line line2 = new Line(centreX + radius, centreY - radius, centreX + radius, centreY + radius);
            Line line3 = new Line(centreX - radius, centreY + radius, centreX + radius, centreY + radius);
            Line line4 = new Line(centreX - radius, centreY - radius, centreX - radius, centreY + radius);
            aPolygon.addSide(line1);
            aPolygon.addSide(line2);
            aPolygon.addSide(line3);
            aPolygon.addSide(line4);
            aShape.setTheShape(aPolygon);

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

            float vx = abs(theRandom.nextInt()) % 100 + 50;
            float vy = abs(theRandom.nextInt()) % 100 + 50;
            aCircle.setVelocity(new Vector(vx, vy));
        }
    }
}
