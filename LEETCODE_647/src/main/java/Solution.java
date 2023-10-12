import java.awt.*;

public class Solution {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < 2 * s.length() - 1; ++i) {
            int i1 = i / 2;
            if (Math.floorMod(i, 2) == 0) {
                // 回文中心是i
                count ++;
                int kuoZhan = 1;
                while (i1 - kuoZhan > -1 && i1 + kuoZhan < s.length()) {
                    if (s.charAt(i1 - kuoZhan) == s.charAt(i1 + kuoZhan)) {
                        count ++;
                        kuoZhan ++;
                    } else {
                        break;
                    }
                }
            } else {
                // 回文中心是i和i + 1
                if (s.charAt(i1) != s.charAt(i1 + 1)) {
                    continue;
                }
                count ++;
                int kuoZhan = 1;
                while (i1 - kuoZhan > -1 && i1 + kuoZhan + 1 < s.length()) {
                    if (s.charAt(i1 - kuoZhan) == s.charAt(i1 + kuoZhan + 1)) {
                        count ++;
                        kuoZhan ++;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }
}
