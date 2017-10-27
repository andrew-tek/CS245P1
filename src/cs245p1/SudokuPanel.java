
package cs245p1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.JTextField;

public class SudokuPanel extends javax.swing.JPanel { 
    /**
     * jTextField for all inputs for board game
     * jTextField##.setToolTipText("Enter a number from 1 to 9");
     */

    private JTextField[] enteredWord = new JTextField[81];
    private int[] intEntered = new int[81];
    private boolean[] calculated = new boolean[81];
    private Sudoku sudoku = new Sudoku();
    
    public SudokuPanel() {
        initComponents();
        // Initialize Arrays
        initializeArrays();
        // Initialize game board
        initializeGameBoard();
        
        // SUBMIT NUMBERS
        // When submit is pressed, all numbers inputted will be recorded and then calculated to see if they are correct
        submitNumbers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // WORKS FOR FIRST ROW
                // Non-user numbers
//                if (i == 0 || i == 3 || i == 5 || i == 8 || i == 15 || i == 19 
//                        || i == 24 || i == 25 || i == 27 || i == 29 || i == 31 
//                        || i == 33 || i == 34 || i == 40 || i == 46 || i == 47 
//                        || i == 49 || i == 51 || i == 53 || i == 55 || i == 56 
//                        || i == 61 || i == 65 || i == 72 || i == 75 || i == 77 
//                        || i == 80)
//                                 continue;
//                enteredWord[1].setText(jTextField1.getText());
//                enteredWord[2].setText(jTextField2.getText());
//                enteredWord[4].setText(jTextField3.getText());
//                enteredWord[6].setText(jTextField4.getText());
//                enteredWord[7].setText(jTextField5.getText());
                intEntered[1] = Integer.parseInt(enteredWord[1].getText());
                intEntered[2] = Integer.parseInt(enteredWord[2].getText());
                intEntered[4] = Integer.parseInt(enteredWord[4].getText());
                intEntered[6] = Integer.parseInt(enteredWord[6].getText());
                intEntered[7] = Integer.parseInt(enteredWord[7].getText());
                // FIRST ROW TEST
                for (int i = 0; i < 9; i++) {
                    if (intEntered[i] == sudoku.getSolution()[i]) {
                    // 3 == 3
                    System.out.println("Good | Entered: " + intEntered[i] + " Sol: " + sudoku.getSolution()[i]);
                    }
                    else {
                    System.out.println("Bad | Entered: " + intEntered[i] + " Sol: " + sudoku.getSolution()[i]);
                    }
                }
            }
        });

        ActionListener updateClock = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy hh:mm:ss");
            Date date = new Date();
            clockLabel.setText(dateFormat.format(date).toString());
            
            // Set points to points + 540 (Sudoku)
            // ERROR HERE int points = CS245P1.getSudokuGame().getPoints() + CS245P1.getColorGame().getPoints() + CS245P1.getGame().getPoints();
            int points = CS245P1.getColorGame().getPoints() + CS245P1.getGame().getPoints();
            jLabelUserScore.setText("User Score: " + points);
        }
        };
        
        Timer timer = new Timer (1000, updateClock);
        timer.setRepeats(true);
        timer.start();
    }
    
    // method: initializeArrays
    // purpose: initialize JTextField and integer arrays to calculate user inputs for later
    public void initializeArrays() {
        for (int i = 0; i < enteredWord.length; i++) {
            enteredWord[i] = new JTextField();
            calculated[i] = false;
        }
    }
    
    // method: initliaizeGameBoard
    // purpose: adds the default numbers from pdf to game board
    private void initializeGameBoard() {
        enteredWord[0].setText("8");
        enteredWord[3].setText("4");
        enteredWord[5].setText("6");
        enteredWord[8].setText("7");
        enteredWord[15].setText("4");
        enteredWord[19].setText("1");
        enteredWord[24].setText("6");
        enteredWord[25].setText("5");
        enteredWord[27].setText("5");
        enteredWord[29].setText("9");
        enteredWord[31].setText("3");
        enteredWord[33].setText("7");
        enteredWord[34].setText("8");
        enteredWord[40].setText("7");
        enteredWord[46].setText("4");
        enteredWord[47].setText("8");
        enteredWord[49].setText("2");
        enteredWord[51].setText("1");
        enteredWord[53].setText("3");
        enteredWord[55].setText("5");
        enteredWord[56].setText("2");
        enteredWord[61].setText("9");
        enteredWord[65].setText("1");
        enteredWord[72].setText("3");
        enteredWord[75].setText("9");
        enteredWord[77].setText("2");
        enteredWord[80].setText("5");
        for (int j = 0; j < intEntered.length; j++) {
            if (enteredWord[j].getText() != null && !enteredWord[j].getText().equals("")) {
                intEntered[j] = Integer.parseInt(enteredWord[j].getText());
            }
        }
    }
    
    private void checkInput(){
        
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
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jTextField37 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jTextField42 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jTextField46 = new javax.swing.JTextField();
        jTextField47 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        jTextField50 = new javax.swing.JTextField();
        jTextField51 = new javax.swing.JTextField();
        jTextField52 = new javax.swing.JTextField();
        jTextField53 = new javax.swing.JTextField();
        jTextField54 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jTextField55 = new javax.swing.JTextField();
        jTextField56 = new javax.swing.JTextField();
        jTextField57 = new javax.swing.JTextField();
        jTextField58 = new javax.swing.JTextField();
        jTextField59 = new javax.swing.JTextField();
        jTextField60 = new javax.swing.JTextField();
        jTextField61 = new javax.swing.JTextField();
        jTextField62 = new javax.swing.JTextField();
        jTextField63 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jTextField64 = new javax.swing.JTextField();
        jTextField65 = new javax.swing.JTextField();
        jTextField66 = new javax.swing.JTextField();
        jTextField67 = new javax.swing.JTextField();
        jTextField68 = new javax.swing.JTextField();
        jTextField69 = new javax.swing.JTextField();
        jTextField70 = new javax.swing.JTextField();
        jTextField71 = new javax.swing.JTextField();
        jTextField72 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jTextField73 = new javax.swing.JTextField();
        jTextField74 = new javax.swing.JTextField();
        jTextField75 = new javax.swing.JTextField();
        jTextField76 = new javax.swing.JTextField();
        jTextField77 = new javax.swing.JTextField();
        jTextField78 = new javax.swing.JTextField();
        jTextField79 = new javax.swing.JTextField();
        jTextField80 = new javax.swing.JTextField();
        jTextField81 = new javax.swing.JTextField();
        submitNumbers = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 400));

        clockLabel.setText("Clock Here");
        clockLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), null));
        clockLabel.setPreferredSize(new java.awt.Dimension(150, 25));

        jLabelUserScore.setText("User Score:");

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
        sudokuTextField1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField1.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField1.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(sudokuTextField1);

        sudokuTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField2.setText("sudokuTextField10");
        sudokuTextField2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField2.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField2.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(sudokuTextField2);

        sudokuTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField3.setText("sudokuTextField10");
        sudokuTextField3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField3.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField3.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(sudokuTextField3);

        sudokuTextField10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField10.setText("sudokuTextField10");
        sudokuTextField10.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField10.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField10.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(sudokuTextField10);

        sudokuTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField11.setText("sudokuTextField10");
        sudokuTextField11.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField11.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField11.setPreferredSize(new java.awt.Dimension(30, 30));
        sudokuTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sudokuTextField11ActionPerformed(evt);
            }
        });
        jPanel1.add(sudokuTextField11);

        sudokuTextField12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField12.setText("sudokuTextField10");
        sudokuTextField12.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField12.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField12.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(sudokuTextField12);

        sudokuTextField19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField19.setText("sudokuTextField10");
        sudokuTextField19.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField19.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField19.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(sudokuTextField19);

        sudokuTextField20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField20.setText("sudokuTextField10");
        sudokuTextField20.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField20.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField20.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(sudokuTextField20);

        sudokuTextField21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField21.setText("sudokuTextField10");
        sudokuTextField21.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField21.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField21.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(sudokuTextField21);

        sudokuPanel.add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setMinimumSize(new java.awt.Dimension(96, 96));
        jPanel2.setPreferredSize(new java.awt.Dimension(96, 96));
        jPanel2.setLayout(new java.awt.GridLayout(3, 3));

        sudokuTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField4.setText("sudokuTextField10");
        sudokuTextField4.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField4.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField4.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel2.add(sudokuTextField4);

        sudokuTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField5.setText("sudokuTextField10");
        sudokuTextField5.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField5.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField5.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel2.add(sudokuTextField5);

        sudokuTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField6.setText("sudokuTextField10");
        sudokuTextField6.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField6.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField6.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel2.add(sudokuTextField6);

        sudokuTextField13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField13.setText("sudokuTextField10");
        sudokuTextField13.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField13.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField13.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel2.add(sudokuTextField13);

        sudokuTextField14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField14.setText("sudokuTextField10");
        sudokuTextField14.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField14.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField14.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel2.add(sudokuTextField14);

        sudokuTextField15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField15.setText("sudokuTextField10");
        sudokuTextField15.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField15.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField15.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel2.add(sudokuTextField15);

        sudokuTextField22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField22.setText("sudokuTextField10");
        sudokuTextField22.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField22.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField22.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel2.add(sudokuTextField22);

        sudokuTextField23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField23.setText("sudokuTextField10");
        sudokuTextField23.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField23.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField23.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel2.add(sudokuTextField23);

        sudokuTextField24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField24.setText("sudokuTextField10");
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
        sudokuTextField7.setText("sudokuTextField10");
        sudokuTextField7.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField7.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField7.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel3.add(sudokuTextField7);

        sudokuTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField8.setText("sudokuTextField10");
        sudokuTextField8.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField8.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField8.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel3.add(sudokuTextField8);

        sudokuTextField9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField9.setText("sudokuTextField10");
        sudokuTextField9.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField9.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField9.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel3.add(sudokuTextField9);

        sudokuTextField16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField16.setText("sudokuTextField10");
        sudokuTextField16.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField16.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField16.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel3.add(sudokuTextField16);

        sudokuTextField17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField17.setText("sudokuTextField10");
        sudokuTextField17.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField17.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField17.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel3.add(sudokuTextField17);

        sudokuTextField18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField18.setText("sudokuTextField10");
        sudokuTextField18.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField18.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField18.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel3.add(sudokuTextField18);

        sudokuTextField25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField25.setText("sudokuTextField10");
        sudokuTextField25.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField25.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField25.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel3.add(sudokuTextField25);

        sudokuTextField26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField26.setText("sudokuTextField10");
        sudokuTextField26.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField26.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField26.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel3.add(sudokuTextField26);

        sudokuTextField27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTextField27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTextField27.setText("sudokuTextField10");
        sudokuTextField27.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        sudokuTextField27.setMinimumSize(new java.awt.Dimension(30, 30));
        sudokuTextField27.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel3.add(sudokuTextField27);

        sudokuPanel.add(jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel4.setMinimumSize(new java.awt.Dimension(96, 96));
        jPanel4.setPreferredSize(new java.awt.Dimension(96, 96));
        jPanel4.setLayout(new java.awt.GridLayout(3, 3));

        jTextField28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField28.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField28.setPreferredSize(new java.awt.Dimension(30, 30));
        jTextField28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField28ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField28);

        jTextField29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField29.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField29.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel4.add(jTextField29);

        jTextField30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField30.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField30.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel4.add(jTextField30);

        jTextField31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField31.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField31.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel4.add(jTextField31);

        jTextField32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField32.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField32.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel4.add(jTextField32);

        jTextField33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField33.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField33.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel4.add(jTextField33);

        jTextField34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField34.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField34.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel4.add(jTextField34);

        jTextField35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField35.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField35.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel4.add(jTextField35);

        jTextField36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField36.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField36.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel4.add(jTextField36);

        sudokuPanel.add(jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel5.setMinimumSize(new java.awt.Dimension(96, 96));
        jPanel5.setPreferredSize(new java.awt.Dimension(96, 96));
        jPanel5.setLayout(new java.awt.GridLayout(3, 3));

        jTextField37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField37.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField37.setPreferredSize(new java.awt.Dimension(30, 30));
        jTextField37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField37ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField37);

        jTextField38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField38.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField38.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel5.add(jTextField38);

        jTextField39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField39.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField39.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel5.add(jTextField39);

        jTextField40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField40.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField40.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel5.add(jTextField40);

        jTextField41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField41.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField41.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel5.add(jTextField41);

        jTextField42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField42.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField42.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel5.add(jTextField42);

        jTextField43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField43.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField43.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel5.add(jTextField43);

        jTextField44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField44.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField44.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel5.add(jTextField44);

        jTextField45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField45.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField45.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel5.add(jTextField45);

        sudokuPanel.add(jPanel5);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel6.setMinimumSize(new java.awt.Dimension(96, 96));
        jPanel6.setPreferredSize(new java.awt.Dimension(96, 96));
        jPanel6.setLayout(new java.awt.GridLayout(3, 3));

        jTextField46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField46.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField46.setPreferredSize(new java.awt.Dimension(30, 30));
        jTextField46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField46ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField46);

        jTextField47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField47.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField47.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel6.add(jTextField47);

        jTextField48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField48.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField48.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel6.add(jTextField48);

        jTextField49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField49.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField49.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel6.add(jTextField49);

        jTextField50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField50.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField50.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel6.add(jTextField50);

        jTextField51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField51.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField51.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel6.add(jTextField51);

        jTextField52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField52.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField52.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel6.add(jTextField52);

        jTextField53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField53.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField53.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel6.add(jTextField53);

        jTextField54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField54.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField54.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel6.add(jTextField54);

        sudokuPanel.add(jPanel6);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel7.setMinimumSize(new java.awt.Dimension(96, 96));
        jPanel7.setPreferredSize(new java.awt.Dimension(96, 96));
        jPanel7.setLayout(new java.awt.GridLayout(3, 3));

        jTextField55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField55.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField55.setPreferredSize(new java.awt.Dimension(30, 30));
        jTextField55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField55ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField55);

        jTextField56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField56.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField56.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel7.add(jTextField56);

        jTextField57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField57.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField57.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel7.add(jTextField57);

        jTextField58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField58.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField58.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel7.add(jTextField58);

        jTextField59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField59.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField59.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel7.add(jTextField59);

        jTextField60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField60.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField60.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel7.add(jTextField60);

        jTextField61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField61.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField61.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel7.add(jTextField61);

        jTextField62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField62.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField62.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel7.add(jTextField62);

        jTextField63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField63.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField63.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel7.add(jTextField63);

        sudokuPanel.add(jPanel7);

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel8.setMinimumSize(new java.awt.Dimension(96, 96));
        jPanel8.setPreferredSize(new java.awt.Dimension(96, 96));
        jPanel8.setLayout(new java.awt.GridLayout(3, 3));

        jTextField64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField64.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField64.setPreferredSize(new java.awt.Dimension(30, 30));
        jTextField64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField64ActionPerformed(evt);
            }
        });
        jPanel8.add(jTextField64);

        jTextField65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField65.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField65.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel8.add(jTextField65);

        jTextField66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField66.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField66.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel8.add(jTextField66);

        jTextField67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField67.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField67.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel8.add(jTextField67);

        jTextField68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField68.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField68.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel8.add(jTextField68);

        jTextField69.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField69.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField69.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel8.add(jTextField69);

        jTextField70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField70.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField70.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel8.add(jTextField70);

        jTextField71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField71.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField71.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel8.add(jTextField71);

        jTextField72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField72.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField72.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel8.add(jTextField72);

        sudokuPanel.add(jPanel8);

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel9.setMinimumSize(new java.awt.Dimension(96, 96));
        jPanel9.setPreferredSize(new java.awt.Dimension(96, 96));
        jPanel9.setLayout(new java.awt.GridLayout(3, 3));

        jTextField73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField73.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField73.setPreferredSize(new java.awt.Dimension(30, 30));
        jTextField73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField73ActionPerformed(evt);
            }
        });
        jPanel9.add(jTextField73);

        jTextField74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField74.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField74.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(jTextField74);

        jTextField75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField75.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField75.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(jTextField75);

        jTextField76.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField76.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField76.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(jTextField76);

        jTextField77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField77.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField77.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(jTextField77);

        jTextField78.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField78.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField78.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(jTextField78);

        jTextField79.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField79.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField79.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(jTextField79);

        jTextField80.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField80.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField80.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(jTextField80);

        jTextField81.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField81.setMinimumSize(new java.awt.Dimension(30, 30));
        jTextField81.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel9.add(jTextField81);

        sudokuPanel.add(jPanel9);

        submitNumbers.setText("Submit");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUserScore, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitNumbers))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(sudokuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUserScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(sudokuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(submitNumbers)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField28ActionPerformed

    private void jTextField37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField37ActionPerformed

    private void jTextField46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField46ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField46ActionPerformed

    private void jTextField55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField55ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField55ActionPerformed

    private void jTextField64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField64ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField64ActionPerformed

    private void jTextField73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField73ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField73ActionPerformed

    private void sudokuTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sudokuTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sudokuTextField11ActionPerformed

   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clockLabel;
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
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTextField jTextField58;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextField jTextField61;
    private javax.swing.JTextField jTextField62;
    private javax.swing.JTextField jTextField63;
    private javax.swing.JTextField jTextField64;
    private javax.swing.JTextField jTextField65;
    private javax.swing.JTextField jTextField66;
    private javax.swing.JTextField jTextField67;
    private javax.swing.JTextField jTextField68;
    private javax.swing.JTextField jTextField69;
    private javax.swing.JTextField jTextField70;
    private javax.swing.JTextField jTextField71;
    private javax.swing.JTextField jTextField72;
    private javax.swing.JTextField jTextField73;
    private javax.swing.JTextField jTextField74;
    private javax.swing.JTextField jTextField75;
    private javax.swing.JTextField jTextField76;
    private javax.swing.JTextField jTextField77;
    private javax.swing.JTextField jTextField78;
    private javax.swing.JTextField jTextField79;
    private javax.swing.JTextField jTextField80;
    private javax.swing.JTextField jTextField81;
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
    private cs245p1.SudokuTextField sudokuTextField3;
    private cs245p1.SudokuTextField sudokuTextField4;
    private cs245p1.SudokuTextField sudokuTextField5;
    private cs245p1.SudokuTextField sudokuTextField6;
    private cs245p1.SudokuTextField sudokuTextField7;
    private cs245p1.SudokuTextField sudokuTextField8;
    private cs245p1.SudokuTextField sudokuTextField9;
    // End of variables declaration//GEN-END:variables
}