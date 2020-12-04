import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdventD4P2 {
    public static void main(String[] args) {
        try {
            File source = new File("inputDay4.txt");
            Scanner scan = new Scanner(source);
            scan.useDelimiter("\r\n\r\n");
            int validPassports = 0;
            int g =0;
            while (scan.hasNext()) {
                String passport = scan.next();
                if (checks(parse(passport))) {
                    validPassports++;
                    System.out.println("Nice");
                }
                else{
                    System.out.println("This passport is garbage. #: "+g);
                }
                g++;
            }
            System.out.println(validPassports+" "+g);
        } catch (FileNotFoundException e) {
            System.out.println("Hmmmm, there's no file here");
            e.getStackTrace();
        }
    }

    public static String[] parse(String s) {
        String[] fields = s.split("\n| ");
        return fields;
    }


    public static Boolean checks(String[] s) {
        int validChecks = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].split(":")[0].compareTo("byr") == 0) {
                if (validByr(s, i)) {
                    validChecks++;
                } else {
                    System.out.println("Byr failed");
                }
            } else if (s[i].split(":")[0].compareTo("iyr") == 0) {
                if (validIyr(s, i)) {
                    validChecks++;
                } else {
                    System.out.println("Iyr failed");
                }
            } else if (s[i].split(":")[0].compareTo("eyr") == 0) {
                if (validEyr(s, i)) {
                    validChecks++;
                } else {
                    System.out.println("Eyr failed");
                }
            } else if (s[i].split(":")[0].compareTo("hgt") == 0) {
                if (validHgt(s, i)) {
                    validChecks++;
                } else {
                    System.out.println("Hgt failed");
                }
            } else if (s[i].split(":")[0].compareTo("hcl") == 0) {
                if (validHcl(s, i)) {
                    validChecks++;
                } else {
                    System.out.println("Hcl failed");
                }
            } else if (s[i].split(":")[0].compareTo("ecl") == 0) {
                if (validEcl(s, i)) {
                    validChecks++;
                } else {
                    System.out.println("Ecl failed");
                }
            } else if (s[i].split(":")[0].compareTo("pid") == 0) {
                if (validPid(s, i)) {
                    validChecks++;
                } else {
                    System.out.println("Pid failed");
                }
            }
        }
        if (validChecks == 7) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean validByr(String[] s, int i) {
        String byr = s[i].split(":")[1];
        if (byr.length() == 4) {
            int Byr = Integer.parseInt(byr);
            if (Byr < 1920) {
                return false;
            } else if (Byr > 2002) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static Boolean validIyr(String[] s, int i) {
        String iyr = s[i].split(":")[1];
        if (iyr.length() == 4) {
            int Iyr = Integer.parseInt(iyr);
            if (Iyr < 2010) {
                return false;
            } else if (Iyr > 2020) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static Boolean validEyr(String[] s, int i) {
        String eyr = s[i].split(":")[1];
        if (eyr.length() == 4) {
            int Eyr = Integer.parseInt(eyr);
            if (Eyr < 2020) {
                return false;
            } else if (Eyr > 2030) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static Boolean validHgt(String[] s, int i) {
        String hgt = s[i].split(":")[1];
        Character d = hgt.charAt(hgt.length() - 2);
        if (d == 'c') {
            int Hgt = Integer.parseInt(hgt.split("c")[0]);
            if (Hgt < 150) {
                return false;
            } else if (Hgt > 193) {
                return false;
            } else {
                return true;
            }
        } else if (d == 'i') {
            int Hgt = Integer.parseInt(hgt.split("i")[0]);
            if (Hgt < 59) {
                return false;
            } else if (Hgt > 76) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static Boolean validHcl(String[] s, int i) {
        String hcl = s[i].split(":")[1];
        if (hcl.charAt(0) == '#') {
            if (hcl.length() == 7) {
                int count = 0;
                for (int j = 1; j < 7; j++) {
                    if (hcl.charAt(j)=='a') {
                        count++;
                    }
                    else if(hcl.charAt(j)=='b'){
                        count++;
                    }
                    else if(hcl.charAt(j)=='c'){
                        count++;
                    }
                    else if(hcl.charAt(j)=='d'){
                        count++;
                    }
                    else if(hcl.charAt(j)=='e'){
                        count++;
                    }
                    else if(hcl.charAt(j)=='f'){
                        count++;
                    }
                    else if (Character.isDigit(hcl.charAt(j))) {
                        count++;
                    }
                }
                if (count == 6) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static Boolean validEcl(String[] s, int i) {
        String ecl = s[i].split(":")[1];
        if (ecl.compareTo("amb") == 0) {
            return true;
        } else if (ecl.compareTo("blu") == 0) {
            return true;
        } else if (ecl.compareTo("brn") == 0) {
            return true;
        } else if (ecl.compareTo("gry") == 0) {
            return true;
        } else if (ecl.compareTo("grn") == 0) {
            return true;
        } else if (ecl.compareTo("hzl") == 0) {
            return true;
        } else if (ecl.compareTo("oth") == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean validPid(String[] s, int i) {
        String pid = s[i].split(":")[1];
        if (pid.length() == 9) {
            int counter = 0;
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(pid.charAt(i))) {
                    counter++;
                }
            }
            if (counter == 9) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


}
