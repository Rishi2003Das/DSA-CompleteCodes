import java.util.*;
class Circularll{
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
      private Node head;
      private Node tail;
     
    public void insertLast(int val){
        Node node= new Node(val);
        if(head==null || tail==null){
        head=node;
        tail=node;
        }
        tail.next=node;
        node.next=head;
        tail=node;
        }
    
        public void display(){
            Node node = head;
            if(head!=null){
                do{
                    System.out.print(node.value + "->");
                    node=node.next;
                }while(node != head);
                }
                System.out.println("HEAD");
            }
            
            public void delete(int val){
                Node node=head;
                if(node ==  null)
                return;
                if(node.value == val){
                    head=head.next;
                    tail.next=head;
                }
                do{
                    Node n= node.next;
                    if(n.value == val){
                        node.next=n.next;
                        break;
                    }
                    node= node.next;
                }while(node!=head);
            }
            
        }
