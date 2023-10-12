import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,-3,-2,3};
        int k = 3;
        int x = 2;
        System.out.println(Arrays.toString(new Solution().getSubarrayBeauty(nums, k, x)));
    }

//    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
//        // 每个元素开始往后k个元素构成一个子数组
//        // 魅力值 = 子数组第x小的元素是负数 ? 子数组第x小的元素 : 0
//        int[] result = new int[nums.length - k + 1];
//        for (int i = 0; i < nums.length - k + 1; ++i) {
//            int[] temp = Arrays.copyOfRange(nums, i, i + k);
//            Arrays.sort(temp);
//            result[i] = temp[x - 1] < 0 ? temp[x - 1] : 0;
//        }
//        return result;
//    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] map = new int[101];
        int[] result = new int[nums.length - k + 1];
        // 初始化，窗口为0 - k的元素
        for (int i = 0; i < k; ++i) {
            map[nums[i] + 50] ++;
        }
        int count = 0;
        for (int i = 0; i < 101; ++i) {
            count += map[i];
            if (count >= x) {
                result[0] = Math.min(i - 50, 0);
                break;
            }
        }

        for (int i = 0; i < nums.length - k; ++i) {
            // 下标为i的元素出窗，所以要把对应元素在map中的值--
            // 下标为i + k的元素入窗，所以要把对应元素在map中的值++
            map[nums[i] + 50] --;
            map[nums[i + k] + 50] ++;
            count = 0;
            for (int j = 0; j < 101; ++j) {
                count += map[j];
                if (count >= x) {
                    result[i + 1] = Math.min(j - 50, 0);
                    break;
                }
            }
        }

        return result;
    }

}
