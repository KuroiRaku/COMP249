/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

/**
 *
 * @author Le Cherng
 */
public class FileInvalidException extends Exception{
    
    public FileInvalidException(){
        
    }
    
    public FileInvalidException(String file, String ... aspect ){
        String msg="File is Invalid: Field";
        for(String temp: aspect){
            msg +=" \""+temp+"\" " ;
        }
        System.out.println("Problem detected with input file: "+file+"\n"+msg+" not found");
    }
}
