import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class AdventD5P2 {
    public static void main(String[] args) {
        try {
            int mySeat = -666;
            ArrayList<Integer> ids = new ArrayList<Integer>();
            File source = new File("inputDay5.txt");
            Scanner scan = new Scanner(source);
            while(scan.hasNext()) {
                String seat = scan.nextLine();
                int row = getRow(seat);
                int column = getColumn(seat);
                int seatID = (row*8)+column;
                ids.add(seatID);
            }
            mySeat = getMySeat(ids);
            System.out.println(mySeat);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int getMySeat(ArrayList<Integer> s){
        Collections.sort(s);
        for(int i=0;i<s.size();i++){
            if(i>0&&i<s.size()){
                int sum = s.get(i)+s.get(i+1)+s.get(i-1);
                int product = 3*s.get(i);
                if(sum!=product){
                    return s.get(i)+1;
                }
            }
        }
        return -666;
    }

    public static int getRow(String s){
        int upperIndex = 127;
        int lowerIndex = 0;
        String input = s.substring(0,7);
        for(int i=0;i<7;i++){
            if(input.charAt(i)=='F'){
                upperIndex = getMidPoint(lowerIndex,upperIndex);
            }
            else if(input.charAt(i)=='B'){
                lowerIndex = getMidPoint(lowerIndex, upperIndex);
            }
        }
        return upperIndex;
    }

    public static int getColumn(String s){
        int upperIndex = 7;
        int lowerIndex = 0;
        String input = s.substring(7);
        for(int i=0;i<3;i++){
            if(input.charAt(i)=='L'){
                upperIndex = getMidPoint(lowerIndex,upperIndex);
            }
            else if(input.charAt(i)=='R'){
                lowerIndex = getMidPoint(lowerIndex, upperIndex);
            }
        }
        return upperIndex;
    }

    public static int getMidPoint(int l, int u){
        return (l+u)/2;
    }
}
