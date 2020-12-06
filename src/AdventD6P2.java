import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AdventD6P2 {
    public static void main(String[] args) {
        try {
            File source = new File("inputDay6.txt");
            Scanner scan = new Scanner(source);
            scan.useDelimiter("\r\n\r\n");
            int totalSum = 0;
            while (scan.hasNext()) {
                String groupAnswers = scan.next();
                totalSum += getAllAnsw(groupAnswers);
                System.out.println(totalSum);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int getAllAnsw(String s) {
        String[] arrayAnswers = parse(s);
        Set<String> set = new HashSet<>();
        Set<String> finalSet = new HashSet<>();
        if (arrayAnswers[0].contains("a")) {
            finalSet.add("a");
        }
        if (arrayAnswers[0].contains("b")) {
            finalSet.add("b");
        }
        if (arrayAnswers[0].contains("c")) {
            finalSet.add("c");
        }
        if (arrayAnswers[0].contains("d")) {
            finalSet.add("d");
        }
        if (arrayAnswers[0].contains("e")) {
            finalSet.add("e");
        }
        if (arrayAnswers[0].contains("f")) {
            finalSet.add("f");
        }
        if (arrayAnswers[0].contains("g")) {
            finalSet.add("g");
        }
        if (arrayAnswers[0].contains("h")) {
            finalSet.add("h");
        }
        if (arrayAnswers[0].contains("i")) {
            finalSet.add("i");
        }
        if (arrayAnswers[0].contains("j")) {
            finalSet.add("j");
        }
        if (arrayAnswers[0].contains("k")) {
            finalSet.add("k");
        }
        if (arrayAnswers[0].contains("l")) {
            finalSet.add("l");
        }
        if (arrayAnswers[0].contains("m")) {
            finalSet.add("m");
        }
        if (arrayAnswers[0].contains("n")) {
            finalSet.add("n");
        }
        if (arrayAnswers[0].contains("o")) {
            finalSet.add("o");
        }
        if (arrayAnswers[0].contains("p")) {
            finalSet.add("p");
        }
        if (arrayAnswers[0].contains("q")) {
            finalSet.add("q");
        }
        if (arrayAnswers[0].contains("r")) {
            finalSet.add("r");
        }
        if (arrayAnswers[0].contains("s")) {
            finalSet.add("s");
        }
        if (arrayAnswers[0].contains("t")) {
            finalSet.add("t");
        }
        if (arrayAnswers[0].contains("u")) {
            finalSet.add("u");
        }
        if (arrayAnswers[0].contains("v")) {
            finalSet.add("v");
        }
        if (arrayAnswers[0].contains("w")) {
            finalSet.add("w");
        }
        if (arrayAnswers[0].contains("x")) {
            finalSet.add("x");
        }
        if (arrayAnswers[0].contains("y")) {
            finalSet.add("y");
        }
        if (arrayAnswers[0].contains("z")) {
            finalSet.add("z");
        }
        for (int i = 1; i < arrayAnswers.length; i++) {
            if (arrayAnswers[i].contains("a")) {
                set.add("a");
            }
            if (arrayAnswers[i].contains("b")) {
                set.add("b");
            }
            if (arrayAnswers[i].contains("c")) {
                set.add("c");
            }
            if (arrayAnswers[i].contains("d")) {
                set.add("d");
            }
            if (arrayAnswers[i].contains("e")) {
                set.add("e");
            }
            if (arrayAnswers[i].contains("f")) {
                set.add("f");
            }
            if (arrayAnswers[i].contains("g")) {
                set.add("g");
            }
            if (arrayAnswers[i].contains("h")) {
                set.add("h");
            }
            if (arrayAnswers[i].contains("i")) {
                set.add("i");
            }
            if (arrayAnswers[i].contains("j")) {
                set.add("j");
            }
            if (arrayAnswers[i].contains("k")) {
                set.add("k");
            }
            if (arrayAnswers[i].contains("l")) {
                set.add("l");
            }
            if (arrayAnswers[i].contains("m")) {
                set.add("m");
            }
            if (arrayAnswers[i].contains("n")) {
                set.add("n");
            }
            if (arrayAnswers[i].contains("o")) {
                set.add("o");
            }
            if (arrayAnswers[i].contains("p")) {
                set.add("p");
            }
            if (arrayAnswers[i].contains("q")) {
                set.add("q");
            }
            if (arrayAnswers[i].contains("r")) {
                set.add("r");
            }
            if (arrayAnswers[i].contains("s")) {
                set.add("s");
            }
            if (arrayAnswers[i].contains("t")) {
                set.add("t");
            }
            if (arrayAnswers[i].contains("u")) {
                set.add("u");
            }
            if (arrayAnswers[i].contains("v")) {
                set.add("v");
            }
            if (arrayAnswers[i].contains("w")) {
                set.add("w");
            }
            if (arrayAnswers[i].contains("x")) {
                set.add("x");
            }
            if (arrayAnswers[i].contains("y")) {
                set.add("y");
            }
            if (arrayAnswers[i].contains("z")) {
                set.add("z");
            }
            finalSet.retainAll(set);
            set.clear();
        }
        return finalSet.size();
    }

    public static String[] parse(String s) {
        String[] list = s.split("\r\n");
        return list;
    }

    public static int getNumAnsw(HashSet<String> s) {
        return s.size();
    }
}
