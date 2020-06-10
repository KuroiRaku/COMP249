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
public class ResidentialBuilding extends Building{
    private int maxNumberOfHabitants;
    
    public ResidentialBuilding(int YOC, double C,double LS, String M, int MNOH) {
        super(YOC, C, LS, M);
        maxNumberOfHabitants = MNOH;
    }
    
    public ResidentialBuilding(ResidentialBuilding C){
        super(C);
        maxNumberOfHabitants= C.getMaxNumberOfHabitants();
    }
    
    public int getMaxNumberOfHabitants(){
        return maxNumberOfHabitants;
    }
    public void setMaxNumberOfHabitants(int MNOH){
        maxNumberOfHabitants = MNOH;
    }
    public ResidentialBuilding clone(){
        return new ResidentialBuilding(this);
    }
}
