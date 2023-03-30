import java.util.*;

public class Solution_2 {
    public static void main(String[] args) {
        // 用hashmap存储，但是在输出时，使用排序了的键列表
        Scanner scanner = new Scanner(System.in);
        int length = 0;
        if (scanner.hasNextInt()) {
            length = scanner.nextInt();
        }
        if (length == 0) {
            return;
        }
        scanner.nextLine();
        int cnt = 0;
        HashMap<Integer, Integer> keyValHashMap = new HashMap<>();
        while (cnt != length) {
            if (scanner.hasNextLine()) {
                cnt ++;
                String temp = scanner.nextLine();
                int key = Integer.parseInt(temp.split(" ")[0]);
                int val = Integer.parseInt(temp.split(" ")[1]);
                if (keyValHashMap.containsKey(key)) {
                    keyValHashMap.put(key, keyValHashMap.get(key) + val);
                }
                else {
                    keyValHashMap.put(key, val);
                }
            }
        }
        // ArrayList<Integer> keyArray = new ArrayList<>(keyValHashMap.keySet());  // new ArrayList<>()能接收的参数是int capacity, Collection<>
        Integer[] keyArray = new Integer[keyValHashMap.size()];
        keyValHashMap.keySet().toArray(keyArray);
        Arrays.sort(keyArray);
        for (int i : keyArray) {
            System.out.println(i + " " + keyValHashMap.get(i));
        }
    }
}
