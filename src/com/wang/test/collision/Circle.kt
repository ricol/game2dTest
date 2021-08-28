/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.collision

import com.wang.Game2dEngine.action.ExpandByAction
import com.wang.Game2dEngine.painter.interfaces.IEngineGraphics
import com.wang.Game2dEngine.scene.Layer
import com.wang.test.basicsprites.BasicSprite

/**
 * @author ricolwang
 */
class Circle : BasicSprite()
{
    override fun onAddToLayer(theLayer: Layer)
    {
        super.onAddToLayer(theLayer) //To change body of generated methods, choose Tools | Templates.
        val aExpandAction = ExpandByAction()
        aExpandAction.expandBy(20f, 0.2f)
        addAction(aExpandAction)
        bDeadIfNoActions = true
    }

    override fun onCustomDraw(theEngineGraphics: IEngineGraphics)
    {
        super.onCustomDraw(theEngineGraphics) //To change body of generated methods, choose Tools | Templates.
    }

    init
    {
        width = 1.0
        height = 1.0
        red = 255
        green = 255
        blue = 255
        bDrawShape = true
        bCustomDrawing = true
    }
}