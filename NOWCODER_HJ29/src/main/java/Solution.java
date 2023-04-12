import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String plainInput = "";
        if (scanner.hasNextLine()) {
            plainInput = scanner.nextLine();
        }
        String encodedInput = "";
        if (scanner .hasNextLine()) {
            encodedInput = scanner.nextLine();
        }
        char[] chars = new char[plainInput.length()];
        for (int i = 0; i < plainInput.length(); ++i) {
            chars[i] = encodeChar(plainInput.charAt(i));
        }
        System.out.println(String.copyValueOf(chars));
        chars = new char[encodedInput.length()];
        for (int i = 0; i < encodedInput.length(); ++i) {
            chars[i] = decodeChar(encodedInput.charAt(i));
        }
        System.out.println(String.copyValueOf(chars));
    }
    public static char encodeChar(char c) {
        if (c >= 'a' && c <= 'y') {
            return (char) (c - 'a' + 'A' + 1);
        }
        else if (c >= 'A' && c <= 'Y') {
            return (char) (c - 'A' + 'a' + 1);
        }
        else if (c == 'z') {
            return 'A';
        }
        else if (c == 'Z') {
            return 'a';
        }
        else if (c >= '0' && c <= '8') {
            return (char) (c + 1);
        }
        else if (c == '9') {
            return '0';
        }
        else {
            return c;
        }
    }
    public static char decodeChar(char c) {
        if (c >= 'b' && c <= 'z') {
            return (char) (c - 'a' + 'A' - 1);
        }
        else if (c >= 'B' && c <= 'Z') {
            return (char) (c - 'A' + 'a' - 1);
        }
        else if (c == 'a') {
            return 'Z';
        }
        else if (c == 'A') {
            return 'z';
        }
        else if (c >= '1' && c <= '9') {
            return (char) (c - 1);
        }
        else if (c == '0') {
            return '9';
        }
        else {
            return c;
        }
    }
}
