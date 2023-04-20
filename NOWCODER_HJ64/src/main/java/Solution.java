import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int musicNum = 0;
        if (scanner.hasNextInt()) {
            musicNum = scanner.nextInt();
        }
        scanner.nextLine();
        String commands = "";
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
    static class screenMenu {
        public int totalMusic;
        // [begin, end)规定了显示范围，end - begin = 4
        public int begin;
        public int end;
        public int cursor;
        public screenMenu(int totalMusic) {
            this.totalMusic = totalMusic;
            this.end = 4;
        }
        public void moveUp() {

        }
    }
}
