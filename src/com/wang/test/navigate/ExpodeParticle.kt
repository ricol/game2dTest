/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.navigate

import com.wang.Game2dEngine.painter.interfaces.IEngineGraphics
import com.wang.Game2dEngine.sprite.Sprite

/**
 * @author ricolwang
 */
class ExpodeParticle @JvmOverloads constructor(x: Double = 0.0, y: Double = 0.0, width: Double = 7.0, height: Double = 7.0, mass: Double = 0.0, velocityX: Double = 0.0, velocityY: Double = 0.0) : Sprite(x, y, width, height, velocityX, velocityY)
{
    override fun onCustomDraw(theGraphics2D: IEngineGraphics)
    {
        theGraphics2D.setColor(this.color)
        theGraphics2D.fillOval(0, 0, width.toInt() - 1, height.toInt() - 1)
    }

    init
    {
        bCustomDrawing = true
        this.mass = mass
    }
}