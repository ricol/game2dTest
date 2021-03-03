/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.universe;

import static java.lang.Math.abs;

/**
 * @author ricolwang
 */
public class Planet extends Entity
{

    public Planet()
    {
        super();

        this.setGreen(abs(theRandom.nextInt()) % 255);
        this.setRed(abs(theRandom.nextInt()) % 255);
        this.setBlue(abs(theRandom.nextInt()) % 255);
        this.bEnableGravity = true;
    }
}
