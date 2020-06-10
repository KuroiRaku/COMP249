/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommercialAirport;

import FX_W20PKG.Airport;

/**
 *
 * @author Le Cherng
 */
public class CommercialAirport extends Airport{
    private int numberOfGates;
    
    public CommercialAirport(int YOC, double C, int NOR, String Code, int NOG) {
        super(YOC, C, NOR, Code);
        numberOfGates= NOG;
    }
    public CommercialAirport(CommercialAirport C){
        super(C);
        numberOfGates= C.getNumberOfGates();
    }
    public int getNumberOfGates(){
        return numberOfGates;
    }
    public void setNumberOfGates(int NOG){
        numberOfGates= NOG;
    }
    public CommercialAirport clone(){
        return new CommercialAirport(this);
    }
}
