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

    //method: SudokuTextField (Constructor)
    //purpose: Default constructor which simply calls its super class constructor
    public SudokuTextField() {
        super();
    }
    
    //method: SudokuTextField (Constructor)
    //purpose: Constructor which takes a given number of columns and passes them to the super constructor
    public SudokuTextField(int cols) {
        super(cols);
    }

    //method: createDefaultModel
    //purpose: Builds and returns a "SudokuDocument" object
    protected Document createDefaultModel() {
        return new SudokuDocument();
    }

    //inner-class: SudokuDocument
    //purpose: This inner-class is used by the custom JTextField to define the proper operations of this subclass of JTextField.
    //It defines a new method for "insertString" which is referenced by the SudokuTextField, allowing only a single digit 1-9 to be
    //inserted into the field. A message will be displayed to the user if they attempt to enter a character that isn't supported (and zeroes
    //are simply ignored).
    static class SudokuDocument extends PlainDocument {

        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            
            if ((str == null) || (str.length() > 1)) {
                return;
            }else if((this.getLength() + str.length()) <= 1){
                if(Character.isDigit(str.charAt(0))){ //since the string can only be length 0 or 1 here, no need to check other characters
                    if(Integer.parseInt(str) != 0){ //only insert the string if it is a digit 1-9
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
