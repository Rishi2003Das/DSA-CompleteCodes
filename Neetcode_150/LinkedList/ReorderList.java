/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
        return;
        ListNode mid=mid(head);
        ListNode curr=head;
        ListNode ahead=reverse(mid);

        while(curr!=null && ahead!=null){
            ListNode temp=curr.next;
            curr.next=ahead;
            curr=temp;
            temp=ahead.next;
            ahead.next=curr;
            ahead=temp;
        }
        if(curr!=null)
        curr.next=null;
    }
    public ListNode mid(ListNode head){
        if (head == null || head.next == null)return head;
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head){
        if (head==null||head.next==null)return head;

        ListNode prev=null;
        ListNode curr=head;

        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
