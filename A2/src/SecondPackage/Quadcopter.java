// -----------------------------------------------------
// Assignment 2 
// Question: 
// Written by: Le Cherng Lee. 40122814
//------------------------------------------------------
package SecondPackage;

import FirstPackage.Airplane;

/**
 *
 * @author Le Cherng
 */
public class Quadcopter extends Helicopter
{
    private int MaxFlyingSpeed;
    
    public Quadcopter()
    {
        super();
        MaxFlyingSpeed=0;
    }
    
    public Quadcopter(String B, double P, int HP, int NOC, int CY, int PC, int MFS)
    {
        super(B,P,HP, NOC,CY,PC);
        MaxFlyingSpeed=MFS;
    }
    public Quadcopter(Quadcopter C)
    {
        super(C);
        MaxFlyingSpeed=C.GetMaxFlyingSpeed();
    }
    
    public int GetMaxFlyingSpeed()
    {
        return MaxFlyingSpeed;
    }
    
    public void SetMaxFlyingSPeed(int MFS)
    {
        MaxFlyingSpeed = MFS;
    }
    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        return "This Quadcopter Brand is "+GetBrand()+"\nPrice is "+GetPrice()+"\nNumber of Cylinders is "+GetNumberOfCylinders()
                +"\nCreation Year is "+GetCreationYear()+"\nPassenger Capacity is "+ GetPassengerCapacity()+"\nMax Flying Speed is "+MaxFlyingSpeed;
    }
    
    public boolean equals(Quadcopter C)
    {
        if(C==null)
        {
            return false;
        }else
        {
            return this.GetBrand().equals(C.GetBrand()) && this.GetPrice() == C.GetPrice() && this.GetHorsePower()==C.GetHorsePower()
                    && this.GetNumberOfCylinders()== C.GetNumberOfCylinders() && this.GetCreationYear() == GetCreationYear()
                    && this.GetPassengerCapacity() == C.GetPassengerCapacity() && this.MaxFlyingSpeed == C.GetMaxFlyingSpeed();
    
        }
    }
   
    
    @Override
    public Quadcopter Copy() 
    {
        return new Quadcopter(this);
    }
}
