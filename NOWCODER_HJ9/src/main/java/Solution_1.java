import java.util.HashSet;
import java.util.Scanner;

public class Solution_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            StringBuffer sb = null;
            try {
                Integer.parseInt(input);
                // 用hash集合判断重复
                HashSet<Character> integers = new HashSet<>();
                sb = new StringBuffer();
                int inputLength = input.length();
                for (int i = 0; i < inputLength; ++i) {
                    if (!integers.contains(input.charAt(inputLength - i - 1))) {
                        sb.append(input.charAt(inputLength - i - 1));
                        integers.add(input.charAt(inputLength - i - 1));
                    }
                    else {
                        // 啥也不做
                    }
                }
            }
            catch (Exception e) {

            }
            if (sb != null) {
                System.out.println(sb);
            }
        }
    }
}
