import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
        String[] splitInput = split(input);
        StringBuffer sb = new StringBuffer();
        for (int i = splitInput.length - 1; i > -1; --i) {
            if (splitInput[i] != "") {
                sb.append(splitInput[i] + " ");
            }
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
    public static String[] split(String input) {
        return input.split("[^a-zA-Z]");
    }
}
