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
public class Airport extends Structure{
    private int numberOfRunways;
    private String code;
    
    
    public Airport(int YOC, double C, int NOR, String Code) {
        super(YOC, C);
        numberOfRunways= NOR;
        code= Code;
    }
    
    public Airport(Airport C){
        super(C);
        numberOfRunways = C.getNumberOfRunways();
        code = C.getCode();
    }
    
    public int getNumberOfRunways(){
        return numberOfRunways;
    }
    
    public String getCode(){
        return code;
    }
    
    public void setNumberOfRunways(int NOR){
        numberOfRunways= NOR;
    }
    public void setCode(String C){
        code = C;
    }
    
    public Airport clone(){
        return new Airport(this);
    }
    
    
    
}
