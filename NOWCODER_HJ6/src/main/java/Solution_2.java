import java.util.Scanner;

public class Solution_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 用递归实现
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            // 开始循环找
            while (input != 1) {
                int temp = findMinFactor(input);
                System.out.print(temp + " ");
                input /= temp;
            }
            System.out.println();
        }
    }

    /**
     * 找到num的最小因数
     * @param num
     * @return
     */
    public static int findMinFactor(int num) {
        int temp = (int) Math.sqrt(num) + 1;
        for (int i = 2; i < temp; ++i) {
            if (num % i == 0) {
                return i;
            }
        }
        return num;
    }
}
