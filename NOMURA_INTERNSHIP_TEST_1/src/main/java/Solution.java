import java.util.*;

public class Solution {
    public int solution(int N, int[] A, int[] B) {
        // Implement your solution here
        HashMap<Integer, Integer> vertexConnectedMap = new HashMap<>();
        for (int a : A) {
            vertexConnectedMap.put(a, (vertexConnectedMap.get(a) == null ? 0 : vertexConnectedMap.get(a)) + 1);
        }
        for (int b : B) {
            vertexConnectedMap.put(b, (vertexConnectedMap.get(b) == null ? 0 : vertexConnectedMap.get(b)) + 1);
        }
        // 对哈希表的值进行降序排列
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(vertexConnectedMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        // 按照出现次数顺序乘以递减的N，求和
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : entryList) {
            sum += entry.getValue() * (N --);
        }
        return sum;
    }
}
