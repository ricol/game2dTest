/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.realworld;

import au.com.rmit.Game2dEngine.geometry.ClosureShape;
import au.com.rmit.Game2dEngine.geometry.Line;
import au.com.rmit.Game2dEngine.geometry.PolygonShape;
import java.util.ArrayList;

/**
 *
 * @author ricolwang
 */
public class Polygon extends ShapeSprite
{

    double l = 30;
    double min = 1;
    double divide = 5;
    double r = 10;
    double angle = Math.PI / 12.0;

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

        aPolygon.addSide(lineTop);
        aPolygon.addSide(lineRight);
        aPolygon.addSide(lineBottom);
        aPolygon.addSide(lineLeft);
        this.addLinesClock(lineTop, l, aPolygon, true);
        this.addLinesClock(lineRight, l, aPolygon, true);
        this.addLinesClock(lineBottom, l, aPolygon, true);
        this.addLinesClock(lineLeft, l, aPolygon, true);

        this.addLinesCounterClock(lineTop, l, aPolygon, true);
        this.addLinesCounterClock(lineRight, l, aPolygon, true);
        this.addLinesCounterClock(lineBottom, l, aPolygon, true);
        this.addLinesCounterClock(lineLeft, l, aPolygon, true);
        return aPolygon;
    }

    void addLinesCounterClock(Line aLine, double distance, PolygonShape thePolygon, boolean bArrow)
    {
        if (distance < min)
        {
            thePolygon.addSide(aLine);
            if (bArrow)
                this.addLineArrow(aLine, r, angle, thePolygon);
            return;
        }

        ArrayList<Line> lines = aLine.getSpecialLinesCounterClockwise(distance);

        for (Line tmpLine : lines)
            this.addLinesCounterClock(tmpLine, distance / divide, thePolygon, bArrow);
    }

    void addLinesClock(Line aLine, double distance, PolygonShape thePolygon, boolean bArrow)
    {
        if (distance < min)
        {
            thePolygon.addSide(aLine);
            if (bArrow)
                this.addLineArrow(aLine, r, angle, thePolygon);
            return;
        }

        ArrayList<Line> lines = aLine.getSpecialLinesClockwise(distance);

        for (Line tmpLine : lines)
            this.addLinesClock(tmpLine, distance / divide, thePolygon, bArrow);
    }

    void addLineArrow(Line aLine, double l, double angle, PolygonShape thePolygon)
    {
        ArrayList<Line> lines = aLine.getArrowLines(l, angle);
        thePolygon.addSides(lines);
    }

}
