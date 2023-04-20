import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        if (scanner.hasNextLine()) {
            input = scanner.nextInt();
        }

        // 从input / 2开始，一直找到2
        int result = 0;
        for (int i = input / 2; i > 1; --i) {
            if (shiZhiShu(i) && shiZhiShu(input - i)) {
                result = i;
                break;
            }
        }
        System.out.println(result);
        System.out.println(input - result);
    }
    public static boolean shiZhiShu(int num) {
        if (num == 2) {
            return true;
        }
        for (int i = 2; i < Math.sqrt(num) + 1; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
