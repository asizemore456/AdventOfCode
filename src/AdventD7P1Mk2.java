import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AdventD7P1Mk2 {
    public static void main(String[] args){
        try{
            File source = new File("inputDay7.txt");
            Scanner scan = new Scanner(source);
            scan.useDelimiter("\r\n");
            ArrayList<Bag> myBags = new ArrayList<>();
            while(scan.hasNext()){
                String rule = scan.next();
                String name = rule.split(" bags contain ")[0];
                System.out.println(name);
                ArrayList<String> tempArrayList = new ArrayList<>();
                String tempString = rule.split("contain ")[1];
                tempArrayList.add(tempString);
                ArrayList<String> contents = cleanGarbage(tempArrayList);
                System.out.println(contents);
                Bag tempBag = new Bag(name, contents);
                myBags.add(tempBag);
            }
            //myBags has all the bags in it now
            Set<Bag> carriers = new HashSet();
            for(Bag bag:myBags){
                if(bag.canContain("shiny gold")){
                    carriers.add(bag);
                }
            }
            for(Bag gen1:carriers){
                String name = gen1.getBagName();
                for(Bag bag:myBags){
                    if(bag.canContain(name)){
                        carriers.add(bag);
                    }
                }
            }
            System.out.println(carriers.size());
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<String> cleanGarbage(ArrayList<String> s) {
        if(s.size()==0){
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
