import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;


public class AdventD2P1 {
    //main method
    public static void main(String[] args) {
        try {
            int wrongPasswords = 0;
            ArrayList<Integer> lowerLim = new ArrayList<>();
            ArrayList<Integer> upperLim = new ArrayList<>();
            ArrayList<Character> specialChar = new ArrayList<>();
            ArrayList<String> password = new ArrayList<>();
            File source = new File("inputDay2.txt");
            Scanner scan = new Scanner(source);
            while (scan.hasNext()) {
                String tempString = scan.next();
                String[] temp1 = tempString.split("-");
                lowerLim.add(Integer.parseInt(temp1[0]));
                upperLim.add(Integer.parseInt(temp1[1]));
                tempString = scan.next();
                temp1 = tempString.split(":");
                specialChar.add(temp1[0].charAt(0));
                tempString = scan.next();
                password.add(tempString);
            }
            System.out.println(getCorrectPasswords(lowerLim, upperLim,specialChar, password));
        } catch (FileNotFoundException e) {
            System.out.println("Import a file, dummy");
            e.printStackTrace();
        }
    }

    public static int countChar(String str, char c) {
        int count = 0;

        for (int ik = 0; ik < str.length(); ik++) {
            if (str.charAt(ik) == c)
                count++;
        }

        return count;
    }




    public static int getCorrectPasswords(ArrayList<Integer> lowerLim, ArrayList<Integer> upperLim, ArrayList<Character> specialChar, ArrayList<String> password){
        int correctPasswords = 0;
        int wrongPasswords = 0;
        for (int ij = 0; ij < password.size(); ij++) {
            if (countChar(password.get(ij), specialChar.get(ij)) > upperLim.get(ij)) {
                wrongPasswords++;
                System.out.println("Upper Lim Violation at index: " + ij + " " + password.get(ij));
                System.out.println("Upper Lim Violation:" + lowerLim.get(ij));
                System.out.println("Upper Lim Violation:" + upperLim.get(ij));
                System.out.println("Upper Lim Violation:" + specialChar.get(ij));
            } else if (countChar(password.get(ij), specialChar.get(ij)) < lowerLim.get(ij)) {
                wrongPasswords++;
                System.out.println("Lower Lim Violation at index: " + ij + " " + password.get(ij));
                System.out.println("Lower Lim Violation:" + lowerLim.get(ij));
                System.out.println("Lower Lim Violation:" + upperLim.get(ij));
                System.out.println("Lower Lim Violation:" + specialChar.get(ij));
            } else {
                correctPasswords++;
            }
        }
        return correctPasswords;
    }
    //Helper Methods
    //public static void populate(){
    //  while (scan.hasNext()) {
    //    int value = scan.nextInt();
    //  inputArrayL.add(value);
    //}
    //}

    //public static void checkPasswords(){

    //}


}
