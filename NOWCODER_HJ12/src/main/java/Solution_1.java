import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputLength = 0;
        if (scanner.hasNextInt()) {
            inputLength = scanner.nextInt();
        }
        if (inputLength == 0) {
            return;
        }
        scanner.nextLine();
        int cnt = 0;
        String[] strings = new String[inputLength];
        while (cnt != inputLength) {
            if (scanner.hasNextLine()) {
                cnt ++;
                strings[cnt - 1] = scanner.nextLine();
            }
        }
        Arrays.sort(strings);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
