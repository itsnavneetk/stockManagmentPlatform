/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.*;
import java.net.*;
/**
 *
 * @author navneet
 */
public class Demo {

    public Demo(String quo) throws IOException{
        
        final String SYN = quo;
        URL url = new URL("https://www.google.com/finance?q="+SYN+"&ei=lO7VWKHpEdbDuASS0Z3oBg");
        URLConnection urlConn = url.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);
        String price = null;
        String line = buff.readLine();
        while(line!= null){
            //System.out.println(line);
             if(line.contains("[\""+SYN+"\",")){
                int target = line.indexOf("[\""+SYN+"\",");
                int deci = line.indexOf(",", target);
                int deci1 = line.indexOf(",", deci+1);
                int deciReal = line.indexOf(".", deci1);
                int start = deciReal;
                
                // System.out.println("values : "+target+"deci "+deci+"deci1 "+deci1+"deciReal : "+deciReal);
                while(line.charAt(start)!='\"')
                    start--;
            //System.out.println(line);
               price = line.substring(start+1, deciReal+3); 
            
            } 
            line = buff.readLine();        
        }
        System.out.println(" "+SYN+" price: "+ price);
    }
    public static void main(String[] args) throws IOException{
            Demo obj1 = new Demo("KO");
            Demo obj2 = new Demo("AAPL");
            Demo obj3 = new Demo("GOOG");
            Demo obj4 = new Demo("IBM");
            Demo obj5 = new Demo("FB");
}
    
}
