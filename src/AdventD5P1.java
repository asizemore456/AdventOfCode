import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdventD5P1 {
    public static void main(String[] args) {
        try {
            File source = new File("test.txt");
            Scanner scan = new Scanner(source);
            int highestID = 0;
            while(scan.hasNext()) {
                String seat = scan.nextLine();
                int row = getRow(seat);
                int column = getColumn(seat);
                System.out.println(row);
                System.out.println(column);
                int seatID = (row*8)+column;
                if(seatID>highestID){
                   highestID = seatID;
                }
            }
            System.out.println(highestID);
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
            else if(s.charAt(i)=='B'){
                lowerIndex = getMidPoint(lowerIndex, upperIndex);
            }
        }
        return upperIndex;
    }

    public static int getColumn(String s){
        int upperIndex = 7;
        int lowerIndex = 0;
        String input = s.substring(7);
        System.out.println("Column Input: "+input);
        for(int i=0;i<3;i++){
            if(s.charAt(i)=='L'){
                upperIndex = getMidPoint(lowerIndex,upperIndex);
            }
            else if(s.charAt(i)=='R'){
                lowerIndex = getMidPoint(lowerIndex, upperIndex);
            }
            System.out.println("Upper Index: "+upperIndex+" Lower Index: "+lowerIndex);
        }
        return upperIndex;
    }

    public static int getMidPoint(int l, int u){
        System.out.println("Midpoint: "+(l+u)/2);
        return (l+u)/2;
    }
}
