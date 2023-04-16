import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // 给出的砝码能称出多少重量
        Scanner scanner = new Scanner(System.in);

        // 读重量有多少种
        int totalWeightsType = 0;
        if (scanner.hasNextInt()) {
            totalWeightsType = scanner.nextInt();
        }
        scanner.nextLine();

        // 读每种重量的值
        int[] weights = new int[totalWeightsType];
        String[] weightsStringSplit = new String[totalWeightsType];
        if (scanner.hasNextLine()) {
            weightsStringSplit = scanner.nextLine().split(" ");
        }
        for (int i = 0; i < totalWeightsType; ++i) {
            weights[i] = Integer.parseUnsignedInt(weightsStringSplit[i]);
        }

        // 读每种重量有多少个
        int[] weightsCount = new int[totalWeightsType];
        String[] weightsCountSplit = new String[totalWeightsType];
        if (scanner.hasNextLine()) {
            weightsCountSplit = scanner.nextLine().split(" ");
        }
        for (int i = 0; i < totalWeightsType; ++i) {
            weightsCount[i] = Integer.parseUnsignedInt(weightsCountSplit[i]);
        }

        // 用set集合去除重复，这个集合不含0，能称出的重量种数就是集合的size加1
        // 遍历所有砝码（应该不排序也没事），每遍历到一个重量，就给set集合插入原集合中所有重量加该重量，以及该重量自身
        Set<Integer> combinedWeights = new HashSet<>();
        for (int i = 0; i < weights.length; ++i) {
            for (int j = 0; j < weightsCount[i]; ++j) {
                // 当前重量为weights[i]，重复weigthsCount[i]遍
                List<Integer> temp = new ArrayList<>();
                for (Integer combinedWeight : combinedWeights) {
                    temp.add(combinedWeight + weights[i]);
                }
                combinedWeights.add(weights[i]);
                combinedWeights.addAll(temp);
            }
        }

        System.out.println(combinedWeights.size() + 1);
    }
}
