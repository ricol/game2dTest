/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.spaceship

import com.wang.Game2dEngine.action.Action
import com.wang.Game2dEngine.scene.Layer

/**
 * @author ricolwang
 */
class TestSpaceship : Spaceship("my-spaceship.png")
{
    var theEngine = PropelEngine()
    override fun onDead()
    {
        super.onDead() //To change body of generated methods, choose Tools | Templates.
    }

    override fun onAddToLayer(theLayer: Layer?)
    {
        super.onAddToLayer(theLayer) //To change body of generated methods, choose Tools | Templates.
        theEngine.centreX = width / 2
        theEngine.centreY = height
    }

    override fun onActionComplete(aAction: Action?)
    {
    }

    init
    {
        addAChild(theEngine)
        bDrawFrame = true
        theEngine.bDrawFrame = true
        theEngine.red = 255
        theEngine.width = 20.0
        theEngine.height = 20.0
    }
}