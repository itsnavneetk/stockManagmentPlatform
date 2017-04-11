/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.exchange;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author navneet
 */
public class MarqueeTest {

    void display() {
        JFrame f = new JFrame("MarqueeTest");
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String s = "Bourses in Europe closed mixed Friday after the U.S. fired cruise missiles against an air base in Syria, raising concerns over an escalating conflict in the region.";
        MarqueePanel mp = new MarqueePanel(s, 32);
        f.add(mp);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        mp.start();
    }

}    

