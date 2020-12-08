import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class AdventD7P1 {
    public static void main(String[] args) {
        try {
            ArrayList<String> bags = new ArrayList<>();
            ArrayList<ArrayList<String>> contents = new ArrayList<>();
            File source = new File("inputDay7.txt");
            Scanner scan = new Scanner(source);
            scan.useDelimiter("\r\n");
            int total = 0;
            ArrayList<String> garbage = new ArrayList<>();
            while (scan.hasNext()) {
                String rule = scan.next();
                bags.add(rule.split("contain ")[0]);
                String myString = rule.split("contain ")[1];
                System.out.println("My String: "+myString);
                garbage.add(myString);
                System.out.println("Garbage Pre-Clean: "+garbage);
                contents.add(cleanGarbage(garbage));
                System.out.println("Clean Garbage"+cleanGarbage(garbage));
                garbage.clear();
            }
            bags = cleanBags(bags);
            for (int i = 0; i < bags.size(); i++) {
                int indexOfRule = bags.indexOf(contents.get(i));
                if (canContain(contents.get(i), "shiny gold")) {
                    total++;
                    System.out.println("Direct Carrier");
                }
                else if(indexOfRule>=0){
                    if (canContain(contents.get(indexOfRule), "shiny gold")) {
                        total++;
                        System.out.println("Indirect Carrier");
                    }
                }
            }
            System.out.println(total);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> cleanGarbage(ArrayList<String> s) {
        if(s.size()==0){
            return new ArrayList<String>();
        }
        String[] temp;
        temp = s.get(0).split(", |.");
        for (int d = 0; d < temp.length; d++) {

            if (temp[d].charAt(0) == ' ') {
                temp[d] = temp[d].substring(1);
            }
        }
        ArrayList<String> out = new ArrayList<>();
        for (int f = 0; f < temp.length; f++) {
            if(temp[f].indexOf("bag",0)>0){
                String a = temp[f].substring(2, temp[f].indexOf("bag",0) - 1);
                s.add(f,a);
            }
        }
        System.out.println("S: "+s);
        return s;
    }

    public static Boolean canContain(ArrayList<String> s, String sg) {
        for (int j = 0; j < s.size(); j++) {
            if (s.get(j).contains(sg)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> cleanBags(ArrayList<String> s) {
        for (int j = 0; j < s.size(); j++) {
            String cleanBag = s.get(j).split("bag")[0];
            s.set(j, cleanBag);
        }
        return s;
    }
}
