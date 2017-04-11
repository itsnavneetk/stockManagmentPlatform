/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.exchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Saumya
 */
public class webscraper {
    public String pr=" ";
    public webscraper(String quo) throws IOException{
        
        final String SYN = quo;
        URL url = new URL("https://www.google.com/finance?q="+SYN+"&ei=lO7VWKHpEdbDuASS0Z3oBg");
        URLConnection urlConn = url.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);
        pr = null;
        String change = null;
        String line = buff.readLine();
        while(line!= null){
            //System.out.println(line); 
            
            if(line.contains("[\""+SYN+"\",")){
                int target = line.indexOf("[\""+SYN+"\",");
                int deci = line.indexOf(",", target);
                int deci1 = line.indexOf(",", deci+1);
                int deci2 = line.indexOf(",", deci1+1);
                int deciReal = line.indexOf(".", deci1);
                int deciReal2 = line.indexOf(".", deci2);
                int start = deciReal;
                
                // System.out.println("values : "+target+"deci "+deci+"deci1 "+deci1+"deciReal : "+deciReal);
                while(line.charAt(start)!='\"')
                    start--;
            //System.out.println(line);
               pr = line.substring(start+1, deciReal+3); 
               change = line.substring(deciReal2-2, deciReal2+3);
            }
            
            line = buff.readLine();        
        }
        

    }
}