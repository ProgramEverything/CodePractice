import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = "^[WASD]\\d+";
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] opCodes = input.split(";");
            int[] position = new int[2];
            for (String opCode : opCodes) {
                if (opCode.matches(pattern)) {
                    char direction = opCode.toCharArray()[0];
                    int distance = Integer.parseInt(opCode.substring(1));
                    switch (direction) {
                        case 'W':
                            position[1] += distance;
                            break;
                        case 'S':
                            position[1] -= distance;
                            break;
                        case 'A':
                            position[0] -= distance;
                            break;
                        case 'D':
                            position[0] += distance;
                    }
                }
                else {
                    // 什么也不做
                }
            }
            System.out.println(position[0] + "," + position[1]);
        }
    }
}
