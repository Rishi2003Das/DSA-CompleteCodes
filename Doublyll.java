import java.util.*;

class Doublyll{
    private class Node{
        int val;
        Node next;
        Node prev;
        
        public Node(int val){
            this.val=val;
        }
        
        public Node(int val, Node next, Node prev){
            this.val=val;
            this.next=next;
            this.prev=prev;
        }
    }
    private Node head;
    private Node tail;
    private int size;
        public void insertFirst(int val){
        Node node=new Node(val);
        node.next=head;
        node.prev=null;
        if(head!=null)// To prevent null pointer exception
        head.prev=node;
        head=node;
    }
    
        public void insertLast(int val){
        Node node= new Node(val);
        Node last= head;
        if(head!=null){
        while(head.next!=null){
            last=head.next;
        }
    }
    head=node;
    head.prev=null;
    }
    
        public void insert(int val, int index){
            Node node= new Node(val);
        if(index == 0){
         insertFirst(val);
         return;
        }
         if (index == (size-1)){
         insertLast(val);
         return;
        }
        Node temp= head;
        int i=1;
        while(i!=index){
            temp= temp.next;
        }
        node.next=temp.next;
        temp.next=node;
        node.prev=temp;
        if(node.next!=null)
        node.next.prev=node;
    }
    
        public void display(){
         Node node = head;
         while(node!= null){
             System.out.print(node.val + " -> ");
             node= node.next;
         }
         System.out.println("Null");
    }
    
        public void revdisplay(){
         Node node = tail;
         while(node!= null){
             System.out.print(node.val + " -> ");
             node= node.prev;
         }
         System.out.println("Null");
     }
     
}