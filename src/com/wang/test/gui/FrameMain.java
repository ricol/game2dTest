package com.wang.test.gui;

import com.wang.Game2dEngine.director.Director;
import com.wang.common.JavaTheme;
import com.wang.test.fireworks.FireworksScene;
import com.wang.test.fountain.FountainScene;
import com.wang.test.math.MathScene;
import com.wang.test.pinball.PinballScene;
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

        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnFountain = new javax.swing.JButton();
        btnFireworks = new javax.swing.JButton();
        btnGravity = new javax.swing.JButton();
        btnPinball = new javax.swing.JButton();
        btnMath = new javax.swing.JButton();
        panelGame = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel3.add(btnClose);

        btnPause.setText("Pause");
        btnPause.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnPauseActionPerformed(evt);
            }
        });
        jPanel3.add(btnPause);

        jPanel4.add(jPanel3);

        btnFountain.setText("Fountain");
        btnFountain.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnFountainActionPerformed(evt);
            }
        });
        jPanel2.add(btnFountain);

        btnFireworks.setText("Fireworks");
        btnFireworks.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnFireworksActionPerformed(evt);
            }
        });
        jPanel2.add(btnFireworks);

        btnGravity.setText("Universe");
        btnGravity.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnGravityActionPerformed(evt);
            }
        });
        jPanel2.add(btnGravity);

        btnPinball.setText("Pinball");
        btnPinball.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnPinballActionPerformed(evt);
            }
        });
        jPanel2.add(btnPinball);

        btnMath.setText("Math");
        btnMath.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnMathActionPerformed(evt);
            }
        });
        jPanel2.add(btnMath);

        jPanel4.add(jPanel2);

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_START);

        panelGame.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout panelGameLayout = new javax.swing.GroupLayout(panelGame);
        panelGame.setLayout(panelGameLayout);
        panelGameLayout.setHorizontalGroup(
            panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 863, Short.MAX_VALUE)
        );
        panelGameLayout.setVerticalGroup(
            panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        getContentPane().add(panelGame, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        Director.getSharedInstance().setParent(this.panelGame);
    }//GEN-LAST:event_formWindowOpened

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPauseActionPerformed
    {//GEN-HEADEREND:event_btnPauseActionPerformed
        if (Director.getSharedInstance().currentScene != null)
        {
            Director.getSharedInstance().currentScene.pause();
        }

        if (Director.getSharedInstance().currentScene.isScenePaused())
        {
            this.btnPause.setText("Continue");
        } else
        {
            this.btnPause.setText("Pause");
        }
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCloseActionPerformed
    {//GEN-HEADEREND:event_btnCloseActionPerformed
        exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnFountainActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnFountainActionPerformed
    {//GEN-HEADEREND:event_btnFountainActionPerformed
        Director.getSharedInstance().showScene(new FountainScene());
    }//GEN-LAST:event_btnFountainActionPerformed

    private void btnFireworksActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnFireworksActionPerformed
    {//GEN-HEADEREND:event_btnFireworksActionPerformed
        Director.getSharedInstance().showScene(new FireworksScene());
    }//GEN-LAST:event_btnFireworksActionPerformed

    private void btnGravityActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnGravityActionPerformed
    {//GEN-HEADEREND:event_btnGravityActionPerformed
        Director.getSharedInstance().showScene(new GravityDemoScene());
    }//GEN-LAST:event_btnGravityActionPerformed

    private void btnPinballActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPinballActionPerformed
    {//GEN-HEADEREND:event_btnPinballActionPerformed
        Director.getSharedInstance().showScene(new PinballScene());
    }//GEN-LAST:event_btnPinballActionPerformed

    private void btnMathActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnMathActionPerformed
    {//GEN-HEADEREND:event_btnMathActionPerformed
        Director.getSharedInstance().showScene(new MathScene());
    }//GEN-LAST:event_btnMathActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnFireworks;
    private javax.swing.JButton btnFountain;
    private javax.swing.JButton btnGravity;
    private javax.swing.JButton btnMath;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPinball;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panelGame;
    // End of variables declaration//GEN-END:variables
}
