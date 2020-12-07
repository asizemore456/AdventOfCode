import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventD7P1 {
    public static void main(String[] args) {
        try {
            ArrayList<String> bags;
            ArrayList<ArrayList<String>> contents;
            File source = new File("inputDay7.txt");
            Scanner scan = new Scanner(source);
            scan.useDelimiter("\r\n");
            bags = new ArrayList<>();
            contents = new ArrayList<>();
            int total = 0;
            ArrayList<String> garbage = new ArrayList<>();
            while (scan.hasNext()) {
                String rule = scan.next();
                bags.add(rule.split("contain ")[0]);
                garbage.add(rule.split("contain ")[1]);
                contents.add(cleanGarbage(garbage));
            }
            bags = cleanBags(bags);
            for (int i = 0; i < bags.size(); i++) {
                if (canContain(contents.get(i), "shiny gold")) {
                    total++;
                }
                for (int k = 0; k < contents.get(i).size(); k++) {
                    int indexOfRule = bags.indexOf(contents.get(i).get(k));
                    if (canContain(contents.get(indexOfRule), "shiny gold")) {
                        total++;
                    }
                }
            }
            System.out.println(total);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> cleanGarbage(ArrayList<String> s){
        String[] temp;
        temp = s.get(0).split(",");
        s.clear();
        for(int l = 0;l<temp.length;l++){
            s.add(temp[l]);
        }
        for(int f = 0;f<s.size();f++){
            String a = s.get(f).split(" ")[1];
            String b = s.get(f).split(" ")[2];
            a = a+" "+b;
            s.add(f,a);
        }
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
