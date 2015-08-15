/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.realworld;

import au.com.rmit.Game2dEngine.math.CollisionQuadraticEquation;
import au.com.rmit.Game2dEngine.math.Vector;
import au.com.rmit.Game2dEngine.sprite.Sprite;
import au.com.rmit.test.gui.TestCommon;
import au.com.rmit.test.sprites.Wall;
import java.awt.Graphics2D;
import static java.lang.Math.abs;

/**
 *
 * @author ricolwang
 */
public class ShapeSprite extends Sprite
{

    public ShapeSprite()
    {
        this.bCollisionDetect = true;
        this.setCollisionCategory(TestCommon.CATEGORY_CIRCLE);
        this.addTargetCollisionCategory(TestCommon.CATEGORY_WALL);

        this.bCollisionArbitrary = true;
        this.bCustomDrawing = true;
        this.enableGravity();
    }

    @Override
    public void onCustomDraw(Graphics2D theGraphics2D)
    {
        super.onCustomDraw(theGraphics2D); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void onCollideWith(Sprite target)
    {
        if (target instanceof Wall)
        {
            Vector V1 = new Vector(this.getVelocityX(), this.getVelocityY());
            V1.print("BEFORE V");
            System.out.println("Y: " + (this.getY() + this.getHeight()) + " <-> Bottom: " + this.theScene.getHeight());

            Wall aWall = (Wall) target;
            if (aWall.wallType == Wall.WALLTYPE.LEFT)
            {
                this.setVelocityX(-this.getVelocityX());
            } else if (aWall.wallType == Wall.WALLTYPE.RIGHT)
            {
                this.setVelocityX(-this.getVelocityX());
            } else if (aWall.wallType == Wall.WALLTYPE.TOP)
            {
                this.setVelocityY(-this.getVelocityY());
            } else if (aWall.wallType == Wall.WALLTYPE.BOTTOM)
            {
                double v = this.getVelocityY();
                v -= 5;
                this.setVelocityY(-v);
            }
        } else
            this.processCollision(target);
    }

    @Override
    public void afterCollisionProcess(double currentTime)
    {
        super.afterCollisionProcess(currentTime); //To change body of generated methods, choose Tools | Templates.

        Wall theBottomWall = ((RealWorldScene) this.theScene).theWallBottom;

        this.enableGravity();

        if (abs(this.getVelocityY()) <= 70 && distanceToWall((Wall) theBottomWall) <= 2)
        {
            this.setVelocityY(0);
            this.disableGravity();
        }

        this.checkWall();
    }

    public void processCollision(Sprite target)
    {
        Vector AB = new Vector(target.getCentreX() - this.getCentreX(), target.getCentreY() - this.getCentreY());
        if (AB.getMagnitude() <= 0)
            return;

        Vector BC = AB.getPerpendicularUnitVectorClockwise();

        Vector V_A = new Vector(this.getVelocityX(), this.getVelocityY());

        double cosBC_V_A = BC.getCosValueForAngleToVector(V_A);
        if (cosBC_V_A < 0)
            BC = AB.getPerpendicularUnitVectorCounterClockwise();

        Vector UNIT_AB = AB.getTheUnitVector();
        Vector V_A_AB = V_A.getProjectVectorOn(UNIT_AB);

        Vector V_B = new Vector(target.getVelocityX(), target.getVelocityY());
        Vector V_B_AB = V_B.getProjectVectorOn(UNIT_AB);

        double absV_A_AB = V_A_AB.getMagnitude();

        if (V_A.getCosValueForAngleToVector(AB) < 0)
            absV_A_AB = -absV_A_AB;

        double absV_B_AB = V_B_AB.getMagnitude();

        if (V_B.getCosValueForAngleToVector(AB) < 0)
            absV_B_AB = -absV_B_AB;

        CollisionQuadraticEquation aEquation = new CollisionQuadraticEquation(this.getMass(), target.getMass(), absV_A_AB, absV_B_AB);
        double resultAbsV_A_AB = aEquation.getNewVelocityAlternative();
        double resultAbsV_B_AB = aEquation.getTheOtherObjectVelocityAlternative();

        Vector RESULT_V_A_AB = UNIT_AB.multiplyNumber(resultAbsV_A_AB);
        Vector UNIT_BC = BC.getTheUnitVector();
        Vector V_A_BC = V_A.getProjectVectorOn(UNIT_BC);
        Vector RESULT_V_A = RESULT_V_A_AB.addVector(V_A_BC);

        this.setVelocityX(RESULT_V_A.x);
        this.setVelocityY(RESULT_V_A.y);

        Vector RESULT_V_B_AB = UNIT_AB.multiplyNumber(resultAbsV_B_AB);
        Vector V_B_BC = V_B.getProjectVectorOn(UNIT_BC);
        Vector RESULT_V_B = RESULT_V_B_AB.addVector(V_B_BC);

        target.setVelocityX(RESULT_V_B.x);
        target.setVelocityY(RESULT_V_B.y);

        this.setTargetCollisionProcessed(true);
    }

    @Override
    public String toString()
    {
        return "Class: " + this.getClass() + "; identifier: " + this.identifier + "; velocityX: " + this.getVelocityX() + "; velocityY: " + this.getVelocityY();
    }

    void checkWall()
    {
        if (this.theScene == null)
            return;

        Wall theWall = ((RealWorldScene) this.theScene).theWallTop;
        while (this.getY() < theWall.getY() + theWall.getHeight())
            this.setY(this.getY() + 1);

        theWall = ((RealWorldScene) this.theScene).theWallBottom;
        while (this.getY() + this.getHeight() > theWall.getY())
            this.setY(this.getY() - 1);

        theWall = ((RealWorldScene) this.theScene).theWallLeft;
        while (this.getX() < theWall.getX() + theWall.getWidth())
            this.setX(this.getX() + 1);

        theWall = ((RealWorldScene) this.theScene).theWallRight;
        while (this.getX() + this.getWidth() > theWall.getX())
            this.setX(this.getX() - 1);
    }

    double distanceToWall(Wall theWall)
    {
        return abs(this.getCentreY() + this.getHeight() / 2 - theWall.getY());
    }
}
