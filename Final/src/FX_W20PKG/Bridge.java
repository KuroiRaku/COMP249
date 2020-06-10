/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FX_W20PKG;

/**
 *
 * @author Le Cherng
 */
public class Bridge extends Structure{
    
    private double length;
    private double height;
    
    public Bridge(int YOC, double C, double L, double H){
        super(YOC, C);
        length = L;
        height = H;
    }
    public Bridge(Bridge C){
        super(C);
        length= C.getLength();
        height= C.getHeight();
    }
    
    public double getLength(){
        return length;
    }
    public double getHeight(){
        return height;
    }
    
    public void setLength(double L){
        length= L;
    }
    
    public void setHeight(double H){
        height = H;
    }
    
    public Bridge clone(){
        return new Bridge(this);
    }
}
