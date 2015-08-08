/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.physicengine;

import au.com.rmit.Game2dEngine.geometry.shape.CircleShape;
import au.com.rmit.Game2dEngine.scene.Scene;
import au.com.rmit.Game2dEngine.sprite.Sprite;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import static java.lang.Math.abs;

/**
 *
 * @author ricolwang
 */
public class TestScene extends Scene
{

    WallSprite theWallTop;
    WallSprite theWallLeft;
    WallSprite theWallBottom;
    WallSprite theWallRight;

    int startX = 5, startY = 5;
    int wallSize = 50;

    void resizeWalls()
    {
        if (theWallTop != null)
        {
            theWallTop.setX(startX);
            theWallTop.setY(startY);
            theWallTop.setWidth(getWidth() - 2 * startX);
            theWallTop.setHeight(wallSize);
        }

        if (theWallBottom != null)
        {
            theWallBottom.setX(startX);
            theWallBottom.setY(getHeight() - wallSize - startX);
            theWallBottom.setWidth(getWidth() - 2 * startX);
            theWallBottom.setHeight(wallSize);
        }

        if (theWallLeft != null)
        {
            theWallLeft.setX(startX);
            theWallLeft.setY(startY);
            theWallLeft.setWidth(wallSize);
            theWallLeft.setHeight(getHeight() - 2 * startY);
        }

        if (theWallRight != null)
        {
            theWallRight.setX(getWidth() - wallSize - startX);
            theWallRight.setY(startY);
            theWallRight.setWidth(wallSize);
            theWallRight.setHeight(getHeight() - 2 * startY);
        }
    }

    public TestScene()
    {
        this.enableCollisionDetect();

        this.addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent evt)
            {
                resizeWalls();
            }
        });

        this.addMouseMotionListener(new MouseMotionListener()
        {

            @Override
            public void mouseDragged(MouseEvent e)
            {
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {
            }
        });

        this.addMouseListener(new MouseListener()
        {

            @Override
            public void mouseClicked(MouseEvent e)
            {

            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                if (theWallTop == null)
                {
                    theWallTop = new WallSprite();
                    theWallTop.setBlue(255);
                    theWallTop.wallType = WallSprite.WALLTYPE.TOP;
                    addSprite(theWallTop);
                }

                if (theWallBottom == null)
                {

                    theWallBottom = new WallSprite();
                    theWallBottom.setBlue(255);
                    theWallBottom.wallType = WallSprite.WALLTYPE.BOTTOM;
                    addSprite(theWallBottom);
                }

                if (theWallLeft == null)
                {
                    theWallLeft = new WallSprite();
                    theWallLeft.setBlue(255);
                    theWallLeft.wallType = WallSprite.WALLTYPE.LEFT;
                    addSprite(theWallLeft);
                }

                if (theWallRight == null)
                {
                    theWallRight = new WallSprite();
                    theWallRight.setBlue(255);
                    theWallRight.wallType = WallSprite.WALLTYPE.RIGHT;
                    addSprite(theWallRight);
                }
                
                resizeWalls();

                float maxmass = 1000;
                float size = 100;

                if (e.getButton() == MouseEvent.BUTTON3)
                {
                    Sprite aCircle = new CircleSprite();

                    aCircle.setBlue(255);

                    aCircle.setCentreX(e.getX());
                    aCircle.setCentreY(e.getY());

//                    aCircle.setMass(abs(theRandom.nextInt()) % 900 + 100);
                    aCircle.setMass(500);
                    aCircle.setVelocityX(abs(theRandom.nextInt()) % 200 + 200);
                    aCircle.setVelocityY(abs(theRandom.nextInt()) % 200 + 200);
                    aCircle.setWidth((aCircle.getMass() / maxmass) * size);
                    aCircle.setHeight(aCircle.getWidth());

                    aCircle.setTheShape(new CircleShape(aCircle.getCentreX(), aCircle.getCentreY(), aCircle.getWidth() > aCircle.getHeight() ? aCircle.getWidth() / 2.0f : aCircle.getHeight() / 2.0f));

                    addSprite(aCircle);

                } else if (e.getButton() == MouseEvent.BUTTON1)
                {
                    Sprite aCircle = new CircleSprite();

                    aCircle.setRed(255);

                    aCircle.setCentreX(e.getX());
                    aCircle.setCentreY(e.getY());

//                    aCircle.setMass(abs(theRandom.nextInt()) % 900 + 100);
                    aCircle.setMass(1000);
                    aCircle.setVelocityX(abs(theRandom.nextInt()) % 200 + 200);
                    aCircle.setVelocityY(abs(theRandom.nextInt()) % 200 + 200);
                    aCircle.setWidth((aCircle.getMass() / maxmass) * size);
                    aCircle.setHeight(aCircle.getWidth());

                    aCircle.setTheShape(new CircleShape(aCircle.getCentreX(), aCircle.getCentreY(), aCircle.getWidth() > aCircle.getHeight() ? aCircle.getWidth() / 2.0f : aCircle.getHeight() / 2.0f));

                    addSprite(aCircle);
                }
            }

            @Override

            public void mouseReleased(MouseEvent e)
            {
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
            }
        }
        );
    }

}
