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
public class Overpass extends Bridge{
    private double maxLoad;
    public Overpass(int YOC, double C, double L, double H, double ML) {
        super(YOC, C, L, H);
        maxLoad= ML;
    }
    public Overpass(Overpass C){
        super(C);
        maxLoad= C.getMaxLoad();
    }
    
    public double getMaxLoad(){
        return maxLoad;
    }
    public void setMaxLoad(double ML){
        maxLoad= ML;
    }
    
    public Overpass clone(){
        return new Overpass(this);
    }
}
