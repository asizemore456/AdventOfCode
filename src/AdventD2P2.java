import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;


public class AdventD2P2 {
    //main method
    public static void main(String[] args) {
        try {
            File source = new File("inputDay2.txt");
            Scanner scan = new Scanner(source);
            int correctPasswords = 0;
            int wrongPasswords = 0;
            while (scan.hasNext()) {
                String line = scan.nextLine();
                if (isCorrectPasswords(parse(line))) {
                    correctPasswords++;
                } else {
                    wrongPasswords++;
                }
            }
            System.out.println(correctPasswords);
        } catch (FileNotFoundException e) {
            System.out.println("Import a file, dummy");
            e.printStackTrace();
        }
    }


    public static boolean isCorrectPasswords(String[] stringArray) {
        int firstIndex = Integer.parseInt(stringArray[0])-1;
        int secondIndex = Integer.parseInt(stringArray[1])-1;
        if (0 == Character.compare(stringArray[3].charAt(firstIndex), stringArray[2].charAt(0))) {
            if (secondIndex > stringArray[3].length()) {
                return true;
            } else {
                if (0 == Character.compare(stringArray[3].charAt(secondIndex), stringArray[2].charAt(0))) {
                    return false;
                } else {
                    return true;
                }
            }
        } else if (secondIndex > stringArray[3].length()) {
            return false;
        } else {
            if (0 == Character.compare(stringArray[3].charAt(secondIndex), stringArray[2].charAt(0))) {
                return true;
            } else {
                return false;
            }
        }
    }


    public static String[] parse(String inputString) {
        String[] finalArray = new String[4];
        String[] tempArray;
        String[] tempArray2;
        tempArray = inputString.split("-");
        finalArray[0] = tempArray[0];
        tempArray = tempArray[1].split(" ");
        finalArray[1] = tempArray[0];
        tempArray2 = tempArray[1].split(":");
        finalArray[2] = tempArray2[0];
        finalArray[3] = tempArray[2];
        return finalArray;

    }

}

