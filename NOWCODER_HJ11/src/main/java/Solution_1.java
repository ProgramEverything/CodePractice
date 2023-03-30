import java.util.Scanner;

public class Solution_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] strings = input.split(" ");
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < strings.length; ++i) {
                sb.append(strings[strings.length - i - 1]);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}
