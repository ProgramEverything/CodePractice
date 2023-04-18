import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    static class LinkedNode {
        int val;
        LinkedNode next;
        public LinkedNode(int val, LinkedNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputSplit = new String[0];
        if (scanner.hasNextLine()) {
            inputSplit = scanner.nextLine().split(" ");
        }
        LinkedNode head = new LinkedNode(Integer.parseInt(inputSplit[1]), null);
        int length = Integer.parseInt(inputSplit[0]);
        int target = Integer.parseInt(inputSplit[inputSplit.length - 1]);
        for (int i = 0; i < length - 1; ++i) {
            int insertAt = Integer.parseInt(inputSplit[i * 2 + 3]);
            int insertVal = Integer.parseInt(inputSplit[i * 2 + 2]);
            insert(head, insertAt, insertVal);
        }
        LinkedNode p = head;
        if (head.val == target) {
            head = head.next;
        }
        else {
            while (p.next != null) {
                if (p.next.val == target) {
                    p.next = p.next.next;
                }
                p = p.next;
            }
        }
        p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
    public static void insert(LinkedNode head, int insertAt, int insertVal) {
        LinkedNode p = head;
        while (p != null) {
            if (p.val == insertAt) {
                p.next = new LinkedNode(insertVal, p.next);
                return;
            }
            p = p.next;
        }
    }
}
