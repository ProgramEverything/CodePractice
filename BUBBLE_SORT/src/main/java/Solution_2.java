import java.util.Arrays;

public class Solution_2 {
    public int[] BubbleSort(int[] ori) {
        int lastIndex = ori.length - 1;
        int temp;
        int tempLastIndex = 0;
        while (true) {
            // 用最后一次交换发生的索引来判断排序是否完成
            for (int i = 0; i < lastIndex; ++i) {
                if (ori[i] > ori[i + 1]) {
                    temp = ori[i];
                    ori[i] = ori[i + 1];
                    ori[i + 1] = temp;
                    tempLastIndex = i;
                }
            }
            System.out.println(Arrays.toString(ori));
            lastIndex = tempLastIndex;
            if (lastIndex == 0) {
                // 最后一次的交换发生在第一个，也就是全部交换完成
                break;
            }
        }
        return ori;
    }
}
