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

    int number = 0;

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

        double l = 25;
        Set<Line> newLines;
        aPolygon.addSide(line1);
//        Set<Line> newLines = line1.getSeperateLines(l);
//        aPolygon.addSides(newLines);

        aPolygon.addSide(line2);
//        newLines = line2.getSeperateLines(l);
//        aPolygon.addSides(newLines);

        aPolygon.addSide(line3);
//        newLines = line3.getSeperateLines(l);
//        aPolygon.addSides(newLines);

        aPolygon.addSide(line4);

        this.addLines(line4, l, aPolygon);

        return aPolygon;
    }

    void addLines(Line aLine, double distance, PolygonShape thePolygon)
    {
        if (number >= 3 * 2)
            return;

        number++;
        Set<Line> lines = aLine.getSeperateLines(distance);

        thePolygon.addSides(lines);
        for (Line tmpLine : lines)
            this.addLines(tmpLine, distance - 5, thePolygon);
    }

}
