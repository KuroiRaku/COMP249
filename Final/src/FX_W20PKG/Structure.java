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
public class Structure implements Cloneable {
    private int yearOfCreation;
    private double cost;
    
    public Structure(int YOC, double C){
        yearOfCreation= YOC;
        cost= C;
    }

    public Structure(Structure structure) {
        yearOfCreation = structure.getYearOfCreation();
        cost= structure.getCost();
    }
    
    public int getYearOfCreation(){
        return yearOfCreation;
    }
    
    public double getCost(){
        return cost;
    }
    
    public void setYearOfCreation(int YOC){
        yearOfCreation = YOC;
    }
    
    public void setCost(double C){
        cost = C;
    }
    public Structure clone(){
        return new Structure(this);
    }
    
}
