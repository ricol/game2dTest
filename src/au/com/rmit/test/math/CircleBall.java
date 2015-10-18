/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.math;

import au.com.rmit.Game2dEngine.geometry.CircleShape;
import au.com.rmit.Game2dEngine.geometry.Point;
import au.com.rmit.Game2dEngine.math.vector.Vector;
import au.com.rmit.Game2dEngine.physics.collision.PhysicsCollisionProcess;
import au.com.rmit.Game2dEngine.sprite.Sprite;
import au.com.rmit.test.basicsprites.BasicSprite;
import au.com.rmit.test.common.TestCommon;
import java.awt.Color;
import java.awt.Graphics2D;
import static java.lang.Math.abs;
import java.util.ArrayList;

/**
 *
 * @author ricolwang
 */
public class CircleBall extends BasicSprite
{
    public CircleBall()
    {
        this.bCollisionArbitrary = true;
        this.bCollisionDetect = true;
        this.bEnablePhysics = true;
        this.bCustomDrawing = true;
        this.bDrawShape = true;
        this.theColorOfTheShape = Color.orange;
        this.setRed(255);
        this.setWidth(100);
        this.setHeight(100);
        this.setMass(50);
        float vx = (abs(theRandom.nextInt()) % 10 + 10) * (theRandom.nextBoolean() ? 1 : -1);
        float vy = (abs(theRandom.nextInt()) % 10 + 10) * (theRandom.nextBoolean() ? 1 : -1);
        this.setVelocity(new Vector(vx, vy));
        this.addTargetCollisionCategory(TestCommon.CATEGORY_WALL);
//        this.bDrawVelocityVector = true;
//        this.DrawVelocityBase = 0.3;
    }

    @Override
    public void onCustomDraw(Graphics2D theGraphics2D)
    {
        super.onCustomDraw(theGraphics2D); //To change body of generated methods, choose Tools | Templates.

//        theGraphics2D.setColor(this.getColor());
//        theGraphics2D.fillArc(0, 0, (int) this.getWidth(), (int) this.getHeight(), 0, 360);
    }

    @Override
    public void onCollideWith(Sprite target)
    {
        super.onCollideWith(target); //To change body of generated methods, choose Tools | Templates.
        
        if (this.getTheShape() instanceof CircleShape && target.getTheShape() instanceof CircleShape)
        {
            CircleShape A = (CircleShape)this.getTheShape();
            CircleShape B = (CircleShape)target.getTheShape();
            ArrayList<Point> points = PhysicsCollisionProcess.getCollisionPointsForCircle(A, B);
            for (Point p : points)
            {
                Circle aCircleSprite = new Circle();
                aCircleSprite.setCentreX(p.x);
                aCircleSprite.setCentreY(p.y);
                this.theScene.addSprite(aCircleSprite);
//                this.explode(5, (int)p.x, (int)p.y);
            }
        }
    }
    
}
