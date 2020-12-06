import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdventD6P1 {
    public static void main(String[] args) {
        try {
            File source = new File("inputDay6.txt");
            Scanner scan = new Scanner(source);
            scan.useDelimiter("\r\n\r\n");
            int totalSum = 0;
            while (scan.hasNext()) {
                String groupAnswers = scan.next();
                totalSum += getNumAnsw(groupAnswers);
                System.out.println(totalSum);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int getNumAnsw(String s) {
        int numAnswered = 0;
        if (s.contains("a")) {
            numAnswered++;
        }
        if (s.contains("b")) {
            numAnswered++;
        }
        if (s.contains("c")) {
            numAnswered++;
        }
        if(s.contains("d")){
            numAnswered++;
        }
        if(s.contains("e")){
            numAnswered++;
        }
        if(s.contains("f")){
            numAnswered++;
        }
        if(s.contains("g")){
            numAnswered++;
        }
        if(s.contains("h")){
            numAnswered++;
        }
        if(s.contains("i")){
            numAnswered++;
        }
        if(s.contains("j")){
            numAnswered++;
        }
        if(s.contains("k")){
            numAnswered++;
        }
        if(s.contains("l")){
            numAnswered++;
        }
        if(s.contains("m")){
            numAnswered++;
        }
        if(s.contains("n")){
            numAnswered++;
        }
        if(s.contains("o")){
            numAnswered++;
        }
        if(s.contains("p")){
            numAnswered++;
        }
        if(s.contains("q")){
            numAnswered++;
        }
        if(s.contains("r")){
            numAnswered++;
        }
        if(s.contains("s")){
            numAnswered++;
        }
        if(s.contains("t")){
            numAnswered++;
        }
        if(s.contains("u")){
            numAnswered++;
        }
        if(s.contains("v")){
            numAnswered++;
        }
        if(s.contains("w")){
            numAnswered++;
        }
        if(s.contains("x")){
            numAnswered++;
        }
        if(s.contains("y")){
            numAnswered++;
        }
        if(s.contains("z")){
            numAnswered++;
        }
        return numAnswered;
    }
}
