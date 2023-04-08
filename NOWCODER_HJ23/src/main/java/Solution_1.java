import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_1 {
    public static int[] getHashMap(String in) {
        int[] map = new int[26];
        for (char c : in.toCharArray()) {
            map[c - 'a']++;
        }
        return map;
    }
    public static Set<Character> getLeastOccurredChars(int[] map) {
        int leastOccurs = 20;   // 题目规定输入的字符串最长为20
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < 26; ++i) {
            if (map[i] == 0) {
                // 没有出现的字符不算出现次数最少的字符
                continue;
            }
            if (map[i] < leastOccurs) {
                leastOccurs = map[i];
                characterSet.clear();
                characterSet.add((char) (i + 'a'));
            }
            else if (map[i] == leastOccurs) {
                characterSet.add((char) (i + 'a'));
            }
            else {
                // 啥也不做
            }
        }
        return characterSet;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String in = scanner.nextLine();
            int[] map = getHashMap(in);
            Set<Character> characterSet = getLeastOccurredChars(map);
            StringBuffer sb = new StringBuffer();
            for (char c : in.toCharArray()) {
                if (characterSet.contains(c)) {
                    // 啥也不做，不加到StringBuffer中
                }
                else {
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
