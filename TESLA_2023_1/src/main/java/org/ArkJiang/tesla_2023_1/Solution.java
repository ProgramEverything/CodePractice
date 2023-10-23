package org.ArkJiang.tesla_2023_1;


public class Solution {
    public int solution(String S) {
        // Implement your solution here
        int[] ban = new int[3];
        char[] chars = S.toCharArray();
        for (char c : chars) {
            if (c == 'B') {
                ban[0]++;
            } else if (c == 'A') {
                ban[1]++;
            } else if (c == 'N') {
                ban[2]++;
            }
        }
        int b_times = ban[0] / 1;
        int a_times = ban[1] / 3;
        int n_times = ban[2] / 2;
        return Math.min(b_times, Math.min(a_times, n_times));
    }
}
