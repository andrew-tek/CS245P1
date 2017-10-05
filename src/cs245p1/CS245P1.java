/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245p1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


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
        //Sets up timer for 4000 ms... 3000ms it will change too early
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
//    void static creditsButtonListener (JFrame mainFrame, JPanel creditsPanel) {
//        creditsPanel.getCreditsButton = new JButton("auto");
//        add(creditsPanel.creditsButton);
//        creditsPanel.creditsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JFrame creditsPage = new JFrame();
//                creditsPage.add(creditsPanel);
//                creditsPage.setVisible(true);
//                System.out.println("HERE");
//            }
//        });
//    }
  }
    
