import java.util.HashMap;

public class Solution_2 {
    public int[] twoSum(int[] nums, int target) {
        // 遍历数组，拿到一个数后就可以知道需要的另一个数，
        // 如果另一个数不在hashmap中，那么就把当前的数放进hashmap中
        HashMap<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int anotherNum = target - nums[i];
            if (numIndexMap.containsKey(anotherNum)) {
                // 另一个数存在于hashmap中
                return new int[] {i, numIndexMap.get(anotherNum)};
            }
            // 因为每次找hashmap只是为了找另外一个数，所以即便有数相同，也无所谓，覆盖即可
            numIndexMap.put(nums[i], i);
        }
        return null;
    }
}
