/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.pinball;

import au.com.rmit.Game2dEngine.sprite.Sprite;
import au.com.rmit.test.gui.TestCommon;
import java.awt.Graphics2D;

/**
 *
 * @author ricolwang
 */
public class BaseBall extends Sprite
{

    public BaseBall()
    {
        this.bCollisionDetect = true;
        this.bCustomDrawing = true;
        this.bCollisionArbitrary = true;
        this.bEnablePhysics = true;
        this.bKillWhenOutOfScene = true;

        this.addTargetCollisionCategory(TestCommon.CATEGORY_WALL);
    }

    @Override
    public void onCustomDraw(Graphics2D theGraphics2D)
    {
        super.onCustomDraw(theGraphics2D); //To change body of generated methods, choose Tools | Templates.

        theGraphics2D.setColor(this.getColor());
        theGraphics2D.fillArc(0, 0, (int) this.getWidth(), (int) this.getHeight(), 0, 360);
    }

}
