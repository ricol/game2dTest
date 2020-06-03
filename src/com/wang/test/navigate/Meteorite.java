/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.navigate;

import com.wang.Game2dEngine.painter.interfaces.IEngineGraphics;

/**
 *
 * @author ricolwang
 */
public class Meteorite extends MovingObject
{

    public Meteorite(String imagename)
    {
        super(imagename);
        this.setRed(theRandom.nextInt(255));
        this.setGreen(theRandom.nextInt(255));
        this.setBlue(theRandom.nextInt(255));
        this.setWidth(20);
        this.setHeight(this.getWidth());
        this.setMass(this.getWidth());
    }

    @Override
    public void onCustomDraw(IEngineGraphics theEngineGraphics)
    {
        super.onCustomDraw(theEngineGraphics); //To change body of generated methods, choose Tools | Templates.

    }

}
