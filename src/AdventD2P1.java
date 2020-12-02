import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class AdventD2P1 {
    //main method
    public static void main(String[] args){
        try{
        int wrongPasswords = 0;
        ArrayList<Integer> lowerLim = new ArrayList<>();
        ArrayList<Integer> upperLim = new ArrayList<>();
        ArrayList<Character> specialChar = new ArrayList<>();
        ArrayList<String> password = new ArrayList<>();
        File source = new File("inputDay2.txt");
        Scanner scan = new Scanner(source);
        String re = "";
        Pattern pt = Pattern.compile(re);
    //Step 1 - Input my Inputs, I think I should use 3 or 4 array lists for this
    //LowerLim<>, UpperLim<>, SpecialChar<>, password<>
    //This will become populate()
            int i=0;
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
                i++;
            }
            int correctPasswords = 0;
            for(int ij=0;ij<password.size();ij++){
                String tempString;
                tempString = password.get(ij);
                char tempChar = specialChar.get(ij);
                int characterCount = countChar(tempString,tempChar);
                if(countChar(password.get(ij), specialChar.get(ij))>upperLim.get(ij)){
                   wrongPasswords++;
                    System.out.println("Upper Lim Violation at index: "+ij+" "+password.get(ij));
                    System.out.println("Upper Lim Violation:"+lowerLim.get(ij));
                    System.out.println("Upper Lim Violation:"+upperLim.get(ij));
                    System.out.println("Upper Lim Violation:"+specialChar.get(ij));
                }
                else if(characterCount<lowerLim.get(ij)){
                    wrongPasswords++;
                    System.out.println("Lower Lim Violation at index: "+ij+" "+password.get(ij));
                    System.out.println("Lower Lim Violation:"+lowerLim.get(ij));
                    System.out.println("Lower Lim Violation:"+upperLim.get(ij));
                    System.out.println("Lower Lim Violation:"+specialChar.get(ij));
                }
                else{
                    correctPasswords++;
                }
            }
    //Step 2 - Check all the passwords against their respective conditions
    //Add to wrong password counter reach time a password fails
    //This will become checkPasswords();

    //Print Statements
            System.out.println(wrongPasswords+" "+correctPasswords+" "+password.size());} catch(FileNotFoundException e) {
            System.out.println("Import a file, dummy");
            e.printStackTrace();
        }
    }

    public static int countChar(String str, char c)
    {
        int count = 0;

        for(int ik=0; ik < str.length(); ik++)
        {    if(str.charAt(ik) == c)
            count++;
        }

        return count;
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
