/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245p1;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author 
 */
public class CS245P1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     StartPanel startPanel = new StartPanel();
     MenuPanel menuPanel = new MenuPanel();
     JFrame mainFrame = new JFrame("Basic JFrame");
     mainFrame.setSize(600, 400);
      mainFrame.setLocationRelativeTo(null);
     mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     mainFrame.add(startPanel);
     mainFrame.pack();
     mainFrame.setVisible(true);
     
     mainFrame.remove(startPanel);
     mainFrame.add(menuPanel);
//     try {
//         System.out.println("START");
//         TimeUnit.SECONDS.sleep(3);
//         System.out.println("END");
//     } catch (InterruptedException ex) {
//         Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//     }
//     mainFrame.remove(startPanel);
//     mainFrame.add(menuPanel);
    }
    
}
