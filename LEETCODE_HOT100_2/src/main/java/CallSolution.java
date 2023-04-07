public class CallSolution {
    public static void main(String[] args) {
        Solution_1.ListNode l1 = arrayToLinkedList(new int[] {2,4,3});
        Solution_1.ListNode l2 = arrayToLinkedList(new int[] {5,6,4});
        Solution_1 s = new Solution_1();
        Solution_1.ListNode l3 = s.addTwoNumbers(l1, l2);
    }

    public static Solution_1.ListNode arrayToLinkedList(int[] array) {
        Solution_1.ListNode sentinel = new Solution_1.ListNode(0);
        Solution_1.ListNode p = sentinel;
        for (int i : array) {
            p.next = new Solution_1.ListNode(i);
            p = p.next;
        }
        return sentinel.next;
    }
}
