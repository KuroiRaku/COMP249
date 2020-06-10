// -----------------------------------------------------
// Assignment 2 
// Question: 
// Written by: Le Cherng Lee. 40122814
//------------------------------------------------------
package FourthPackage;

import Driver.FlyingObject;

/**
 *
 * @author Le Cherng
 */
public class UAV extends FlyingObject{
    private double Weight;
    private double Price;
    
    public UAV()
    {
        Weight = 0.0;
        Price = 0.0;
    }
    public UAV(double Weight, double Price)
    {
        this.Weight = Weight;
        this.Price = Price;
    }
    public UAV(UAV C)
    {
        
        this.Weight = C.GetWeight();
        this.Price= C.GetPrice();
    }
    
    //accessors
    public double GetWeight()
    {
        return Weight;
    }
    
    @Override
    public double GetPrice()
    {
        return Price;
    }
    
    //mutators
    public void SetPrice(double P)
    {
        Price = P;
    }
    
    public void SetWeight(double W)
    {
        Weight = W;
    }
    
     @Override
    //Why can't i follow my own code convention :(
    public String toString()
    {
        return "This Unmanned Aerial Vehicle's weight is "+ Weight+"\nPrice is "+Price;
    }
    
    public boolean equals(UAV C)
    {
        if(C ==null){
            return false;
        }else
        {
            return C.GetWeight() == this.Weight && this.Price==C.GetPrice();
        }
    }
    
    //another way of doing it
    @Override
    public UAV Copy()
    {
        return new UAV(this);
    }
}
