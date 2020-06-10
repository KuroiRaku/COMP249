// -----------------------------------------------------
// Assignment: 4
// 
// Written by: Le Cherng Lee 40122814
// -----------------------------------------------------
package assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * @author Le Cherng
 */
public class Assignment3 {

    /**
     * @param args the command line arguments
     */
    public static int fileInvalid=0;
    public static void main(String[] args)  {
        String fileName="";
        
        for(int i=0; i<10;i++){
            int j=i+1;
            fileName = "bib/Latex"+j+".BIB";
            processFilesForValidation(fileName,j);
            
        }
        System.out.println("There are total of "+ fileInvalid+" invalid files");
        int terminateNumber=0;
        while(true){
            System.out.println("\nPlease enter the filenames that you want to review! Press 0 to exit!");
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            if(userInput.equals("0")){
                System.out.println("Thanks for using the software");
                break;
            }
            File fold = new File("Output/"+userInput);
            if(!fold.exists()){
                System.out.println("Files does not exist! Please check the filename again");
                terminateNumber++;
            }else{
                readFile(userInput);
                terminateNumber=0;
            }
            if(terminateNumber ==3){
                System.out.println("Please stop messing around :P The program will terminate");
                System.exit(0);
            }
        }
            
        
    }
    
    public static void processFilesForValidation(String fileName, int LatexNo){
        
        try {
                Scanner inputStream = new Scanner(new FileInputStream(fileName));
                String author="";
                String journal="";
                String title = "";
                String year="";
                String volume="";
                String number="";
                String pages="";
                String keywords="";
                String doi="";
                String ISSN="";
                String month="";
                int articlesNumber=0;
                System.out.println("\n\n"+ fileName);
                while(inputStream.hasNextLine()){
                    String emptyChecker = inputStream.nextLine();
                    if(emptyChecker.trim().equals("") || emptyChecker.equals("}")){
                        System.out.println("It is empty");
                    }else{
                        String []temp= emptyChecker.split("[={}@]");
                        temp = Arrays.stream(temp).filter(s ->(s !=null & s.length()>0)).toArray(String[]::new);
                        System.out.println(temp[0]);
                        switch (temp[0]) {
                            case "ARTICLE":
                                articlesNumber++;
                                System.out.println("Articles No."+articlesNumber);
                                break;
                            case "author":
                                if(temp[1].trim().equals(",")){
                                    System.out.println("Empty Fields!");
                                    
                                    throw new FileInvalidException(fileName, "author");
                                }else{
                                    if(temp[1].contains("and")){
                                    String moretemp2 [] = temp[1].trim().split("and");
                                    System.out.println(moretemp2[1]);
                                    for(int s=0;s <moretemp2.length;s++ ){
                                        if(s==moretemp2.length-1){
                                            author+=moretemp2[s];
                                        }else{
                                            author+=  moretemp2[s] +",";
                                        }
                                    }
                                    author += "$";
                                    System.out.println(author);
                                }else{
                                        author+=temp[1]+"$";
                                    }
                                    
                                }
                                   break;
                            case "title":
                                if(temp[1].trim().equals(",")){
                                    System.out.println("Empty Fields!");
                                    
                                    throw new FileInvalidException(fileName, "journal");
                                }else{
                                    title+= temp[1] + "$";
                                }
                                break;       
                            case "journal":
                                if(temp[1].trim().equals(",")){
                                    System.out.println("Empty Fields!");
                                    
                                    throw new FileInvalidException(fileName, "journal");
                                }else{
                                    journal+= temp[1] + "$";
                                }
                                break;
                            case "year":
                                if(temp[1].trim().equals(",")){
                                    System.out.println("Empty Fields!");
                                    
                                    throw new FileInvalidException(fileName, "year");
                                }else{
                                    year += temp[1] +"$";
                                }
                                break;
                            case "volume":
                                if(temp[1].trim().equals(",")){
                                    System.out.println("Empty Fields!");
                                    
                                    throw new FileInvalidException(fileName, "volume");
                                }else{
                                    volume+= temp[1] +"$";
                                }
                                break;
                            case "number":
                                if(temp[1].trim().equals(",")){
                                    System.out.println("Empty Fields!");
                                    
                                    throw new FileInvalidException(fileName, "number");
                                }else{
                                    number+= temp[1] +"$";
                                }
                                break;
                            case "pages":
                                if(temp[1].trim().equals(",")){
                                    System.out.println("Empty Fields!");
                                    
                                    throw new FileInvalidException(fileName, "pages");
                                }else{
                                    pages+= temp[1]+"$";
                                }
                                break;
                            case "keywords":
                                if(temp[1].trim().equals(",")){
                                    System.out.println("Empty Fields!");
                                    
                                    throw new FileInvalidException(fileName, "month");
                                }else{
                                    keywords+= temp[1]+"$";
                                }
                                break;
                            case "doi":
                                if(temp[1].trim().equals(",")){
                                    System.out.println("Empty Fields!");
                                    
                                    throw new FileInvalidException(fileName, "month");
                                }else{
                                    doi+= temp[1]+"$";
                                }
                                break;
                            case "ISSN":
                                if(temp[1].trim().equals(",")){
                                    System.out.println("Empty Fields!");
                                    
                                    throw new FileInvalidException(fileName, "month");
                                }else{
                                    ISSN+= temp[1]+"$";
                                }
                                break;
                            case "month":
                                if(temp[1].trim().equals(",")){
                                    System.out.println("Empty Fields!");
                                    
                                    throw new FileInvalidException(fileName, "month");
                                }else{
                                    month+= temp[1]+"$";
                                    System.out.println("Month for article No."+articlesNumber+" is "+ month);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
                File fnew =new File("Output/IEEE"+LatexNo+".json");
                fnew.getParentFile().mkdir();
                String[] inputAuthor = author.split("[$]");
                String[] inputJournal = journal.split("[$]");
                String[] inputTitle = title.split("[$]");
                String[] inputYear= year.split("[$]");
                String[] inputVolume= volume.split("[$]");
                String[] inputNumber= number.split("[$]");
                String[] inputPages= pages.split("[$]");
                String[] inputKeywords= keywords.split("[$]");
                String[] inputDoi= doi.split("[$]");
                String[] inputISSN= ISSN.split("[$]");
                String[] inputMonth= month.split("[$]");
                String[] authorACM=null;
                String outputACM =null;
                String outputNU =null;
                String authorNU=null;
                System.out.println(Arrays.toString(inputMonth));
                //ieee
                for(int i=0;i< articlesNumber;i++){
                    String output = inputAuthor[i]+". \""+inputTitle[i]+"\", "+inputJournal[i] 
                            + ", vol. "+ inputVolume[i]+", no. "+inputNumber[i]+", p. "+inputPages[i] +
                            ", "+inputMonth[i]+" "+inputYear[i]+".";
                    System.out.println(output);
                    authorACM = inputAuthor[i].split(",");
                    int j =i+1;
                    if(authorACM.length==1){
                        outputACM= "["+j+"]\t"+authorACM[0]+". "+ inputYear[i]+". "+ inputTitle[i]
                                +". "+inputJournal[i]+". "+inputVolume[i]+", "+inputNumber[i]+ " ("+ inputYear[i]
                                +"), "+inputPages[i]+". DOI:https//doi.org/"+inputDoi[i]+'.';
                        
                    }else{
                        outputACM= "["+j+"]\t"+authorACM[0]+" et al. "+ inputYear[i]+". "+ inputTitle[i]
                                +". "+inputJournal[i]+". "+inputVolume[i]+", "+inputNumber[i]+ '('+ inputYear[i]
                                +"), "+inputPages[i]+". DOI:https//doi.org/"+inputDoi[i]+'.';
                        
                    }
                    
                    authorNU= inputAuthor[i].replace(',', '&');
                    outputNU= authorNU+". "+inputTitle[i]+". "+inputJournal[i]+". "+inputVolume[i]
                            +". "+inputPages[i]+'('+inputYear[i]+").";
                    System.out.println(outputNU);
                    
                    try{
                        PrintWriter outputStream = new PrintWriter(new FileOutputStream("Output/IEEE"+LatexNo+".json",true));
                        PrintWriter outputStream2 = new PrintWriter(new FileOutputStream("Output/ACM"+LatexNo+".json",true));
                        PrintWriter outputStream3= new PrintWriter(new FileOutputStream("Output/NU"+LatexNo+".json",true));
                        outputStream.println(output +"\n");
                        outputStream2.println(outputACM+"\n");
                        outputStream3.println(outputNU+"\n");
                        outputStream2.println();
                        outputStream3.close();
                        outputStream2.close();
                        outputStream.close();
                    }catch(FileNotFoundException e){
                        
                    }
                }
                //something
                inputStream.close();
                } catch (FileNotFoundException ex) {
                    System.out.println("Could not open input file "+fileName +" for reading" );
                    System.out.println("\nPlease check if file exists! Program will terminate after closing any opened files.");
                    for(int i=LatexNo; i>0;i--){
                        System.out.println("Delete");
                        File fold1 = new File("Output/IEEE"+i+".json");
                        File fold2 = new File("Output/ACM"+i+".json");
                        File fold3 = new File("Output/NU"+i+".json");
                        if(fold1.delete()){
                            System.out.println(fold1.getName() +"is deleted");
                        }else{
                            System.out.println("File don't exist");
                        }
                        if(fold2.delete()){
                            System.out.println(fold2.getName() +"is deleted");
                        }else{
                            System.out.println("File don't exist");
                        }
                        if(fold3.delete()){
                            System.out.println(fold3.getName() +"is deleted");
                        }else{
                            System.out.println("File don't exist");
                        }
                    }
                    System.exit(0);
                }catch (FileInvalidException e){
                    fileInvalid++;
                }
    }
    
    public static void readFile(String fileName){
        try{
            FileReader reader = new FileReader("Output/"+fileName);
            BufferedReader inputStream = new BufferedReader(reader);
            String line;
            while ((line = inputStream.readLine()) != null) {
                System.out.println(line);
            }
        }catch(IOException e){
            System.err.format("Error");
        }
    }
}
