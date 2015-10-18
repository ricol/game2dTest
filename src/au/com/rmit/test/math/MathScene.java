/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.math;

import au.com.rmit.Game2dEngine.physics.gravity.Gravity;
import au.com.rmit.test.basicscene.WallScene;
import java.awt.event.MouseEvent;

/**
 *
 * @author ricolwang
 */
public class MathScene extends WallScene
{

    ObjectWithVectors theObject;
    Ball MyBall;
    Gravity g = new Gravity(0, 200);

    @Override
    public void mousePressed(MouseEvent e)
    {
        super.mousePressed(e);

        if (e.getButton() == MouseEvent.BUTTON3)
        {
//            if (MyBall == null)
//                return;
//
//            MyBall.rotateClockwise(Math.PI * 1.5);
        } else if (e.getButton() == MouseEvent.BUTTON1)
        {
//            if (MyBall == null)
//            {
//                MyBall = new Ball();
//                MyBall.setCentreX(e.getX());
//                MyBall.setCentreY(e.getY());
//                addSprite(MyBall);
//            }
//
//            MyBall.rotateCounterClock(Math.PI * 1.5);
//            
//            if (theObject == null)
//            {
//                theObject = new ObjectWithVectors();
//                theObject.setCentreX(e.getX());
//                theObject.setCentreY(e.getY());
//                addSprite(theObject);
//            }

            CircleBall aBall = new CircleBall();
            aBall.setCentreX(e.getX());
            aBall.setCentreY(e.getY());
            addSprite(aBall);
        }
    }
}
