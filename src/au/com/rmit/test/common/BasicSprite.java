/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.common;

import au.com.rmit.Game2dEngine.action.AlphaToAction;
import au.com.rmit.Game2dEngine.sprite.Sprite;
import au.com.rmit.test.pinball.BaseBall;
import static java.lang.Math.abs;
import static java.lang.Math.pow;

/**
 *
 * @author ricolwang
 */
public class BasicSprite extends Sprite
{

    protected void explode(int total, int x, int y)
    {
        int number = abs(theRandom.nextInt()) % 10 + total;

        for (int i = 0; i < number; i++)
        {
            double tmpX = pow(-1, theRandom.nextInt() % 10) * theRandom.nextFloat() * BaseBall.SPEED_EXPLODE_PARTICLE;
            double tmpY = pow(-1, theRandom.nextInt() % 10) * theRandom.nextFloat() * BaseBall.SPEED_EXPLODE_PARTICLE;

            ExpodeParticle aFire = new ExpodeParticle();
            aFire.setX(x);
            aFire.setY(y);
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
