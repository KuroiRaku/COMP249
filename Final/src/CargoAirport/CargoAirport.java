/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CargoAirport;

import FX_W20PKG.Airport;

/**
 *
 * @author Le Cherng
 */
public class CargoAirport extends Airport{
    private double landedWeight;

    public CargoAirport(int YOC, double C, int NOR, String Code, double LW) {
        super(YOC, C, NOR, Code);
        landedWeight = LW;
    }
    public CargoAirport(CargoAirport C){
        super(C);
        landedWeight= C.getLandedWeight();
        
    }
    
    public double getLandedWeight(){
        return landedWeight;
    }
    public void setLandedWeight(double LW){
        landedWeight=LW;
    }
    
    public CargoAirport clone(){
        return new CargoAirport(this);
    }
}
