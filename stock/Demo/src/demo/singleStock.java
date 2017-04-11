/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author navneet
 */
public class singleStock {
    public static void main(String[] args) throws IOException{
        final String SYN ;
        SYN = "IBM";
        URL url = new URL("https://www.google.com/finance?q="+SYN+"&ei=tPjVWLDgLpLYuASynZrgBg");
        URLConnection urlConn = url.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);
        String price = null;
        String line = buff.readLine();
        while(line!= null){
           if(line.contains("[\""+SYN+"\",")){
               System.out.println(line);
                int target = line.indexOf("[\""+SYN+"\",");
                int deci = line.indexOf(".", target);
                int start = deci;
                while(line.charAt(start)!='\"')
                    start--;
                price = line.substring(start+1, deci+3); 
            
            }
            line = buff.readLine();        
        }
        System.out.println(" "+SYN+" price: "+ price);
    }
}
