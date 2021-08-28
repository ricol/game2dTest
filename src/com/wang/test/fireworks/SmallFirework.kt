/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.fireworks

/**
 * @author ricolwang
 */
class SmallFirework : Firework
{
    constructor(x: Double, y: Double, width: Double, height: Double, mass: Double, velocityX: Double, velocityY: Double) : super(x, y, width, height, mass, velocityX, velocityY)
    {
    }

    constructor() : super("resource/starSmall.png")
    {
    }
}