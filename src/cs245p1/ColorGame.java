/***************************************************************
* file: GameOverPanel.java
* author: Andrew Tek
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Point and Click Game – v.1.1
* date last modified: 10/17/2017
*
* purpose: This class holds the basic logic for the color game
* 
*
****************************************************************/
package cs245p1;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JLabel;


public class ColorGame {
    private int points;
    
    //method: Constructor
    //purpose: Initialize class set points = 0
    public ColorGame() {
        points = 0;
    }
    //method: addPoints
    //purpose: add points to the game score
    public void addPoints(int amount) {
        points += amount;
    }
    //method: getPoints
    //purpose: return number of points
    public int getPoints() {
        return points;
    }
    //method: resetPoints
    //purpose: reset points to 0
    public void resetPoints() {
        points = 0;
    }
    //method: configureLabel
    //purpose: Set the color and the text of a label to different colors
    public void configureLabel(JLabel label) {
        List <String> colors = new ArrayList();
        colors.add("RED");
        colors.add("BLUE");
        colors.add("YELLOW");
        colors.add("GREEN");
        colors.add("PURPLE");
        Collections.shuffle(colors);
        label.setText(colors.remove(0));
        String colorOfText = colors.remove(0);
        switch (colorOfText) {
            case "RED":
                label.setForeground(Color.RED);
                break;
            case "BLUE":
                label.setForeground(Color.BLUE);
                break;
            case "YELLOW":
                label.setForeground(Color.YELLOW);
                break;
            case "GREEN":
                label.setForeground(Color.GREEN);
                break;
            case "PURPLE":
                label.setForeground(Color.MAGENTA);
        }
        
        
    }
}
