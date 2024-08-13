class PalindromeLL {
    //The main driver non- static function
    public boolean isPalindrome(ListNode head) {
        ListNode mid= middleNode(head);
        ListNode rev= reverseList(mid);
        ListNode rerev=rev;

        //Comparing both the halves
        while(head!= null && rev!=null){
            if(head.val != rev.val){
                break;
            }
            head=head.next;
            rev=rev.next;
        }
        
        //Rereversing the list to its proper format
        reverseList(rerev);

        return head == null || rev ==null;
    }
        public ListNode middleNode(ListNode head) {
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