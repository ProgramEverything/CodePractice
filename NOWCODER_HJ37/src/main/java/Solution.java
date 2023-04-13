import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = 0;
        if (scanner.hasNextInt()) {
            month = scanner.nextInt();
        }
        // 兔子有三个状态，出生第一个月，出生第二个月，出生第三个月
        // 用三个值保存处于以上三个状态的兔子的数量
        int[] rabbitsByStatus = new int[3];
        // 初始状态是第一个月有一只出生第一个月的兔子
        rabbitsByStatus[0] = 1;
        for (int i = 1; i < month; ++i) {
            rabbitsByStatus[2] += rabbitsByStatus[1];
            rabbitsByStatus[1] = rabbitsByStatus[0];
            rabbitsByStatus[0] = rabbitsByStatus[2];
        }
        int sum = 0;
        for (int i : rabbitsByStatus) {
            sum += i;
        }
        System.out.println(sum);
    }
}
