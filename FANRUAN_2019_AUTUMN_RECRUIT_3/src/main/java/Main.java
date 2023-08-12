import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<Character, String> pinyinMap = new HashMap<>();
    static {
        pinyinMap.put('帆', "FAN");
        pinyinMap.put('软', "RUAN");
    }
    public static void main(String[] args) {
        String[] input = new String[0];
        Scanner s = new Scanner(System.in);
        if (s.hasNextLine()) {
            input = s.nextLine().split(" ");
        }
        char[] parsedInput = new char[2];
        parsedInput[0] = input[0].charAt(0);
        parsedInput[1] = input[1].charAt(0);
        System.out.println(compare(parsedInput[0], parsedInput[1]));
    }
    public static int compare(char c1, char c2) {
        boolean containsC1 = pinyinMap.containsKey(c1);
        boolean containsC2 = pinyinMap.containsKey(c2);
        if (containsC1 && containsC2) {
            return pinyinMap.get(c1).compareToIgnoreCase(pinyinMap.get(c2));
        }
        else if (containsC1) {
            return 1;
        }
        else if (containsC2) {
            return -1;
        }
        else {
            return c1 - c2;
        }
    }
}
