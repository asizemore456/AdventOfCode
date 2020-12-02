import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


public class AdventD1P1 {
    public static void main(String[] args) {
        try {
            File source = new File("numberList.txt");
            Scanner scan = new Scanner(source);
            ArrayList<Integer> inputArrayL = new ArrayList<Integer>();
            while (scan.hasNext()) {
                int value = scan.nextInt();
                inputArrayL.add(value);
            }
            System.out.println(findAnswer(inputArrayL));
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Import a file, dummy");
            e.printStackTrace();
        }

    }


    private static int findAnswer(ArrayList<Integer> inputArrayL) {
        Collections.sort(inputArrayL);
        int result = 0;
        for (int i = 0; i < inputArrayL.size(); i++) {
            for (int j = inputArrayL.size() - 1; j >= 0; j--) {
                if (inputArrayL.get(i) + inputArrayL.get(j) == 2020) {
                    result = inputArrayL.get(i) * inputArrayL.get(j);
                    return result;
                }
            }
        }
        return -666;
    }
}



