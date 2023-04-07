import java.util.HashSet;

public class Solution_1 {
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口，范围是[begin, end)
        int begin = 0;
        int end = 1;
        HashSet<Character> characters = new HashSet<>();
        int longest = 0;
        while (end != s.length()) {
            if (characters.contains(s.charAt(end))) {
                while (characters.contains(s.charAt(end))) {
                    characters.remove(s.charAt(begin ++));
                }
                characters.add(s.charAt(end));
                end ++;
            }
            else {
                characters.add(s.charAt(end));
                end ++;
            }
            if (end - begin > longest) {
                longest = end - begin;
            }
        }
        return longest;
    }
}
