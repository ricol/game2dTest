/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.basicsprites

import com.wang.Game2dEngine.physics.sprites.WallSprite
import com.wang.test.common.TestCommon

/**
 * @author ricolwang
 */
class Wall : WallSprite()
{
    init
    {
        collisionCategory = TestCommon.CATEGORY_WALL
    }
}