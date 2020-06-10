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
public class MAV extends UAV{
    
    private String Model;
    private double Size;
    
     public MAV()
    {
        super();
        Model = "";
        Size =0;
    }
    
    public MAV(double W, double P, String M, int S)
    {
        super(W,P);
        Model = M;
        Size =S;
    }
    
    public MAV(MAV C)
    {
        super(C);
        this.Model = C.Model;
        this.Size =C.Size;
    }
    
    public String GetModel()
    {
        return Model;
    }
    
    public double GetSize()
    {
        return Size;
    }
    
    public void SetModel(String M)
    {
        Model = M;
    }
    
    public void SetSize(double S)
    {
        Size = S;
    }
    /**
     * 
     * 
     *
     * @return
     */
    @Override
    //Why can't i follow my own code convention :(
    public String toString()
    {
        return "This Micro Air Vehicle weight is "+ GetWeight()+"\nPrice is "+GetPrice()+"\nModel is "+Model+"/nAnd the size is "+Size;
    }
    
    public boolean equals(MAV C)
    {
        if(C==null)
        {
            return false;
        }else
        {
            return C.GetWeight() == this.GetWeight() && this.GetPrice()==C.GetPrice() && this.Model.equals(C.Model) && this.Size == C.GetSize();
        }
    }
    
    
    
    @Override
    public MAV Copy() 
    {
        return new MAV(this);
    }
    
}
