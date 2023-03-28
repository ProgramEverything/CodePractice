import java.util.Scanner;

public class Note {
    public static void main(String[] args) {
        // 可以反复输入
        Scanner scanner  = new Scanner(System.in);
        String input = "";
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            // 空字符串不处理
            if (input == "") {
                System.out.println("");
                return;
            }
            // 用取余得到最后要补齐的0的位数，然后把字符串每8位输出
            int totalLength = input.length();
            int inadequateLength = totalLength % 8 == 0 ? 0 : (8 - totalLength % 8);
            int adequateLength = totalLength + inadequateLength;
            for (int i = 0; i < inadequateLength; ++i) {
                input += "0";
            }
            for (int i = 0; i < adequateLength / 8; ++i) {
                System.out.println(input.substring(i * 8, i * 8 + 8));
            }
        }
    }
}
