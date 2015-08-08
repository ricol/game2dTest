/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.solarsystem;

import au.com.rmit.test.universe.Star;
import static java.lang.Math.pow;

/**
 *
 * @author ricolwang
 */
public class Sun extends Star
{

    public Sun()
    {
        super();

        this.setMass(10.0f * pow(10, 16));
        this.setWidth(100);
        this.setHeight(100);
    }
}
