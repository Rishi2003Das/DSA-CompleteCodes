//Merge sort of a Linked List by using two external functions merge() and getMid()
class MergeSortLL {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        ListNode tail = node;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                tail.next = list2;
                list2 = list2.next;
            } else {
                tail.next = list1;
                list1 = list1.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 != null) ? list1 : list2;
        return node.next;
    }

    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null;
        }
        
        return slow;
    }

    public static void main(String[] args) {
        MergeSortLL sol = new MergeSortLL();
        
        // Test the solution with the given example
        ListNode testNode = new ListNode(1111111);
        // Populate the testNode with more values as needed

        ListNode sortedList = sol.sortList(testNode);
        
        // Print sorted list to verify
        while (sortedList != null) {
            System.out.print(sortedList.val + " ");
            sortedList = sortedList.next;
        }
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
