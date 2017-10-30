/** *************************************************************
 * file: SudokuPanel.java
 * author: Nicholas Pham, Christopher Kilian
 * class: CS 245 – Programming Graphical User Interfaces
 *
 * assignment: Point and Click Game – v.1.2
 * date last modified: 10/30/2017
 *
 * purpose: The panel for handling the Sudoku game operations
 *
 *************************************************************** */
package cs245p1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JTextField;

public class SudokuPanel extends javax.swing.JPanel {

    //Please note: Auto-generated instance variables are automatically placed at the end of the class definition and cannot be moved
    
    private List<JTextField> gameBoardTracker;
    private boolean[] credit;

    //method: SudokuPanel (Constructor)
    //purpose: Sets up the Sudoku game panel, including the relevant action listeners, initial game values, etc
    public SudokuPanel() {
        initComponents();
        credit = new boolean[81];
        initializeGameBoardList();
        initializeArrays();

        //setup action listeners for local buttons
        submitNumbers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkInput();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CS245P1.getSudokuGame().quitGame();
                transitionToGameOver();
            }
        });

        ActionListener updateClock = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy hh:mm:ss");
                Date date = new Date();
                clockLabel.setText(dateFormat.format(date).toString());
                
                int points = CS245P1.getColorGame().getPoints() + CS245P1.getGame().getPoints();
                jLabelUserScore.setText("User Score: " + points);
                jLabelSudokuScore.setText("Sudoku Score: " + CS245P1.getSudokuGame().getPoints());
            }
        };

        Timer timer = new Timer(1000, updateClock);
        timer.setRepeats(true);
        timer.start();
    }

    //method: resetSodoku
    //purpose: Resets the game board for a new round (clears filled in board fields and resets the "credit" array)
    public void resetSodoku() {
        initializeArrays();
        for(JTextField field : gameBoardTracker){
            if (field.isEditable()) {
                field.setText("");
            }
        }
        //System.out.println("Called for reset");
    }

    //method: transitionToGameOver
    //purpose: Called when the player wins the game or quits. Handles the ending of the game, resetting of the board, and movement
    //to the "Game Over" screen
    private void transitionToGameOver() {
        //reset panel values to initial state - need a new method for this (just clear all the editable fields - remember to leave uneditable fields alone)
        //resetCoordsSets();
        //set score on game over panel and move to that panel
        GameOverPanel gameOver = (GameOverPanel) CS245P1.getPanelMap().get(CS245P1.GAME_OVER);
        gameOver.setScore();
        this.resetSodoku();
        CS245P1.getPrimaryLayout().show(CS245P1.getPrimaryCardHolder(), CS245P1.GAME_OVER);
        gameOver.checkForHighScore();
    }

    // method: checkInput
    // purpose: Checks the currently entered solution to see if it is correct. Uses the "credit" array to track
    //when points need to be deducted, or if they've already been deducted. If the players solution is correct, the game
    //is over and "transitionToGameOver" is called.
    private void checkInput() {
        boolean solvedFlag = true;
        int[] solution = CS245P1.getSudokuGame().getSolution();
        for (int i = 0; i < solution.length; i++) {
            boolean checkFlag = false;
            if (!gameBoardTracker.get(i).getText().isEmpty()) {
                if (Integer.parseInt(gameBoardTracker.get(i).getText()) != solution[i]) {
                    checkFlag = true;
                }
            } else {
                checkFlag = true;
            }

            if (checkFlag) {
                solvedFlag = false;
                if (credit[i]) {
                    credit[i] = false;
                    CS245P1.getSudokuGame().subPoints(); //only subtract points when this field has never been checked as incorrect before
                }
            }
        }

        if (solvedFlag) {
            transitionToGameOver();
        } else {
            JOptionPane.showMessageDialog(null, "Your solution is incorrect, please attempt another!");
        }
    }

    // method: initializeGameBoardList
    // purpose: Build the list which holds all of the sudokuTextFields on the board
    private void initializeGameBoardList() {
        gameBoardTracker = new ArrayList();
        gameBoardTracker.add(sudokuTextField1);
        gameBoardTracker.add(sudokuTextField2);
        gameBoardTracker.add(sudokuTextField3);
        gameBoardTracker.add(sudokuTextField4);
        gameBoardTracker.add(sudokuTextField5);
        gameBoardTracker.add(sudokuTextField6);
        gameBoardTracker.add(sudokuTextField7);
        gameBoardTracker.add(sudokuTextField8);
        gameBoardTracker.add(sudokuTextField9);
        gameBoardTracker.add(sudokuTextField10);
        gameBoardTracker.add(sudokuTextField11);
        gameBoardTracker.add(sudokuTextField12);
        gameBoardTracker.add(sudokuTextField13);
        gameBoardTracker.add(sudokuTextField14);
        gameBoardTracker.add(sudokuTextField15);
        gameBoardTracker.add(sudokuTextField16);
        gameBoardTracker.add(sudokuTextField17);
        gameBoardTracker.add(sudokuTextField18);
        gameBoardTracker.add(sudokuTextField19);
        gameBoardTracker.add(sudokuTextField20);
        gameBoardTracker.add(sudokuTextField21);
        gameBoardTracker.add(sudokuTextField22);
        gameBoardTracker.add(sudokuTextField23);
        gameBoardTracker.add(sudokuTextField24);
        gameBoardTracker.add(sudokuTextField25);
        gameBoardTracker.add(sudokuTextField26);
        gameBoardTracker.add(sudokuTextField27);
        gameBoardTracker.add(sudokuTextField28);
        gameBoardTracker.add(sudokuTextField29);
        gameBoardTracker.add(sudokuTextField30);
        gameBoardTracker.add(sudokuTextField31);
        gameBoardTracker.add(sudokuTextField32);
        gameBoardTracker.add(sudokuTextField33);
        gameBoardTracker.add(sudokuTextField34);
        gameBoardTracker.add(sudokuTextField35);
        gameBoardTracker.add(sudokuTextField36);
        gameBoardTracker.add(sudokuTextField37);
        gameBoardTracker.add(sudokuTextField38);
        gameBoardTracker.add(sudokuTextField39);
        gameBoardTracker.add(sudokuTextField40);
        gameBoardTracker.add(sudokuTextField41);
        gameBoardTracker.add(sudokuTextField42);
        gameBoardTracker.add(sudokuTextField43);
        gameBoardTracker.add(sudokuTextField44);
        gameBoardTracker.add(sudokuTextField45);
        gameBoardTracker.add(sudokuTextField46);
        gameBoardTracker.add(sudokuTextField47);
        gameBoardTracker.add(sudokuTextField48);
        gameBoardTracker.add(sudokuTextField49);
        gameBoardTracker.add(sudokuTextField50);
        gameBoardTracker.add(sudokuTextField51);
        gameBoardTracker.add(sudokuTextField52);
        gameBoardTracker.add(sudokuTextField53);
        gameBoardTracker.add(sudokuTextField54);
        gameBoardTracker.add(sudokuTextField55);
        gameBoardTracker.add(sudokuTextField56);
        gameBoardTracker.add(sudokuTextField57);
        gameBoardTracker.add(sudokuTextField58);
        gameBoardTracker.add(sudokuTextField59);
        gameBoardTracker.add(sudokuTextField60);
        gameBoardTracker.add(sudokuTextField61);
        gameBoardTracker.add(sudokuTextField62);
        gameBoardTracker.add(sudokuTextField63);
        gameBoardTracker.add(sudokuTextField64);
        gameBoardTracker.add(sudokuTextField65);
        gameBoardTracker.add(sudokuTextField66);
        gameBoardTracker.add(sudokuTextField67);
        gameBoardTracker.add(sudokuTextField68);
        gameBoardTracker.add(sudokuTextField69);
        gameBoardTracker.add(sudokuTextField70);
        gameBoardTracker.add(sudokuTextField71);
        gameBoardTracker.add(sudokuTextField72);
        gameBoardTracker.add(sudokuTextField73);
        gameBoardTracker.add(sudokuTextField74);
        gameBoardTracker.add(sudokuTextField75);
        gameBoardTracker.add(sudokuTextField76);
        gameBoardTracker.add(sudokuTextField77);
        gameBoardTracker.add(sudokuTextField78);
        gameBoardTracker.add(sudokuTextField79);
        gameBoardTracker.add(sudokuTextField80);
        gameBoardTracker.add(sudokuTextField81);
    }

    // method: initializeArrays
    // purpose: initialize JTextField and integer arrays to calculate user inputs for later
    public void initializeArrays() {
        Arrays.fill(credit, true);
        //fill array with "true", then re-falsify the values which are prefilled on the board (the player should not get any
        //credit for those)
        credit[0] = false;
        credit[3] = false;
        credit[5] = false;
        credit[8] = false;
        credit[15] = false;
        credit[19] = false;
        credit[24] = false;
        credit[25] = false;
        credit[27] = false;
        credit[29] = false;
        credit[31] = false;
        credit[33] = false;
        credit[34] = false;
        credit[40] = false;
        credit[46] = false;
        credit[47] = false;
        credit[49] = false;
        credit[51] = false;
        credit[53] = false;
        credit[55] = false;
        credit[56] = false;
        credit[61] = false;
        credit[65] = false;
        credit[72] = false;
        credit[75] = false;
        credit[77] = false;
        credit[80] = false;
    }

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
        jPanel1 = new javax.swing.JPanel();
        sudokuTextField1 = new cs245p1.SudokuTextField();
        sudokuTextField2 = new cs245p1.SudokuTextField();
        sudokuTextField3 = new cs245p1.SudokuTextField();
        sudokuTextField10 = new cs245p1.SudokuTextField();
        sudokuTextField11 = new cs245p1.SudokuTextField();
        sudokuTextField12 = new cs245p1.SudokuTextField();
        sudokuTextField19 = new cs245p1.SudokuTextField();
        sudokuTextField20 = new cs245p1.SudokuTextField();
        sudokuTextField21 = new cs245p1.SudokuTextField();
        jPanel2 = new javax.swing.JPanel();
        sudokuTextField4 = new cs245p1.SudokuTextField();
        sudokuTextField5 = new cs245p1.SudokuTextField();
        sudokuTextField6 = new cs245p1.SudokuTextField();
        sudokuTextField13 = new cs245p1.SudokuTextField();
        sudokuTextField14 = new cs245p1.SudokuTextField();
        sudokuTextField15 = new cs245p1.SudokuTextField();
        sudokuTextField22 = new cs245p1.SudokuTextField();
        sudokuTextField23 = new cs245p1.SudokuTextField();
        sudokuTextField24 = new cs245p1.SudokuTextField();
        jPanel3 = new javax.swing.JPanel();
        sudokuTextField7 = new cs245p1.SudokuTextField();
        sudokuTextField8 = new cs245p1.SudokuTextField();
        sudokuTextField9 = new cs245p1.SudokuTextField();
        sudokuTextField16 = new cs245p1.SudokuTextField();
        sudokuTextField17 = new cs245p1.SudokuTextField();
        sudokuTextField18 = new cs245p1.SudokuTextField();
        sudokuTextField25 = new cs245p1.SudokuTextField();
        sudokuTextField26 = new cs245p1.SudokuTextField();
        sudokuTextField27 = new cs245p1.SudokuTextField();
        jPanel4 = new javax.swing.JPanel();
        sudokuTextField28 = new cs245p1.SudokuTextField();
        sudokuTextField29 = new cs245p1.SudokuTextField();
        sudokuTextField30 = new cs245p1.SudokuTextField();
        sudokuTextField37 = new cs245p1.SudokuTextField();
        sudokuTextField38 = new cs245p1.SudokuTextField();
        sudokuTextField39 = new cs245p1.SudokuTextField();
        sudokuTextField46 = new cs245p1.SudokuTextField();
        sudokuTextField47 = new cs245p1.SudokuTextField();
        sudokuTextField48 = new cs245p1.SudokuTextField();
        jPanel5 = new javax.swing.JPanel();
        sudokuTextField31 = new cs245p1.SudokuTextField();
        sudokuTextField32 = new cs245p1.SudokuTextField();
        sudokuTextField33 = new cs245p1.SudokuTextField();
        sudokuTextField40 = new cs245p1.SudokuTextField();
        sudokuTextField41 = new cs245p1.SudokuTextField();
        sudokuTextField42 = new cs245p1.SudokuTextField();
        sudokuTextField49 = new cs245p1.SudokuTextField();
        sudokuTextField50 = new cs245p1.SudokuTextField();
        sudokuTextField51 = new cs245p1.SudokuTextField();
        jPanel6 = new javax.swing.JPanel();
        sudokuTextField34 = new cs245p1.SudokuTextField();
        sudokuTextField35 = new cs245p1.SudokuTextField();
        sudokuTextField36 = new cs245p1.SudokuTextField();
        sudokuTextField43 = new cs245p1.SudokuTextField();
        sudokuTextField44 = new cs245p1.SudokuTextField();
        sudokuTextField45 = new cs245p1.SudokuTextField();
        sudokuTextField52 = new cs245p1.SudokuTextField();
        sudokuTextField53 = new cs245p1.SudokuTextField();
        sudokuTextField54 = new cs245p1.SudokuTextField();
        jPanel7 = new javax.swing.JPanel();
        sudokuTextField55 = new cs245p1.SudokuTextField();
        sudokuTextField56 = new cs245p1.SudokuTextField();
        sudokuTextField57 = new cs245p1.SudokuTextField();
        sudokuTextField64 = new cs245p1.SudokuTextField();
        sudokuTextField65 = new cs245p1.SudokuTextField();
        sudokuTextField66 = new cs245p1.SudokuTextField();
        sudokuTextField73 = new cs245p1.SudokuTextField();
        sudokuTextField74 = new cs245p1.SudokuTextField();
        sudokuTextField75 = new cs245p1.SudokuTextField();
        jPanel8 = new javax.swing.JPanel();
        sudokuTextField58 = new cs245p1.SudokuTextField();
        sudokuTextField59 = new cs245p1.SudokuTextField();
        sudokuTextField60 = new cs245p1.SudokuTextField();
        sudokuTextField67 = new cs245p1.SudokuTextField();
        sudokuTextField68 = new cs245p1.SudokuTextField();
        sudokuTextField69 = new cs245p1.SudokuTextField();
        sudokuTextField76 = new cs245p1.SudokuTextField();
        sudokuTextField77 = new cs245p1.SudokuTextField();
        sudokuTextField78 = new cs245p1.SudokuTextField();
        jPanel9 = new javax.swing.JPanel();
        sudokuTextField61 = new cs245p1.SudokuTextField();
        sudokuTextField62 = new cs245p1.SudokuTextField();
        sudokuTextField63 = new cs245p1.SudokuTextField();
        sudokuTextField70 = new cs245p1.SudokuTextField();
        sudokuTextField71 = new cs245p1.SudokuTextField();
        sudokuTextField72 = new cs245p1.SudokuTextField();
        sudokuTextField79 = new cs245p1.SudokuTextField();
        sudokuTextField80 = new cs245p1.SudokuTextField();
        sudokuTextField81 = new cs245p1.SudokuTextField();
        submitNumbers = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        jLabelSudokuScore = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(600, 400));

        clockLabel.setText("Clock Here");
        clockLabel.setToolTipText("Date/Time");
        clockLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), null));
        clockLabel.setPreferredSize(new java.awt.Dimension(150, 25));

        jLabelUserScore.setText("User Score:");
        jLabelUserScore.setToolTipText("Overall score from previous games");

        sudokuPanel.setPreferredSize(new java.awt.Dimension(288, 288));
        sudokuPanel.setLayout(new java.awt.GridLayout(3, 3));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setMinimumSize(new java.awt.Dimension(96, 96));
        jPanel1.setPreferredSize(new java.awt.Dimension(96, 96));
        jPanel1.setLayout(new java.awt.GridLayout(3, 3));

        sudokuTextField1.setEditable(false);
        sudokuTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField1.setText("8");
        sudokuTextField1.setToolTipText("Don't Click Me");
        sudokuTextField1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField1.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField1.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(sudokuTextField1);

        sudokuTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField2.setToolTipText("Click Me!");
        sudokuTextField2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField2.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField2.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(sudokuTextField2);

        sudokuTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField3.setToolTipText("Click Me!");
        sudokuTextField3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField3.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField3.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(sudokuTextField3);

        sudokuTextField10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField10.setToolTipText("Click Me!");
        sudokuTextField10.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField10.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField10.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(sudokuTextField10);

        sudokuTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField11.setToolTipText("Click Me!");
        sudokuTextField11.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField11.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField11.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(sudokuTextField11);

        sudokuTextField12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField12.setToolTipText("Click Me!");
        sudokuTextField12.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField12.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField12.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(sudokuTextField12);

        sudokuTextField19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField19.setToolTipText("Click Me!");
        sudokuTextField19.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField19.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField19.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(sudokuTextField19);

        sudokuTextField20.setEditable(false);
        sudokuTextField20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField20.setText("1");
        sudokuTextField20.setToolTipText("Don't Click Me");
        sudokuTextField20.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField20.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField20.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(sudokuTextField20);

        sudokuTextField21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField21.setToolTipText("Click Me!");
        sudokuTextField21.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField21.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField21.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(sudokuTextField21);

        sudokuPanel.add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setMinimumSize(new java.awt.Dimension(96, 96));
        jPanel2.setPreferredSize(new java.awt.Dimension(96, 96));
        jPanel2.setLayout(new java.awt.GridLayout(3, 3));

        sudokuTextField4.setEditable(false);
        sudokuTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField4.setText("4");
        sudokuTextField4.setToolTipText("Don't Click Me");
        sudokuTextField4.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField4.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField4.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel2.add(sudokuTextField4);

        sudokuTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField5.setToolTipText("Click Me!");
        sudokuTextField5.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField5.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField5.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel2.add(sudokuTextField5);

        sudokuTextField6.setEditable(false);
        sudokuTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField6.setText("6");
        sudokuTextField6.setToolTipText("Don't Click Me");
        sudokuTextField6.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField6.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField6.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel2.add(sudokuTextField6);

        sudokuTextField13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField13.setToolTipText("Click Me!");
        sudokuTextField13.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField13.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField13.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel2.add(sudokuTextField13);

        sudokuTextField14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField14.setToolTipText("Click Me!");
        sudokuTextField14.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField14.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField14.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel2.add(sudokuTextField14);

        sudokuTextField15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField15.setToolTipText("Click Me!");
        sudokuTextField15.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField15.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField15.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel2.add(sudokuTextField15);

        sudokuTextField22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField22.setToolTipText("Click Me!");
        sudokuTextField22.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField22.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField22.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel2.add(sudokuTextField22);

        sudokuTextField23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField23.setToolTipText("Click Me!");
        sudokuTextField23.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField23.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField23.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel2.add(sudokuTextField23);

        sudokuTextField24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField24.setToolTipText("Click Me!");
        sudokuTextField24.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField24.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField24.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel2.add(sudokuTextField24);

        sudokuPanel.add(jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel3.setMinimumSize(new java.awt.Dimension(96, 96));
        jPanel3.setPreferredSize(new java.awt.Dimension(96, 96));
        jPanel3.setLayout(new java.awt.GridLayout(3, 3));

        sudokuTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField7.setToolTipText("Click Me!");
        sudokuTextField7.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField7.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField7.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel3.add(sudokuTextField7);

        sudokuTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField8.setToolTipText("Click Me!");
        sudokuTextField8.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField8.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField8.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel3.add(sudokuTextField8);

        sudokuTextField9.setEditable(false);
        sudokuTextField9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField9.setText("7");
        sudokuTextField9.setToolTipText("Don't Click Me");
        sudokuTextField9.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField9.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField9.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel3.add(sudokuTextField9);

        sudokuTextField16.setEditable(false);
        sudokuTextField16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField16.setText("4");
        sudokuTextField16.setToolTipText("Don't Click Me");
        sudokuTextField16.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField16.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField16.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel3.add(sudokuTextField16);

        sudokuTextField17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField17.setToolTipText("Click Me!");
        sudokuTextField17.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField17.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField17.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel3.add(sudokuTextField17);

        sudokuTextField18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField18.setToolTipText("Click Me!");
        sudokuTextField18.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField18.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField18.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel3.add(sudokuTextField18);

        sudokuTextField25.setEditable(false);
        sudokuTextField25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField25.setText("6");
        sudokuTextField25.setToolTipText("Don't Click Me");
        sudokuTextField25.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField25.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField25.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel3.add(sudokuTextField25);

        sudokuTextField26.setEditable(false);
        sudokuTextField26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField26.setText("5");
        sudokuTextField26.setToolTipText("Don't Click Me");
        sudokuTextField26.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField26.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField26.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel3.add(sudokuTextField26);

        sudokuTextField27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField27.setToolTipText("Click Me!");
        sudokuTextField27.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField27.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField27.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel3.add(sudokuTextField27);

        sudokuPanel.add(jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel4.setMinimumSize(new java.awt.Dimension(96, 96));
        jPanel4.setPreferredSize(new java.awt.Dimension(96, 96));
        jPanel4.setLayout(new java.awt.GridLayout(3, 3));

        sudokuTextField28.setEditable(false);
        sudokuTextField28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField28.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField28.setText("5");
        sudokuTextField28.setToolTipText("Don't Click Me");
        sudokuTextField28.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField28.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField28.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel4.add(sudokuTextField28);

        sudokuTextField29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField29.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField29.setToolTipText("Click Me!");
        sudokuTextField29.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField29.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField29.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel4.add(sudokuTextField29);

        sudokuTextField30.setEditable(false);
        sudokuTextField30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField30.setText("9");
        sudokuTextField30.setToolTipText("Don't Click Me");
        sudokuTextField30.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField30.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField30.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel4.add(sudokuTextField30);

        sudokuTextField37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField37.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField37.setToolTipText("Click Me!");
        sudokuTextField37.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField37.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField37.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel4.add(sudokuTextField37);

        sudokuTextField38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField38.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField38.setToolTipText("Click Me!");
        sudokuTextField38.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField38.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField38.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel4.add(sudokuTextField38);

        sudokuTextField39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField39.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField39.setToolTipText("Click Me!");
        sudokuTextField39.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField39.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField39.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel4.add(sudokuTextField39);

        sudokuTextField46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField46.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField46.setToolTipText("Click Me!");
        sudokuTextField46.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField46.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField46.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel4.add(sudokuTextField46);

        sudokuTextField47.setEditable(false);
        sudokuTextField47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField47.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField47.setText("4");
        sudokuTextField47.setToolTipText("Don't Click Me");
        sudokuTextField47.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField47.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField47.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel4.add(sudokuTextField47);

        sudokuTextField48.setEditable(false);
        sudokuTextField48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField48.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField48.setText("8");
        sudokuTextField48.setToolTipText("Don't Click Me");
        sudokuTextField48.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField48.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField48.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel4.add(sudokuTextField48);

        sudokuPanel.add(jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel5.setMinimumSize(new java.awt.Dimension(96, 96));
        jPanel5.setPreferredSize(new java.awt.Dimension(96, 96));
        jPanel5.setLayout(new java.awt.GridLayout(3, 3));

        sudokuTextField31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField31.setToolTipText("Click Me!");
        sudokuTextField31.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField31.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField31.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel5.add(sudokuTextField31);

        sudokuTextField32.setEditable(false);
        sudokuTextField32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField32.setText("3");
        sudokuTextField32.setToolTipText("Don't Click Me");
        sudokuTextField32.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField32.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField32.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel5.add(sudokuTextField32);

        sudokuTextField33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField33.setToolTipText("Click Me!");
        sudokuTextField33.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField33.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField33.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel5.add(sudokuTextField33);

        sudokuTextField40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField40.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField40.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField40.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField40.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel5.add(sudokuTextField40);

        sudokuTextField41.setEditable(false);
        sudokuTextField41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField41.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField41.setText("7");
        sudokuTextField41.setToolTipText("Don't Click Me");
        sudokuTextField41.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField41.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField41.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel5.add(sudokuTextField41);

        sudokuTextField42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField42.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField42.setToolTipText("Click Me!");
        sudokuTextField42.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField42.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField42.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel5.add(sudokuTextField42);

        sudokuTextField49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField49.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField49.setToolTipText("Click Me!");
        sudokuTextField49.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField49.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField49.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel5.add(sudokuTextField49);

        sudokuTextField50.setEditable(false);
        sudokuTextField50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField50.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField50.setText("2");
        sudokuTextField50.setToolTipText("Don't Click Me");
        sudokuTextField50.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField50.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField50.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel5.add(sudokuTextField50);

        sudokuTextField51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField51.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField51.setToolTipText("Click Me!");
        sudokuTextField51.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField51.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField51.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel5.add(sudokuTextField51);

        sudokuPanel.add(jPanel5);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel6.setMinimumSize(new java.awt.Dimension(96, 96));
        jPanel6.setPreferredSize(new java.awt.Dimension(96, 96));
        jPanel6.setLayout(new java.awt.GridLayout(3, 3));

        sudokuTextField34.setEditable(false);
        sudokuTextField34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField34.setText("7");
        sudokuTextField34.setToolTipText("Don't Click Me");
        sudokuTextField34.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField34.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField34.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel6.add(sudokuTextField34);

        sudokuTextField35.setEditable(false);
        sudokuTextField35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField35.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField35.setText("8");
        sudokuTextField35.setToolTipText("Don't Click Me");
        sudokuTextField35.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField35.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField35.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel6.add(sudokuTextField35);

        sudokuTextField36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField36.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField36.setToolTipText("Click Me!");
        sudokuTextField36.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField36.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField36.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel6.add(sudokuTextField36);

        sudokuTextField43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField43.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField43.setToolTipText("Click Me!");
        sudokuTextField43.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField43.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField43.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel6.add(sudokuTextField43);

        sudokuTextField44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField44.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField44.setToolTipText("Click Me!");
        sudokuTextField44.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField44.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField44.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel6.add(sudokuTextField44);

        sudokuTextField45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField45.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField45.setToolTipText("Click Me!");
        sudokuTextField45.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField45.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField45.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel6.add(sudokuTextField45);

        sudokuTextField52.setEditable(false);
        sudokuTextField52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField52.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField52.setText("1");
        sudokuTextField52.setToolTipText("Don't Click Me");
        sudokuTextField52.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField52.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField52.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel6.add(sudokuTextField52);

        sudokuTextField53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField53.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField53.setToolTipText("Click Me!");
        sudokuTextField53.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField53.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField53.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel6.add(sudokuTextField53);

        sudokuTextField54.setEditable(false);
        sudokuTextField54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField54.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField54.setText("3");
        sudokuTextField54.setToolTipText("Don't Click Me");
        sudokuTextField54.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField54.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField54.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel6.add(sudokuTextField54);

        sudokuPanel.add(jPanel6);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel7.setMinimumSize(new java.awt.Dimension(96, 96));
        jPanel7.setPreferredSize(new java.awt.Dimension(96, 96));
        jPanel7.setLayout(new java.awt.GridLayout(3, 3));

        sudokuTextField55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField55.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField55.setToolTipText("Click Me!");
        sudokuTextField55.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField55.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField55.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel7.add(sudokuTextField55);

        sudokuTextField56.setEditable(false);
        sudokuTextField56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField56.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField56.setText("5");
        sudokuTextField56.setToolTipText("Don't Click Me");
        sudokuTextField56.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField56.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField56.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel7.add(sudokuTextField56);

        sudokuTextField57.setEditable(false);
        sudokuTextField57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField57.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField57.setText("2");
        sudokuTextField57.setToolTipText("Don't Click Me");
        sudokuTextField57.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField57.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField57.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel7.add(sudokuTextField57);

        sudokuTextField64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField64.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField64.setToolTipText("Click Me!");
        sudokuTextField64.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField64.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField64.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel7.add(sudokuTextField64);

        sudokuTextField65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField65.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField65.setToolTipText("Click Me!");
        sudokuTextField65.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField65.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField65.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel7.add(sudokuTextField65);

        sudokuTextField66.setEditable(false);
        sudokuTextField66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField66.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField66.setText("1");
        sudokuTextField66.setToolTipText("Don't Click Me");
        sudokuTextField66.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField66.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField66.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel7.add(sudokuTextField66);

        sudokuTextField73.setEditable(false);
        sudokuTextField73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField73.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField73.setText("3");
        sudokuTextField73.setToolTipText("Don't Click Me");
        sudokuTextField73.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField73.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField73.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel7.add(sudokuTextField73);

        sudokuTextField74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField74.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField74.setToolTipText("Click Me!");
        sudokuTextField74.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField74.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField74.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel7.add(sudokuTextField74);

        sudokuTextField75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField75.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField75.setToolTipText("Click Me!");
        sudokuTextField75.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField75.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField75.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel7.add(sudokuTextField75);

        sudokuPanel.add(jPanel7);

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel8.setMinimumSize(new java.awt.Dimension(96, 96));
        jPanel8.setPreferredSize(new java.awt.Dimension(96, 96));
        jPanel8.setLayout(new java.awt.GridLayout(3, 3));

        sudokuTextField58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField58.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField58.setToolTipText("Click Me!");
        sudokuTextField58.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField58.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField58.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel8.add(sudokuTextField58);

        sudokuTextField59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField59.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField59.setToolTipText("Click Me!");
        sudokuTextField59.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField59.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField59.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel8.add(sudokuTextField59);

        sudokuTextField60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField60.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField60.setToolTipText("Click Me!");
        sudokuTextField60.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField60.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField60.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel8.add(sudokuTextField60);

        sudokuTextField67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField67.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField67.setToolTipText("Click Me!");
        sudokuTextField67.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField67.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField67.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel8.add(sudokuTextField67);

        sudokuTextField68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField68.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField68.setToolTipText("Click Me!");
        sudokuTextField68.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField68.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField68.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel8.add(sudokuTextField68);

        sudokuTextField69.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField69.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField69.setToolTipText("Click Me!");
        sudokuTextField69.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField69.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField69.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel8.add(sudokuTextField69);

        sudokuTextField76.setEditable(false);
        sudokuTextField76.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField76.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField76.setText("9");
        sudokuTextField76.setToolTipText("Don't Click Me");
        sudokuTextField76.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField76.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField76.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel8.add(sudokuTextField76);

        sudokuTextField77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField77.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField77.setToolTipText("Click Me!");
        sudokuTextField77.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField77.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField77.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel8.add(sudokuTextField77);

        sudokuTextField78.setEditable(false);
        sudokuTextField78.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField78.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField78.setText("2");
        sudokuTextField78.setToolTipText("Don't Click Me");
        sudokuTextField78.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField78.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField78.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel8.add(sudokuTextField78);

        sudokuPanel.add(jPanel8);

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel9.setMinimumSize(new java.awt.Dimension(96, 96));
        jPanel9.setPreferredSize(new java.awt.Dimension(96, 96));
        jPanel9.setLayout(new java.awt.GridLayout(3, 3));

        sudokuTextField61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField61.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField61.setToolTipText("Click Me!");
        sudokuTextField61.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField61.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField61.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(sudokuTextField61);

        sudokuTextField62.setEditable(false);
        sudokuTextField62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField62.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField62.setText("9");
        sudokuTextField62.setToolTipText("Don't Click Me");
        sudokuTextField62.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField62.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField62.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(sudokuTextField62);

        sudokuTextField63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField63.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField63.setToolTipText("Click Me!");
        sudokuTextField63.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField63.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField63.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(sudokuTextField63);

        sudokuTextField70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField70.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField70.setToolTipText("Click Me!");
        sudokuTextField70.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField70.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField70.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(sudokuTextField70);

        sudokuTextField71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField71.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField71.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField71.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField71.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(sudokuTextField71);

        sudokuTextField72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField72.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField72.setToolTipText("Click Me!");
        sudokuTextField72.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField72.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField72.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(sudokuTextField72);

        sudokuTextField79.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField79.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField79.setToolTipText("Click Me!");
        sudokuTextField79.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField79.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField79.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(sudokuTextField79);

        sudokuTextField80.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField80.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField80.setToolTipText("Click Me!");
        sudokuTextField80.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField80.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField80.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(sudokuTextField80);

        sudokuTextField81.setEditable(false);
        sudokuTextField81.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField81.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField81.setText("5");
        sudokuTextField81.setToolTipText("Don't Click Me");
        sudokuTextField81.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField81.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField81.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(sudokuTextField81);

        sudokuPanel.add(jPanel9);

        submitNumbers.setText("Submit");
        submitNumbers.setToolTipText("Warning: You will lose 10 points for each incorrect sqaure");

        quitButton.setText("Quit");
        quitButton.setToolTipText("I Don't Blame You");

        jLabelSudokuScore.setText("Sudoku Score:");
        jLabelSudokuScore.setToolTipText("Your current possible Sudoku points");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelUserScore, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(submitNumbers)
                        .addGap(44, 44, 44)
                        .addComponent(sudokuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(quitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelSudokuScore, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelUserScore))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSudokuScore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sudokuPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitNumbers, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(quitButton)))
                .addGap(49, 49, 49))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clockLabel;
    private javax.swing.JLabel jLabelSudokuScore;
    private javax.swing.JLabel jLabelUserScore;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton submitNumbers;
    private javax.swing.JPanel sudokuPanel;
    private cs245p1.SudokuTextField sudokuTextField1;
    private cs245p1.SudokuTextField sudokuTextField10;
    private cs245p1.SudokuTextField sudokuTextField11;
    private cs245p1.SudokuTextField sudokuTextField12;
    private cs245p1.SudokuTextField sudokuTextField13;
    private cs245p1.SudokuTextField sudokuTextField14;
    private cs245p1.SudokuTextField sudokuTextField15;
    private cs245p1.SudokuTextField sudokuTextField16;
    private cs245p1.SudokuTextField sudokuTextField17;
    private cs245p1.SudokuTextField sudokuTextField18;
    private cs245p1.SudokuTextField sudokuTextField19;
    private cs245p1.SudokuTextField sudokuTextField2;
    private cs245p1.SudokuTextField sudokuTextField20;
    private cs245p1.SudokuTextField sudokuTextField21;
    private cs245p1.SudokuTextField sudokuTextField22;
    private cs245p1.SudokuTextField sudokuTextField23;
    private cs245p1.SudokuTextField sudokuTextField24;
    private cs245p1.SudokuTextField sudokuTextField25;
    private cs245p1.SudokuTextField sudokuTextField26;
    private cs245p1.SudokuTextField sudokuTextField27;
    private cs245p1.SudokuTextField sudokuTextField28;
    private cs245p1.SudokuTextField sudokuTextField29;
    private cs245p1.SudokuTextField sudokuTextField3;
    private cs245p1.SudokuTextField sudokuTextField30;
    private cs245p1.SudokuTextField sudokuTextField31;
    private cs245p1.SudokuTextField sudokuTextField32;
    private cs245p1.SudokuTextField sudokuTextField33;
    private cs245p1.SudokuTextField sudokuTextField34;
    private cs245p1.SudokuTextField sudokuTextField35;
    private cs245p1.SudokuTextField sudokuTextField36;
    private cs245p1.SudokuTextField sudokuTextField37;
    private cs245p1.SudokuTextField sudokuTextField38;
    private cs245p1.SudokuTextField sudokuTextField39;
    private cs245p1.SudokuTextField sudokuTextField4;
    private cs245p1.SudokuTextField sudokuTextField40;
    private cs245p1.SudokuTextField sudokuTextField41;
    private cs245p1.SudokuTextField sudokuTextField42;
    private cs245p1.SudokuTextField sudokuTextField43;
    private cs245p1.SudokuTextField sudokuTextField44;
    private cs245p1.SudokuTextField sudokuTextField45;
    private cs245p1.SudokuTextField sudokuTextField46;
    private cs245p1.SudokuTextField sudokuTextField47;
    private cs245p1.SudokuTextField sudokuTextField48;
    private cs245p1.SudokuTextField sudokuTextField49;
    private cs245p1.SudokuTextField sudokuTextField5;
    private cs245p1.SudokuTextField sudokuTextField50;
    private cs245p1.SudokuTextField sudokuTextField51;
    private cs245p1.SudokuTextField sudokuTextField52;
    private cs245p1.SudokuTextField sudokuTextField53;
    private cs245p1.SudokuTextField sudokuTextField54;
    private cs245p1.SudokuTextField sudokuTextField55;
    private cs245p1.SudokuTextField sudokuTextField56;
    private cs245p1.SudokuTextField sudokuTextField57;
    private cs245p1.SudokuTextField sudokuTextField58;
    private cs245p1.SudokuTextField sudokuTextField59;
    private cs245p1.SudokuTextField sudokuTextField6;
    private cs245p1.SudokuTextField sudokuTextField60;
    private cs245p1.SudokuTextField sudokuTextField61;
    private cs245p1.SudokuTextField sudokuTextField62;
    private cs245p1.SudokuTextField sudokuTextField63;
    private cs245p1.SudokuTextField sudokuTextField64;
    private cs245p1.SudokuTextField sudokuTextField65;
    private cs245p1.SudokuTextField sudokuTextField66;
    private cs245p1.SudokuTextField sudokuTextField67;
    private cs245p1.SudokuTextField sudokuTextField68;
    private cs245p1.SudokuTextField sudokuTextField69;
    private cs245p1.SudokuTextField sudokuTextField7;
    private cs245p1.SudokuTextField sudokuTextField70;
    private cs245p1.SudokuTextField sudokuTextField71;
    private cs245p1.SudokuTextField sudokuTextField72;
    private cs245p1.SudokuTextField sudokuTextField73;
    private cs245p1.SudokuTextField sudokuTextField74;
    private cs245p1.SudokuTextField sudokuTextField75;
    private cs245p1.SudokuTextField sudokuTextField76;
    private cs245p1.SudokuTextField sudokuTextField77;
    private cs245p1.SudokuTextField sudokuTextField78;
    private cs245p1.SudokuTextField sudokuTextField79;
    private cs245p1.SudokuTextField sudokuTextField8;
    private cs245p1.SudokuTextField sudokuTextField80;
    private cs245p1.SudokuTextField sudokuTextField81;
    private cs245p1.SudokuTextField sudokuTextField9;
    // End of variables declaration//GEN-END:variables
}
