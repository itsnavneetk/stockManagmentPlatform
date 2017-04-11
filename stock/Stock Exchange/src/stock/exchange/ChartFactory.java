/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.exchange;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author mahe
 */
class ChartFactory {
    public static void main(String args[]){
    WebView wv;
    JFXPanel fxPanel;
    try{
        //String stock_name = (String) jComboBox2.getSelectedItem();
        fxPanel = new JFXPanel ();
        JFrame frame;
        wv = new WebView ();
                String stock_name = "AAPL";
                System.out.println("LOL");
                wv.getEngine ().load ( "https://www.google.com/finance/company_news?q=\""+stock_name+"\"&amp;ei=uHLiWNHKFsiHuwTSsqOoAw" );
                fxPanel.setScene ( new Scene ( wv, 1000, 750 ) );
                frame = new JFrame ( "AAPL" );
                frame.add ( new JScrollPane ( fxPanel ) );
                frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
                frame.setVisible ( true );
                frame.pack ();
        }
        catch(Exception e){}
    
    }
}
