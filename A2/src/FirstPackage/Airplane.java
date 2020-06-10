// -----------------------------------------------------
// Assignment 2 
// Question: 
// Written by: Le Cherng Lee. 40122814
//------------------------------------------------------
package FirstPackage;
import Driver.FlyingObject;

/**
 *
 * @author Le Cherng
 */
public class Airplane extends FlyingObject {
    private String Brand;
    private double Price;
    private int HorsePower;
    
    public Airplane()
    {
        Brand ="";
        Price = 0.0;
        HorsePower= 0;
    }
    public Airplane(String Brand, double Price, int HorsePower)
    {
        this.Brand= Brand;
        this.Price = Price;
        this.HorsePower= HorsePower;
    }
    
    public Airplane(Airplane C)
    {
        this.Brand = C.GetBrand();
        this.Price= C.GetPrice();
        this.HorsePower= C.GetHorsePower();
    }
    
    public String GetBrand()
    {
        return Brand;
    }
    
    @Override
    public double GetPrice()
    {
        return Price;
    }
    
    public int GetHorsePower()
    {
        return HorsePower;
    }
    
    public void SetBrand(String B)
    {
        Brand = B;
    }
    
    public void SetPrice(double P)
    {
        Price= P;
    }
    
    public void SetHorsePower(int HP)
    {
        HorsePower = HP;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        return "This Airplane's Brand is "+Brand+"\nPrice is "+Price+"\nHorse Power is "+HorsePower;
    }
    
    
 
    
    public boolean equals(Airplane C)
    {
        if(C==null){
            return false;
        }else
        {
            return this.Brand.equals(C.GetBrand()) && this.Price==C.GetPrice() && this.HorsePower==C.GetHorsePower();
        }
    }
    
  
    @Override
    public Airplane Copy() 
    {
        return new Airplane(this);
    }
}
