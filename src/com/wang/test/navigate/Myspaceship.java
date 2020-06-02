/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.navigate;

import com.wang.Game2dEngine.action.AlphaToAction;
import com.wang.math.vector.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import javax.swing.Timer;

/**
 *
 * @author ricolwang
 */
public class Myspaceship extends MovingObject implements ActionListener
{

    private final Timer theTimerForEngineLeft = new Timer(10, this);
    private final Timer theTimerForEngineRight = new Timer(10, this);
    private final Timer theTimerForEngineMiddle = new Timer(10, this);
    private double leftAccelaration = 0;
    private double leftTopAccelaration = 0;
    private double rightAccelaration = 0;
    private double rightTopAccelaration = 0;
    private double topAccelaration = 0;
    private final double TOP_ACCELARATION = 700;
    private final double LEFT_ACCELARATION = 100;
    private final double LEFT_TOP_ACCELARATION = 650;
    private final double RIGHT_ACCELARATION = 100;
    private final double RIGHT_TOP_ACCELARATION = 650;

    public Myspaceship(String imagename)
    {
        super(imagename);

        this.bCustomDrawing = false;
        this.setMass(500);
    }

    public static Myspaceship getInstance()
    {
        Myspaceship ship = new Myspaceship("resource/rocket.png");
        return ship;
    }

    public void middleEngine(boolean start)
    {
        topAccelaration = start ? -TOP_ACCELARATION : 0;
        this.setAccelaration(new Vector(rightAccelaration + leftAccelaration, topAccelaration + leftTopAccelaration + rightTopAccelaration));
        if (start)
            this.theTimerForEngineMiddle.start();
        else
            this.theTimerForEngineMiddle.stop();
    }

    public void leftEngine(boolean start)
    {
        rightAccelaration = start ? LEFT_ACCELARATION : 0;
        rightTopAccelaration = start ? -RIGHT_TOP_ACCELARATION : 0;
        this.setAccelaration(new Vector(rightAccelaration + leftAccelaration, topAccelaration + leftTopAccelaration + rightTopAccelaration));
        if (start)
            this.theTimerForEngineLeft.start();
        else
            this.theTimerForEngineLeft.stop();
    }

    public void rightEngine(boolean start)
    {
        leftAccelaration = start ? -RIGHT_ACCELARATION : 0;
        leftTopAccelaration = start ? -LEFT_TOP_ACCELARATION : 0;
        this.setAccelaration(new Vector(rightAccelaration + leftAccelaration, topAccelaration + leftTopAccelaration + rightTopAccelaration));
        if (start)
            this.theTimerForEngineRight.start();
        else
            this.theTimerForEngineRight.stop();
    }

    private void engine(double offset)
    {
        int number = abs(theRandom.nextInt()) % 5 + 20;

        for (int i = 0; i < number; i++)
        {
            double tmpX = pow(-1, theRandom.nextInt() % 10) * theRandom.nextFloat() * 20 * 6;
            double tmpY = theRandom.nextFloat() * 100 * 20;

            int size = 6;
            ExpodeParticle aFire = new ExpodeParticle();
            aFire.setX(this.getCentreX() - size / 2 + offset);
            aFire.setY(this.getCentreY() + this.getHeight() / 2);
            aFire.setVelocityX(tmpX);
            aFire.setVelocityY(tmpY);
            aFire.setRed(255);
            aFire.setGreen(255);
            aFire.setBlue(255);
            aFire.setWidth(size);
            aFire.setHeight(size);
            aFire.bDeadIfNoActions = true;

            AlphaToAction aAction = new AlphaToAction(aFire);
            aAction.alphaTo(0, 0.1f);
            aFire.addAction(aAction);

            this.theScene.addSprite(aFire);
        }
    }

    private void engineLeft()
    {
        engine(-this.getWidth() / 8.0);
    }

    private void engineRight()
    {
        engine(this.getWidth() / 8.0);
    }

    private void engineMiddle()
    {
        engine(0);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (this.getShouldDie())
        {
            return;
        }

        if (e.getSource().equals(this.theTimerForEngineLeft))
        {
            engineLeft();
        }

        if (e.getSource().equals(this.theTimerForEngineRight))
        {
            engineRight();
        }

        if (e.getSource().equals(this.theTimerForEngineMiddle))
        {
            engineMiddle();
        }
    }

    @Override
    public void didUpdateState()
    {
        if (this.getCentreX() < this.getWidth() / 2.0 || this.getCentreX() > this.theScene.getWidth() - this.getWidth() / 2.0)
        {
            this.restoreX();
            this.setVelocityX(0);
        }

        if (this.getCentreY() > this.theScene.getHeight() - this.getHeight() / 2.0)
        {
            this.restoreY();
            this.setVelocityX(0);
            this.setVelocityY(0);
        }

        if (this.getCentreY() < this.getHeight() / 2.0)
        {
            this.restoreY();
            this.setVelocityY(0);
        }

        super.didUpdateState();
    }
}
