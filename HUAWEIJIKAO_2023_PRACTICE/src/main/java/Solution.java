import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
        char[] chars = input.toCharArray();
        appendString(new StringBuffer(), chars);
        System.out.println(resultStrings.toString());
    }
    public static HashSet<String> resultStrings = new HashSet<>();
    public static void appendString(StringBuffer sb, char[] chars) {
        // 用回溯法延长sb中的字符串，如果chars中的所有字符都是空字符'\0'，那么把sb中的字符串放到HashSet中
        boolean charsEmpty = true;
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] != '\0') {
                charsEmpty = false;
                sb.append(chars[i]);
                chars[i] = '\0';
                appendString(sb, chars);
                chars[i] = sb.charAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        if (charsEmpty) {
            resultStrings.add(sb.toString());
        }
    }
}
