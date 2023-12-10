package Programs;
import java.util.*;
class Queue{
  int a[];
  int f;
  int r; 
  int s;
  Queue(int size){
      s=size;
      a=new int[s];
      f=r=0;
    }
  void insert(int v){
      if(r==s-1)
       System.out.println("Queue over flow");
      else
        a[++r]=v;
    }
  void delete(){
       if(f==r)
        System.out.println("Queue underflow");
      else
        System.out.println("deleted element"+a[++f]);
    }
  void display(){
       if(f==r)
       System.out.println("stack underflow");
      else
         { for(int i=f+1 ; i<=r; i++)
              System.out.print(a[i]+"  ");
            }
        }
  public static void main(String args[]){
      int s; char an ;
      Scanner sc=new Scanner(System.in);
      do{
          System.out.println("enter the size of stack");
           s=sc.nextInt();
        }while(s<=0);
        Queue ob=new Queue(s);
      do{ System.out.println("press 1 for push , 2 for pop , 3 for display");
            System.out.println("enter your choice");
            int ch=sc.nextInt();
            switch(ch){
                case 1: System.out.println("enter the element");
                         int x=sc.nextInt();
                          ob.insert(x);
                           break ;
                 case 2: ob.delete();
                             break ;
                 case 3 : ob.display();
                              break ;
                 default: System.out.println("wrong choice");
                }
             System.out.println("Do you wants to continue(y/n)");   
              an=sc.next().charAt(0);
            }while(an=='y' || an=='Y');
        }
    }