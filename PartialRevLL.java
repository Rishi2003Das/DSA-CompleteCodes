class PartialRevLL {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right)
        return head;

        ListNode pres= head;
        ListNode prev= null;
        for(int i=0; pres!=null && i<left-1; i++){
            prev =pres;
            pres=pres.next;
        }

            ListNode last=prev;
            ListNode newEnd=pres;

            ListNode next= pres.next;
            for(int i=0; pres!=null && i<right-left+1 ; i++){
                pres.next=prev;
                prev=pres;
                pres=next;
                if(next != null){
                    next=next.next;
                }
            }
            if(last != null){
                last.next=prev;
            }
                else{
                    head=prev;
                }
            newEnd.next=pres;
                return head;
    }
}