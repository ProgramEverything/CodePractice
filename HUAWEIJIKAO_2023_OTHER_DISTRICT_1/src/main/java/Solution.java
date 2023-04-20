import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // 交易系统的降级策略
        // 使用二分查找
        Scanner scanner = new Scanner(System.in);
        String[] callPayLoadStringSplit = new String[0];
        if (scanner.hasNextLine()) {
            callPayLoadStringSplit = scanner.nextLine().split(" ");
        }
        int[] callPayLoad = new int[callPayLoadStringSplit.length];
        for (int i = 0; i < callPayLoadStringSplit.length; ++i) {
            callPayLoad[i] = Integer.parseInt(callPayLoadStringSplit[i]);
        }
        int cnt = 0;
        if (scanner.hasNextInt()) {
            cnt = scanner.nextInt();
        }
        // 求调用量限额limit，搜索范围是[0, 1e5)，搜索目标是限额后的总调用量<=cnt
        int result = search(callPayLoad, cnt);
        System.out.println(result);
    }

    public static int search(int[] oriCallPayLoad, int cnt) {
        int begin = 0;
        int end = (int) 1e5;
        int middle;
        while (begin != end) {
            middle = (begin + end + 1) >> 1;
            if (check(oriCallPayLoad, middle, cnt)) {
                // middle的取值可以使总调用量小于限额
                begin = middle;
            } else {
                // middle的取值不可以使总调用量小于限额
                end = middle - 1;
            }
        }
        return begin;
    }

    public static boolean check(int[] oriCallPayLoad, int limit, int cnt) {
        int sum = 0;
        for (int i : oriCallPayLoad) {
            if (i > limit) {
                sum += limit;
            } else {
                sum += i;
            }
        }
        if (sum > cnt) {
            return false;
        } else {
            return true;
        }
    }
}
