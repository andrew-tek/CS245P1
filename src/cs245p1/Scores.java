/***************************************************************
* file: Scores.java
* author: Nicholas Pham
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Point and Click Game – v.1.0
* date last modified: 10/07/2017
*
* purpose: This class creates the object of each individual score
*
****************************************************************/

package cs245p1;

/**
 * This class stores the objects of each high score and allows for storage in the high scores list.
 */
public class Scores {
    
    // Name of player or user
    private String player;
    // Player's high score
    private int score;

    /**
     * Constructor for each player's name and score
     */
    public Scores(String player, int score) {
        this.player = player;
        this.score = score;
    }
    
    /**
     * Constructor for player's score
     */
    public Scores(int score) {
        this.score = score;
    }
    
    /**
     * This getter returns the player's name
     */
    public String getPlayer() {
        return player;
    }
    
    /**
     * This getter returns the player's score
     */
    public int getScore() {
        return score;
    }
}
