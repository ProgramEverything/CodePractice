import java.util.Scanner;

public class Solution_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            // 也可以换个角度想，因为质因数数组其实只要知道从小到大的每个质数能除被分解数几次即可
            // 所以这个方法其实可以准备一个质数表
            int temp = (int) Math.sqrt(input);
            for (int i = 2; i < temp + 1; ++i) {
                // 用当前的质数i（虽然i在循环中是不分质数还是非质数，但是在循环到任何非质数之前，已经把该非质数的因数都除完了）
                while (input % i == 0) {
                    // 只要还能整除，就一直除
                    System.out.print(i + " ");
                    input /= i;
                }
            }
            if (input != 1) {
                System.out.println(input);
            }
            else {
                System.out.println();
            }
        }
    }
}
