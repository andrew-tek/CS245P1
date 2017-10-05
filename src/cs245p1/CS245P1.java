/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245p1;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author 
 */
public class CS245P1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StartPanel startPanel = new StartPanel();
        MenuPanel menuPanel = new MenuPanel();
        MainGamePanel mainGamePanel = new MainGamePanel();
        //HighScorePanel goes here
        CreditsPanel creditPanel = new CreditsPanel();
        GameOverPanel gameOver = new GameOverPanel();
        
        
        
        JFrame mainFrame = new JFrame();
        mainFrame.add(startPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
        ActionListener showMenuScreen = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mainFrame.remove(startPanel);
                mainFrame.add(menuPanel);
                mainFrame.pack();
            }
        };
        Timer timer = new Timer (4000, showMenuScreen);
        timer.setRepeats(false);
        timer.start();  
    }
  }
    
