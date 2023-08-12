import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] a = new String[0];
        String[] b = new String[0];
        if (s.hasNextLine()) {
            a = s.nextLine().split(" ");
        }
        if (s.hasNextLine()) {
            b = s.nextLine().split(" ");
        }
        s.close();
        int[] nums1 = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            nums1[i] = Integer.parseInt(a[i]);
        }
        int[] nums2 = new int[b.length];
        for (int i = 0; i < b.length; ++i) {
            nums2[i] = Integer.parseInt(b[i]);
        }
        // 动态规划，打表
        Main m = new Main();
        System.out.println(m.findLength(nums1, nums2));
    }
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dpTable = new int[nums1.length + 1][nums2.length + 1];
        // nums1从0到length - 1索引对应动态规划表的1到length索引
        int max = 0;
        for (int i = 0; i < nums1.length; ++i) {
            for (int j = 0; j < nums2.length; ++j) {
                if (nums1[i] == nums2[j]) {
                    dpTable[i + 1][j + 1] = dpTable[i][j] + 1;
                    if (dpTable[i + 1][j + 1] > max) {
                        max = dpTable[i + 1][j + 1];
                    }
                }
            }
        }
        return max;
    }
}
