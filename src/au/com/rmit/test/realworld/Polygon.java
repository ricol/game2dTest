/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.realworld;

import au.com.rmit.Game2dEngine.geometry.ClosureShape;
import au.com.rmit.Game2dEngine.geometry.Line;
import au.com.rmit.Game2dEngine.geometry.PolygonShape;

/**
 *
 * @author ricolwang
 */
public class Polygon extends ShapeSprite
{

    public Polygon()
    {
        super();

        this.bDrawShape = true;
    }

    @Override
    ClosureShape buildShape()
    {
        PolygonShape aPolygon = new PolygonShape();
        double centreX = this.getCentreX();
        double centreY = this.getCentreY();
        double radius = this.getWidth();
        Line line1 = new Line(centreX - radius, centreY - radius, centreX + radius, centreY - radius);
        Line line2 = new Line(centreX + radius, centreY - radius, centreX + radius, centreY + radius);
        Line line3 = new Line(centreX - radius, centreY + radius, centreX + radius, centreY + radius);
        Line line4 = new Line(centreX - radius, centreY - radius, centreX - radius, centreY + radius);
        aPolygon.addSide(line1);
        aPolygon.addSide(line2);
        aPolygon.addSide(line3);
        aPolygon.addSide(line4);

        return aPolygon;
    }

}
