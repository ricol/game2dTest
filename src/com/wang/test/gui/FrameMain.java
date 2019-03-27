package com.wang.test.gui;

import com.wang.Game2dEngine.director.Director;
import com.wang.Game2dEngine.scene.Scene;
import com.wang.common.JavaTheme;
import com.wang.test.fireworks.FireworksScene;
import com.wang.test.fountain.FountainScene;
import com.wang.test.math.MathScene;
import com.wang.test.navigate.NavigateScene;
import com.wang.test.universe.GravityDemoScene;
import static java.lang.System.exit;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ricolwang
 */
public class FrameMain extends javax.swing.JFrame
{

    public FrameMain()
    {
        initComponents();
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JavaTheme.setLookAndFeel(JavaTheme.LOOKANDFEEL_NIBUM);
                new FrameMain().setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        panelGame = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        menuGame = new javax.swing.JMenu();
        menuFountain = new javax.swing.JMenuItem();
        menuFireworks = new javax.swing.JMenuItem();
        menuMath = new javax.swing.JMenuItem();
        menuPinball = new javax.swing.JMenuItem();
        menuUniverse = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuExit = new javax.swing.JMenuItem();
        menuOption = new javax.swing.JMenu();
        menuPause = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        panelGame.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout panelGameLayout = new javax.swing.GroupLayout(panelGame);
        panelGame.setLayout(panelGameLayout);
        panelGameLayout.setHorizontalGroup(
            panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 863, Short.MAX_VALUE)
        );
        panelGameLayout.setVerticalGroup(
            panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        getContentPane().add(panelGame, java.awt.BorderLayout.CENTER);

        menuGame.setText("Game");

        menuFountain.setText("Foundtain");
        menuFountain.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuFountainActionPerformed(evt);
            }
        });
        menuGame.add(menuFountain);

        menuFireworks.setText("Fireworks");
        menuFireworks.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuFireworksActionPerformed(evt);
            }
        });
        menuGame.add(menuFireworks);

        menuMath.setText("Math");
        menuMath.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuMathActionPerformed(evt);
            }
        });
        menuGame.add(menuMath);

        menuPinball.setText("Rocket");
        menuPinball.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuPinballActionPerformed(evt);
            }
        });
        menuGame.add(menuPinball);

        menuUniverse.setText("Universe");
        menuUniverse.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuUniverseActionPerformed(evt);
            }
        });
        menuGame.add(menuUniverse);
        menuGame.add(jSeparator1);

        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuExitActionPerformed(evt);
            }
        });
        menuGame.add(menuExit);

        menuBar.add(menuGame);

        menuOption.setText("Option");

        menuPause.setText("Pause");
        menuPause.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuPauseActionPerformed(evt);
            }
        });
        menuOption.add(menuPause);

        menuBar.add(menuOption);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        Director.getSharedInstance().setParent(this.panelGame);
    }//GEN-LAST:event_formWindowOpened

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuExitActionPerformed
    {//GEN-HEADEREND:event_menuExitActionPerformed
        exit(0);
    }//GEN-LAST:event_menuExitActionPerformed

    private void menuFountainActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuFountainActionPerformed
    {//GEN-HEADEREND:event_menuFountainActionPerformed
        Director.getSharedInstance().showScene(new FountainScene());
    }//GEN-LAST:event_menuFountainActionPerformed

    private void menuFireworksActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuFireworksActionPerformed
    {//GEN-HEADEREND:event_menuFireworksActionPerformed
        Director.getSharedInstance().showScene(new FireworksScene());
    }//GEN-LAST:event_menuFireworksActionPerformed

    private void menuMathActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuMathActionPerformed
    {//GEN-HEADEREND:event_menuMathActionPerformed
        Director.getSharedInstance().showScene(new MathScene());
    }//GEN-LAST:event_menuMathActionPerformed

    private void menuPinballActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuPinballActionPerformed
    {//GEN-HEADEREND:event_menuPinballActionPerformed
        Director.getSharedInstance().showScene(new NavigateScene());
    }//GEN-LAST:event_menuPinballActionPerformed

    private void menuUniverseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuUniverseActionPerformed
    {//GEN-HEADEREND:event_menuUniverseActionPerformed
        Director.getSharedInstance().showScene(new GravityDemoScene());
    }//GEN-LAST:event_menuUniverseActionPerformed

    private void menuPauseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuPauseActionPerformed
    {//GEN-HEADEREND:event_menuPauseActionPerformed
        Scene theScene = Director.getSharedInstance().currentScene;
        if (theScene != null) theScene.pause();
    }//GEN-LAST:event_menuPauseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenuItem menuFireworks;
    private javax.swing.JMenuItem menuFountain;
    private javax.swing.JMenu menuGame;
    private javax.swing.JMenuItem menuMath;
    private javax.swing.JMenu menuOption;
    private javax.swing.JMenuItem menuPause;
    private javax.swing.JMenuItem menuPinball;
    private javax.swing.JMenuItem menuUniverse;
    private javax.swing.JPanel panelGame;
    // End of variables declaration//GEN-END:variables
}
