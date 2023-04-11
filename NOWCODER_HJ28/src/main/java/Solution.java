import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        if (scanner.hasNextInt()) {
            total = scanner.nextInt();
        }
        scanner.nextLine();
        int[] odds = new int[total / 2];
        int[] evens = new int[total / 2];
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] split = input.split(" ");
            int oddCnt = 0;
            for (int i = 0; i < total; ++i) {
                int temp = Integer.parseInt(split[i]);
                if (isOdd(temp)) {
                    odds[oddCnt++] = temp;
                }
                else {
                    evens[i - oddCnt] = temp;
                }
            }
        }
        // 使用匈牙利算法进行匹配，先到先得，能让则让
        // 奇数-odd, 偶数-even
        // 建立一个映射表，表的索引对应奇数数组的索引，表的值为偶数数组的索引
        int[] mappingTable = new int[total / 2];

    }
    public static boolean match(int oddIndex, int[] odds, int[] evens, int[] mappingTable) {
        // 要对odds中索引为oddIndex的奇数进行匹配，尝试进行匹配的对象是evens中索引从mappingTable[oddIndex](不含)到结束

        return false;
    }
    public static boolean isUndividable(int num) {
        if (num == 1) {
            return true;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i < sqrt + 1; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isOdd(int num) {
        if (num % 2 == 0) {
            return false;
        }
        return true;
    }
}
