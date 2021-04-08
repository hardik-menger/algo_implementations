import java.util.List;

class ListNode {
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

class RotateLinkedList {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int length = getLength(temp);
        if (length <= 1)
            return head;
        int tries = k % length;
        while (tries-- != 0 && temp != null) {
            ListNode runningHead = temp;
            temp = detachLast(temp);
            if (temp != runningHead)
                temp.next = runningHead;
        }
        return temp;
    }

    public int getLength(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private ListNode detachLast(ListNode head) {
        ListNode temp = head, pre = null;
        while (temp != null && temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        if (pre != null)
            pre.next = null;
        return temp;
    }

    public static void main(String[] args) {
        RotateLinkedList rotateLinkedList = new RotateLinkedList();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        rotateLinkedList.print(rotateLinkedList.rotateRight(root, 50000));
    }
}
