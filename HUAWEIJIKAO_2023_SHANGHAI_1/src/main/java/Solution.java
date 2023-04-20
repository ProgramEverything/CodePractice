import java.util.Arrays;
import java.util.Scanner;

public class Solution {
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
        int[] timeMap = new int[endTime - startTime + 1];   // 因为时间是闭区间，即[0, mapSize]，哈希表长度+1
        for (int[] taskTimeSlot : taskTimeSlots) {
            for (int i = taskTimeSlot[0]; i <= taskTimeSlot[1]; ++i) {
                timeMap[i - startTime] ++;
            }
        }
        int sum = 0;
        for (int i = startTime; i <= endTime; ++i) {
            if (timeMap[i - startTime] == 0) {
                sum ++;
            }
            else if (timeMap[i - startTime] == 1) {
                sum += 3;
            }
            else {
                sum += 4;
            }
        }
        System.out.println(sum);
    }
}
