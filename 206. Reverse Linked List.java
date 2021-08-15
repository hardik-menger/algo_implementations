class ReverseLinkedList {
    public class ListNode {
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

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, next = head, cur = head;
        while (cur != null) {
            ListNode newnext = next.next;
            next.next = prev;
            prev = next;
            next = newnext;
            cur = cur.next;
        }
        return prev;
    }
}
