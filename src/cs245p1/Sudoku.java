/** *************************************************************
 * file: Sudoku.java
 * author: Nicholas Pham, Christopher Kilian
 * class: CS 245 – Programming Graphical User Interfaces
 *
 * assignment: Point and Click Game – v.1.2
 * date last modified: 10/30/2017
 *
 * purpose: This class is the base for the Sudoku game
 *
 *************************************************************** */
package cs245p1;

public class Sudoku {

    // Correct solution (by row) given in PDF
    private final int[] SOLUTION = {8, 3, 5, 4, 1, 6, 9, 2, 7,
                                    2, 9, 6, 8, 5, 7, 4, 3, 1,
                                    4, 1, 7, 2, 9, 3, 6, 5, 8,
                                    5, 6, 9, 1, 3, 4, 7, 8, 2,
                                    1, 2, 3, 6, 7, 8, 5, 4, 9,
                                    7, 4, 8, 5, 2, 9, 1, 6, 3,
                                    6, 5, 2, 7, 8, 1, 3, 9, 4,
                                    9, 8, 1, 3, 4, 5, 2, 7, 6,
                                    3, 7, 4, 9, 6, 2, 8, 1, 5};

    private int points;

    //method: Sudoku (Constructor)
    //purpose: Constructor, sets up the private variables for the game
    public Sudoku() {
        points = 540;
    }

    //method: getPoints
    //purpose: Getter for the current points
    public int getPoints() {
        return points;
    }

    //method: subPoints
    //purpose: Subtracts a set number of points from the total at any given time
    public void subPoints() {
        if(points > 0){
            points = points - 10;
        }
    }

    //method: getSolution
    //purpose: returns the stored valid solution
    public int[] getSolution() {
        return SOLUTION;
    }

    //method: quitGame
    //purpose: Called when the game is being quit, sets score to 0
    public void quitGame() {
        points = 0;
    }
}
