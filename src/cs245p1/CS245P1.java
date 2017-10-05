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
    
    private static final String MAIN_MENU = "Menu";
    private static final String CREDITS_SCREEN = "Credits";
    private static final String START_SCREEN = "Start";
    private static final String GAME_OVER = "Game Over";
    private static final String HIGH_SCORES = "High Scores";
    private static final String GAME = "Game";
    private static HangManGame currentGame;
    /**
     * @param args the command line arguments
     */
    public CS245P1(){
        JFrame mainFrame = new JFrame();
        CardLayout cardLayout = new CardLayout();
        JPanel cardHolder = new JPanel(cardLayout);
        CreditsPanel creditPanel = new CreditsPanel();
        GameOverPanel gameOverPanel = new GameOverPanel();
        HighScoresPanel highScoresPanel = new HighScoresPanel();
        MainGamePanel mainGamePanel = new MainGamePanel();
        MenuPanel menuPanel = new MenuPanel();
        StartPanel startPanel = new StartPanel();
        
        cardHolder.add(creditPanel, CREDITS_SCREEN);
        cardHolder.add(gameOverPanel, GAME_OVER);
        cardHolder.add(highScoresPanel, HIGH_SCORES);
        cardHolder.add(mainGamePanel, GAME);
        cardHolder.add(startPanel, START_SCREEN);
        cardHolder.add(menuPanel, MAIN_MENU);
        
        mainFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(new java.awt.Dimension(600, 400));
        mainFrame.add(cardHolder);
        cardLayout.show(cardHolder, START_SCREEN);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        
        ActionListener showMenuScreen = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cardLayout.show(cardHolder, MAIN_MENU);
            }
        };
        Timer timer = new Timer (1000, showMenuScreen);
        timer.setRepeats(false);
        timer.start(); 
                
        ActionListener buttonHandler = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == menuPanel.getPlayButton()) {
                    currentGame = new HangManGame();
                    cardLayout.show(cardHolder, GAME);
                }else if(e.getSource() == menuPanel.getHighscoreButton()){
                    cardLayout.show(cardHolder, HIGH_SCORES);
                }else if(e.getSource() == menuPanel.getCreditsButton()){
                    cardLayout.show(cardHolder, CREDITS_SCREEN);
                }else if(e.getSource() == mainGamePanel.getSkipButton()){
                    cardLayout.show(cardHolder, GAME_OVER);
                }else if((e.getSource() == gameOverPanel.getEndButton()) ||
                        (e.getSource() == creditPanel.getBackButton()) ||
                        (e.getSource() == highScoresPanel.getBackButton())){
                    cardLayout.show(cardHolder, MAIN_MENU);
                }
            }
        };
        menuPanel.getCreditsButton().addActionListener(buttonHandler);
        menuPanel.getPlayButton().addActionListener(buttonHandler);
        menuPanel.getHighscoreButton().addActionListener(buttonHandler);
        mainGamePanel.getSkipButton().addActionListener(buttonHandler);
        gameOverPanel.getEndButton().addActionListener(buttonHandler);
        creditPanel.getBackButton().addActionListener(buttonHandler);
        highScoresPanel.getBackButton().addActionListener(buttonHandler);
    }
    
    public static HangManGame getGame(){
        return currentGame;
    }
    
    public static void main(String[] args) {
        CS245P1 game = new CS245P1();
    }
    
}

