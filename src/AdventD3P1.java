import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdventD3P1 {
    public static void main(String[] args) {
        try {
            File source = new File("inputDay3.txt");
            Scanner scan = new Scanner(source);
            int trees = 0;
            int index = 0;
            int row = 0;
            while (scan.hasNext()) {
                while(index>30){
                    index = index-31;
                }
                Character path = parse(scan.nextLine(),index);
                if (isTree(path)){
                    trees++;
                }
                index = index + 3;
                row++;
            }
            System.out.println(trees);
            System.out.println(row);
        } catch (FileNotFoundException e) {
            System.out.println("Import a file, dummy");
            e.printStackTrace();
        }

    }
    public static boolean isTree(Character c){
        Character pound = new Character('#');
        if(0 == Character.compare(pound,c)){
            return true;
        }
        else{
            return false;
        }
}

public static Character parse(String s, int i){
       return s.charAt(i);
}
}
