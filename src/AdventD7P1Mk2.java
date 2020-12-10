import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AdventD7P1Mk2 {
    public static void main(String[] args) {
        try {
            File source = new File("inputDay7.txt");
            Scanner scan = new Scanner(source);
            scan.useDelimiter("\r\n");
            HashMap<String, Bag> myBags = new HashMap<>();
            ;
            while (scan.hasNext()) {
                String rule = scan.next();
                String name = rule.split(" bags contain ")[0];
                System.out.println(name);
                ArrayList<String> tempArrayList = new ArrayList<>();
                String tempString = rule.split("contain ")[1];
                tempArrayList.add(tempString);
                ArrayList<String> contents = cleanGarbage(tempArrayList);
                System.out.println(contents);
                Bag tempBag = new Bag(name, contents);
                myBags.put(tempBag.getBagName(), tempBag);
            }
            //myBags has all the bags in it now
            Bag shinyGoldBag = new Bag("shiny gold");
            int counter = 0;
            for (String name : myBags.keySet()) {
                if (canContain(myBags, myBags.get(name), shinyGoldBag)) {
                    counter++;
                }
            }
            System.out.println(counter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean canContain(HashMap<String, Bag> map, Bag lookIn, Bag lookFor) {
        if (lookIn.canContain(lookFor.getBagName())) {
            return true;
        } else {
            for (int i = 0; i < lookIn.getContents().size(); i++) {
                String bagName = lookIn.getContents().get(i);
                Bag thisBag = map.get(bagName);
                if (canContain(map, thisBag, lookFor)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static ArrayList<String> cleanGarbage(ArrayList<String> s) {
        if (s.size() == 0) {
            return new ArrayList<String>();
        }
        String[] temp;
        temp = s.get(0).split(", ");
        s.clear();
        for (int d = 0; d < temp.length; d++) {

            if (temp[d].charAt(0) == ' ') {
                temp[d] = temp[d].substring(1);
            }
        }
        ArrayList<String> out = new ArrayList<>();
        for (int f = 0; f < temp.length; f++) {
            if (temp[f].indexOf("bag", 0) > 0) {
                String a = temp[f].substring(2, temp[f].indexOf("bag", 0) - 1);
                s.add(f, a);
            }
        }
        return s;
    }

}
