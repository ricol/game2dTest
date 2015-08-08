package au.com.rmit.test.gui;

import au.com.rmit.Game2dEngine.director.Director;
import au.com.rmit.test.ball.BallScene;
import au.com.rmit.test.fireworks.FireworksScene;
import au.com.rmit.test.fountain.FountainScene;
import au.com.rmit.test.physicengine.TestScene;
import au.com.rmit.test.realworld.RealWorldScene;
import au.com.rmit.test.spiralDemo.SpiralScene;
import au.com.rmit.test.universe.GravityDemoScene;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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

        this.addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent evt)
            {
                int x = 25, y = 50;
                panelGame.setLocation(x, y);
                panelGame.setSize(new Dimension(getWidth() - 2 * x, getHeight() - 2 * y));
                Director.getSharedInstance().updatePosition(0, 0, panelGame.getWidth(), panelGame.getHeight());
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnPause = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        panelGame = new javax.swing.JPanel();
        btnFountain = new javax.swing.JButton();
        btnSpiral = new javax.swing.JButton();
        btnFireworks = new javax.swing.JButton();
        btnTest = new javax.swing.JButton();
        btnBall = new javax.swing.JButton();
        btnRealWorld = new javax.swing.JButton();
        btnGravity = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        btnPause.setText("Pause");
        btnPause.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnPauseActionPerformed(evt);
            }
        });

        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnStopActionPerformed(evt);
            }
        });

        panelGame.setBackground(new java.awt.Color(0, 102, 51));

        javax.swing.GroupLayout panelGameLayout = new javax.swing.GroupLayout(panelGame);
        panelGame.setLayout(panelGameLayout);
        panelGameLayout.setHorizontalGroup(
            panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelGameLayout.setVerticalGroup(
            panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );

        btnFountain.setText("Fountain");
        btnFountain.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnFountainActionPerformed(evt);
            }
        });

        btnSpiral.setText("Spiral");
        btnSpiral.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSpiralActionPerformed(evt);
            }
        });

        btnFireworks.setText("Fireworks");
        btnFireworks.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnFireworksActionPerformed(evt);
            }
        });

        btnTest.setText("Physic Engine");
        btnTest.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnTestActionPerformed(evt);
            }
        });

        btnBall.setText("Ball");
        btnBall.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBallActionPerformed(evt);
            }
        });

        btnRealWorld.setText("Real World");
        btnRealWorld.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRealWorldActionPerformed(evt);
            }
        });

        btnGravity.setText("Universe");
        btnGravity.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnGravityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPause)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(btnGravity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRealWorld)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBall)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFireworks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFountain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSpiral))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(panelGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPause)
                    .addComponent(btnStop)
                    .addComponent(btnFountain)
                    .addComponent(btnSpiral)
                    .addComponent(btnFireworks)
                    .addComponent(btnTest)
                    .addComponent(btnBall)
                    .addComponent(btnRealWorld)
                    .addComponent(btnGravity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        Director.getSharedInstance().setParent(this.panelGame);
    }//GEN-LAST:event_formWindowOpened

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPauseActionPerformed
    {//GEN-HEADEREND:event_btnPauseActionPerformed
        // TODO add your handling code here:
        if (Director.getSharedInstance().currentScene != null)
        {
            Director.getSharedInstance().currentScene.pause();
        }
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnStopActionPerformed
    {//GEN-HEADEREND:event_btnStopActionPerformed
        // TODO add your handling code here:
        if (Director.getSharedInstance().currentScene != null)
        {
            Director.getSharedInstance().currentScene.stop();
        }
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnFountainActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnFountainActionPerformed
    {//GEN-HEADEREND:event_btnFountainActionPerformed
        // TODO add your handling code here:
        Director.getSharedInstance().showScene(new FountainScene());
    }//GEN-LAST:event_btnFountainActionPerformed

    private void btnSpiralActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSpiralActionPerformed
    {//GEN-HEADEREND:event_btnSpiralActionPerformed
        // TODO add your handling code here:
        Director.getSharedInstance().showScene(new SpiralScene());
    }//GEN-LAST:event_btnSpiralActionPerformed

    private void btnFireworksActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnFireworksActionPerformed
    {//GEN-HEADEREND:event_btnFireworksActionPerformed
        // TODO add your handling code here:
        Director.getSharedInstance().showScene(new FireworksScene());
    }//GEN-LAST:event_btnFireworksActionPerformed

    private void btnTestActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnTestActionPerformed
    {//GEN-HEADEREND:event_btnTestActionPerformed
        // TODO add your handling code here:
        Director.getSharedInstance().showScene(new TestScene());
    }//GEN-LAST:event_btnTestActionPerformed

    private void btnBallActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBallActionPerformed
    {//GEN-HEADEREND:event_btnBallActionPerformed
        // TODO add your handling code here:
        Director.getSharedInstance().showScene(new BallScene());
    }//GEN-LAST:event_btnBallActionPerformed

    private void btnRealWorldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRealWorldActionPerformed
    {//GEN-HEADEREND:event_btnRealWorldActionPerformed
        // TODO add your handling code here:
        Director.getSharedInstance().showScene(new RealWorldScene());
    }//GEN-LAST:event_btnRealWorldActionPerformed

    private void btnGravityActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnGravityActionPerformed
    {//GEN-HEADEREND:event_btnGravityActionPerformed
        // TODO add your handling code here:
        Director.getSharedInstance().showScene(new GravityDemoScene());
    }//GEN-LAST:event_btnGravityActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBall;
    private javax.swing.JButton btnFireworks;
    private javax.swing.JButton btnFountain;
    private javax.swing.JButton btnGravity;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnRealWorld;
    private javax.swing.JButton btnSpiral;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton btnTest;
    private javax.swing.JPanel panelGame;
    // End of variables declaration//GEN-END:variables
}
