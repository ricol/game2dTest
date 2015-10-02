/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.pinball;

import au.com.rmit.test.scene.WallScene;
import java.awt.event.MouseEvent;

/**
 *
 * @author ricolwang
 */
public class PinballScene extends WallScene
{

    @Override
    public void mousePressed(MouseEvent e)
    {
        super.mousePressed(e);

        if (e.getButton() == MouseEvent.BUTTON3)
        {
            float start_x = e.getX();
            float start_y = e.getY();
            float width = 10;
            float gap_x = 2;
            float height = 10;
            float gap_y = 2;

            for (int i = 0; i <= 10; i++)
            {
                for (int j = 0; j <= i; j++)
                {
                    TargetBall aBall = new TargetBall();
                    float x = start_x + i * (width + gap_x);
                    aBall.setCentreX(x);
                    float y = start_y + j * (height + gap_y);
                    aBall.setCentreY(y);
                    addSprite(aBall);
                }
            }

        } else if (e.getButton() == MouseEvent.BUTTON1)
        {

            MyBall MyBall = new MyBall();
            MyBall.setCentreX(e.getX());
            MyBall.setCentreY(e.getY());
            addSprite(MyBall);
        }
    }
}
