import java.util.*;
class LinkedList{
    private Node head;
    private Node tail;
    private int size;
    Node temp = head;
    
     public  LinkedList(){ //Default Constructor
        this.size = 0;
     }
     
     public void insertFirst(int val){
       Node node = new Node(val);
       node.next = head;
       head = node;
        
       if(tail == null){
           tail = head;
       }
       size+=1;
     }
     
     public void insertLast(int val){
         if(tail == null){
             insertFirst(val);
             return;
         }
         Node node = new Node(val);
         tail.next = node;
         tail = node;
         size++;
     }
     
     public void insertRecc(int val, int ind){
            if(ind!=0){
                 temp=temp.next;
                 insertRecc(val,--ind);
            }
            Node node = new Node(val);
            if(head == null)
            node=head;
            Node after= temp.next;
            temp.next = node;
            node.next = after;
            size++;
     }
     
     public void insertMiddle(int val, int ind){
         if(ind == 0){
         insertFirst(val);
         return;
        }
         if (ind == (size-1)){
         insertLast(val);
         return;
        }
             int i=1;
             Node temp = head;
             while(i!=ind){
             temp = temp.next;
             i++;
            }
            Node node = new Node(val, temp.next);
            temp.next = node;
         size++;
     }
     
     public int deleteFirst(){
         int val= head.value;
         head= head.next;
         size--;
         return val;
     }
     
     public int deleteLast(){
         if (size <= 1){
             return deleteFirst();
         }
         
         Node secLast = get(size-2);
         int val = secLast.next.value;
         tail = secLast;
         tail.next = null;
         size --;
         return val;
     }
     
     public Node get(int ind){
         Node node = head;
         for(int i=0; i<ind; i++){
             node = node.next;
         }
         return node;
     }
     
      public void display(){
         Node temp = head;
         while(temp!= null){
             System.out.print(temp.value + " -> ");
             temp= temp.next;
         }
         System.out.println("Null");
     }
     
     private class Node{
         private int value;
         private Node next;
         
         public Node(int value){ //Constructor
             this.value = value;
         }
         
         public Node(int value, Node next){ //Dynamic Constructor
             this.value =value;
             this.next = next;
         }
         
        }
}
