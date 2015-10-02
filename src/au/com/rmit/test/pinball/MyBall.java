/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.pinball;

import au.com.rmit.Game2dEngine.math.Vector;

/**
 *
 * @author ricolwang
 */
public class MyBall extends BaseBall
{

    public MyBall()
    {
        this.setBlue(255);
        this.setRed(255);
        this.setMass(5000);
        this.setWidth(40);
        this.setHeight(this.getWidth());
        this.setVelocity(new Vector(1000, 0));

        this.setCollisionCategory(PinBallCommon.CATEGORY_MY_BALL);
    }

}
