import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Advent1 {
    public static void main(String[] args){
        try{
            File source = new File("numberList.txt");
            Scanner scan = new Scanner(source);
            ArrayList<Integer> inputArrayL = new ArrayList<Integer>();
            while(scan.hasNext()){
                int value = scan.nextInt();
                inputArrayL.add(value);
            }
            for(int i=0;i<inputArrayL.size();i++){
                for(int j=0;j<inputArrayL.size();j++){
                    if(inputArrayL.get(i)+inputArrayL.get(j)==2020){
                        System.out.println(inputArrayL.get(i)*inputArrayL.get(j));
                    }
                }
            }
            scan.close();
        } catch(FileNotFoundException e){
            System.out.println("Import a file, dummy");
            e.printStackTrace();
        }

    }


}



