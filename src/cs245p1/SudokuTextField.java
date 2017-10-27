/***************************************************************
* file: SudokuTextField.java
* author: Christopher Kilian
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Point and Click Game – v.1.2
* date last modified: 10/26/2017
*
* purpose: Custom designed JTextField which only accepts a single character
* entry of the numbers 1 through 9. Any other numeric input (additional numbers 
* or the number 0) are discarded. If the user attempts to enter anything other than
* a digit, they are warned that this is not allowed.
*
****************************************************************/
package cs245p1;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 * This implementation is partially based on the sample for creating custom
 * JTextFields found at
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JTextField.html
 */
public class SudokuTextField extends JTextField {

    public SudokuTextField() {
        super();
    }
    
    public SudokuTextField(int cols) {
        super(cols);
    }

    protected Document createDefaultModel() {
        return new SudokuDocument();
    }

    static class SudokuDocument extends PlainDocument {

        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            
            if ((str == null) || (str.length() > 1)) {
                return;
            }else if((this.getLength() + str.length()) <= 1){
                if(Character.isDigit(str.charAt(0))){ //(str.length() < 1) || 
                    if(Integer.parseInt(str) != 0){
                        super.insertString(offs, str, a);
                    }else{
                        return;
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Please enter only integer values 1-9!");
                }
            }
        }
    }
}
