import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taskNum = 0;
        if (scanner.hasNextInt()) {
            taskNum = scanner.nextInt();
        }
        scanner.nextLine();
        int cnt = 0;
        int[][] taskTimeSlots = new int[taskNum][2];
        int startTime = Integer.MAX_VALUE;
        int endTime = 0;
        while (cnt < taskNum) {
            if (scanner.hasNextLine()) {
                String[] inputSplit = scanner.nextLine().split(" ");
                taskTimeSlots[cnt][0] = Integer.parseInt(inputSplit[0]);
                taskTimeSlots[cnt][1] = Integer.parseInt(inputSplit[1]);
                if (taskTimeSlots[cnt][0] < startTime) {
                    startTime = taskTimeSlots[cnt][0];
                }
                if (taskTimeSlots[cnt][1] > endTime) {
                    endTime = taskTimeSlots[cnt][1];
                }
                cnt++;
            }
        }
        Set<Integer> taskSet = new HashSet<>();

    }
}
