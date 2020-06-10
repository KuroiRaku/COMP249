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
public class CondoBuilding extends ResidentialBuilding{
    
    private int numberOfUnits;
    
    public CondoBuilding(int YOC, double C, double LS, String M, int MNOH, int NOU) {
        super(YOC, C, LS, M, MNOH);
        numberOfUnits = NOU;
    }
    
    public CondoBuilding(CondoBuilding C){
        super(C);
        numberOfUnits= C.getNumberOfUnits();
    }
    
    public int getNumberOfUnits(){
        return numberOfUnits;
    }
    
    public void setNumberOfUNits(int NOU){
        numberOfUnits = NOU;
    }
    public CondoBuilding clone(){
        return new CondoBuilding(this);
    }
}
