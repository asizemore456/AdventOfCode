import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdventD3P2 {
    public static void main(String[] args) {
        long t1 = getTrees(1,1);
        long t2 = getTrees(3,1);
        long t3 = getTrees(5,1);
        long t4 = getTrees(7,1);
        long t5 = getTrees(1,2);
        System.out.println(t1+" "+t2+" "+t3+" "+t4+" "+t5);
        long ProductOfTrees =t1*t2*t3*t4*t5;
        System.out.println(ProductOfTrees);
    }

    public static int getTrees(int deltax, int deltay) {
        int trees = 0;
        try {
            File source = new File("inputDay3.txt");
            Scanner scan = new Scanner(source);
            int index = 0;
            int row = 0;
            while (scan.hasNext()) {
                while (index > 30) {
                    index = index - 31;
                }
                Character path = parse(scan.nextLine(), index);
                if (isTree(path)) {
                    trees++;
                }
                index = index + deltax;
                if(row<322) {
                    for (int i = 0; i < deltay - 1; i++) {
                        String garbage;
                        garbage = scan.nextLine();
                    }
                }
                row = row + deltay;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Import a file, dummy");
            e.printStackTrace();
        }
        return trees;
    }


    public static boolean isTree(Character c) {
        Character pound = new Character('#');
        if (0 == Character.compare(pound, c)) {
            return true;
        } else {
            return false;
        }
    }

    public static Character parse(String s, int i) {
        return s.charAt(i);
    }
}

