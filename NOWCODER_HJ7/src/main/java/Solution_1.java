import java.util.Scanner;

public class Solution_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextFloat()) {
            Float input = scanner.nextFloat();
            float xiaoShu = input - input.intValue();
            if (xiaoShu < 0.5) {
                System.out.println(input.intValue());
            }
            else {
                System.out.println(input.intValue() + 1);
            }
        }
    }
}