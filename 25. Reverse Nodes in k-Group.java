class ReverseNodesinkGroup {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        int curr = k;
        ListNode temp = head;
        while (curr-- != 0 && temp != null)
            temp = temp.next;
        if (temp != null) {
            ListNode nextGroupsPointer = reverseKGroup(temp, k);
            while (++curr != k) {
                ListNode nextNode = head.next;
                head.next = nextGroupsPointer;
                nextGroupsPointer = head;
                head = nextNode;
            }
            head = nextGroupsPointer;
        }
        return head;
    }
}
