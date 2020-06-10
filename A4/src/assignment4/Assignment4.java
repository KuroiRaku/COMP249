// -----------------------------------------------------
// Assignment: 4
// Part A
// Written by: Le Cherng Lee 40122814
// -----------------------------------------------------
package assignment4;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class Assignment4 {
    public static int entries;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> A = new ArrayList<String>();
        ArrayList<String> B = new ArrayList<String>();
        ArrayList<String> C = new ArrayList<String>();
        ArrayList<String> D = new ArrayList<String>();
        ArrayList<String> E = new ArrayList<String>();
        ArrayList<String> F = new ArrayList<String>();
        ArrayList<String> G = new ArrayList<String>();
        ArrayList<String> H = new ArrayList<String>();
        ArrayList<String> I = new ArrayList<String>();
        ArrayList<String> J = new ArrayList<String>();
        ArrayList<String> K = new ArrayList<String>();
        ArrayList<String> L = new ArrayList<String>();
        ArrayList<String> M = new ArrayList<String>();
        ArrayList<String> N = new ArrayList<String>();
        ArrayList<String> O = new ArrayList<String>();
        ArrayList<String> P = new ArrayList<String>();
        ArrayList<String> Q = new ArrayList<String>();
        ArrayList<String> R = new ArrayList<String>();
        ArrayList<String> S = new ArrayList<String>();
        ArrayList<String> T = new ArrayList<String>();
        ArrayList<String> U = new ArrayList<String>();
        ArrayList<String> V = new ArrayList<String>();
        ArrayList<String> W = new ArrayList<String>();
        ArrayList<String> X = new ArrayList<String>();
        ArrayList<String> Y = new ArrayList<String>();
        ArrayList<String> Z = new ArrayList<String>();
        //super unoptimised :p this work with my brain anyways XP
        ArrayList<String> altogether = new ArrayList<String>();
        try {
            String[] test =null;
            String test1=null;
            Scanner inputStream = new Scanner(new FileInputStream("PersonOfTheCentury.txt"));
            PrintWriter outputStream = new PrintWriter(new FileOutputStream("MUahahaha.txt",false));
            while(inputStream.hasNext()){
                test1=inputStream.next().toUpperCase();
                if(test1.equals("MC�")){
                    System.out.println("Detected! Honor Greatest Scientist");
                    if(M.contains(test1)){
                        System.out.println("It exists uwu");
                        }else{
                        sortAdd(M, test1);
                        System.out.println("It was added :P");
                    }
                }else{
                    test=test1.replaceAll("[=,.!?/:;]", " ").split("[�']");
                    System.out.println(test[0]);
                    if(hasNums(test[0]) || test[0].length()==1){
                        System.out.println("FOundNum");
                        switch (test[0]) {
                            case "A":
                                System.out.println("Found A");
                                if(A.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(A, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }   break;
                            case "I":
                                System.out.println("Found I");
                                if(I.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(I, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }   break;
                            default:
                                System.out.println("These characters won't be registered :p");
                                break;
                        }
                    }else{
                        char forTest=test[0].charAt(0);
                        test[0]= test[0].trim();
                        switch(forTest){
                            case 'A':
                                System.out.println("Detected!");
                                if(A.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(A, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'B':
                                if(B.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(B, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'C':
                                if(C.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(C, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'D':
                                if(D.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(D, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'E':
                                if(E.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(E, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'F':
                                if(F.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(F, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'G':
                                if(G.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(G, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'H':
                                if(H.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(H, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'I':
                                if(I.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(I, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'J':
                                if(J.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(J, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'K':
                                if(K.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(K, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'L':
                                if(L.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(L, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'M':
                                if(M.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(M, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'N':
                                if(N.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(N, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'O':
                                if(O.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(O, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'P':
                                if(P.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(P, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'Q':
                                if(Q.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(Q, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'R':
                                if(R.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(R, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'S':
                                if(S.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(S, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'T':
                                if(T.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(T, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'U':
                                if(U.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(U, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'V':
                                if(V.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(V, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'W':
                                if(W.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(W, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'X':
                                if(X.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(X, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'Y':
                                if(Y.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(Y, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            case 'Z':
                                if(Z.contains(test[0])){
                                    System.out.println("It exists uwu");
                                }else{
                                    sortAdd(Z, test[0]);
                                    System.out.println("It was added :P");
                                    entries++;
                                }
                                break;
                            default:
                                break;
                        }   
                    }  
                }  
            }
            inputStream.close();
            outputStream.println("The document produced this sub-dictionary, which includes "+entries+" entries.");
            if(A.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("A\n==\n");
                A.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(B.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("B\n==\n");
                B.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(C.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("C\n==\n");
                C.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(D.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("D\n==\n");
                D.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(E.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("E\n==\n");
                E.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(F.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("F\n==\n");
                F.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(G.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("G\n==\n");
                G.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(H.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("H\n==\n");
                H.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(I.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("I\n==\n");
                I.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(J.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("J\n==\n");
                J.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(K.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("K\n==\n");
                K.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(L.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("L\n==\n");
                L.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(M.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("M\n==\n");
                M.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(O.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("O\n==\n");
                O.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(P.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("P\n==\n");
                P.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(Q.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("Q\n==\n");
                Q.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(R.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("R\n==\n");
                R.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(S.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("S\n==\n");
                S.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(T.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("T\n==\n");
                T.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(U.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("U\n==\n");
                U.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(V.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("V\n==\n");
                V.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(W.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("W\n==\n");
                W.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(X.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("X\n==\n");
                X.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            if(Y.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("Y\n==\n");
                Y.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }if(Z.isEmpty()){
                System.out.println("MEhhhh");
            }else{
                outputStream.println("Z\n==\n");
                Z.forEach((i) -> {
                System.out.println(i);
                outputStream.println(i);
                });
            }
            outputStream.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Filenotfound :P");
        }
    }
    public static ArrayList<String> sortAdd(ArrayList<String> test, String toUpperCase){
        int index = test.size();
            for (int i = 0; i < test.size(); i++) {
                if (test.get(i).compareTo(toUpperCase) > 0) {
                  index = i;
                 break;
            }
        }
            test.add(index, toUpperCase);
            return test;
        
    }
    
    public static boolean hasNums(String str) {
        char[] nums = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        char[] toChar = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            toChar[i] = str.charAt(i);
            for (int j = 0; j < nums.length; j++) {
                if (toChar[i] == nums[j]) { return true; }
            }
        }
        return false;
    }
}
