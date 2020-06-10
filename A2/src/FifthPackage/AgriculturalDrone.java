// -----------------------------------------------------
// Assignment 2 
// Question: 
// Written by: Le Cherng Lee. 40122814
//------------------------------------------------------
package FifthPackage;

import FourthPackage.UAV;

/**
 *
 * @author Le Cherng
 */
public class AgriculturalDrone extends UAV{
    private String Brand;
    private int CarryCapacity;
    
    //constructors
    public AgriculturalDrone()
    {
        super();
        Brand = "";
        CarryCapacity =0;
    }
    
    public AgriculturalDrone(double W, double P, String B, int CC)
    {
        super(W,P);
        Brand = B;
        CarryCapacity =CC;
    }
    
    public AgriculturalDrone(AgriculturalDrone C)
    {
        super(C);
        this.Brand = C.Brand;
        this.CarryCapacity =C.CarryCapacity;
    }
    
    //accessors
    public String GetBrand()
    {
        return Brand;
    }
    
    public int GetCarryCapacity()
    {
        return CarryCapacity;
    }
    
    //mutators
    public void SetBrand(String B)
    {
        Brand = B;
    }
    
    public void SetCarryCapacity(int CC)
    {
        CarryCapacity = CC;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        return "This Agricultural Drone's weight is "+ GetWeight()+"\nPrice is "+GetPrice()
                +"\nBrand is "+Brand+"/nAnd the Carry Capacity is "+CarryCapacity;
    }
    
    public boolean equals(AgriculturalDrone C)
    {
        if(C ==null){
            return false;
        }else{
            return C.GetWeight() == this.GetWeight() && this.GetPrice()==C.GetPrice() && this.Brand.equals(C.GetBrand()) && this.CarryCapacity == C.GetCarryCapacity();
        }
    }
    
    //this code can be used

    /**
     *
     * @return
     */
    @Override
    public AgriculturalDrone Copy() 
    {
        return new AgriculturalDrone(this);
    }
}
