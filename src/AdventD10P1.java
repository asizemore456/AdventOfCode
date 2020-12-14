import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AdventD10P1 {
    public static void main(String[] args) {
        int threes = 1;
        int ones = 1;
        ArrayList<Integer> adapters = new ArrayList<>();
        try {
            File source = new File("inputDay10.txt");
            Scanner scan = new Scanner(source);
            while (scan.hasNext()) {
                int value = scan.nextInt();
                adapters.add(value);
            }
            Collections.sort(adapters);
            System.out.println(adapters);
            for (int i = 1; i < adapters.size(); i++) {
                if (adapters.get(i) - 1 == adapters.get(i - 1)) {
                    ones++;
                }
                if (adapters.get(i) - 3 == adapters.get(i - 1)) {
                    threes++;
                }
            }
            System.out.println(threes * ones);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
