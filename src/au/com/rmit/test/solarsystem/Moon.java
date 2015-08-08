/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.solarsystem;

import au.com.rmit.test.universe.Planet;

/**
 *
 * @author ricolwang
 */
public class Moon extends Planet
{

    public Moon()
    {
        super();

        this.setWidth(10);
        this.setHeight(10);
        
        this.setVelocityY(300);
    }
}
