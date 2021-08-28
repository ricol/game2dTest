/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.navigate

import com.wang.Game2dEngine.action.AlphaToAction
import com.wang.math.vector.Vector
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.Timer

/**
 * @author ricolwang
 */
class Myspaceship(imagename: String?) : MovingObject(imagename), ActionListener
{
    private val theTimerForEngineLeft = Timer(10, this)
    private val theTimerForEngineRight = Timer(10, this)
    private val theTimerForEngineMiddle = Timer(10, this)
    private var leftAccelaration = 0.0
    private var leftTopAccelaration = 0.0
    private var rightAccelaration = 0.0
    private var rightTopAccelaration = 0.0
    private var topAccelaration = 0.0
    private val TOP_ACCELARATION = 700.0
    private val LEFT_ACCELARATION = 100.0
    private val LEFT_TOP_ACCELARATION = 650.0
    private val RIGHT_ACCELARATION = 100.0
    private val RIGHT_TOP_ACCELARATION = 650.0
    fun middleEngine(start: Boolean)
    {
        topAccelaration = if (start) -TOP_ACCELARATION else 0.0
        accelaration = Vector(rightAccelaration + leftAccelaration, topAccelaration + leftTopAccelaration + rightTopAccelaration)
        if (start) theTimerForEngineMiddle.start() else theTimerForEngineMiddle.stop()
    }

    fun leftEngine(start: Boolean)
    {
        rightAccelaration = if (start) LEFT_ACCELARATION else 0.0
        rightTopAccelaration = if (start) -RIGHT_TOP_ACCELARATION else 0.0
        accelaration = Vector(rightAccelaration + leftAccelaration, topAccelaration + leftTopAccelaration + rightTopAccelaration)
        if (start) theTimerForEngineLeft.start() else theTimerForEngineLeft.stop()
    }

    fun rightEngine(start: Boolean)
    {
        leftAccelaration = if (start) -RIGHT_ACCELARATION else 0.0
        leftTopAccelaration = if (start) -LEFT_TOP_ACCELARATION else 0.0
        accelaration = Vector(rightAccelaration + leftAccelaration, topAccelaration + leftTopAccelaration + rightTopAccelaration)
        if (start) theTimerForEngineRight.start() else theTimerForEngineRight.stop()
    }

    private fun engine(offset: Double)
    {
        val number = Math.abs(theRandom.nextInt()) % 5 + 20
        for (i in 0 until number)
        {
            val tmpX = Math.pow(-1.0, theRandom.nextInt() % 10.toDouble()) * theRandom.nextFloat() * 20 * 6
            val tmpY = theRandom.nextFloat() * 100 * 20.toDouble()
            val size = 6
            val aFire = ExpodeParticle()
            aFire.x = this.centreX - size / 2 + offset
            aFire.y = this.centreY + height / 2
            aFire.velocityX = tmpX
            aFire.velocityY = tmpY
            aFire.red = 255
            aFire.green = 255
            aFire.blue = 255
            aFire.width = size.toDouble()
            aFire.height = size.toDouble()
            aFire.bDeadIfNoActions = true
            val aAction = AlphaToAction(aFire)
            aAction.alphaTo(0f, 0.1f)
            aFire.addAction(aAction)
            theScene.addSprite(aFire)
        }
    }

    private fun engineLeft()
    {
        engine(-width / 8.0)
    }

    private fun engineRight()
    {
        engine(width / 8.0)
    }

    private fun engineMiddle()
    {
        engine(0.0)
    }

    override fun actionPerformed(e: ActionEvent)
    {
        if (this.shouldDie)
        {
            return
        }
        if (e.source == theTimerForEngineLeft)
        {
            engineLeft()
        }
        if (e.source == theTimerForEngineRight)
        {
            engineRight()
        }
        if (e.source == theTimerForEngineMiddle)
        {
            engineMiddle()
        }
    }

    override fun didUpdateState()
    {
        if (this.centreX < width / 2.0 || this.centreX > theScene.width - width / 2.0)
        {
            restoreX()
            this.velocityX = 0.0
        }
        if (this.centreY > theScene.height - height / 2.0)
        {
            restoreY()
            this.velocityX = 0.0
            this.velocityY = 0.0
        }
        if (this.centreY < height / 2.0)
        {
            restoreY()
            this.velocityY = 0.0
        }
        super.didUpdateState()
    }

    companion object
    {
        val instance: Myspaceship
            get() = Myspaceship("resource/rocket.png")
    }

    init
    {
        bCustomDrawing = false
        mass = 500.0
    }
}