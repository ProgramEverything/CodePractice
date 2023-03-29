import java.util.*;

public class Solution_1 {
    public static void main(String[] args) {
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
        TreeMap<Integer, Integer> keyValTreeMap = new TreeMap<>();
        while (cnt != length) {
            if (scanner.hasNextLine()) {
                cnt ++;
                String temp = scanner.nextLine();
                int key = Integer.parseInt(temp.split(" ")[0]);
                int val = Integer.parseInt(temp.split(" ")[1]);
                if (keyValTreeMap.containsKey(key)) {
                    keyValTreeMap.put(key, keyValTreeMap.get(key) + val);
                }
                else {
                    keyValTreeMap.put(key, val);
                }
            }
        }
        Iterator iter = keyValTreeMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) iter.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
