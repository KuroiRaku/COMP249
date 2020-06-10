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
public class Building extends Structure {
    
    private double landSpace;
    private String material;
    
    public Building(int YOC, double C, double LS, String M){
        super(YOC, C);
        landSpace = LS;
        material = M;
    }
    
    public Building(Building C){
        super(C);
        landSpace = C.getLandSpace();
        material= C.getMaterial();
    }
    
    public double getLandSpace(){
        return landSpace;
    }
    
    public String getMaterial(){
        return material;
    }
    
    public void setlandSpace(double LS){
        landSpace= LS;
    }
    
    public void setMaterial(String M){
        material = M;
    }
    
    public Building clone(){
        return new Building(this);
    }
}
