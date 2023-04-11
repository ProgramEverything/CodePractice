import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // 有正确率问题
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        if (scanner.hasNextInt()) {
            total = scanner.nextInt();
        }
        scanner.nextLine();
        int[] odds = new int[total];
        int[] evens = new int[total];
        int oddCnt = 0;
        int evenCnt = 0;
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] split = input.split(" ");
            for (int i = 0; i < total; ++i) {
                int temp = Integer.parseInt(split[i]);
                if (isOdd(temp)) {
                    odds[oddCnt++] = temp;
                }
                else {
                    evens[evenCnt++] = temp;
                }
            }
        }
        if (oddCnt == 0 || evenCnt == 0) {
            // 如果奇偶集合任意一个是空的，那么肯定不能组成素数
            System.out.println("0");
            return;
        }
        int[] finalOdds = Arrays.copyOf(odds, oddCnt);
        int[] finalEvens = Arrays.copyOf(evens, evenCnt);
        // 使用匈牙利算法进行匹配，先到先得，能让则让
        // 奇数-odd, 偶数-even
        // 建立一个映射表，表的索引对应奇数数组的索引，表的值为偶数数组的索引
        int[] evenMappingTable = new int[evenCnt];
        int[] oddMappingTable = new int[oddCnt];
        Arrays.fill(evenMappingTable, -1);
        Arrays.fill(oddMappingTable, -1);
        int cnt = 0;
        for (int i = 0; i < oddCnt; ++i) {
            if (match(i, finalOdds, finalEvens, oddMappingTable, evenMappingTable)) cnt++;
        }
        System.out.println(cnt);
    }
    public static boolean match(int oddIndex, int[] odds, int[] evens, int[] oddMappingTable, int[] evenMappingTable) {
        // 要对odds中索引为oddIndex的奇数进行匹配，尝试进行匹配的对象是evens中索引从mappingTable[oddIndex](不含)到结束
        for (int i = oddMappingTable[oddIndex] + 1; i < evens.length; ++i) {
            // 对evens进行遍历，i可以是evens和evenMappingTable的索引
            if (isUndividable(odds[oddIndex] + evens[i])) {
                // 要判断这个偶数是不是已经被匹配了
                if (evenMappingTable[i] != -1) {
                    // 这个偶数已经被匹配了，那么尝试能让则让
                    if (match(evenMappingTable[i], odds, evens, oddMappingTable, evenMappingTable)) {
                        // 可以让
                        oddMappingTable[oddIndex] = i;
                        evenMappingTable[i] = oddIndex;
                        return true;
                    }
                }
                else {
                    // 这个偶数没有被匹配，那么先到先得
                    oddMappingTable[oddIndex] = i;
                    evenMappingTable[i] = oddIndex;
                    return true;
                }
            }
        }
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
