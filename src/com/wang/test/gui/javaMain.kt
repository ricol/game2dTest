/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.gui

import com.wang.Game2dEngine.director.Director
import com.wang.common.JavaTheme
import com.wang.test.collision.CollisionScene
import com.wang.test.fireworks.FireworksScene
import com.wang.test.fountain.FountainScene
import com.wang.test.galaxies.GalaxiesDemoScene
import com.wang.test.navigate.NavigateScene
import com.wang.test.universe.GravityDemoScene
import java.awt.event.WindowEvent
import java.awt.event.WindowListener
import javax.swing.*

/**
 * @author ricolwang
 */
class javaMain
{
    var menuGame: JMenu
    var menuOption: JMenu
    var menuFountain: JMenuItem
    var menuFireworks: JMenuItem
    var menuCollision: JMenuItem
    var menuRocket: JMenuItem
    var menuUniverse: JMenuItem
    var menuGalaxies: JMenuItem
    var menuSeperator: JMenuItem
    var menuExit: JMenuItem
    var menuPause: JMenuItem
    var panelGame = JPanel()

    companion object
    {
        @JvmStatic
        fun main(args: Array<String>)
        {
            SwingUtilities.invokeLater {
                JavaTheme.setLookAndFeel(JavaTheme.LOOKANDFEEL_NIBUM)
                javaMain()
            }
        }
    }

    init
    {
        val f = JFrame("Game2dEngine Test")
        val mb = JMenuBar()
        menuGame = JMenu("Game")
        menuFountain = JMenuItem("Fountan")
        menuFountain.addActionListener { Director.sharedInstance.showScene(FountainScene()) }
        menuFireworks = JMenuItem("Fireforks")
        menuFireworks.addActionListener { Director.sharedInstance.showScene(FireworksScene()) }
        menuCollision = JMenuItem("Collision")
        menuCollision.addActionListener { Director.sharedInstance.showScene(CollisionScene()) }
        menuRocket = JMenuItem("Rocket")
        menuRocket.addActionListener { Director.sharedInstance.showScene(NavigateScene()) }
        menuUniverse = JMenuItem("Universe")
        menuUniverse.addActionListener { Director.sharedInstance.showScene(GravityDemoScene()) }
        menuGalaxies = JMenuItem("Galaxies")
        menuGalaxies.addActionListener { Director.sharedInstance.showScene(GalaxiesDemoScene()) }
        menuSeperator = JMenuItem("-")
        menuExit = JMenuItem("Exit")
        menuExit.addActionListener { System.exit(0) }
        menuGame.add(menuFountain)
        menuGame.add(menuFireworks)
        menuGame.add(menuCollision)
        menuGame.add(menuRocket)
        menuGame.add(menuUniverse)
        menuGame.add(menuGalaxies)
        menuGame.add(menuSeperator)
        menuGame.add(menuExit)
        menuOption = JMenu("Option")
        menuPause = JMenuItem("Pause")
        menuPause.addActionListener {
            val theScene = Director.sharedInstance.currentScene
            theScene?.pause()
        }
        menuOption.add(menuPause)
        mb.add(menuGame)
        mb.add(menuOption)
        f.contentPane = panelGame
        f.jMenuBar = mb
        f.setSize(800, 600)
        f.layout = null
        f.isVisible = true
        f.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        f.addWindowListener(object : WindowListener
        {
            override fun windowOpened(e: WindowEvent)
            {
                Director.sharedInstance.setParent(panelGame)
            }

            override fun windowClosing(e: WindowEvent)
            {
            }

            override fun windowClosed(e: WindowEvent)
            {
            }

            override fun windowIconified(e: WindowEvent)
            {
            }

            override fun windowDeiconified(e: WindowEvent)
            {
            }

            override fun windowActivated(e: WindowEvent)
            {
            }

            override fun windowDeactivated(e: WindowEvent)
            {
            }
        })
    }
}