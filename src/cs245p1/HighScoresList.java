/***************************************************************
* file: HighScoresList.java
* author: Nicholas Pham
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Point and Click Game – v.1.0
* date last modified: 10/07/2017
*
* purpose: This class creates the list of high scores accumulated
*
****************************************************************/

package cs245p1;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This class stores the high scores list to display on its respective panel.
 */
public class HighScoresList {
    
    // List of high scores (see: Scores)
    private ArrayList<Scores> highScores;
    // Reader to read file
    private BufferedReader br;
    
    /**
     * Constructor to initialize the list
     */
    public HighScoresList() {
        highScores = new ArrayList<Scores>();
    }
    
    /**
     * Returns the list of high scores
     */
    public ArrayList<Scores> getScores() {
        loadFile();
        return highScores;
    }
    
    /**
     * Loads data from file (highscores.txt)
     */
    public void loadFile() {
        try {
            try {
                // [Player, Score]
                String[] info;
                // Line to read
                String textLine;
                // Player name read
                String name;
                // Player score read
                int score;
                
                // Load file to reader
                br = new BufferedReader(new FileReader("src/highscores.txt"));
                // Read file until last line
                while ((textLine = br.readLine()) != null) {
                   // Delimiter in file is ","
                    info = textLine.split(",");
                    
                    name = info[0];
                    score = Integer.parseInt(info[1]);
                    // Add player and associated score to list
                    highScores.add(new Scores(name, score));
                }
            } finally {
                // Close reader
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
