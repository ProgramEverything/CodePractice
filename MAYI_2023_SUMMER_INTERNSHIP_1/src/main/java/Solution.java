import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputSplit = new String[0];
        if (scanner.hasNextLine()) {
            inputSplit = scanner.nextLine().split(" ");
        }
        int a = Integer.parseInt(inputSplit[0]);
        int b = Integer.parseInt(inputSplit[1]);
        double result = 0.25 * (4 * a + b) + 0.5 * (2 * a + 2 * b) + 0.25 * (a + 4 * b);
        System.out.println(String.format("%.2f", result));
    }
}
