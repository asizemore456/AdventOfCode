import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventD9P2 {
    public static void main(String[] args) {
        try {
            File source = new File("inputDay9.txt");
            Scanner scan = new Scanner(source);
            ArrayList<Long> inputArrayL = new ArrayList<Long>();
            while (scan.hasNext()) {
                long value = scan.nextLong();
                inputArrayL.add(value);
            }
            scan.close();
            for (int i = 0; i < inputArrayL.size(); i++) {
                long sum = 0;
                long min = Long.MAX_VALUE;
                long max = Long.MIN_VALUE;
                long answer = 0;
                long bigSum = 69316178;
                for (int j = i; j < inputArrayL.size(); j++) {
                    min = Math.min(min,inputArrayL.get(j));
                    max = Math.max(max,inputArrayL.get(j));
                    sum += inputArrayL.get(j);
                    if (sum == bigSum) {
                        answer = min + max;
                        System.out.println(answer);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Import a file, dummy");
            e.printStackTrace();
        }

    }

    public static boolean sumOf25(ArrayList<Long> s, int i) {
        for (int k = i - 25; k < i; k++) {
            for (int j = i - 25; j < i; j++) {
                if (s.get(k) + s.get(j) == s.get(i)) {
                    return true;
                }
            }
        }
        return false;
    }
}
