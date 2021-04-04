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

class MergekSortedLists {
    ListNode merge2LinkedList(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        if (list1 == null)
            temp.next = list2;
        if (list2 == null)
            temp.next = list1;
        return res.next;
    }

    public ListNode solution2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = merge2LinkedList(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }

    public ListNode solution1(ListNode[] lists) {
        ListNode newroot = null, resultroot = null;
        while (true) {
            int min = Integer.MAX_VALUE;
            int selectedNodeIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    selectedNodeIndex = i;
                }
            }
            if (selectedNodeIndex == -1)
                break;
            if (newroot == null) {
                newroot = new ListNode(min);
                resultroot = newroot;
            } else {
                newroot.next = new ListNode(min);
                newroot = newroot.next;
            }
            lists[selectedNodeIndex] = lists[selectedNodeIndex].next;
        }
        return resultroot;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return solution2(lists);
    }

}