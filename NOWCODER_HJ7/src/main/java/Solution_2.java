import java.util.Scanner;

public class Solution_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextFloat()) {
            float input = scanner.nextFloat();
            System.out.println((int) (input + 0.5));
        }
    }
}
