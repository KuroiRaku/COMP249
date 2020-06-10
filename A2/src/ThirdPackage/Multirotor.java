// -----------------------------------------------------
// Assignment 2 
// Question: 
// Written by: Le Cherng Lee. 40122814
//------------------------------------------------------
package ThirdPackage;

import SecondPackage.Helicopter;

/**
 *
 * @author Le Cherng
 */
public class Multirotor extends Helicopter{
    private int NumberOfRotors;
    
    //constructors
    public Multirotor()
    {
        super();
        NumberOfRotors=0;
    }
    
    public Multirotor(String B, double P, int HP,int NOC, int CY, int PC, int NOR)
    {
        super(B,P,HP, NOC, CY, PC);
        NumberOfRotors=NOR;
    }
    public Multirotor(Multirotor C)
    {
        super(C);
        NumberOfRotors=C.GetNumberOfRotors();
    }
    public int GetNumberOfRotors()
    {
        return NumberOfRotors;
    }
    
    public void SetNumberOfRotors(int NOR)
    {
        NumberOfRotors= NOR;
    }
    
    
    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        return "This Multirotor Brand is "+GetBrand()+"\nPrice is "+GetPrice()+"\nNumber of Cylinders is "+GetNumberOfCylinders()
                +"\nCreation Year is "+GetCreationYear()+"\nPassenger Capacity is "+ GetPassengerCapacity()+"\nNumber of Rotors are "+NumberOfRotors;
    }
    
    public boolean equals(Multirotor C)
    {
        if(C==null)
        {
            return false;
        }else
        {
            return this.GetBrand().equals(C.GetBrand()) && this.GetPrice() == C.GetPrice() && this.GetHorsePower()==C.GetHorsePower()
                    && this.GetNumberOfCylinders()== C.GetNumberOfCylinders() && this.GetCreationYear() == GetCreationYear()
                    && this.GetPassengerCapacity() == C.GetPassengerCapacity() && this.NumberOfRotors == C.GetNumberOfRotors();
    
        }
    }
    
    
    
    @Override
    public Multirotor Copy() 
    {
        return new Multirotor(this);
    }
}
