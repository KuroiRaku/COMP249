// -----------------------------------------------------
// Assignment 2 
// Question: 
// Written by: Le Cherng Lee. 40122814
//------------------------------------------------------
package Driver;



//I dont understand what the questioin want for part 2, so I create two different driver classes which is this one and flying object, please check flying object 
//if this isn't what the question wants
//this works :D
import static Driver.Driver.Brand.RandomBrand;
import FirstPackage.Airplane;
import SecondPackage.Helicopter;
import SecondPackage.Quadcopter;
import ThirdPackage.Multirotor;
import FourthPackage.UAV;
import FifthPackage.AgriculturalDrone;
import FifthPackage.MAV;

import java.util.*;

/**
 *
 * @author Le Cherng
 */


public class Driver {
    
    //I think the question doesn't want us to find the name for the class :(
    public static Object[] CopyFlyingObjects(Object[] C) {
        Object[] Copy = new Object[C.length];
        for (int I = 0; I < C.length; I++) {
            if(C[I] instanceof Airplane){
                Copy[I] = new Airplane((Airplane) C[I]);
            }else if(C[I] instanceof Helicopter){
                Copy[I]= new Helicopter((Helicopter)C[I]);
            }else if(C[I] instanceof Quadcopter){
                Copy[I]= new Quadcopter((Quadcopter)C[I]);
            }else if(C[I] instanceof Multirotor){
                Copy[I]= new Multirotor((Multirotor)C[I]);
            }else if(C[I] instanceof UAV){
                Copy[I]= new UAV((UAV)C[I]);
            }else if(C[I] instanceof MAV){
                Copy[I]= new MAV((MAV)C[I]);
            }else if(C[I] instanceof AgriculturalDrone){
                Copy[I]= new AgriculturalDrone((AgriculturalDrone)C[I]);
            }else{
                /*
                //you cant use this :(
                Copy[I]= new Object(C[I]);
                */
            }
            
        }
        return Copy;
    }
    //OMG PLEASE KILL ME
    //Find the name for each class then implement their methods
    //sadly this way isn't optimised
    //using string, cause you need to return two different price and is easier to just print the message along with the result :D
    public static String FindCheapestPrice(Object[] C)
    {
        String MethodName = "GetPrice";
        double SumOfPrice=0;
        //initialise cheapest price to a price that is unrealistically big so that it can get replaced by cheaper price
        //do not initialise to zero
        double CheapestPrice=1000000000;
        double SecondCheapestPrice=1000000000;
        for (Object C1 : C) {
            //find each classes using instance of and replace the cheapest price :D
            if (C1 instanceof Airplane) {
                Airplane Temp = new Airplane((Airplane) C1);
                SumOfPrice+=Temp.GetPrice();
                if(Temp.GetPrice()<CheapestPrice){
                    CheapestPrice = Temp.GetPrice();
                }else if(Temp.GetPrice()<SecondCheapestPrice){
                    SecondCheapestPrice = Temp.GetPrice();
                }
            } else if (C1 instanceof Helicopter) {
                Helicopter Temp = new Helicopter((Helicopter) C1);
                SumOfPrice+=Temp.GetPrice();
                if(Temp.GetPrice()<CheapestPrice){
                    CheapestPrice = Temp.GetPrice();
                }else if(Temp.GetPrice()<SecondCheapestPrice){
                    SecondCheapestPrice = Temp.GetPrice();
                }
            } else if (C1 instanceof Quadcopter) {
                Quadcopter Temp = new Quadcopter((Quadcopter) C1);
                SumOfPrice+=Temp.GetPrice();
                if(Temp.GetPrice()<CheapestPrice){
                    CheapestPrice = Temp.GetPrice();
                }else if(Temp.GetPrice()<SecondCheapestPrice){
                    SecondCheapestPrice = Temp.GetPrice();
                }
            } else if (C1 instanceof Multirotor) {
                Multirotor Temp = new Multirotor((Multirotor) C1);
                SumOfPrice+=Temp.GetPrice();
                if(Temp.GetPrice()<CheapestPrice){
                    CheapestPrice = Temp.GetPrice();
                }else if(Temp.GetPrice()<SecondCheapestPrice){
                    SecondCheapestPrice = Temp.GetPrice();
                }
            } else if (C1 instanceof UAV) {
                UAV Temp = new UAV((UAV) C1);
                SumOfPrice+=Temp.GetPrice();
                if(Temp.GetPrice()<CheapestPrice){
                    CheapestPrice = Temp.GetPrice();
                }else if(Temp.GetPrice()<SecondCheapestPrice){
                    SecondCheapestPrice = Temp.GetPrice();
                }
            } else if (C1 instanceof MAV) {
                MAV Temp = new MAV((MAV) C1);
                SumOfPrice+=Temp.GetPrice();
                if(Temp.GetPrice()<CheapestPrice){
                    CheapestPrice = Temp.GetPrice();
                }else if(Temp.GetPrice()<SecondCheapestPrice){
                    SecondCheapestPrice = Temp.GetPrice();
                }
            } else if (C1 instanceof AgriculturalDrone) {
                AgriculturalDrone Temp = new AgriculturalDrone((AgriculturalDrone) C1);
                SumOfPrice+=Temp.GetPrice();
                if(Temp.GetPrice()<CheapestPrice){
                    CheapestPrice = Temp.GetPrice();
                }else if(Temp.GetPrice()<SecondCheapestPrice){
                    SecondCheapestPrice = Temp.GetPrice();
                }
            }
        }
        return"Sum Of Price is "+ SumOfPrice+"\nCheapest Price is "+ CheapestPrice +"\nSecond Cheapest Price is "+ SecondCheapestPrice;
    }

    //the program will choose a random brand from here
    public enum Brand {
        Yamaha, Ghoul, Hugo, Raku, Mitsubishi, Airbus;

        public static String RandomBrand() {
            int Pick = new Random().nextInt(Brand.values().length);
            return Brand.values()[Pick].toString();
        }
    }

    //giving different constructors using random list
    public static void RandomListOfObjects(Object[] C) {
        for (int I = 0; I < C.length; I++) {
            Random Random = new Random();
            int RandomInt = Random.nextInt(7) + 1;
            //based on the random integer generated by the computer, the array will be given with different classes
            //random variables below :D
            String RandomBrand = RandomBrand();
            int RandomHorsePower = RandomInt * 100;
            double RandomPrice = Random.nextDouble() * RandomInt * 100;
            int RandomCreationYear = RandomInt + 2000;
            System.out.println(RandomInt);
            switch (RandomInt) {
                case 1:
                    C[I] = new Airplane(RandomBrand, RandomPrice, RandomHorsePower);
                    break;
                case 2:
                    C[I] = new Helicopter(RandomBrand, RandomPrice, RandomHorsePower, RandomInt, RandomCreationYear, RandomInt);
                    break;
                case 3:
                    C[I] = new Quadcopter(RandomBrand, RandomPrice, RandomHorsePower, RandomInt, RandomCreationYear, RandomInt, RandomHorsePower);
                    break;
                case 4:
                    C[I] = new Multirotor(RandomBrand, RandomPrice, RandomHorsePower, RandomInt, RandomCreationYear, RandomInt, RandomInt);
                    break;
                case 5:
                    //random creation year is for the weight
                    C[I] = new UAV(RandomCreationYear, RandomPrice);
                    break;
                case 6:
                    C[I] = new AgriculturalDrone(RandomCreationYear, RandomPrice, RandomBrand, RandomInt);
                    break;
                case 7:
                    C[I] = new MAV(RandomCreationYear, RandomPrice, RandomBrand, RandomInt);
                    break;
            }
        }
    }

    public static void main(String args[]) {
        Object[] FlyingObjects = new Object[15];
        //randomly initialise them =.=
        RandomListOfObjects(FlyingObjects);
        Object[] FlyingObjectsCopy = CopyFlyingObjects(FlyingObjects);
        System.out.println(FlyingObjects[2].getClass());
        System.out.println(FlyingObjects[0]);
        System.out.println(FlyingObjectsCopy[1].equals(FlyingObjects[1]));
        System.out.println("\n\n\n\n");
        System.out.println(FlyingObjects[1].toString());
        System.out.println("\n\n\n\n");
        System.out.println(FlyingObjectsCopy[1].toString());
        System.out.println("\n\n\n\n");
        //Array tosString will print use the function of the classes :D 
        System.out.println(Arrays.toString(FlyingObjectsCopy));
        System.out.println("\n\n\n\n");
        System.out.println(Arrays.toString(FlyingObjects));
        //cheapest price for flying object
        System.out.println(FindCheapestPrice(FlyingObjects));
        System.out.println(FindCheapestPrice(FlyingObjectsCopy));
        FlyingObjects[1] = new UAV(); 
        System.out.println(FlyingObjects[1].toString());
    }

}
