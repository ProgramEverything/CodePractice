import java.util.Arrays;

public class Solution_1 {
    public int[] BubbleSort(int[] ori) {
        int temp;
        for (int i = 0; i < ori.length - 1; ++i) {
            // 因为每轮冒泡一定会把最大的一个移动到最后，所以最多要进行ori.length - 1次交换
            // 因为最后一次交换是让两个数字到位
            for (int j = 0; j < ori.length - 1; ++j) {
                // 一轮冒泡，因为是ori[j]和ori[j + 1]换，所以循环次数是ori.length - 1
                if (ori[j] > ori[j + 1]) {
                    temp = ori[j];
                    ori[j] = ori[j + 1];
                    ori[j + 1] = temp;
                }
            }
            System.out.println("第" + i + "轮冒泡结果：" + Arrays.toString(ori));
        }
        return ori;
    }
}
