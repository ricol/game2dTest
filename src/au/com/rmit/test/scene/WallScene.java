/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.scene;

import au.com.rmit.Game2dEngine.physics.sprites.WallSprite;
import au.com.rmit.Game2dEngine.scene.Scene;
import au.com.rmit.test.sprites.Wall;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author ricolwang
 */
public class WallScene extends Scene implements MouseListener
{

    public Wall theWallTop;
    public Wall theWallLeft;
    public Wall theWallBottom;
    public Wall theWallRight;

    int startX = 5, startY = 5;
    int wallSize = 20;

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

    public WallScene()
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

        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (theWallTop == null)
        {
            theWallTop = new Wall();
            theWallTop.setBlue(255);
            theWallTop.wallType = WallSprite.WALLTYPE.TOP;
            addSprite(theWallTop);
        }

        if (theWallBottom == null)
        {

            theWallBottom = new Wall();
            theWallBottom.setBlue(255);
            theWallBottom.wallType = WallSprite.WALLTYPE.BOTTOM;
            addSprite(theWallBottom);
        }

        if (theWallLeft == null)
        {
            theWallLeft = new Wall();
            theWallLeft.setBlue(255);
            theWallLeft.wallType = WallSprite.WALLTYPE.LEFT;
            addSprite(theWallLeft);
        }

        if (theWallRight == null)
        {
            theWallRight = new Wall();
            theWallRight.setBlue(255);
            theWallRight.wallType = WallSprite.WALLTYPE.RIGHT;
            addSprite(theWallRight);
        }

        resizeWalls();

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
