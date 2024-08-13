//Reordering List
class ReOrderList {
    public void reorderList(ListNode head) {
        ListNode slow= head;
        ListNode fast= head;
        int i=0;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            i++;
        }
        ListNode now= slow;
        if(i%2==0){
            now=now.next.next;
            slow=slow.next;
        }
        else{
            now=now.next;
        }
        ListNode n=reverseList(now);
        ListNode  m= head;
        ListNode node1=m;
        ListNode node2=n;
        while(m!=null && n!=null){
            node1=m.next;
            node2=n.next;
            m.next=n;
            n.next=m;
        }
        if(node1!=null){
            node1.next=null;
        }
    }
        public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }
}