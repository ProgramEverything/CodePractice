import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a = 12345678987654321.0;
        System.out.printf("%.0f", a * a);   // java语言特性：double类型的数，即便针对整数部分，仍然有精度丢失问题！！！
        BigDecimal b = new BigDecimal("12345678987654321.0");
        System.out.printf("\n%.0f", b.multiply(b));
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        if (scanner.hasNextInt()) {
            i = scanner.nextInt();
        }
        scanner.nextLine();
        BigDecimal fib_i = BigDecimal.valueOf(fib(i));
        BigDecimal square = fib_i.multiply(fib_i);
        BigDecimal[] result = square.divideAndRemainder(new BigDecimal("1.000000007e9"));
        System.out.printf("%.0f", result[1]);
    }
    // 1000 -> 500478595
    public static int fib(int i) {
        int[] fibArray = new int[i];
        for (int ii = 0; ii < i; ii++) {
            if (ii == 0) {
                fibArray[ii] = 2;
                continue;
            }
            else if (ii == 1) {
                fibArray[ii] = 3;
                continue;
            }
            int i1 = fibArray[ii - 1] + fibArray[ii - 2];
            fibArray[ii] = (int) (i1 % (1e9 + 7));
        }
        return fibArray[i - 1];
    }
}
