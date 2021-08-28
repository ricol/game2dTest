/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.fireworks

import com.wang.Game2dEngine.sprite.Sprite

/**
 * @author Philology
 */
class FireSprite(x: Double, y: Double, width: Double, height: Double, mass: Double, velocityX: Double, velocityY: Double) : Sprite(x, y, width, height, velocityX, velocityY)
{
    init
    {
        this.mass = mass
    }
}