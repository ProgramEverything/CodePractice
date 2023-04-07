public class Solution_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        addNode(0, l1, l2, sentinel);
        return sentinel.next;
    }

    public void addNode(int jinWeiRu, ListNode l1, ListNode l2, ListNode l3) {
        // 把进位和l1, l2的值加起来，放到l3.next的node中
        if (jinWeiRu == 0 && l1 == null && l2 == null) {
            return;
        }
        int a = l1 == null ? 0 : l1.val;
        int b = l2 == null ? 0 : l2.val;
        int jinWeiChu = (jinWeiRu + a + b) / 10;
        l3.next = new ListNode((jinWeiRu + a + b) % 10);
        addNode(jinWeiChu, l1 == null ? null : l1.next, l2 == null ? null : l2.next, l3.next);
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
