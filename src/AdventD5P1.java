import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdventD5P1 {
    public static void main(String[] args) {
        try {
            File source = new File("inputDay4.txt");
            Scanner scan = new Scanner(source);
            int highestProduct = 0;
            while(scan.hasNext()) {
                String seat = scan.next();
                int row = getRow(seat);
                int column = getColumn(seat);
                if(row*column>highestProduct){
                   highestProduct = row*column;
                }
            }
            System.out.println(highestProduct);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int getRow(String s){
        int upperIndex = 127;
        int lowerIndex = 0;
        String input = s.substring(0,6);
        for(int i=0;i<7;i++){
            if(s.charAt(i)=='F'){
                upperIndex = getMidPoint(lowerIndex,upperIndex);
            }
            else{
                lowerIndex = getMidPoint(lowerIndex, upperIndex);
            }
        }
        return upperIndex;
    }

    public static int getColumn(String s){
        int upperIndex = 127;
        int lowerIndex = 0;
        String input = s.substring(7);
        for(int i=0;i<3;i++){
            if(s.charAt(i)=='F'){
                upperIndex = getMidPoint(lowerIndex,upperIndex);
            }
            else{
                lowerIndex = getMidPoint(lowerIndex, upperIndex);
            }
        }
        return upperIndex;
    }

    public static int getMidPoint(int l, int u){
        int midPoint = (l+u)/2;
        return midPoint;
    }
}
