import java.util.ArrayList;
import java.util.HashMap;

public class FibSeq {
    public static void main(String[] args){
        ArrayList<Integer> sequence = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        System.out.println(fib(20,map));
    }

    public static int fib(int n, HashMap<Integer, Integer> h){
        if(h.containsKey(n)){
            return h.get(n);
        }
        if(n==2){
            h.put(2,1);
            return 1;
        }
        if(n==1){
            h.put(1,1);
            return 1;
        }
        if(n==0){
            h.put(0,1);
            return 1;
        }
        int value = fib(n-1,h)+fib(n-2,h)+fib(n-3,h);
        h.put(n,value);
        return value;
    }
}
