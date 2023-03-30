import java.util.Arrays;

public class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        // 这个解法存在正确性问题，但是目前不知道问题在哪里
        if (A == null) {
            return 1;
        }
        if (A.length == 1) {
            return A[0] < 1 ? 1 : A[0] + 1;
        }
        Arrays.sort(A);
        int missedPositiveInteger = 1;  // 从1开始找缺少的最小正整数
        for (int i = 0; i < A.length; ++i) {
            if (A[i] == missedPositiveInteger) {
                // 如果相等说明该正整数没有缺少，那么正整数+1
                missedPositiveInteger ++;
            }
        }
        return missedPositiveInteger;
    }
}
