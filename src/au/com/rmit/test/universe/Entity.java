/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.universe;

import au.com.rmit.Game2dEngine.math.CollisionQuadraticEquation;
import au.com.rmit.Game2dEngine.math.Vector;
import au.com.rmit.Game2dEngine.physics.gravity.Gravity;
import au.com.rmit.Game2dEngine.sprite.Sprite;
import au.com.rmit.test.scene.WallScene;
import au.com.rmit.test.sprites.Wall;
import java.awt.Color;
import java.awt.Graphics2D;
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
    }

    @Override
    public void onCustomDraw(Graphics2D theGraphics2D)
    {
        super.onCustomDraw(theGraphics2D); //To change body of generated methods, choose Tools | Templates.

        theGraphics2D.setColor(this.getColor());
        theGraphics2D.fillArc(0, 0, (int) this.getWidth() - 1, (int) this.getHeight() - 1, 0, 360);
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
                continue;

            if (aObject.equals(this))
            {
                continue;
            }

            double delX = aObject.getCentreX() - this.getCentreX();
            double delY = aObject.getCentreY() - this.getCentreY();
            double G = 6.67384 * Math.pow(10, -11);
            double M = aObject.getMass();
            Vector DISTANCE = new Vector(delX, delY);
            double distanceAbsolute = DISTANCE.getMagnitude();
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

    @Override
    public void onCollideWith(Sprite target)
    {
        if (target instanceof Wall)
        {
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
                this.setVelocityY(-this.getVelocityY());
            }
        } else
            this.processCollision(target);
    }

    @Override
    public void didCollisionProcess()
    {
        super.didCollisionProcess(); //To change body of generated methods, choose Tools | Templates.

        this.checkWall();

//        this.checkOthers();
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

    void checkWall()
    {
        if (this.theScene == null)
            return;

        boolean bHitWall = false;

        if (this.collideWith(((WallScene) this.theScene).theWallTop)
            || this.collideWith(((WallScene) this.theScene).theWallBottom)
            || this.collideWith(((WallScene) this.theScene).theWallLeft)
            || this.collideWith(((WallScene) this.theScene).theWallRight))
            bHitWall = true;

        if (bHitWall)
            this.restorePosition();
    }

    void checkOthers()
    {
        if (this.theScene == null)
            return;

        boolean bHit = false;

        for (Sprite aSprite : this.theScene.getAllSprites())
        {
            if (aSprite.equals(this))
                continue;

            if (this.collideWith(aSprite))
            {
                bHit = true;
                break;
            }
        }

        if (bHit)
            this.restorePosition();
    }

}
