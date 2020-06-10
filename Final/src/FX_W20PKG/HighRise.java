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
public class HighRise extends Building{
    private double height;
    
    public HighRise(int YOC, double C, double LS, String M, double H) {
        super(YOC, C, LS, M);
        height = H;
    }
    
    public HighRise(HighRise C){
        super(C);
        height = C.getHeight();
    }
    
    public double getHeight(){
        return height;
    }
    
    public void setHeight(double H){
        height = H;
    }
    
    public HighRise clone(){
        return new HighRise(this);
    }
    
}
