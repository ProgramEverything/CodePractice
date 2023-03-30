import java.util.HashSet;
import java.util.Scanner;

public class Solution_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            HashSet<Character> charSet = new HashSet<>();
            for (char c : input.toCharArray()) {
                if (c >= 0 && c <= 127) {
                    charSet.add(c);
                }
            }
            System.out.println(charSet.size());
        }
    }
}
