/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.collision;

import com.wang.Game2dEngine.physics.gravity.Gravity;
import com.wang.test.basicscene.WallScene;
import java.awt.event.MouseEvent;

/**
 * @author ricolwang
 */
public class CollisionScene extends WallScene
{

    ObjectWithVectors theObject;
    Gravity g = new Gravity(0, 500);

    public CollisionScene()
    {
        super();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        super.mousePressed(e);

        int x = e.getX(), y = e.getY();
        CircleBall aBall = new CircleBall(x, y);
        aBall.bEnableGravity = true;
        aBall.applyGravity(g);
        addSprite(aBall);
    }
}
