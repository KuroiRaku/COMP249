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
public class Helicopter extends Airplane{
    
    private int NumberOfCylinders;
    private int CreationYear;
    private int PassengerCapacity;
    
    public Helicopter()
    {
        super();
        NumberOfCylinders =0;
        CreationYear=0;
        PassengerCapacity=0;
    }
    public Helicopter(String B, double P,int HP, int NOC, int CY, int PC)
    {
        super(B, P, HP);
        NumberOfCylinders =NOC;
        CreationYear=CY;
        PassengerCapacity=PC;
    }
    
    public Helicopter(Helicopter C)
    {
        super(C);
        NumberOfCylinders =C.GetNumberOfCylinders();
        CreationYear=C.GetCreationYear();
        PassengerCapacity=C.GetPassengerCapacity();
    }
    public int GetNumberOfCylinders()
    {
        return NumberOfCylinders;
    }
    public int GetCreationYear()
    {
        return CreationYear;
    }
    public int GetPassengerCapacity()
    {
        return PassengerCapacity;
    }
    
    public void SetNumberOfCylinders(int NOC)
    {
        NumberOfCylinders= NOC;
    }
    
    public void SetCreationYear(int CY)
    {
        CreationYear= CY;
    }
    public void SetPassengerCapacity(int PC)
    {
        PassengerCapacity= PC;
    }
    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        return "This Helicopter's Brand is "+GetBrand()+"\nPrice is "+GetPrice()+"\nHorse Power is "+GetHorsePower()
                +"\nNumber of Cylinders are "+NumberOfCylinders+"\nCreationYear is "+CreationYear
                +"Passenger Capacity is "+PassengerCapacity;
    }
    
    public boolean equals(Helicopter C)
    {
        if(C == null){
            return false;
        }else
        {
            return this.GetBrand().equals(C.GetBrand()) && this.GetPrice() == C.GetPrice() && this.GetHorsePower()==C.GetHorsePower()
                    && this.NumberOfCylinders== C.GetNumberOfCylinders() && this.CreationYear == C.GetCreationYear()
                    && this.PassengerCapacity == C.GetPassengerCapacity();
        }
    }
    
   
    
    public Helicopter Copy() 
    {
        return new Helicopter(this);
    }
}
