/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.galaxies

import com.wang.Game2dEngine.painter.interfaces.IEngineGraphics
import com.wang.Game2dEngine.sprite.Sprite

/**
 * @author Philology
 */
class Flame : Sprite()
{
    override fun onCustomDraw(theEngineGraphics: IEngineGraphics)
    {
        super.onCustomDraw(theEngineGraphics) //To change body of generated methods, choose Tools | Templates.
        theEngineGraphics.setColor(this.color)
        theEngineGraphics.fillArc(0, 0, width.toInt() - 1, height.toInt() - 1, 0, 360)
    }

    init
    {
        bCustomDrawing = true
    }
}