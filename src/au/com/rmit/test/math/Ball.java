/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.math;

import au.com.rmit.Game2dEngine.math.vector.Vector;
import au.com.rmit.test.basicsprites.BasicSprite;
import au.com.rmit.test.common.TestCommon;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author ricolwang
 */
public class Ball extends BasicSprite
{

    public Ball()
    {
        this.bCollisionArbitrary = true;
        this.bCollisionDetect = true;
        this.bEnablePhysics = true;
        this.bCustomDrawing = true;
        this.bDrawShape = true;
        this.theColorOfTheShape = Color.orange;
        this.setRed(255);
        this.setWidth(50);
        this.setHeight(50);
        this.setMass(50);
//        float vx = (abs(theRandom.nextInt()) % 200 + 100) * (theRandom.nextBoolean() ? 1 : -1);
//        float vy = (abs(theRandom.nextInt()) % 200 + 100) * (theRandom.nextBoolean() ? 1 : -1);
//        this.setVelocity(new Vector(vx, vy));
        this.setVelocity(new Vector(100, 100));
        this.addTargetCollisionCategory(TestCommon.CATEGORY_WALL);
        this.bDrawVelocityVector = true;
        this.DrawVelocityBase = 0.3;
    }

    @Override
    public void onCustomDraw(Graphics2D theGraphics2D)
    {
        super.onCustomDraw(theGraphics2D); //To change body of generated methods, choose Tools | Templates.

//        theGraphics2D.setColor(this.getColor());
//        theGraphics2D.fillArc(0, 0, (int) this.getWidth(), (int) this.getHeight(), 0, 360);
    }

    public void rotateClockwise(double angle)
    {
        Vector v = this.getVelocity();
        Vector NewV = v.getVectorRotateByInClockwise(angle);
        this.setVelocity(NewV);
    }

    public void rotateCounterClock(double angle)
    {
        Vector v = this.getVelocity();
        Vector NewV = v.getVectorRotateByInCounterClockwise(angle);
        this.setVelocity(NewV);
    }

}
