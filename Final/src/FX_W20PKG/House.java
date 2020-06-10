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
public class House extends ResidentialBuilding{
    private double numberOfRooms;
    private int numberOfFloors;
    
    public House(int YOC, double C, double LS, String M, int MNOH, double NOR, int NOF) {
        super(YOC, C, LS, M, MNOH);
        numberOfRooms= NOR;
        numberOfFloors= NOF;
        
    }
    
    public House(House C){
        super(C);
        numberOfRooms = C.GetNumberOfRooms();
        numberOfFloors= C.getNumberOfFloors();
    }
    
    public double GetNumberOfRooms(){
        return numberOfRooms;
    }
    
    public int getNumberOfFloors(){
        return numberOfFloors;
    }
    public void setNumberOfRooms( double NOR){
        numberOfRooms = NOR;
    }
    public void setNumberOfFloors(int NOF){
        numberOfRooms = NOF;
    }
    public House clone(){
        return new House(this);
    }
}
