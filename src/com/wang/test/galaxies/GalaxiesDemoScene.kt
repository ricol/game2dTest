/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.galaxies

import com.wang.test.basicscene.NormalScene
import java.awt.event.MouseEvent
import java.util.*

/**
 * @author ricolwang
 */
class GalaxiesDemoScene : NormalScene()
{
    val allEntities: MutableSet<Entity>
        get()
        {
            val allEntities: MutableSet<Entity> = HashSet()
            val all = this.allSprites
            for (aSprite in all)
            {
                if (aSprite is Entity)
                {
                    allEntities.add(aSprite)
                }
            }
            return allEntities
        }

    override fun mousePressed(e: MouseEvent)
    {
        if (e.button == MouseEvent.BUTTON1)
        {
            Galaxy(this, e.x.toDouble(), e.y.toDouble())
        } else if (e.button == MouseEvent.BUTTON3)
        {
            for (s in this.allSprites)
            {
                s!!.setLifeTime(0.0)
            }
        }
    }
}