import java.util.Scanner;

public class Solution_2 {
    public static void main(String[] args) {
        // 读取连续的字符串
        Scanner scanner = new Scanner(System.in);
        String input = "";
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
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
