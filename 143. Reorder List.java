class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode slow = head, fast = head, prevMiddle = null;
        while (fast != null && fast.next != null) {
            prevMiddle = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevMiddle.next = null;
        ListNode curr = slow, prev = null;
        while (curr != null) {
            ListNode newNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newNext;
        }
        ListNode l2 = prev, l1 = head;
        while (l1 != null) {
            ListNode nextOne = l1.next, nextTwo = l2.next;
            l1.next = l2;
            if (nextOne == null)
                break;
            l1 = nextOne;
            l2.next = nextOne;
            l2 = nextTwo;
        }
    }
}
