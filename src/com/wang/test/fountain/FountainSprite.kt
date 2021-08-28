/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.fountain

import com.wang.Game2dEngine.painter.interfaces.IEngineGraphics
import com.wang.Game2dEngine.sprite.Sprite

/**
 * @author ricolwang
 */
class FountainSprite(x: Double, y: Double, width: Double, height: Double, mass: Double, velocityX: Double, velocityY: Double) : Sprite(x, y, width, height, mass, velocityX, velocityY)
{
    override fun onCustomDraw(theGraphics2D: IEngineGraphics)
    {
        super.onCustomDraw(theGraphics2D) //To change body of generated methods, choose Tools | Templates.
        theGraphics2D.setColor(this.color)
        theGraphics2D.fillArc(0, 0, width.toInt() - 1, height.toInt() - 1, 0, 360)
    }

    init
    {
        bCustomDrawing = true
    }
}