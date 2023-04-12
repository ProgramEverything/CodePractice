import java.util.Scanner;

public class TestSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            char input = scanner.nextLine().charAt(0);
            System.out.println(Solution.reverseBinary(input));
        }
    }
}
