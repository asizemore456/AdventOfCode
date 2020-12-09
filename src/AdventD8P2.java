import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventD8P2 {
    public static void main(String args[]) {
        try {
            File source = new File("inputDay8.txt");
            Scanner scan = new Scanner(source);
            ArrayList<String> operations = new ArrayList<>();
            scan.useDelimiter("\r\n");
            while (scan.hasNext()) {
                String string = scan.nextLine();
                operations.add(string);
            }
            int i = 0;
            ArrayList<Rule> rules = new ArrayList<>();
            while (i < operations.size()) {
                String type = operations.get(i).split(" ")[0];
                int num = Integer.parseInt(operations.get(i).split(" ")[1]);
                Rule tempRule = new Rule(type, num);
                rules.add(tempRule);
                i++;
            }
            ArrayList<Integer> ind = getIndexes(rules);
            //System.out.println("Index conatins 626: "+ind.contains(629));
            for (int index : ind
            ) {
                ArrayList<Rule> tempRules = changeAtI(rules, index);
                execute(tempRules);
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void execute(ArrayList<Rule> r) {
        int i = 0;
        int max = 0;
        int last = 0;
        int accumulator = 0;
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        while (i < r.size()) {
            max = Math.max(i,max);
            String type = r.get(i).getType();
            int num = r.get(i).getNumber();
            if (type.equals("nop")) {
                if (indexes.contains(i)) {
                    break;
                } else {
                    indexes.add(i);
                    last = i;
                    i++;
                }
            } else if (type.equals("acc")) {
                if (indexes.contains(i)) {
                    break;
                } else {
                    accumulator = accumulator + num;
                    indexes.add(i);
                    last = i;
                    i++;
                }
            } else if (type.equals("jmp")) {
                if (indexes.contains(i)) {
                    break;
                } else {
                    indexes.add(i);
                    last = i;
                    i = i + num;
                }
            }
        }
        //System.out.println("Max Executed: "+max);
        //System.out.println("Last: "+last);
        if(i>=r.size()) {
            System.out.println("I terminated naturally. Accumulator: " + accumulator);
            return;
        }
    }

    public static ArrayList<Rule> changeAtI(ArrayList<Rule> r, int i) {
        ArrayList<Rule> changed = new ArrayList<>();
        for(int j =0;j<r.size();j++) {
            changed.add(new Rule(r.get(j).getType(),r.get(j).getNumber()));
        }
        if (changed.get(i).getType().equals("nop")) {
            changed.get(i).setType("jmp");
        } else {
            changed.get(i).setType("nop");
        }
        return changed;
    }

    public static ArrayList<Integer> getIndexes(ArrayList<Rule> r) {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        int i = 0;
        while (i < r.size()) {
            if (r.get(i).getType().equals("jmp")) {
                indexes.add(i);
            }
            if (r.get(i).getType().equals("nop")) {
                indexes.add(i);
            }
            i++;
        }
        return indexes;
    }
}
