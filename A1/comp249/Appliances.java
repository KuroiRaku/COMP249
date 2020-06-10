// -----------------------------------------------------
// Assignment 1 
// Question: 
// Written by: Le Cherng Lee. 40122814
//------------------------------------------------------
package comp249;



import java.util.Scanner;


public class Appliances {
/** 
 *
 * @author Le Cherng Lee 40122814
 * this program register appliances in a program, user can access the details of the appliances
 * and people who have password can modifies it.
 * Name(s) and ID(s) (include full names and IDs)
 * COMP249
 * Assignment # (include the assignment number)
 * Due Date (include the due date for this assignment)
 */
    //using Pascal code convention
    private String Type;
    private String Brand;
    private long SerialNumber;
    private double Price;
    private static int NumberOfCreatedAppliances=0;
    static double LowestPrice=1;
    private final static String Password ="c249";
    
    enum AcceptedType{
        //enum for list of types of products, Coders can also directly add new Accepted type here
        AIRCONDITIONER, WASHER, DRYER, FREEZER, STOVE, DISHWASHER, WATERHEATERS, MICROWAVE;
        //ideally I should follow pascal code convention throughout and uses another method to convert everythint=g to either lowercase or uppercase
    }
    
    public Appliances(){
        Type = "Unknown";
        Brand = "Unknown";
        SerialNumber= 0;
        Price= 1.0;
        //NumberOfCreatedAppliances++;
        //default constructor are usually just to prevent error in the program... I won't consider it as a created appliances
    }
    public Appliances(String Type, String Brand, long SerialNumber, double Price){
        this.Type= Type;
        this.Brand = Brand;
        this.SerialNumber=SerialNumber;
        this.Price=Price;
        NumberOfCreatedAppliances++;
    }
    public String GetType(){
        return Type;
    }
    
    public String GetBrand(){
        return Brand;
    }
    public double GetPrice(){
        return Price;
    }
    public long GetSerialNumber(){
        return SerialNumber;
    }
    public String ToString(){
        //the format are simply just using tab and new line
        return "\nType: "+Type+"\nBrand: "+Brand+"\nSerial Number: "+SerialNumber+"\nPrice: "+Price;
    }
    public static int FindNumberOfCreatedAppliances(){
        return NumberOfCreatedAppliances;
    }
    
    public boolean Equals(Appliances B){
        return this.Brand.equals(B.Brand) && this.Type.equals(B.Type) && this.Price==B.Price;
    }
    
    public static boolean Contains(String UserType) {
    for (AcceptedType T : AcceptedType.values()) {
        if (T.name().equals(UserType)) {
            return true;
        }
    }
    return false;
    }
    //mutators
    public void SetType(String Type){
        this.Type = Type;
    }
    public void SetBrand(String Brand){
        this.Brand = Brand;
    }
    public void SetPrice(double Price){
        this.Price= Price;
    }
    public static void main(String[] args) throws InterruptedException{
        boolean Continue = true;
        Scanner Input = new Scanner(System.in);
        int Count = 0;
        int IllegalInput=0;
        //welcome message
        System.out.println("Hi Welcome to Inventory Software written by Le Cherng Lee!");
        System.out.println("What's the maximum number of appliances your store can contain?");
        //promp user to enter their store capacity 
        int MaxAppliances = Input.nextInt();
        Input.nextLine();
        //Input next Line is needed to chip away the extra line due to Input..nextInt
        Appliances Inventory[]= new Appliances[MaxAppliances];
        while (Continue){
            if(IllegalInput==4){
                //When user have failed too mamy times, the program will terminate.. To be honest, the hacker can still reboot the
                //program and start again..... 
                System.out.println("Program detected suspicious activities and will terminate immediately");
                System.exit(0);
            }
            //menu
            System.out.println("What do you want to do?");
            System.out.println("\t1\tEnter new appliances(password required)");
            System.out.println("\t2\tChange information of an appliance(password required)");
            System.out.println("\t3\tDisplay all appliances by a specific brand");
            System.out.println("\t4\tDisplay all appliances under a certain a price");
            System.out.println("\t5\tQuit");
            System.out.println("Please enter your choice: ");
            int Choice = Input.nextInt();
            Input.nextLine();
            //when there's no created appliances, user can only pick 1 or 5
            while(FindNumberOfCreatedAppliances()==0 && Choice !=1 &&Choice!=5){
                //I can use a method to show the Menu to optimised it, but Im too lazy 
                System.out.println("Please create appliances before you proceed");
                System.out.println("What do you want to do?");
                System.out.println("\t1\tEnter new appliances(password required)");
                System.out.println("\t2\tChange information of an appliance(password required)");
                System.out.println("\t3\tDisplay all appliances by a specific brand");
                System.out.println("\t4\tDisplay all appliances under a certain a price");
                System.out.println("\t5\tQuit");
                System.out.println("Please enter your choice: ");
                Choice = Input.nextInt();
                Input.nextLine();
            }
            switch (Choice){
                //method for creating new appliances
                case 1:
                    //Count will be reset everytime the user decide not to troll. 
                    Count=0;
                    int Attempt =0;
                    //OUTER are used so during the switch statement in a loop, the break will allow user to break
                    OUTER:
                    while (Attempt<3) {
                        System.out.print("Please Enter the Password to access the system or press 0 to quit: ");
                        String UserInput = Input.nextLine();
                        switch (UserInput) {
                            case Password:
                                System.out.println("\nAccess Granted");
                                //reset the failed attempts
                                Attempt =0;
                                IllegalInput =0;
                                System.out.println("How many appliances you want to Enter?");
                                int UserNewAppliances = Input.nextInt();
                                Input.nextLine();
                                if(UserNewAppliances > Inventory.length){
                                    //when the user enter the amount of item is more than the storage
                                    System.out.println("There is not enough storage");
                                }else{
                                    int NotEmpty =FindNumberOfCreatedAppliances();
                                    if(UserNewAppliances + NotEmpty > Inventory.length){
                                        //when the user enter the amount of item is less than the storage but existing appliances take up the space and causes user doesn't have enough storage to put it.
                                        System.out.println("There isn't enough storage");
                                        System.out.println("There's only "+ (Inventory.length-NotEmpty)+ " spaces left");
                                    }else{
                                        //Create new appliances
                                        for(int I=0; I<UserNewAppliances; I++){
                                            //I as zero is vital
                                            //prompt user to input brand, type and price
                                            //all the brand and type will be uppercase for comparison
                                            System.out.println("Enter Brand of item No."+(I+1));
                                            String UserBrand = Input.nextLine();
                                            UserBrand= UserBrand.replaceAll("\\s","").toUpperCase();
                                            System.out.println("Enter Type of item "+ (I+1));
                                            String UserType = Input.nextLine();
                                            UserType = UserType.replaceAll("\\s","").toUpperCase();
                                            while(Contains(UserType)==false){
                                                System.out.println("Please Enter a valid type for the item");
                                                UserType = Input.nextLine();
                                                UserType=UserType.replaceAll("\\s","").toUpperCase();
                                            }
                                            System.out.println("Enter Price of item "+ (I+1));
                                            double Price = Input.nextDouble();
                                            Input.nextLine();
                                            //nextline is to remove additional line due to nextInt
                                            //Seriously, why doesn't jajva fix this?
                                            while (Price<LowestPrice){
                                                System.out.println("Please enter a legal price");
                                                Price = Input.nextDouble();
                                                Input.nextLine();
                                            }
                                            if(Inventory[0]==null){
                                                //for the first item created, the program will created the very first UserSerial
                                                long UserSerial = 1000000;
                                                Inventory[0]= new Appliances(UserType, UserBrand, UserSerial, Price);
                                                System.out.println("First Appliance registered");
                                            }else{
                                                //For the upcoming items, the program will use the serial number from its previous item
                                                long UserSerial = Inventory[NotEmpty+I-1].GetSerialNumber()+1;
                                                Inventory[NotEmpty+I]= new Appliances(UserType, UserBrand, UserSerial, Price);
                                                System.out.println("New Appliances registered");
                                            }  
                                        }
                                    }
                                }
                                break;
                            case "0":
                                //User can quit to main menu using this command
                                break OUTER;
                            default:
                                //Wrong password message
                                System.out.println("\nYou have entered the wrong password");
                                Attempt ++;
                                break;
                        }
                    }
                    IllegalInput++;
                    break;
                case 2:
                    int Attempt2 =0;
                    Count=0;
                    boolean ProductNotFound= true;
                    OUTER_1:
                    while (Attempt2<3) {
                        System.out.print("Please Enter the Password: or press 0 to exit");
                        String UserInput = Input.nextLine();
                        switch (UserInput) {
                            case Password:
                                System.out.println("\nAccess Granted");
                                //reset the failed attempts
                                Attempt2 =0;
                                boolean Continue2 = true;
                                while(Continue2){
                                    System.out.println("Please Enter the Serial Number of the products you wish to change"
                                            + " Or press 0 to exit");
                                    Long UserSerial = Input.nextLong();
                                    Input.nextLine();
                                    if(UserSerial ==0){
                                        Continue2=false;
                                    }else{
                                        for(int I = 0; I< Inventory.length;I++){
                                            if(UserSerial== Inventory[I].GetSerialNumber()){
                                                System.out.println("We have found the product");
                                                ProductNotFound=false;
                                                boolean Update= true;
                                                while(Update){
                                                    //Player can keep modifying the details of the products until they pressed 4 to quit
                                                    Inventory[I].ToString();
                                                    System.out.println("What information would you like to change?");
                                                    System.out.println("\t1.\tbrand \t2.\t type \t3.\t price \t4.\t Quit");
                                                    System.out.print("Enter your choice: ");
                                                    int UserChoice = Input.nextInt();
                                                    Input.nextLine();
                                                    //Once again, nextLine to consume additional line due to NextInt
                                                    String UserInput2;
                                                    switch (UserChoice){
                                                        case 1:
                                                            System.out.println("Please enter the new brand you wish to put");
                                                            UserInput2 = Input.nextLine();
                                                            //By doing this, even space or lowercase or uppercase from input won't matter
                                                            UserInput2=UserInput2.replaceAll("\\s","").toUpperCase();
                                                            Inventory[I].SetBrand(UserInput2);
                                                            break;
                                                        case 2:
                                                            System.out.println("Please enter the new type you wish to put");
                                                            UserInput2 = Input.nextLine();
                                                            //By doing this, even space or lowercase or uppercase from input won't matter
                                                            UserInput2=UserInput2.replaceAll("\\s","").toUpperCase();
                                                            while(Contains(UserInput2)==false){
                                                                System.out.println("Please Enter a valid type for the item");
                                                                UserInput2 = Input.nextLine();
                                                                UserInput2=UserInput2.replaceAll("\\s","").toUpperCase();
                                                            }
                                                            Inventory[I].SetType(UserInput2);
                                                            break;
                                                        case 3:
                                                            System.out.println("Please enter the new price you wish to put");
                                                            double Price = Input.nextDouble();
                                                            Input.nextLine();
                                                            //User can't enter the price lower than the lowest price
                                                            //Lowest price can be modified 
                                                            while (Price<LowestPrice){
                                                                System.out.println("Please enter a legal price");
                                                                Price = Input.nextDouble();
                                                                Input.nextLine();
                                                            }
                                                            Inventory[I].SetPrice(Price);
                                                            break;
                                                        case 4:
                                                            //Quit to break through from the loop
                                                            Update = false;
                                                            break;
                                                        default:
                                                            System.out.println("Please Enter a valid choice");
                                                            break;
                                                    }
                                                }
                                            }
                                        }
                                        if(ProductNotFound){
                                            System.out.println("Sorry there's no such item with the serial number you have entered");
                                            System.out.println("Do you wish to reenter Serial Number(Press 1) or quit?(Press 2)");
                                            int UserInput2 = Input.nextInt();
                                            //this is for consuming the nextline due to .nextInt
                                            Input.nextLine();
                                            switch (UserInput2) {
                                                case 1:
                                                //we don't need to do anything and just let the loop go again
                                                    break;
                                                case 2:
                                                    Continue = false;
                                                    break;
                                                default:
                                                    System.out.println("Stop messing around will ya?");
                                                    break;
                                            }
                                        }
                                    }
                                }
                                break;
                            case "0":
                                //break other feels great! Replaces the break needed when switch were used.  
                                break OUTER_1;
                            default:
                                System.out.println("You have entered the wrong password, Please Try again");
                                Attempt2++;
                                break;
                        }
                    }
                    break;
                case 3:
                    //continue still can be used for optimisation
                    boolean Continue3 = true;
                    Count=0;
                    while(Continue3){
                        int ListNumber =0;
                        System.out.print("Please enter the brand of the product you wish to find!"
                                + " Or press 0 to quit!");
                        String UserInput = Input.nextLine();
                        if(UserInput.equals("0")){
                            Continue3=false;
                        }else{
                            UserInput = UserInput.replaceAll("\\s", "").toUpperCase();
                            //for some reason, I'm so damn lazy to optimise by making it a method 
                            //sigh, depends on memory speed I guess
                            for (Appliances Inventory1 : Inventory) {
                                if(Inventory1 !=null){
                                    if (Inventory1.GetBrand().equals(UserInput)) {
                                        ListNumber++;
                                        System.out.print(ListNumber+ ". ");
                                        System.out.println(Inventory1.ToString());
                                        System.out.println("\n");
                                    }
                                }
                            }
                            if(ListNumber ==0){
                                System.out.println("No such brand found :"+'(');
                            }
                        }
                    }
                    break;
                case 4:
                    Count =0;
                    boolean Continue4=true;
                    while(Continue4){
                        System.out.println("Enter a price!, Products that falls below or equal to that value will be displayed"
                            + "\nPress 0 to quit");
                        //message for the price that user wants the program to display
                        Double UserPrice = Input.nextDouble();
                        Input.nextLine();
                        if(UserPrice==0){
                            Continue4 = false;
                        }else{
                            int ListNumber = 0;
                            //for some reason, I'm so damn lazy to optimise by making it a method 
                            //sigh, depends on memory speed I guess
                            for (Appliances Inventory1 : Inventory) {
                                if (Inventory1 != null) {
                                    //is null function so that the software won't check the rest of inventory that are null
                                    if (Inventory1.GetPrice() <= UserPrice) {
                                        ListNumber++;
                                        System.out.print(ListNumber+ ". ");
                                        System.out.println(Inventory1.ToString());
                                        System.out.println("\n");
                                    }
                                }
                            }
                        }
                    }    
                    break;
                case 5:
                    //quit function
                    //Ending message
                    System.out.println("Thanks for using the program, the program will now terminate");
                    Count =0;
                    Continue = false;
                    break;
                default:
                    //just some anti troll command
                    if(Count <2){
                        System.out.println("Please enter a valid choice");
                        Count++;
                    }else if(Count <4){
                        System.out.println("Stop Fooling around, willt you?");
                        Count++;
                    }else{
                        System.out.println("You won't be able to enter anything for 5 seconds");
                        Thread.sleep(5000);
                    }
                    break;
            }
        }
        
    }
    
}

