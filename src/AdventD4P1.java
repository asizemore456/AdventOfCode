import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class AdventD4P1 {
    public static void main(String[] args) {
        try {
            File source = new File("inputDay4.txt");
            Scanner scan = new Scanner(source);
            scan.useDelimiter("\r\n\r\n");
            int validPassports = 0;
            while (scan.hasNext()) {
                if (isValid(parse(scan.next()))) {
                    validPassports++;
                }
            }
            System.out.println(validPassports);
        } catch (FileNotFoundException e) {
            System.out.println("Hmmmm, there's no file here");
            e.getStackTrace();
        }
    }

    public static String[] parse(String s) {
        String[] fields = s.split("\n| ");
        for (int i = 0; i < fields.length; i++) {
            fields[i] = fields[i].split(":")[0];
        }
        return fields;
    }

    public static Boolean isValid(String[] s) {
        if (s.length == 8) {
            return true;
        } else if (s.length == 7) {
            if (cidExists(s)) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static Boolean cidExists(String[] s) {
        for (int i = 0; i < s.length; i++){
            if(s[i].compareTo("cid")==0){
                return true;
            }
        }
        return false;
    }
}
