import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (checkContain(line) && checkLength(line) && checkSubstring(line)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }

    public static boolean checkLength(String in) {
        if (in.length() > 8) {
            return true;
        }
        return false;
    }

    public static int[] checkChar(String in) {
        int[] result = new int[4];
        for (char c : in.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                result[0]++;
            } else if (c >= 'A' && c <= 'Z') {
                result[1]++;
            } else if (c >= '0' && c <= '9') {
                result[2]++;
            } else if (c == ' ' || c == '\n') {
                // 啥也不是
            } else {
                result[3]++;
            }
        }
        return result;
    }

    public static boolean checkContain(String in) {
        int[] result = checkChar(in);
        int cnt = 0;
        for (int i : result) {
            if (i > 0) {
                cnt++;
            }
        }
        if (cnt > 2) {
            return true;
        }
        return false;
    }

    public static boolean checkSubstring(String in) {
        // 基于以下判断，只要按顺序取出所有长度为3的子串，判断是否重复即可
        // 如果存在长度大于3的子串重复，那么一定存在长度等于3的子串重复
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < in.length() - 3; ++i) {
            if (strings.contains(in.substring(i, i + 3))) {
                return false;
            } else {
                strings.add(in.substring(i, i + 3));
            }
        }
        return true;
    }
}
