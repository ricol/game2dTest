/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.galaxies;

import com.wang.test.universe.*;
import com.wang.Game2dEngine.painter.interfaces.IEngineGraphics;
import com.wang.Game2dEngine.sprite.Sprite;

/**
 *
 * @author Philology
 */
public class Flame extends Sprite
{

    public Flame()
    {
        super();
        this.bCustomDrawing = true;
    }

    @Override
    public void onCustomDraw(IEngineGraphics theEngineGraphics)
    {
        super.onCustomDraw(theEngineGraphics); //To change body of generated methods, choose Tools | Templates.

        theEngineGraphics.setColor(this.getColor());
        theEngineGraphics.fillArc(0, 0, (int) this.getWidth() - 1, (int) this.getHeight() - 1, 0, 360);
    }

}
