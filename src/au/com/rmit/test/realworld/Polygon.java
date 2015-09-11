/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.realworld;

import au.com.rmit.Game2dEngine.geometry.ClosureShape;
import au.com.rmit.Game2dEngine.geometry.Line;
import au.com.rmit.Game2dEngine.geometry.PolygonShape;
import java.util.Set;

/**
 *
 * @author ricolwang
 */
public class Polygon extends ShapeSprite
{
    int min = 5;
    double divide = 5;

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
        Line lineTop = new Line(centreX - radius, centreY - radius, centreX + radius, centreY - radius);
        Line lineRight = new Line(centreX + radius, centreY - radius, centreX + radius, centreY + radius);
        Line lineBottom = new Line(centreX + radius, centreY + radius, centreX - radius, centreY + radius);
        Line lineLeft = new Line(centreX - radius, centreY + radius, centreX - radius, centreY - radius);

        double l = 30;
        
        aPolygon.addSide(lineTop);
        aPolygon.addSide(lineRight);
        aPolygon.addSide(lineBottom);
        aPolygon.addSide(lineLeft);
        
        this.addLinesClock(lineTop, l, aPolygon);
        this.addLinesClock(lineRight, l, aPolygon);
        this.addLinesClock(lineBottom, l, aPolygon);
        this.addLinesClock(lineLeft, l, aPolygon);
        
        this.addLinesCounterClock(lineTop, l, aPolygon);
        this.addLinesCounterClock(lineRight, l, aPolygon);
        this.addLinesCounterClock(lineBottom, l, aPolygon);
        this.addLinesCounterClock(lineLeft, l, aPolygon);

        return aPolygon;
    }

    void addLinesCounterClock(Line aLine, double distance, PolygonShape thePolygon)
    {
        if (distance < min)
        {
            thePolygon.addSide(aLine);
            return;
        }

        Set<Line> lines = aLine.getSeperateLinesCounterClock(distance);

        for (Line tmpLine : lines)
            this.addLinesCounterClock(tmpLine, distance / divide, thePolygon);
    }
    
    void addLinesClock(Line aLine, double distance, PolygonShape thePolygon)
    {
        if (distance < min)
        {
            thePolygon.addSide(aLine);
            return;
        }

        Set<Line> lines = aLine.getSeperateLinesClock(distance);

        for (Line tmpLine : lines)
            this.addLinesClock(tmpLine, distance / divide, thePolygon);
    }

}
