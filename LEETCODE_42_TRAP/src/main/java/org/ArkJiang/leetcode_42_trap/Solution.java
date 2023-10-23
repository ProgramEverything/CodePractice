package org.ArkJiang.leetcode_42_trap;

public class Solution {
    public static void main(String[] args) {
        int[] trapper = new int[] {4,2,0,3,2,5};
        System.out.println(new Solution().trap(trapper));
    }

    /**
     * O(n^2)复杂度
     * 按列求积水量
     * @param height
     * @return
     */
    public int trap(int[] height) {
        // 每个点查找其左边最高值和右边最高值，该点的积水量为min(左边最高值，右边最高值) - 该点高度，如果是负数那么为0
        int[] leftMax = new int[height.length]; // 每个点左边（不包括当前点）能找到的最高值
        for (int i = 1; i < height.length; ++i) {
            if (height[i - 1] > leftMax[i - 1]) {
                leftMax[i] = height[i - 1];
            } else {
                leftMax[i] = leftMax[i - 1];
            }
        }
        int[] rightMax = new int[height.length];    // 每个点右边（不包括当前点）能找到的最高值
        for (int i = height.length - 2; i > -1; --i) {
            if (height[i + 1] > rightMax[i + 1]) {
                rightMax[i] = height[i + 1];
            } else {
                rightMax[i] = rightMax[i + 1];
            }
        }
        int result = 0;
        for (int i = 0; i < height.length; ++i) {
            result += Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
        }
        return result;
    }
}
