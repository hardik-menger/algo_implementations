class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode even = head.next, odd = head;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = head.next;
        return odd;
    }
}
