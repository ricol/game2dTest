/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wang.test.gui;

import com.wang.Game2dEngine.director.Director;
import com.wang.Game2dEngine.scene.Scene;
import com.wang.common.JavaTheme;
import com.wang.test.collision.CollisionScene;
import com.wang.test.fireworks.FireworksScene;
import com.wang.test.fountain.FountainScene;
import com.wang.test.galaxies.GalaxiesDemoScene;
import com.wang.test.navigate.NavigateScene;
import com.wang.test.universe.GravityDemoScene;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import static java.lang.System.exit;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author ricolwang
 */
public class javaMain
{

    JMenu menuGame, menuOption;
    JMenuItem menuFountain, menuFireworks, menuCollision, menuRocket, menuUniverse, menuGalaxies, menuSeperator, menuExit, menuPause;
    JPanel panelGame = new JPanel();

    public javaMain()
    {
        JFrame f = new JFrame("Game2dEngine Test");
        JMenuBar mb = new JMenuBar();

        menuGame = new JMenu("Game");

        menuFountain = new JMenuItem("Fountan");
        menuFountain.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Director.getSharedInstance().showScene(new FountainScene());
            }
        });

        menuFireworks = new JMenuItem("Fireforks");
        menuFireworks.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Director.getSharedInstance().showScene(new FireworksScene());
            }
        });

        menuCollision = new JMenuItem("Collision");
        menuCollision.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Director.getSharedInstance().showScene(new CollisionScene());
            }
        });

        menuRocket = new JMenuItem("Rocket");
        menuRocket.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Director.getSharedInstance().showScene(new NavigateScene());
            }
        });

        menuUniverse = new JMenuItem("Universe");
        menuUniverse.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Director.getSharedInstance().showScene(new GravityDemoScene());
            }
        });

        menuGalaxies = new JMenuItem("Galaxies");
        menuGalaxies.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Director.getSharedInstance().showScene(new GalaxiesDemoScene());
            }
        });

        menuSeperator = new JMenuItem("-");

        menuExit = new JMenuItem("Exit");
        menuExit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                exit(0);
            }
        });

        menuGame.add(menuFountain);
        menuGame.add(menuFireworks);
        menuGame.add(menuCollision);
        menuGame.add(menuRocket);
        menuGame.add(menuUniverse);
        menuGame.add(menuGalaxies);
        menuGame.add(menuSeperator);
        menuGame.add(menuExit);

        menuOption = new JMenu("Option");

        menuPause = new JMenuItem("Pause");
        menuPause.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Scene theScene = Director.getSharedInstance().currentScene;
                if (theScene != null) theScene.pause();
            }
        });
        menuOption.add(menuPause);

        mb.add(menuGame);
        mb.add(menuOption);

        f.setContentPane(panelGame);
        f.setJMenuBar(mb);
        f.setSize(800, 600);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.addWindowListener(new WindowListener()
        {
            @Override
            public void windowOpened(WindowEvent e)
            {
                Director.getSharedInstance().setParent(panelGame);
            }

            @Override
            public void windowClosing(WindowEvent e)
            {
            }

            @Override
            public void windowClosed(WindowEvent e)
            {
            }

            @Override
            public void windowIconified(WindowEvent e)
            {
            }

            @Override
            public void windowDeiconified(WindowEvent e)
            {
            }

            @Override
            public void windowActivated(WindowEvent e)
            {
            }

            @Override
            public void windowDeactivated(WindowEvent e)
            {
            }
        });
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JavaTheme.setLookAndFeel(JavaTheme.LOOKANDFEEL_NIBUM);
                new javaMain();
            }
        });
    }
}
