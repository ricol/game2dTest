/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.pinball;

import com.wang.Game2dEngine.painter.interfaces.IEngineGraphics;
import com.wang.Game2dEngine.sprite.Sprite;
import com.wang.test.basicsprites.BasicSprite;
import com.wang.test.common.TestCommon;

/**
 *
 * @author ricolwang
 */
public class BaseBall extends BasicSprite
{

    public static final float SPEED_EXPLODE_PARTICLE = 300;

    public BaseBall()
    {
        this.bCollisionDetect = true;
        this.bCustomDrawing = true;
        this.bDrawShape = true;
        this.bCollisionArbitrary = true;
        this.bEnablePhysics = true;
        this.bEnableGravity = true;
        this.bKillWhenOutOfScene = true;
        this.bDrawVelocityVector = true;
        this.DrawVelocityBase = 0.2;

        this.addTargetCollisionCategory(TestCommon.CATEGORY_WALL);
    }

    @Override
    public void onCustomDraw(IEngineGraphics theEngineGraphics)
    {
        super.onCustomDraw(theEngineGraphics); //To change body of generated methods, choose Tools | Templates.

//        theEngineGraphics.setColor(this.getColor());
//        theEngineGraphics.fillArc(0, 0, (int) this.getWidth(), (int) this.getHeight(), 0, 360);
    }

    @Override
    public void onCollideWith(Sprite target)
    {
        super.onCollideWith(target); //To change body of generated methods, choose Tools | Templates.

//        this.explode(5, (int) this.getCentreX(), (int) this.getCentreY());
    }

}
