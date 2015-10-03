/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.pinball;

import au.com.rmit.Game2dEngine.action.AlphaToAction;
import au.com.rmit.Game2dEngine.sprite.Sprite;
import au.com.rmit.test.gui.TestCommon;
import java.awt.Graphics2D;
import static java.lang.Math.abs;
import static java.lang.Math.pow;

/**
 *
 * @author ricolwang
 */
public class BaseBall extends Sprite
{

    public static final float SPEED_EXPLODE_PARTICLE = 300;

    public BaseBall()
    {
        this.bCollisionDetect = true;
        this.bCustomDrawing = true;
        this.bDrawShape = true;
        this.bCollisionArbitrary = true;
        this.bEnablePhysics = true;
        this.bEnableGravity = true;
        this.bKillWhenOutOfScene = true;
        this.bDrawVelocityVector = true;
        this.DrawVelocityBase = 0.2;

        this.addTargetCollisionCategory(TestCommon.CATEGORY_WALL);
    }

    @Override
    public void onCustomDraw(Graphics2D theGraphics2D)
    {
        super.onCustomDraw(theGraphics2D); //To change body of generated methods, choose Tools | Templates.

//        theGraphics2D.setColor(this.getColor());
//        theGraphics2D.fillArc(0, 0, (int) this.getWidth(), (int) this.getHeight(), 0, 360);
    }

    @Override
    public void onCollideWith(Sprite target)
    {
        super.onCollideWith(target); //To change body of generated methods, choose Tools | Templates.
        
//        this.explode(10);
    }

    protected void explode(int total)
    {
        int number = abs(theRandom.nextInt()) % 10 + total;

        for (int i = 0; i < number; i++)
        {
            double tmpX = pow(-1, theRandom.nextInt() % 10) * theRandom.nextFloat() * BaseBall.SPEED_EXPLODE_PARTICLE;
            double tmpY = pow(-1, theRandom.nextInt() % 10) * theRandom.nextFloat() * BaseBall.SPEED_EXPLODE_PARTICLE;

            ExpodeParticle aFire = new ExpodeParticle();
            aFire.setX(this.getCentreX());
            aFire.setY(this.getCentreY());
            aFire.setVelocityX(tmpX);
            aFire.setVelocityY(tmpY);
            aFire.setRed(255);
            aFire.setGreen(255);
            aFire.setBlue(255);
            aFire.bDeadIfNoActions = true;

            AlphaToAction aAction = new AlphaToAction(aFire);
            aAction.alphaTo(0, 0.1f);
            aFire.addAction(aAction);

            if (this.theScene == null)
            {
                break;
            }
            this.theScene.addSprite(aFire);
        }
    }

}
