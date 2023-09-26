import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        HashMap<Integer, Integer> testHashMap = new HashMap<>();
        Hashtable<Integer, Integer> testHashtable = new Hashtable<>();
        ConcurrentHashMap<Integer, Integer> benchmark = new ConcurrentHashMap<>();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; ++i) {
                    int kv = r.nextInt();
                    testHashMap.put(kv, kv);
                    testHashtable.put(kv, kv);
                    benchmark.put(kv, kv);
                }
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        Thread thread3 = new Thread(runnable);
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("=========== Result ==============");
        System.out.printf("HashMap表中共计有%d项键值对\n", testHashMap.size());
        System.out.printf("Hashtable表有%d项键值对\n", testHashtable.size());
        System.out.printf("ConcurrentHashMap表有%d项键值对\n", benchmark.size());
    }
}
