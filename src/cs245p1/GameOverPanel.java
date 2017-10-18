/***************************************************************
* file: GameOverPanel.java
* author: Christopher Kilian
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Point and Click Game – v.1.1
* date last modified: 10/17/2017
*
* purpose: This class defines the panel which displays the game over screen
* and the players score for the game
*
****************************************************************/
package cs245p1;

import javax.swing.JButton;

public class GameOverPanel extends javax.swing.JPanel {

    //Please note: Auto-generated instance variables are automatically placed at the end of the class definition and cannot be moved
    
    // method: GameOverPanel
    // purpose: constructor
    public GameOverPanel() {
        initComponents();
    }
    
    // method: setScore
    // purpose: sets the score label with the most recent game score
    public void setScore(){
        int totalPoints = CS245P1.getGame().getPoints() + CS245P1.getColorGame().getPoints();
        scoreLabel.setText("Your Score: " + totalPoints);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameOverLabel = new javax.swing.JLabel();
        endButton = new javax.swing.JButton();
        scoreLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(600, 400));

        gameOverLabel.setFont(new java.awt.Font("Century", 3, 36)); // NOI18N
        gameOverLabel.setForeground(new java.awt.Color(255, 51, 0));
        gameOverLabel.setText("Game Over");

        endButton.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        endButton.setText("End");

        scoreLabel.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        scoreLabel.setText("Your Score: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(endButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gameOverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(gameOverLabel)
                .addGap(53, 53, 53)
                .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(endButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public JButton getEndButton() {
        return endButton;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton endButton;
    private javax.swing.JLabel gameOverLabel;
    private javax.swing.JLabel scoreLabel;
    // End of variables declaration//GEN-END:variables
}
