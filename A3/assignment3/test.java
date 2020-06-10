// -----------------------------------------------------
// Assignment: 4
// 
// Written by: Le Cherng Lee 40122814
// -----------------------------------------------------
package assignment3;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Le Cherng
 */
public class test {
    
    public static void main(String[]args){
        try {
            
            String test = "2";
            String []afterTest= test.split("[$]");
            System.out.println(Arrays.toString(afterTest));
            System.out.println(afterTest[0]);
            System.out.println(test.getClass().getSimpleName());
            Scanner inputStream = new Scanner(new FileInputStream("bib/Latex1.BIB"));
            
            for(int i=0;i<13;i++)
            inputStream.nextLine();
            String emptyChecker= inputStream.nextLine();
            System.out.println(emptyChecker);
            String temp[]= emptyChecker.split("[=,{}]");
            temp = Arrays.stream(temp).filter(s ->(s !=null & s.length()>0)).toArray(String[]::new);
            System.out.println(Arrays.toString(temp));
            if(emptyChecker.trim().equals("") || emptyChecker.equals("}"))System.out.println("It is empty");
                
                
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    
}
