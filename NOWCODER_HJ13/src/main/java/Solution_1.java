import java.util.Scanner;

public class Solution_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            int cnt = 0;
            for (int i = 0; i < 32; ++i) {
                if (((input >> i) & 0x01) == 0x01) {
                    cnt ++;
                }
            }
            System.out.println(cnt);
        }
    }
}
