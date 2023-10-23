package org.ArkJiang.leetcode_128_hot100_longest_consecutive;

import java.util.HashMap;
import java.util.Iterator;
import java.util.function.BiConsumer;

public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> numOccurred = new HashMap();
        for (int num : nums) {
            numOccurred.put(num, -1);
        }
        for (Integer i : numOccurred.keySet()) {
            getConsecutiveNum(i, numOccurred);
        }
        return max;
    }

    Integer max = Integer.MIN_VALUE;

    public void getConsecutiveNum(int current, HashMap<Integer, Integer> numOccurred) {
        if (numOccurred.get(current) != -1) {
            return;
        }

        if (numOccurred.get(current + 1) != null && numOccurred.get(current + 1) != -1) {
            // 如果下一个数（当前数+1）存在并且以下一个数开始的最长连续长度已经计算过了，那么把该值+1赋给current对应的值
            numOccurred.put(current, numOccurred.get(current + 1) + 1);
        } else if (numOccurred.get(current + 1) == null) {
            // 下一个数不存在
            numOccurred.put(current, 1);
        } else if (numOccurred.get(current + 1) == -1) {
            // 以下一个数开始的最长连续长度还没计算过
            getConsecutiveNum(current + 1, numOccurred);
            numOccurred.put(current, numOccurred.get(current + 1) + 1);
        }

        if (max < numOccurred.get(current)) {
            max = numOccurred.get(current);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[] {100,4,200,1,3,2};
        System.out.println(new Solution().longestConsecutive(test));
    }
}
