import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventD9P1 {
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
            for(int i = 25;i<inputArrayL.size();i++){
                if(sumOf25(inputArrayL,i)){
                    System.out.println(inputArrayL.get(i));
                }
                else{
                    System.out.println("First Fail: "+inputArrayL.get(i));
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Import a file, dummy");
            e.printStackTrace();
        }

    }

    public static boolean sumOf25(ArrayList<Long> s,int i){
        for(int k=i-25;k<i;k++){
            for(int j=i-25;j<i;j++){
                if(s.get(k)+s.get(j)==s.get(i)){
                    return true;
                }
            }
        }
        return false;
    }
}
