import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class AdventDay10P2 {
    public static void main(String[] args) {
        int threes = 1;
        int ones = 1;
        ArrayList<Integer> adapters = new ArrayList<>();
        HashMap<Long, Long> map = new HashMap<>();
        try {
            File source = new File("inputDay10.txt");
            Scanner scan = new Scanner(source);
            while (scan.hasNext()) {
                int value = scan.nextInt();
                adapters.add(value);
            }
            Collections.sort(adapters);
            System.out.println(fib(adapters.get(adapters.size() - 1) + 3, map, adapters));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static long fib(int n, HashMap<Long, Long> h, ArrayList<Integer> adapters) {
        if (h.containsKey((long)n)) {
            return h.get((long)n);
        }
        if (n == 3) {
            h.put(3L, 3L);
            return 4;
        }
        if (n == 2) {
            h.put(2L, 2L);
            return 2;
        }
        if (n == 1) {
            h.put(1L, 1L);
            return 1;
        }
        long output = 0;
        if (adapters.contains(n - 1)) {
            long n1value = fib(n-1,h,adapters);
            output+=n1value;
            h.put((long)n-1,n1value);
        }
        if(adapters.contains(n-2)){
            long n2value = fib(n-2,h,adapters);
            output+=n2value;
            h.put((long)n-2,n2value);
        }
        if(adapters.contains(n-3)){
            long n3value = fib(n-3,h,adapters);
            output+=n3value;
            h.put((long)n-3,n3value);
        }
        h.put((long)n,output);
        return output;
    }
}
