/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.exchange;
import java.util.*;

import static sun.java2d.cmm.ColorTransform.In;
/**
 *
 * @author navneet
 */

/** An instance is a stock quote for a given ticker symbol at the time of creation.
  *  The static variable record maintains a list of all requested quotes.
  * Requires In.java to compile; download and place it in the same directory.
  * Download site: http://www.cs.princeton.edu/introcs/stdlib/In.java
  * Demo idea due to Sedgewick and Wayne */
public class StockQuote{
    
    private String symbol; // stock ticker symbol 
    private Date time; // time the quote was taken;
    private double price; // price of the stock when the quote was recorded
    
    private static Vector<StockQuote> record= new Vector<StockQuote>(); // list of all requested quotes
    
    
    
    /** Constructor: a new StockQuote for ticker symbol s, taken at time t, 
      *  at price p; the time will be now.
      * Adds this StockQuote to the list of record.
      * Precondition: s is a valid ticker symbol (case doesn't matter).
      */
    private StockQuote(String s, Date t, double p) {
        symbol= s;
        time= t; 
        price= p;
        record.add(this);
    }
    
    
    /** Print current price of stock with ticker symbol s,
      * and add the new quote to the record.
      * Print format: <symbol> @ <date>: $<price>
      * Precondition: s is a valid ticker symbol (case doesn't matter):
      * examples:  "goog", "GOOG" "MsFT" */
    
    public static void getQuote(String s) {
        
        double price= 0.0;
        
        // find URL for data
        String url="http://finance.yahoo.com/q?s=" +s; 
        
        // treat the webpage as a String so we can process it
        String targetText= new In(url).readAll();
        
        // pull out the substring corresponding to the price
        targetText= targetText.substring(targetText.indexOf("Last Trade:"));
        targetText= targetText.substring(0,targetText.indexOf("</span>"));
        targetText= targetText.substring(targetText.lastIndexOf(">")+1);
        
        // convert String in targetText to a double price
        price= Double.parseDouble(targetText);
        
        // record the new quote (by creating it) and print the info out
        System.out.println(new StockQuote(s, new Date(), price));   
    }
    
    /** = StockQuote at index i. 
      * Precondition: i is a valid index into the record
      */
    public static StockQuote recordAt(int i) {
        return record.get(i);
   }
    
    /** = String rep of record, using Vector's default toString format*/
    public static String showRecord() {
        return record.toString();
   }
    
    /** = <symbol> @ <date>: $<price> */
    public String toString() {
        return symbol + " @ " + time + ": $" + price; 
    }
    
    /** just for private debugging purposes */
    public static void test() {
        //tests of getQuote
        System.out.println("getting a google quote: ");   getQuote("goog");
        System.out.println("getting a MSFT quote: "); getQuote("msft");
        System.out.println("getting an apple quote: ");   getQuote("aapl");
        System.out.println("getting a google quote: ");   getQuote("goog");
        
        // tests of record (list) handling
        System.out.println("\nlist of quotes:\n" + showRecord() + "\n\n");
        System.out.println("element in record at index 0: " + recordAt(0));
    }
    
    
     public static void main(String[] args) {
      // Following statement would create an object myPuppy
     
   }
    
}
