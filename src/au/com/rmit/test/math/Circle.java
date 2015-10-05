/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.math;

import au.com.rmit.Game2dEngine.action.ExpandByAction;
import au.com.rmit.Game2dEngine.scene.Layer;
import au.com.rmit.test.common.BasicSprite;
import java.awt.Graphics2D;

/**
 *
 * @author ricolwang
 */
public class Circle extends BasicSprite
{
    public Circle()
    {
        this.setWidth(1);
        this.setHeight(1);
        this.setRed(255);
        this.setGreen(255);
        this.setBlue(255);
        this.bDrawShape = true;
        this.bCustomDrawing = true;
    }

    @Override
    public void onAddToLayer(Layer theLayer)
    {
        super.onAddToLayer(theLayer); //To change body of generated methods, choose Tools | Templates.
        
        ExpandByAction aExpandAction = new ExpandByAction();
        aExpandAction.expandBy(20, 0.5f);
        this.addAction(aExpandAction);
        this.bDeadIfNoActions = true;
    }

    @Override
    public void onCustomDraw(Graphics2D theGraphics2D)
    {
        super.onCustomDraw(theGraphics2D); //To change body of generated methods, choose Tools | Templates.
    }
    
}
