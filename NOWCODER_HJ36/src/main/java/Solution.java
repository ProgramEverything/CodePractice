import java.util.Scanner;

public class Solution {
    public static char[] getLowerMapping(String cryptoKey) {
        int[] lowerHashMap = new int[26];
        int cnt = 0;
        char[] lowerCharMapping = new char[26];
        for (char c : cryptoKey.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                // 是小写字符
                if (lowerHashMap[c - 'a'] == 0) {
                    lowerCharMapping[cnt++] = c;
                    lowerHashMap[c - 'a'] = 1;
                }
                else {
                    // 啥也不做
                }
            }
        }
        for (int i = 0; i < 26; ++i) {
            if (lowerHashMap[i] == 0) {
                lowerCharMapping[cnt++] = (char) (i + 'a');
            }
        }
        return lowerCharMapping;
    }
    public static char[] getUpperMapping(String cryptoKey) {
        int[] upperHashMap = new int[26];
        int cnt = 0;
        char[] upperCharMapping = new char[26];
        for (char c : cryptoKey.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                // 是大写字符
                if (upperHashMap[c - 'A'] == 0) {
                    upperCharMapping[cnt++] = c;
                    upperHashMap[c - 'A'] = 1;
                }
                else {
                    // 啥也不做
                }
            }
        }
        for (int i = 0; i < 26; ++i) {
            if (upperHashMap[i] == 0) {
                upperCharMapping[cnt++] = (char) (i + 'A');
            }
        }
        return upperCharMapping;
    }
    public static String encryption(char[] lowerCharMapping, char[] upperCharMapping, String ori) {
        StringBuffer sb = new StringBuffer();
        for (char c : ori.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append(lowerCharMapping[c - 'a']);
            }
            else if (c >= 'A' && c <= 'Z') {
                sb.append(upperCharMapping[c - 'A']);
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cryptoKey = "";
        if (scanner.hasNextLine()) {
            cryptoKey = scanner.nextLine();
        }
        char[] lowerCharMapping = getLowerMapping(cryptoKey);
        char[] upperCharMapping = getUpperMapping(cryptoKey);
        String plainText = "";
        if (scanner.hasNextLine()) {
            plainText = scanner.nextLine();
        }
        System.out.println(encryption(lowerCharMapping, upperCharMapping, plainText));
    }
}
