/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.basicsprites;

import au.com.rmit.Game2dEngine.physics.sprites.WallSprite;
import au.com.rmit.test.common.TestCommon;

/**
 *
 * @author ricolwang
 */
public class Wall extends WallSprite
{

    public Wall()
    {
        super();

        this.setCollisionCategory(TestCommon.CATEGORY_WALL);
    }

}
