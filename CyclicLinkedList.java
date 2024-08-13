public class CyclicLinkedList {
    public ListNode detectCycle(ListNode head) {
        int len = 0;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                len = lenCycle(head);
                break;
            }
        }
        if (len == 0)
            return null;
        ListNode f = head;
        ListNode s = head;
        while (len > 0) {
            s = s.next;
            len--;
        }
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return f;
    }

    public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
    public int lenCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode temp = slow;
                int l = 0;
                do {
                    temp = temp.next;
                    l++;
                } while (temp != slow);
                return l;
            }
        }
        return 0;
    }
}
