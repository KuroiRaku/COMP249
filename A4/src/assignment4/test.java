/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Le Cherng
 */
public class test {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            Scanner inputStream = new Scanner(new FileInputStream("PersonOfTheCentury.txt"));
            ArrayList<String> arrli = new ArrayList<String>();
            ArrayList<String> E = new ArrayList<String>();
            arrli.add(inputStream.next());
            System.out.println(arrli);
            String test = inputStream.next();
            test = inputStream.next();
            String toUpperCase = test.toUpperCase();
            String firstLetter = Character.toString(toUpperCase.charAt(0));
            System.out.println(toUpperCase.charAt(0));
            if(firstLetter.equals("E")){
                System.out.println("Detected");
                if(arrli.contains(test)){
                    System.out.println("It exists uwu");
                }else{
                    sortAdd(arrli, test);
                    sortAdd(arrli, inputStream.next().toUpperCase());
                    sortAdd(arrli, inputStream.next().toUpperCase());
                    System.out.println("It was added :P");
                }
            }
            
            System.out.println(arrli);
            
        } catch (FileNotFoundException ex) {
            System.out.println("Filenotfound :P");
        }
    }
    
    public static ArrayList<String> sortAdd(ArrayList<String> test, String toUpperCase){
        int index = test.size();
            for (int i = 0; i < test.size(); i++) {
                if (test.get(i).compareTo(toUpperCase) > 0) {
                  index = i;
                 break;
            }
        }
            test.add(index, toUpperCase);
            return test;
        
    }
}
