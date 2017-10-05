/***************************************************************
* file: HangManGame.java
* author: Christopher Kilian
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Point and Click Game – v.1.0
* date last modified: 10/04/2017
*
* purpose: This class handles the actual game play functionality behind
* the Hangman game
*
****************************************************************/
package cs245p1;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class HangManGame {
    
    //Constants and instance variables
    private static final String[] WORD_DB = {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};
    private static final int FAIL_SCORE = 40;
    private int correctGuesses;
    private int points;
    private int correctNeeded;
    private String gameWord;
    
    //method: constructor
    //purpose: Builds the game environment by initializing score and correct points, randomly choosing a word from the database,
    //and initializing the number of correct guesses needed for a win by checking how many unique characters exist in the chosen word
    public HangManGame(){
        int randomNum = ThreadLocalRandom.current().nextInt(0, WORD_DB.length+1);
        gameWord = WORD_DB[randomNum];
        correctGuesses = 0;
        points = 100;
        correctNeeded = (int)gameWord.chars().distinct().count();
    }
    
    //method: getPoints
    //purpose: Getter which returns the players score
    public int getPoints(){
        return points;
    }
    
    //method: getWordLength
    //purpose: A simple getter which returns the length of the chosen word so that the
    //display knows how many dashes to place
    public int getWordLength(){
        return gameWord.length();
    }
    
    //method: skipGame
    //purpose: Called when a player decides to skip a word, this method sets their score to 0
    public void skipGame(){
        points = 0;
    }
    
    //method: checkForWin
    //purpose: A method returning a boolean which indicates whether the player has won the game or not
    public boolean checkForWin(){
        boolean win = false;
        if((points > FAIL_SCORE) && (correctGuesses == correctNeeded)){
            win = true;
        }
        return win;
    }
    
    //method: checkLetter
    //purpose: This method accepts a letter (in the form of a string) and checks the "game word"
    //(chosen at random when the game is instantiated) to see what the positons in the word (if any) are for
    //the guessed letter. An arraylist is returned, so if the letter is not found anywhere in the word it will
    //return an empty arraylist. Otherwise, the arraylist will contain all the index values of the word.
    //Additionally, if the letter exists even a single time in the word, correctGuesses is incremented. Otherwise, 10 points
    //are removed from the players score (they made an incorrect guess)
    public ArrayList<Integer> checkLetter(String theLetter){
        ArrayList foundIndices = new ArrayList();
        int foundIndex = gameWord.indexOf(theLetter);
        
        if(foundIndex >= 0){
            correctGuesses++;
        }else{
            points -= 10;
        }
        
        while(foundIndex >= 0){
            foundIndices.add(foundIndex);
            foundIndex = gameWord.indexOf(theLetter, foundIndex+1);
        }
        
        return foundIndices;
    }
    
}
