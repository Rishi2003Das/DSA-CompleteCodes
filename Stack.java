package Programs;
import java.util.*;
class Stack{
  private int a[];
  private int top;
  private int s;
  Stack(int size){//Parameterised costructor
      s=size;
      a=new int[s];
      top=-1;
    }
  void push(int v){
      if(top==(s-1))
       System.out.println("Stack Overflow");
      else
        a[++top]=v;
    }
  void pop(){
       if(top==-1)
        System.out.println("Stack Underflow");
      else
        System.out.println("Deleted element: "+a[top--]);
    }
  void display(){
       if(top==-1)
       System.out.println("Stack Underflow");
      else
         { for(int i=top ; i>=0; i--)
              System.out.print(a[i]+"  ");
            }
        }
  public static void main(String args[]){
      int s; char an ;
      Scanner sc=new Scanner(System.in);
      do{
          System.out.println("Enter the size of stack");
           s=sc.nextInt();
        }while(s<=0);
        Stack ob=new Stack(s);
      do{ 
          System.out.println("Press 1 for push , 2 for pop , 3 for display");
            System.out.println("Enter your choice:");
            int ch=sc.nextInt();
            switch(ch){
                case 1: System.out.println("Enter the element");
                         int x=sc.nextInt();
                          ob.push(x);
                           break ;
                 case 2: ob.pop();
                             break ;
                 case 3 : ob.display();
                              break ;
                 default: System.out.println("Wrong Choice");
                }
             System.out.println("Do you wants to continue(Y/N)");   
              an=sc.next().charAt(0);
            }while(an=='y' || an=='Y');
        }
    }