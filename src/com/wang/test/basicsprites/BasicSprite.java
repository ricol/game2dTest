/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.basicsprites;

import com.wang.Game2dEngine.action.AlphaToAction;
import com.wang.Game2dEngine.sprite.Sprite;
import com.wang.test.navigate.MovingObject;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

/**
 * @author ricolwang
 */
public class BasicSprite extends Sprite
{

    public BasicSprite(String imagename)
    {
        super(imagename);
    }

    public BasicSprite()
    {
        super();
    }

    protected void explode(int total, int x, int y)
    {
        int number = abs(theRandom.nextInt()) % 10 + total;

        for (int i = 0; i < number; i++)
        {
            double tmpX = pow(-1, theRandom.nextInt() % 10) * theRandom.nextFloat() * MovingObject.SPEED_EXPLODE_PARTICLE;
            double tmpY = pow(-1, theRandom.nextInt() % 10) * theRandom.nextFloat() * MovingObject.SPEED_EXPLODE_PARTICLE;

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
