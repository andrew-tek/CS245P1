
package cs245p1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.Timer;

public class SudokuPanel extends javax.swing.JPanel {
    
    public SudokuPanel() {
        initComponents();
        
        ActionListener updateClock = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy hh:mm:ss");
            Date date = new Date();
            clockLabel.setText(dateFormat.format(date).toString());
            
            // Set points to points + 540 (Sudoku)
            // ERROR HERE int points = CS245P1.getSudokuGame().getPoints() + CS245P1.getColorGame().getPoints() + CS245P1.getGame().getPoints();
            int points = CS245P1.getColorGame().getPoints() + CS245P1.getGame().getPoints();
            jLabelUserScore.setText("User Score: " + points);
        }
        };
        
        Timer timer = new Timer (1000, updateClock);
        timer.setRepeats(true);
        timer.start();
    }
    
 
    
//    // method: transitionToGameOver
//    // purpose: Handles the transitioning to the game over screen once a game is done. Resets coordinate
//    //values, sets the score on the game over panel, and switches to that panel.
//    private void transitionToGameOver(){
//        //reset panel values to initial state
//        resetCoordsSets();
//        //set score on game over panel and move to that panel
//        GameOverPanel gameOver = (GameOverPanel)CS245P1.getPanelMap().get(CS245P1.GAME_OVER);
//        gameOver.setScore();
//        CS245P1.getPrimaryLayout().show(CS245P1.getPrimaryCardHolder(), CS245P1.GAME_OVER);
//        gameOver.checkForHighScore();
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clockLabel = new javax.swing.JLabel();
        jLabelUserScore = new javax.swing.JLabel();
        sudokuPanel = new javax.swing.JPanel();
        mainBoard = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(600, 400));

        clockLabel.setText("Clock Here");
        clockLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), null));
        clockLabel.setPreferredSize(new java.awt.Dimension(150, 25));

        jLabelUserScore.setText("User Score:");

        mainBoard.setAlignmentX(0.5F);
        mainBoard.setPreferredSize(new java.awt.Dimension(350, 350));

        javax.swing.GroupLayout sudokuPanelLayout = new javax.swing.GroupLayout(sudokuPanel);
        sudokuPanel.setLayout(sudokuPanelLayout);
        sudokuPanelLayout.setHorizontalGroup(
            sudokuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sudokuPanelLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(mainBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        sudokuPanelLayout.setVerticalGroup(
            sudokuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        mainBoard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sudokuBoard.png")));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 389, Short.MAX_VALUE)
                        .addComponent(clockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sudokuPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelUserScore, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUserScore))
                .addGap(18, 18, 18)
                .addComponent(sudokuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clockLabel;
    private javax.swing.JLabel jLabelUserScore;
    private javax.swing.JLabel mainBoard;
    private javax.swing.JPanel sudokuPanel;
    // End of variables declaration//GEN-END:variables
}
