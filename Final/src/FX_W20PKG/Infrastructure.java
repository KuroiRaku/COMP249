/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FX_W20PKG;

import CargoAirport.CargoAirport;
import CommercialAirport.CommercialAirport;
import static FX_W20PKG.Infrastructure.AirportCode.RandomAirportCode;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Le Cherng
 */
public class Infrastructure {
    static int count=0;
    static int i=0;
    
    public static void main(String[]args) throws CloneNotSupportedException{
        Structure strArr[]= initializeObjects();
        System.out.println(strArr.length);
        for(int j=0;j<strArr.length; j++){
            System.out.println(strArr[j].getClass().getSimpleName());
        }
        System.out.println("\n\n\n");
        System.out.println("Task 3C Started\nInitializing a dummy arry to test");
        Structure []test = new Structure [2];
        test[0]= new Structure (2020, 200);
        int i = findTallestHighRise(test);
        if(i== -1){
            System.out.println("No highrise in this array");
        }else{
            System.out.println("Tallest building was found at index "+ i);
        }
        
        System.out.println("\n\n\nNow using strArr");
        i = findTallestHighRise(strArr);
        if(i== -1){
            System.out.println("No highrise in this array");
        }else{
            System.out.println("Tallest building was found at index "+ i);
            System.out.println("The height is "+((HighRise)strArr[i]).getHeight() );
        }
        System.out.println("\n\nTask 3D started");
        showBuildingInfo(strArr);
        System.out.println("\n\n\nTask 3E Started");
        displayAllObjects(strArr);
        System.out.println("\n\nTask 3F started");
        Structure[] copy = copyStructures(strArr);
        System.out.println("This copy perform deep copy since Im using clone method");
        displayAllObjects(copy);
        System.out.println("\n\nTast 4A Started");
        ArrayList<Structure> strArrLst = new ArrayList <Structure>(30);
        System.out.println("Task 4B started");
        for(Structure j: strArr){
            strArrLst.add(j);
        }
        System.out.println("Task 4C started");
        System.out.println(strArrLst);
        Structure check = strArrLst.get(2);
        System.out.println(check.getClass().getSimpleName());
        strArrLst.remove(2);
        
        strArrLst.remove(3);
        Structure confirm= strArrLst.get(10);
        strArrLst.remove(6);
        strArrLst.remove(7);
        strArrLst.remove(9);
        System.out.println();
        System.out.println("Task 4D started\nChecking whether deleted is in the list");
        if(strArrLst.contains(check)){
            System.out.println("Error OMG");
        }else{
            System.out.println(check.getClass().getSimpleName()+" was removed and not found");
        }
        System.out.println("Now checking non deleted is inside");
        if(strArrLst.contains(confirm)){
            System.out.println(confirm.getClass().getSimpleName()+" was found inside the list");
        }else{
            System.out.println("Error OMG");
        }
        
        try{
            System.out.println("\n\ntask 5A started");
            PrintWriter outputStream = new PrintWriter(new FileOutputStream("AirportCodes.txt"),true);
            System.out.println("\n\nTask 5B & 5C started");
            findExistingAirportCodes(outputStream, strArr);
            outputStream.close();
            BufferedReader inputStream = new BufferedReader(new FileReader("AirportCodes.txt"));
            displayAirportCodes(inputStream);
            inputStream.close();
            
        }catch(FileNotFoundException e){
            System.out.println("FileNot found");
            
        }catch(IOException e){
            System.out.println("IOException");
        }
        
        System.out.println("\n\n\nNow starting Task 6, doing add to start 3 objects");
        StructureList list = new StructureList();
        list.addToStart(strArr[2]);
        list.addToStart(strArr[3]);
        list.addToStart(strArr[4]);
        list.showListContents();
        System.out.println("Now trying to addToEnd");
        list.addAtEnd(strArr[5]);
        list.showListContents();
        System.out.println("Now lets use clone");
        StructureList copied = new StructureList (list) ;
        copied.showListContents();
        System.out.println("Now let append copiedList");
        list.append(copied);
        list.showListContents();
        
    }
    
    public static void findExistingAirportCodes(PrintWriter P, Structure strArr[]){
        for(int j=0; j<strArr.length;j++){
            if(strArr[j].getClass().getSimpleName().equals("Airport")){
                P.println(((Airport)strArr[j]).getCode());
            }
        }
        
    }
    
    public static void displayAirportCodes(BufferedReader B) throws IOException{
        System.out.println("Task 5E & 5F started");
        int line = B.read();
        int count = 0;
        while(line != -1){
            if(count ==3 ){
                System.out.println();
                count =0;
            }
            
            if(line == 10 || line ==13){
                line=B.read();
            }else{
                System.out.print((char)line);
                line = B.read();
                count++; 
            }
            
        }
    }
    
    public enum AirportCode {
        YUL, HND, KUL, TPE, PVG, NRT;

        public static String RandomAirportCode() {
            int Pick = new Random().nextInt(AirportCode.values().length);
            return AirportCode.values()[Pick].toString();
        }
    }
    
    public static Structure[] initializeObjects(){
        System.out.println("Task 3 started \nInitializing Six Objects from each classes");
        Structure StrArr[]= new Structure [66];
        int checker=0;
        Random random = new Random();
        int randomYear;
        int randomPrice;
        int randomHeight;
        for(int i=0; i<66; i++){
            randomYear = random.nextInt(25)+1990;
            randomPrice = random.nextInt(100000)+200000;
            randomHeight = random.nextInt(500)+200;
            switch (checker){
                case 0:
                    StrArr[i]= new Structure(randomYear, randomPrice);
                    checker++;
                    break;
                case 1:
                    StrArr[i]= new Building(randomYear, randomPrice, 3.5, "Concrete");
                    checker++;
                    break;
                case 2:
                    StrArr[i]= new Bridge(randomYear, randomPrice, 300, 400);
                    checker++;
                    break;
                case 3:
                    StrArr[i]= new Airport(randomYear, randomPrice, 20, RandomAirportCode());
                    checker++;
                    break;
                case 4:
                    StrArr[i]= new ResidentialBuilding(randomYear, randomPrice, 4.5, "Metal", 5);
                    checker++;
                    break;
                case 5:
                    StrArr[i]= new HighRise(randomYear, randomPrice, 4.5, "Metal", randomHeight);
                    checker++;
                    break;
                case 6:
                    StrArr[i]= new House(randomYear, randomPrice, 4.5, "Stainless Steel", 6, 5, 3);
                    checker++;
                    break;
                case 7:
                    StrArr[i]= new CondoBuilding(randomYear, randomPrice, 4.5, "Metal", 20, 10);
                    checker++;
                    break;
                case 8:
                    StrArr[i]= new Overpass(randomYear, randomPrice, 300, 400, 500);
                    checker++;
                    break;
                case 9:
                    StrArr[i]= new CargoAirport(randomYear, randomPrice, 20, RandomAirportCode(), 5000);
                    checker++;
                    break;
                case 10:
                    StrArr[i]= new CommercialAirport(randomYear, randomPrice, 20, RandomAirportCode(), 50);
                    checker = 0;
                    break;
            }
            
            
        }
        
        return StrArr;
    }
    
    public static int findTallestHighRise(Structure strArr[]){
        int indexOfHighest= -1;
        double Highest=0;
        for(int i=0;i<strArr.length;i++){
            if(strArr[i] instanceof HighRise){
                if(((HighRise)strArr[i]).getHeight()>Highest){
                    indexOfHighest = i;
                    Highest = ((HighRise)strArr[i]).getHeight();
                }
            }
        }
        return indexOfHighest;
    }
    
    public static void showBuildingInfo(Structure strArr[] ){
        for(int i=0;i<strArr.length;i++){
            if(strArr[i].getClass().getSimpleName().equals("Building")){
                System.out.println("Building found, \nPrice: "+strArr[i].getCost()+"\nLandSpace: "+((Building)strArr[i]).getLandSpace());  
            }
            if(strArr[i].getClass().getSimpleName().equals("ResidentialBuilding")){
                System.out.println("Residential Building found, \nPrice: "+strArr[i].getCost()+"\nMaxNumOfHabitants: "+((ResidentialBuilding)strArr[i]).getMaxNumberOfHabitants());  
            }
            if(strArr[i].getClass().getSimpleName().equals("HighRise")){
                System.out.println("HighRise found, \nPrice: "+strArr[i].getCost()+"\nHeight: "+((HighRise)strArr[i]).getHeight());  
            }
            if(strArr[i].getClass().getSimpleName().equals("House")){
                System.out.println("House found, \nPrice: "+strArr[i].getCost()+"\nMaxNumOfHabitants: "+((House)strArr[i]).getNumberOfFloors());  
            }
            if(strArr[i].getClass().getSimpleName().equals("CondoBuilding")){
                System.out.println("CondoBuilding found, \nPrice: "+strArr[i].getCost()+"\nMaxNumOfUnits: "+((CondoBuilding)strArr[i]).getNumberOfUnits());  
            }
        }
    }
    public static void displayAllObjects(Structure strArr[]){
        
        if(count == 0){
            i = strArr.length;
            i -=1;
        }
        Structure Test[] = strArr;
        if(Test[i].getClass().getSimpleName().equals("Structure")){
            System.out.println("Structure found, \nPrice: "+strArr[i].getCost());
        }else if(Test[i].getClass().getSimpleName().equals("Airport")){
            System.out.println("Airport found, \nPrice: "+strArr[i].getCost()+"\nCode: "+((Airport)strArr[i]).getCode());
        }else if(Test[i].getClass().getSimpleName().equals("Cargo Airport")){
            System.out.println("CargoAirport found, \nPrice: "+strArr[i].getCost()+"\nLandedWeight: "+((CargoAirport)strArr[i]).getLandedWeight());
        }else if(Test[i].getClass().getSimpleName().equals("CommercialAirport")){
            System.out.println("CommercialAirport found, \nPrice: "+strArr[i].getCost()+"\nNumberOfGates: "+((CommercialAirport)strArr[i]).getNumberOfGates());
        }else if(Test[i].getClass().getSimpleName().equals("Bridge")){
            System.out.println("Bridge found, \nPrice: "+strArr[i].getCost()+"\nLength: "+((Bridge)strArr[i]).getLength());
        }else if(Test[i].getClass().getSimpleName().equals("Overpass")){
            System.out.println("Building found, \nPrice: "+strArr[i].getCost()+"\nMaxLoad: "+((Overpass)strArr[i]).getMaxLoad());
        }else if(Test[i].getClass().getSimpleName().equals("Building")){
            System.out.println("Building found, \nPrice: "+strArr[i].getCost()+"\nLandSpace: "+((Building)strArr[i]).getLandSpace());
        }else if(Test[i].getClass().getSimpleName().equals("ResidentialBuilding")){
            System.out.println("Residential Building found, \nPrice: "+strArr[i].getCost()+"\nMaxNumOfHabitants: "+((ResidentialBuilding)strArr[i]).getMaxNumberOfHabitants());
        }else if(Test[i].getClass().getSimpleName().equals("HighRise")){
            System.out.println("HighRise found, \nPrice: "+strArr[i].getCost()+"\nHeight: "+((HighRise)strArr[i]).getHeight());
        }else if(Test[i].getClass().getSimpleName().equals("House")){
            System.out.println("House found, \nPrice: "+strArr[i].getCost()+"\nMaxNumOfHabitants: "+((House)strArr[i]).getNumberOfFloors());
        }else if(Test[i].getClass().getSimpleName().equals("CondoBuilding")){
            System.out.println("CondoBuilding found, \nPrice: "+strArr[i].getCost()+"\nMaxNumOfUnits: "+((CondoBuilding)strArr[i]).getNumberOfUnits());
        }
        
        i--;
        if(i != -1){
            count = 1;
            displayAllObjects(Test);
        }else{
            count =0;
        }
    }
    
    public static Structure[] copyStructures(Structure[] strArr) throws CloneNotSupportedException{
        Structure []copy = new Structure[strArr.length];
        for(int j=0; j<strArr.length; j++){
            copy[j]= (Structure) strArr[j].clone();
        }
        return copy;
    }
    
}
