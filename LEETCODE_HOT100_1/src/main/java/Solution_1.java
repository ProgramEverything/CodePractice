import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        // 两数之和
        // 先排序
        HashMap<Integer, LinkedList<Integer>> integerLinkedListHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            LinkedList<Integer> integers = integerLinkedListHashMap.get(nums[i]);
            if (integers == null) {
                LinkedList<Integer> temp = new LinkedList<>();
                temp.add(i);
                integerLinkedListHashMap.put(nums[i], temp);
            }
            else {
                integers.add(i);
                integerLinkedListHashMap.put(nums[i], integers);
            }
        }
        Arrays.sort(nums);
        // 两个指针从两边开始往中间移动
        int front = 0;
        int back = nums.length - 1;
        while (front != back) {
            if (nums[front] + nums[back] > target) {
                // 如果相加大于target，那么back向前移动
                back --;
            }
            else if (nums[front] + nums[back] < target) {
                // 如果相加小于target，那么front向后移动
                front ++;
            }
            else {
                // 相等则找到结果，结束
                break;
            }
        }
        // 返回索引值
        int index1 = integerLinkedListHashMap.get(nums[front]).remove();
        int index2 = integerLinkedListHashMap.get(nums[back]).remove();
        return new int[] {index1, index2};
    }
}
