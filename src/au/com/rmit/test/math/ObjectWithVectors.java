/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rmit.test.math;

import au.com.rmit.Game2dEngine.geometry.Line;
import au.com.rmit.Game2dEngine.math.vector.Vector;
import au.com.rmit.test.common.BasicSprite;
import au.com.rmit.test.common.TestCommon;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author ricolwang
 */
public class ObjectWithVectors extends BasicSprite
{

    ArrayList<Vector> vectors = new ArrayList<>();

    public ObjectWithVectors()
    {
        this.bCollisionArbitrary = true;
        this.bCollisionDetect = true;
        this.bEnablePhysics = true;
        this.bCustomDrawing = true;
        this.bDrawShape = true;
        this.setRed(255);
        this.setWidth(50);
        this.setHeight(50);
        this.setMass(50);
//        float vx = (abs(theRandom.nextInt()) % 200 + 100) * (theRandom.nextBoolean() ? 1 : -1);
//        float vy = (abs(theRandom.nextInt()) % 200 + 100) * (theRandom.nextBoolean() ? 1 : -1);
//        this.setVelocity(new Vector(vx, vy));
        this.setVelocity(new Vector(200, 300));
        this.addTargetCollisionCategory(TestCommon.CATEGORY_WALL);
        this.bDrawVelocityVector = true;
        this.DrawVelocityBase = 0.3;
    }

    @Override
    public void onCustomDrawInTheScene(Graphics2D theGraphics2D)
    {
        super.onCustomDrawInTheScene(theGraphics2D); //To change body of generated methods, choose Tools | Templates.

        theGraphics2D.setColor(Color.green);

        ArrayList<Line> allLines = new ArrayList<>();

        for (Vector v : vectors)
        {
            v.start.x = this.getCentreX();
            v.start.y = this.getCentreY();

            Line aLine = new Line(v.start, v.getTheEndPoint());
            ArrayList<Line> lines = aLine.getArrowLines(10, Math.PI / 6.0);
            lines.add(aLine);
            allLines.add(aLine);
            allLines.addAll(lines);
        }

        for (Line line : allLines)
            theGraphics2D.drawLine((int) line.start.x, (int) line.start.y, (int) line.end.x, (int) line.end.y);
    }

}
