public class Solution {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 5, 10, 99};
        int target = 11;
        System.out.println(binarySearch_ge(array, target));
        System.out.println(binarySearch_le(array, target));
    }
    public static int binarySearch_ge(int[] array, int target) {
        int begin = 0;
        int end = array.length;
        int mid;
        while (begin != end) {
            mid = (begin + end) >> 1;
            if (array[mid] < target) {
                begin = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return begin;
    }
    public static int binarySearch_le(int[] array, int target) {
        int begin = 0;
        int end = array.length;
        int mid;
        while (begin != end) {
            mid = (begin + end + 1) >> 1;
            if (array[mid] <= target) {
                begin = mid;
            }
            else {
                end = mid - 1;
            }
        }
        return begin;
    }
}
