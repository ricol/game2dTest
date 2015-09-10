/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.sprites;

import au.com.rmit.Game2dEngine.physics.sprites.WallSprite;
import au.com.rmit.test.gui.TestCommon;
import java.awt.Graphics2D;

/**
 *
 * @author ricolwang
 */
public class Wall extends WallSprite
{
    public Wall()
    {
        super();
        
        this.setCollisionCategory(TestCommon.CATEGORY_WALL);
        this.bDrawShape = true;
        this.bCustomDrawing = true;
    }

    @Override
    public void onCustomDraw(Graphics2D theGraphics2D)
    {
        super.onCustomDraw(theGraphics2D); //To change body of generated methods, choose Tools | Templates.
    }
}
