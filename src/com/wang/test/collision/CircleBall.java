/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.collision;

import com.wang.Game2dEngine.Shape.ECircleShape;
import com.wang.Game2dEngine.painter.interfaces.IEngineGraphics;
import com.wang.Game2dEngine.physics.collision.PhysicsCollisionProcess;
import com.wang.Game2dEngine.sprite.Sprite;
import com.wang.math.geometry.Point;
import com.wang.math.vector.Vector;
import com.wang.test.basicscene.WallScene;
import com.wang.test.basicsprites.BasicSprite;
import com.wang.test.basicsprites.Wall;
import com.wang.test.common.TestCommon;
import java.awt.Color;
import static java.lang.Math.abs;
import java.util.ArrayList;

/**
 *
 * @author ricolwang
 */
public class CircleBall extends BasicSprite
{

    private int t = 1;
    private int MASS_RANGE = 50;
    private int MASS_BASE = 50;
    private int VELOCITY_RANGE = 200;
    private int VELOCITY_BASE = 20;

    public CircleBall(int x, int y)
    {
        this.bCollisionArbitrary = true;
        this.bCollisionDetect = true;
        this.bEnablePhysics = true;
        this.bCustomDrawing = true;
        this.bDrawShape = true;
        this.theColorOfTheShape = Color.orange;
        this.setRed(255);
        int mass = abs(theRandom.nextInt()) % MASS_RANGE + MASS_BASE;
        this.setMass(mass);
        this.setWidth(mass * t);
        this.setHeight(mass * t);
        float vx = (abs(theRandom.nextInt()) % VELOCITY_RANGE + VELOCITY_BASE) * (theRandom.nextBoolean() ? 1 : -1);
        float vy = (abs(theRandom.nextInt()) % VELOCITY_RANGE + VELOCITY_BASE) * (theRandom.nextBoolean() ? 1 : -1);
        this.setVelocity(new Vector(vx, vy));
        this.addTargetCollisionCategory(TestCommon.CATEGORY_WALL);
//        this.bDrawVelocityVector = true;
//        this.DrawVelocityBase = 0.3;
        this.setCentreX(x);
        this.setCentreY(y);
    }

    @Override
    public void onCustomDraw(IEngineGraphics theEngineGraphics)
    {
        super.onCustomDraw(theEngineGraphics); //To change body of generated methods, choose Tools | Templates.

//        theEngineGraphics.setColor(this.getColor());
//        theEngineGraphics.drawArc(0, 0, (int) this.getWidth(), (int) this.getHeight(), 0, 360);
    }

    @Override
    public void didUpdateState()
    {
        super.didUpdateState();

        WallScene theWallScene = (WallScene) this.theScene;
        Wall top = theWallScene.theWallTop;
        Wall left = theWallScene.theWallLeft;
        Wall right = theWallScene.theWallRight;
        Wall bottom = theWallScene.theWallBottom;
        if (this.getY() <= top.getY() + top.getHeight()) this.setY(top.getY() + top.getHeight());
        if (this.getY() >= bottom.getY() - this.getHeight()) this.setY(bottom.getY() - this.getHeight());
        if (this.getX() <= left.getX() + left.getWidth()) this.setX(left.getX() + left.getWidth());
        if (this.getX() >= right.getX() - this.getWidth()) this.setX(right.getX() - this.getWidth());
    }

    @Override
    public void onCollideWith(Sprite target)
    {
        super.onCollideWith(target); //To change body of generated methods, choose Tools | Templates.

        if (this.getTheShape() instanceof ECircleShape && target.getTheShape() instanceof ECircleShape)
        {
            ECircleShape A = (ECircleShape) this.getTheShape();
            ECircleShape B = (ECircleShape) target.getTheShape();
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
