import java.util.*;
class InsertionSortLL{    
    
    public ListNode insertionSortList(ListNode ptr) {    
        if (ptr == null || ptr.next == null)
            return ptr;
        
        ListNode preInsert, toInsert, dummyHead = new ListNode(0);
        dummyHead.next = ptr;

        while (ptr != null && ptr.next != null) {
            if (ptr.val <= ptr.next.val) {
                ptr = ptr.next;
            } else {      
                toInsert = ptr.next;
                // Locate preInsert.
                preInsert = dummyHead;
                while (preInsert.next.val < toInsert.val) {
                    preInsert = preInsert.next;
                }
                ptr.next = toInsert.next;
                // Insert toInsert after preInsert.
                toInsert.next = preInsert.next;
                preInsert.next = toInsert;
            }
        }
        
        return dummyHead.next;
    }
}