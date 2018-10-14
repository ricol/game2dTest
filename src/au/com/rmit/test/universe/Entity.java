/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.universe;

import au.com.rmit.Game2dEngine.painter.interfaces.IEngineGraphics;
import au.com.rmit.Game2dEngine.physics.gravity.Gravity;
import au.com.rmit.Game2dEngine.sprite.Sprite;
import au.com.rmit.math.vector.Vector;
import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ricolwang
 */
public class Entity extends Sprite
{

    Set<Entity> otherObjects = new HashSet<>();

    public Entity()
    {
        super(0, 0, 0, 0, 0, 0, 0);

        this.bCustomDrawing = true;

        this.theColorOfTheShape = Color.green;
        this.bCollisionArbitrary = true;
        this.bCollisionDetect = true;
        this.bDrawVelocityVector = true;
        this.DrawVelocityBase = 0.1;
        this.bDrawGravityVector = true;
        this.DrawGravityBase = 0.05;
    }

    @Override
    public void onCustomDraw(IEngineGraphics theEngineGraphics)
    {
        super.onCustomDraw(theEngineGraphics); //To change body of generated methods, choose Tools | Templates.

        theEngineGraphics.setColor(this.getColor());
        theEngineGraphics.fillArc(0, 0, (int) this.getWidth() - 1, (int) this.getHeight() - 1, 0, 360);
    }

    @Override
    public void updateState(double currentTime)
    {
        super.updateState(currentTime); //To change body of generated methods, choose Tools | Templates.

        if (this.gravityEnabled())
        {
            this.adjustGravity();
        }
    }

    synchronized void adjustGravity()
    {
        Vector GRAVITY_TOTAL = new Vector(0, 0);

        for (Entity aObject : otherObjects)
        {
            if (aObject == null)
            {
                continue;
            }

            if (aObject.equals(this))
            {
                continue;
            }

            double delX = aObject.getCentreX() - this.getCentreX();
            double delY = aObject.getCentreY() - this.getCentreY();
            double G = 6.67384 * Math.pow(10, -11);
            double M = aObject.getMass();
            Vector DISTANCE = new Vector(delX, delY);
            double distanceAbsolute = DISTANCE.getTheMagnitude();
            double absoluteGravity = (G * M) / (distanceAbsolute * distanceAbsolute);
            Vector GRAVITY = DISTANCE.getTheUnitVector().multiplyNumber(absoluteGravity);
            GRAVITY_TOTAL = GRAVITY.addVector(GRAVITY_TOTAL);
        }

        Gravity g = new Gravity(GRAVITY_TOTAL.x, GRAVITY_TOTAL.y);
        this.applyGravity(g);
    }

    synchronized public void addEntity(Entity aEntity)
    {
        this.otherObjects.add(aEntity);
    }

    synchronized public void removeEntity(Entity aEntity)
    {
        this.otherObjects.remove(aEntity);
    }

    synchronized public void addEntities(Set<Entity> all)
    {
        this.otherObjects.addAll(all);
    }

    synchronized public void removeEntities(Set<Entity> all)
    {
        this.otherObjects.removeAll(all);
    }

}
