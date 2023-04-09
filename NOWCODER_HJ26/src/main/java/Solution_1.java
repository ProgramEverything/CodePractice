import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_1 {
    public static void main(String[] args) {
        // 字符串排序，用桶排序实现
        Scanner scanner = new Scanner(System.in);
        String input = "";
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
        List[] buckets = getBuckets(input);
        System.out.println(recoverString(input, buckets));
    }
    public static String recoverString(String input, List[] buckets) {
        int cnt = 0;
        StringBuffer sb = new StringBuffer();
        for (List<Integer> indexes : buckets) {
            if (indexes == null) {
                continue;
            }
            int indexCnt = 0;
            while (indexCnt != indexes.size()) {
                if (notAlphabet(input.charAt(cnt))) {
                    // 插入一个字符，cnt加1，进入下一次循环，但是下一次循环的index不变
                    sb.append(input.charAt(cnt));
                } else {
                    sb.append(input.charAt(indexes.get(indexCnt)));
                    indexCnt++;
                }
                cnt++;
            }
        }
        if (sb.length() < input.length()) {
            sb.append(input.substring(sb.length()));
        }
        return sb.toString();
    }
    public static boolean notAlphabet(char c) {
        boolean notLower = false;
        if (!(c >= 'a' && c <= 'z')) {
            notLower = true;
        }
        boolean notUpper = false;
        if (!(c >= 'A' && c <= 'Z')) {
            notUpper = true;
        }
        return notLower && notUpper;
    }
    public static List[] getBuckets(String input) {
        List[] buckets = new ArrayList[26];
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (buckets[c - 'a'] == null) {
                    List<Integer> temp = new ArrayList();
                    temp.add(i);
                    buckets[c - 'a'] = temp;
                }
                else {
                    buckets[c - 'a'].add(i);
                }
            }
            else if (c >= 'A' && c <= 'Z'){
                if (buckets[c - 'A'] == null) {
                    List<Integer> temp = new ArrayList();
                    temp.add(i);
                    buckets[c - 'A'] = temp;
                }
                else {
                    buckets[c - 'A'].add(i);
                }
            }
        }
        return buckets;
    }
}
