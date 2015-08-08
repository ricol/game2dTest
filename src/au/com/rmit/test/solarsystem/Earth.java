/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.solarsystem;

import au.com.rmit.test.universe.Planet;
import static java.lang.Math.pow;

/**
 *
 * @author ricolwang
 */
public class Earth extends Planet
{
    public Earth()
    {
        super();

        this.setMass(10.0f * pow(10, 16));
        
        this.setWidth(30);
        this.setHeight(30);
        
        this.setVelocityY(20);
    }
}
