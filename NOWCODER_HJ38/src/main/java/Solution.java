import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = 0;
        if (scanner.hasNextInt()){
            height = scanner.nextInt();
        }
        scanner.nextLine();
        // 第一次触地经过的距离就是1倍高度
        float totalDistance = height;
        float temp = height;
        for (int i = 1; i < 5; ++i) {
            totalDistance += temp;
            temp = temp / 2;
        }
        System.out.println(totalDistance);
        System.out.println(temp / 2);
    }
}
