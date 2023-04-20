import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputSplit = new String[0];
        if (scanner.hasNextLine()) {
            inputSplit = scanner.nextLine().split(" ");
        }
        int[] leakWater = new int[inputSplit.length];
        for (int i =0; i < leakWater.length; ++i) {
            leakWater[i] = Integer.parseInt(inputSplit[i]);
        }
        int sum = 0;
        for (int i = 1; i < leakWater.length - 1; ++i) {
            sum += leakWater[i];
        }
        System.out.println(sum);
    }
}
