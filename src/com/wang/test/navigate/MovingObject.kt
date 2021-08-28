/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.navigate

import com.wang.Game2dEngine.painter.interfaces.IEngineGraphics
import com.wang.Game2dEngine.sprite.Sprite
import com.wang.test.basicsprites.BasicSprite

/**
 * @author ricolwang
 */
open class MovingObject(imagename: String?) : BasicSprite(imagename)
{
    override fun onCustomDraw(theEngineGraphics: IEngineGraphics)
    {
        super.onCustomDraw(theEngineGraphics) //To change body of generated methods, choose Tools | Templates.

//        theEngineGraphics.setColor(this.getColor());
//        theEngineGraphics.fillArc(0, 0, (int) this.getWidth(), (int) this.getHeight(), 0, 360);
    }

    override fun onCollideWith(target: Sprite)
    {
        super.onCollideWith(target) //To change body of generated methods, choose Tools | Templates.

//        this.explode(5, (int) this.getCentreX(), (int) this.getCentreY());
    }

    companion object
    {
        const val SPEED_EXPLODE_PARTICLE = 300f
    }

    init
    {
        bCollisionDetect = true
        bCustomDrawing = true
        //        this.bDrawShape = true;
        bCollisionArbitrary = true
        bEnablePhysics = true
        bEnableGravity = true
        bKillWhenOutOfScene = false
        //        this.bDrawVelocityVector = true;
        DrawVelocityBase = 0.2
        //        this.bDrawAccelarationVector = true;
    }
}