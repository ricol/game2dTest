/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.pinball;

/**
 *
 * @author ricolwang
 */
public class TargetBall extends BaseBall
{

    public TargetBall()
    {
        this.setRed(theRandom.nextInt(255));
        this.setGreen(theRandom.nextInt(255));
        this.setBlue(theRandom.nextInt(255));
        this.setWidth(20);
        this.setHeight(this.getWidth());
        this.setMass(this.getWidth());

        this.addTargetCollisionCategory(PinBallCommon.CATEGORY_TARGET_BALL);
    }
}
