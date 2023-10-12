import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Map<int[], Integer> map = new HashMap<>();
        int[] key = {0, 0};
        map.put(key, 10);
        System.out.println(map.containsKey(key));
        System.out.println(map.get(key));

        Map<String, Integer> map2 = new HashMap<>();
        String str = "hello";
        map2.put(str, 100);
        System.out.println(map2.containsKey("hello"));
        System.out.println(map2.get("hello"));
    }
}
