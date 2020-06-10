// -----------------------------------------------------
// Assignment: 4
// PartB
// Written by: Le Cherng Lee 40122814
// -----------------------------------------------------
package assignment4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Le Cherng
 */
public class CellListUtilization {
    
    public static void main(String[]args) throws CloneNotSupportedException{
        CellList celllist= new CellList();
        
        try{    
            Scanner inputStream = new Scanner(new FileInputStream("Cell_Info.txt"));
            while(inputStream.hasNextLine()){
                String SN= inputStream.next();
                String brand=inputStream.next();
                String price=inputStream.next();
                String year=inputStream.next();
                CellPhone cellphone= new CellPhone(Long.parseLong(SN), brand, Double.parseDouble(price), Integer.parseInt(year));
                celllist.addToStart(cellphone);
            }
            inputStream.close();
        }catch(FileNotFoundException e){
            System.out.println("Errrm? File Not Found duh");
        }
        CellPhone cellphone = new CellPhone(1234, "Raku", 10.99, 2020);
        System.out.println("Clone Celllist one to CellList two :D");
        CellList celllist2=new CellList(celllist);
        CellList celllist3=new CellList();
        celllist3.addToStart(cellphone);
        System.out.println("\n\n\nCreated CellList 3 and add to a CellPhone called Raku :D\nThe content of CellList 1:");
        System.out.println(celllist.showContents());
        System.out.println("\n\n\n Before deleted and the copy of celllist2");
        System.out.println(celllist2.showContents());
        celllist2.deleteFromIndex(1);
        System.out.println("\n\n\n\nCellist 2: After deleted at index 1");
        System.out.println(celllist2.showContents());
        celllist2.deleteFromStart();
        System.out.println("\n\n\n\nCellist 2: After deleted from start");
        System.out.println(celllist2.showContents());
        celllist2.insertAtIndex(cellphone,3);
        System.out.println("\n\n\n\nCellist 2: After added cellphone at index 3");
        System.out.println(celllist2.showContents());
        System.out.println(celllist.equals(celllist2));
        System.out.println(celllist3.equals(celllist));
        System.out.println(celllist2.contains(1234));
        System.out.println("\n\n\nShow Contents of CellList 1 to proove that the celllist are indeed deep copy");
        System.out.println(celllist.showContents());
        System.out.println("\n\n\nTesting Replace At Index for CellList 1");
        celllist.replaceAtIndex(cellphone, 0);
        celllist.replaceAtIndex(cellphone, 1);
        System.out.println(celllist.showContents());
        
        celllist3 = celllist.clone();
        celllist3.showContents();
        /*
        System.out.println("This will give error since CellList 3 don't have index 3");
        celllist3.insertAtIndex(cellphone, 5);
        */
    }
    
}
