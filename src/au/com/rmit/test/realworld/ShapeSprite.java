/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.realworld;

import au.com.rmit.Game2dEngine.geometry.ClosureShape;
import au.com.rmit.Game2dEngine.scene.Layer;
import au.com.rmit.Game2dEngine.sprite.Sprite;
import au.com.rmit.test.gui.TestCommon;

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
        this.bEnableGravity = true;
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
}
