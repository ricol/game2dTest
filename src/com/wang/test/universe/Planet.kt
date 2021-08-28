/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.universe

/**
 * @author ricolwang
 */
class Planet : Entity()
{
    init
    {
        green = Math.abs(theRandom.nextInt()) % 255
        red = Math.abs(theRandom.nextInt()) % 255
        blue = Math.abs(theRandom.nextInt()) % 255
        bEnableGravity = true
    }
}