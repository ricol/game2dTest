/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.galaxies;

import com.wang.Game2dEngine.painter.interfaces.IEngineGraphics;
import com.wang.Game2dEngine.physics.gravity.Gravity;
import com.wang.Game2dEngine.sprite.Sprite;
import com.wang.math.vector.Vector;

import java.awt.*;
import java.util.Set;

/**
 * @author ricolwang
 */
public class Entity extends Sprite
{

    private Set<Entity> allOtherObjects = null;

    public Entity()
    {
        super(0, 0, 0, 0, 0, 0, 0);

        this.bCustomDrawing = true;

        this.theColorOfTheShape = Color.green;
        this.bCollisionArbitrary = true;
        this.bCollisionDetect = true;
//        this.bDrawVelocityVector = true;
        this.DrawVelocityBase = 0.1;
//        this.bDrawGravityVector = true;
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

    void adjustGravity()
    {
        Vector GRAVITY_TOTAL = new Vector(0, 0);
        Set<Entity> all = getAllOtherObjects();
        for (Entity aObject : all)
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
            double G = 6.67384 * 1e-11;
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

    public Set<Entity> getAllOtherObjects()
    {
        if (allOtherObjects == null)
            allOtherObjects = ((GalaxiesDemoScene) theScene).getAllEntities();
        return allOtherObjects;
    }
}
