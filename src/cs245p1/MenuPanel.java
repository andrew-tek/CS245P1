/***************************************************************
* file: MenuPanel.java
* author: Andrew Tek
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Point and Click Game – v.1.1
* date last modified: 10/18/2017
*
* purpose: This class defines the main menu panel, from which the player can access
* various game features (like the game itself, credits, etc)
*
****************************************************************/
package cs245p1;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuPanel extends javax.swing.JPanel {

    //Please note: Auto-generated instance variables are automatically placed at the end of the class definition and cannot be moved
    
    //method: Constructor
    //purpose: Set up panel and shows logo
    public MenuPanel() {
        initComponents();
        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("../trogdor.png"))); 
    }

    //method: getCreditsButton
    //purpose: Returns creditsButton
    public JButton getCreditsButton() {
        return creditsButton;
    }
    
    //method: getHighscoreButton
    //purpose: Returns highscoreButton
    public JButton getHighscoreButton() {
        return highscoreButton;
    }
    
    //method: getPlayButton
    //purpose: Returns playButton
    public JButton getPlayButton() {
        return playButton;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    //Auto generated code
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playButton = new javax.swing.JButton();
        highscoreButton = new javax.swing.JButton();
        creditsButton = new javax.swing.JButton();
        jLabelLogo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));
        setPreferredSize(new java.awt.Dimension(600, 400));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        playButton.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        playButton.setText("Play");
        playButton.setToolTipText("\"Start the game\"");

        highscoreButton.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        highscoreButton.setText("Highscores");
        highscoreButton.setToolTipText("Check Leaderboard");

        creditsButton.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        creditsButton.setText("Credits");
        creditsButton.setToolTipText("Team Members");

        jLabelLogo.setToolTipText("Burninating the country side...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(464, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(creditsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(highscoreButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(playButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highscoreButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(creditsButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        System.out.println("Something pressed");
    }//GEN-LAST:event_formKeyPressed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton creditsButton;
    private javax.swing.JButton highscoreButton;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JButton playButton;
    // End of variables declaration//GEN-END:variables
}
