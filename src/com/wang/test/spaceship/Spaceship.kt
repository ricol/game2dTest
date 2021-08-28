/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.spaceship

import com.wang.Game2dEngine.action.AlphaToAction
import com.wang.Game2dEngine.sprite.Sprite
import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException
import javax.imageio.ImageIO

/**
 * @author ricolwang
 */
open class Spaceship : Sprite
{
    private var totalLife = 100
    var currentLife = totalLife
        private set

    constructor(x: Double, y: Double, width: Double, height: Double, mass: Double, velocityX: Double, velocityY: Double) : super(x, y, width, height, mass, velocityX, velocityY)
    {
    }

    constructor(imagename: String?) : super(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    {
        val aImage: BufferedImage
        try
        {
            aImage = ImageIO.read(File(imagename))
            width = aImage.width.toDouble()
            height = aImage.height.toDouble()
            setImage(imagename)
        } catch (e: IOException)
        {
        }
    }

    fun fire(imagename: String?)
    {
    }

    fun decreaseLife(value: Int)
    {
        val aAction = AlphaToAction(this)
        aAction.alphaTo((this.currentLife - value) / (totalLife * 1.0f), 0f)
        addAction(aAction)
        this.currentLife -= value
        if (this.currentLife <= 0)
        {
            setShouldDie()
        }
    }

    fun resetTotalLife(life: Int)
    {
        totalLife = life
        this.currentLife = life
    }

    fun explode()
    {
    }

    override fun onDead()
    {
        super.onDead() //To change body of generated methods, choose Tools | Templates.
        explode()
    }
}