import java.util.Scanner;

public class Solution_1 {
    public static void main(String[] args) {
        // 计算某个数的所有质因数
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            int temp = (int) Math.sqrt(input);
            while (input != 1) {
                for (int i = 2; i < temp + 1; ++i) {
                    if (input % i == 0) {
                        System.out.print(i + " ");
                        input = input / i;
                        break;
                    }
                    if (i == temp) {
                        // 如果循环走完了，则该数是素数
                        System.out.print(input + " ");
                        input = 1;  // 让while循环结束
                    }
                }
            }
            System.out.println();
        }
    }
}
