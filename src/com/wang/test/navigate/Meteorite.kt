/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.navigate

import com.wang.Game2dEngine.painter.interfaces.IEngineGraphics

/**
 * @author ricolwang
 */
class Meteorite(imagename: String?) : MovingObject(imagename)
{
    override fun onCustomDraw(theEngineGraphics: IEngineGraphics)
    {
        super.onCustomDraw(theEngineGraphics) //To change body of generated methods, choose Tools | Templates.
    }

    init
    {
        red = theRandom.nextInt(255)
        green = theRandom.nextInt(255)
        blue = theRandom.nextInt(255)
        width = 20.0
        height = width
        mass = width
    }
}