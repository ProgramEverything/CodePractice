import java.util.HashMap;
import java.util.Scanner;

public class Solution_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        for (char c = 'a'; c <= 'z'; ++c) {
            if (c < 'd') {
                characterIntegerHashMap.put(c, 2);
            }
            else if (c < 'g') {
                characterIntegerHashMap.put(c, 3);
            }
            else if (c < 'j') {
                characterIntegerHashMap.put(c, 4);
            }
            else if (c < 'm') {
                characterIntegerHashMap.put(c, 5);
            }
            else if (c < 'p') {
                characterIntegerHashMap.put(c, 6);
            }
            else if (c < 't') {
                characterIntegerHashMap.put(c, 7);
            }
            else if (c < 'w') {
                characterIntegerHashMap.put(c, 8);
            }
            else if (c <= 'z') {
                characterIntegerHashMap.put(c, 9);
            }
        }
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            StringBuffer sb = new StringBuffer();
            for (char c : input.toCharArray()) {
                if (c >= 'A' && c < 'Z') {
                    sb.append((char) ('a' + c - 'A' + 1));
                }
                else if (c == 'Z') {
                    sb.append('a');
                }
                else if (c >= 'a' && c <= 'z') {
                    sb.append(characterIntegerHashMap.get(c));
                }
                else if (c >= '0' && c <= '9') {
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
