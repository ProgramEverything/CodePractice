import java.util.Scanner;

public class Solution {
    public static int[] parseIp(String input) {
        String[] splitInput = input.split("\\.");
        int[] parsedIp = new int[4];
        for (int i = 0; i < 4; ++i) {
            parsedIp[i] = Integer.parseInt(splitInput[i]);
        }
        return parsedIp;
    }
    public static long parsedIpToInteger(int[] parsedIp) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; ++i) {
            String temp = Integer.toBinaryString(parsedIp[i]);
            for (int j = 0; j < 8 - temp.length(); ++j) {
                sb.append("0");
            }
            sb.append(temp);
        }
        return Long.parseUnsignedLong(sb.toString(), 2);
    }
    public static String stringToFullBinary(String input2) {
        input2 = Integer.toBinaryString(Integer.parseUnsignedInt(input2));
        int prefix = 32 - input2.length();
        for (int i = 0; i < prefix; ++i) {
            input2 = "0" + input2;
        }
        return input2;
    }
    public static int[] fullBinaryToIp(String fullBinary) {
        int[] splitInput2 = new int[4];
        for (int i = 0; i < 32; i = i + 8) {
            splitInput2[i / 8] = Integer.parseInt(fullBinary.substring(i, i + 8), 2);
        }
        return splitInput2;
    }
    public static String joinInt(int[] intIp) {
        StringBuffer sb = new StringBuffer();
        for (int i : intIp) {
            sb.append(i + ".");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
        int[] parsedIp = parseIp(input);
        System.out.println(parsedIpToInteger(parsedIp));

        String input2 = null;
        if (scanner.hasNextLine()) {
            input2 = scanner.nextLine();
        }
        System.out.println(joinInt(fullBinaryToIp(stringToFullBinary(input2))));
    }
}
