import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventD8P1 {
    public static void main(String[] args) {
        try {
            File source = new File("inputDay8.txt");
            Scanner scan = new Scanner(source);
            ArrayList<String> operations = new ArrayList<>();
            scan.useDelimiter("\r\n");
            while (scan.hasNext()) {
                String string = scan.nextLine();
                System.out.println(string);
                operations.add(string);
            }
            int accumulator = 0;
            int i = 0;
            ArrayList<Integer> indexes = new ArrayList<Integer>();
            while (i < operations.size()) {
                String type = operations.get(i).split(" ")[0];
                System.out.println("Type: " + type);
                int num = Integer.parseInt(operations.get(i).split(" ")[1]);
                if (type.equals("nop")) {
                    if (indexes.contains(i)) {
                        System.out.println("Done this jump before");
                        System.out.println("Accumulator Value: " + accumulator);
                        return;
                    } else {
                        System.out.println("No Operation");
                        indexes.add(i);
                        i++;
                    }
                } else if (type.equals("acc")) {
                    if (indexes.contains(i)) {
                        System.out.println("Done this jump before");
                        System.out.println("Accumulator Value: " + accumulator);
                        return;
                    } else {
                        System.out.println("Accumulated: " + num);
                        accumulator = accumulator + num;
                        indexes.add(i);
                        i++;
                    }
                } else if (type.equals("jmp")) {
                    if (indexes.contains(i)) {
                        System.out.println("Done this jump before");
                        System.out.println("Accumulator Value: " + accumulator);
                        return;
                    } else {
                        System.out.println("Jumped: " + num);
                        indexes.add(i);
                        i = i + num;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
