import java.util.Scanner;

public class Solution_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            String[] temp = input.split("x");
            String split = temp[temp.length - 1];
            System.out.println(Integer.parseInt(split, 16));
        }
    }
}
