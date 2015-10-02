package au.com.rmit.test.gui;

import au.com.rmit.Game2dEngine.director.Director;
import au.com.rmit.test.fireworks.FireworksScene;
import au.com.rmit.test.fountain.FountainScene;
import au.com.rmit.test.pinball.PinballScene;
import au.com.rmit.test.realworld.RealWorldScene;
import au.com.rmit.test.universe.GravityDemoScene;
import static java.lang.System.exit;

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnPause = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        panelGame = new javax.swing.JPanel();
        btnFountain = new javax.swing.JButton();
        btnFireworks = new javax.swing.JButton();
        btnRealWorld = new javax.swing.JButton();
        btnGravity = new javax.swing.JButton();
        btnPinball = new javax.swing.JButton();

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

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCloseActionPerformed(evt);
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

        btnFireworks.setText("Fireworks");
        btnFireworks.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnFireworksActionPerformed(evt);
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

        btnPinball.setText("Pinball");
        btnPinball.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnPinballActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPause)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 290, Short.MAX_VALUE)
                        .addComponent(btnPinball)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGravity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRealWorld)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFireworks)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFountain))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(panelGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPause)
                    .addComponent(btnClose)
                    .addComponent(btnFountain)
                    .addComponent(btnFireworks)
                    .addComponent(btnRealWorld)
                    .addComponent(btnGravity)
                    .addComponent(btnPinball))
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
        if (Director.getSharedInstance().currentScene != null)
        {
            Director.getSharedInstance().currentScene.pause();
        }

        if (Director.getSharedInstance().currentScene.isScenePaused())
            this.btnPause.setText("Continue");
        else
            this.btnPause.setText("Pause");
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

    private void btnRealWorldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRealWorldActionPerformed
    {//GEN-HEADEREND:event_btnRealWorldActionPerformed
        Director.getSharedInstance().showScene(new RealWorldScene());
    }//GEN-LAST:event_btnRealWorldActionPerformed

    private void btnGravityActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnGravityActionPerformed
    {//GEN-HEADEREND:event_btnGravityActionPerformed
        Director.getSharedInstance().showScene(new GravityDemoScene());
    }//GEN-LAST:event_btnGravityActionPerformed

    private void btnPinballActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPinballActionPerformed
    {//GEN-HEADEREND:event_btnPinballActionPerformed
        Director.getSharedInstance().showScene(new PinballScene());
    }//GEN-LAST:event_btnPinballActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnFireworks;
    private javax.swing.JButton btnFountain;
    private javax.swing.JButton btnGravity;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPinball;
    private javax.swing.JButton btnRealWorld;
    private javax.swing.JPanel panelGame;
    // End of variables declaration//GEN-END:variables
}
