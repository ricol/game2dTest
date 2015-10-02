/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.realworld;

import au.com.rmit.Game2dEngine.geometry.ClosureShape;
import au.com.rmit.Game2dEngine.geometry.Shape;
import au.com.rmit.Game2dEngine.scene.Layer;
import au.com.rmit.Game2dEngine.sprite.Sprite;
import au.com.rmit.test.gui.TestCommon;
import au.com.rmit.test.sprites.Wall;

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
        this.bDrawShape = true;
        this.bEnablePhysics = true;
        this.enableGravity();
    }

    @Override
    public void onCollideWith(Sprite target)
    {
        super.onCollideWith(target);

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
        }
    }

    @Override
    public void onAddToLayer(Layer theLayer)
    {
        super.onAddToLayer(theLayer); //To change body of generated methods, choose Tools | Templates.

        ClosureShape aShape = this.buildShape();
        if (aShape != null)
            this.setTheShape(aShape);
    }

    ClosureShape buildShape()
    {
        return null;
    }

    @Override
    public void onShapeAdded(Shape theShape)
    {
        super.onShapeAdded(theShape); //To change body of generated methods, choose Tools | Templates.

        theShape.print("Shape: ");
    }
}
