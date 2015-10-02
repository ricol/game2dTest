/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.realworld;

import au.com.rmit.Game2dEngine.geometry.ClosureShape;
import au.com.rmit.Game2dEngine.geometry.Line;
import au.com.rmit.Game2dEngine.geometry.PolygonShape;
import au.com.rmit.Game2dEngine.sprite.Sprite;
import java.util.ArrayList;

/**
 *
 * @author ricolwang
 */
public class Rectangle extends ShapeSprite
{

    double l = 30;
    double min = 1;
    double divide = 5;
    double r = 10;
    double angle = Math.PI / 12.0;

    public Rectangle()
    {
        super();

        this.bDrawShape = true;
        this.bDrawFrame = false;
        this.bCustomDrawing = true;
    }

    @Override
    ClosureShape buildShape()
    {
        PolygonShape aPolygon = new PolygonShape();
        double centreX = this.getCentreX();
        double centreY = this.getCentreY();
        double radius = this.getWidth() / 2;
        Line lineTop = new Line(centreX - radius, centreY - radius, centreX + radius, centreY - radius);
        Line lineRight = new Line(centreX + radius, centreY - radius, centreX + radius, centreY + radius);
        Line lineBottom = new Line(centreX + radius, centreY + radius, centreX - radius, centreY + radius);
        Line lineLeft = new Line(centreX - radius, centreY + radius, centreX - radius, centreY - radius);

        aPolygon.addSide(lineTop);
        aPolygon.addSide(lineRight);
        aPolygon.addSide(lineBottom);
        aPolygon.addSide(lineLeft);
        
        this.addLineArrow(lineTop, r, angle, aPolygon);
        this.addLineArrow(lineRight, r, angle, aPolygon);
        this.addLineArrow(lineBottom, r, angle, aPolygon);
        this.addLineArrow(lineLeft, r, angle, aPolygon);
        
        return aPolygon;
    }

    void addLineArrow(Line aLine, double l, double angle, PolygonShape thePolygon)
    {
        ArrayList<Line> lines = aLine.getArrowLines(l, angle);
        thePolygon.addSides(lines);
    }

    @Override
    public void onCollideWith(Sprite target)
    {
        super.onCollideWith(target); //To change body of generated methods, choose Tools | Templates.
        
        
    }
    
}
