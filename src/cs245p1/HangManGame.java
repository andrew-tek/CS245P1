/***************************************************************
* file: HangManGame.java
* author: Christopher Kilian
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Point and Click Game – v.1.0
* date last modified: 10/05/2017
*
* purpose: This class handles the actual game play functionality behind
* the Hangman game
*
****************************************************************/
package cs245p1;

import static cs245p1.MainGamePanel.wordsList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HangManGame {
    
    //Constants and instance variables
    private List wordList;
    private static final int FAIL_SCORE = 40;
    private int correctGuesses;
    private int points;
    private int correctNeeded;
    private String gameWord;
    //method: constructor
    //purpose: Builds the game environment by initializing score and correct points, randomly choosing a word from the database,
    //and initializing the number of correct guesses needed for a win by checking how many unique characters exist in the chosen word
    public HangManGame(){
        wordsList = new ArrayList<String> ();
        wordsList.add("cemetery");
        wordsList.add("nurse");
        wordsList.add("abstract");
        wordsList.add("pharmacy");
        wordsList.add("climbing");
        Collections.shuffle(wordsList);
        gameWord = wordsList.get(0);
        wordsList.remove(0);
        gameWord = "nurse";
        correctGuesses = 0;
        points = 100;
//        correctNeeded = (int)gameWord.chars().distinct().count();
    }
    
    //method: getPoints
    //purpose: Getter which returns the players score
    public int getPoints(){
        return points;
    }
    
    public String getWord () {
        String word = wordsList.get(0);
        wordsList.remove(0);
        return word;
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
    public boolean checkForWin(String s){
        boolean win = false;
        if((points > FAIL_SCORE) && (gameWord.equals(s))){
            win = true;
        }
        return win;
    }

    public int getCorrectGuesses() {
        return correctGuesses;
    }
    //method: checkLetter
    //purpose: This method accepts a letter (in the form of a string) and checks the "game word"
    //(chosen at random when the game is instantiated) to see what the positons in the word (if any) are for
    //the guessed letter. An arraylist is returned, so if the letter is not found anywhere in the word it will
    //return an empty arraylist. Otherwise, the arraylist will contain all the index values of the word.
    //Additionally, this method invokes the private "adjustScore" method which examines the initially found index
    //to see how to modify the game state
    public ArrayList<Integer> checkLetter(String theLetter){
        ArrayList foundIndices = new ArrayList();
        int foundIndex = gameWord.indexOf(theLetter);
        adjustScore(foundIndex);
        
        while(foundIndex >= 0){
            foundIndices.add(foundIndex);
            foundIndex = gameWord.indexOf(theLetter, foundIndex+1);
        }
        
        return foundIndices;
    }
    
    //method: adjustScore
    //purpose: This method works with "checkLetter" by examining the index of the first found letter.
    //If the letter exists even a single time in the word, correctGuesses is incremented. Otherwise, 10 points
    //are removed from the players score (they made an incorrect guess)
    private void adjustScore(int foundIndex){
        if(foundIndex >= 0){
            correctGuesses++;
        }else{
            points -= 10;
        }
    }
    
}
