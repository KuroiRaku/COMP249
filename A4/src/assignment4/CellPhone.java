// -----------------------------------------------------
// Assignment: 4
// Parat B
// Written by: Le Cherng Lee 40122814
// -----------------------------------------------------
package assignment4;

import java.util.Scanner;

/**
 *
 * @author Le Cherng
 */
public class CellPhone implements Cloneable {
    private long serialNum;
    private String brand;
    private int year;
    private double price;
    
    public CellPhone(long SN, String B, double P, int Y){
        serialNum=SN;
        brand = B;
        year=Y;
        price=P;
    }
    
    public CellPhone(CellPhone C){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter new serial number: ");
        long newSN= input.nextLong();
        setSerialNum(newSN);
        setBrand(C.brand);
        setYear(C.year);
        setPrice(C.price);
    }
    public long getSerialNum(){
        return serialNum;
    }
    
    public String getBrand(){
        return brand;
    }
    public int getYear(){
        return year;
    }
    public double getPrice(){
        return price;
    }
    public void setSerialNum(long SN){
        this.serialNum = SN;
    }
    public void setBrand(String B){
        brand=B;
    }
    public void setYear(int Y){
        year= Y;
    }
    public void setPrice(double P){
        price = P;
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public CellPhone clone() throws CloneNotSupportedException{
        return new CellPhone(this);
    }
    
    @Override
    public String toString(){
        String format= String.format("Serial Number:%-8d Brand:%-12s Price:%-5.2f Year:%-4d",this.serialNum, this.brand, this.price, this.year );
        return format;
    }
    
    public boolean equal(CellPhone C){
        //exception of serial Number
        return  price==C.price && year == C.year && brand.equals(C.brand);
    }
}
