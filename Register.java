package Programs;
import java.util.*;
class Register{
    String stud[];
    int cap;
    int top;
    Register(int max){
        cap=max;
        top=-1;
        stud=new String[cap];
    }
    void push(String n){
        if(top==(cap-1))
        System.out.println("OVERFLOW");
        else
        stud[++top]=n;
    }
    String pop(){
        if(top==-1)
        return "$$";
        else
        {
            String s=stud[top];
            top--;
            return s;
        }
    }
    void display(){
        if(top==-1)
        System.out.println("Empty list");
        else
        for(int i=top;i>=0;i--)
        System.out.println(stud[i]+" ");
    }
    public static void main(String args[]){
      int s; char an ;
      Scanner sc=new Scanner(System.in);
      do{
          System.out.println("Enter the size of stack");
           s=sc.nextInt();
        }while(s<=0);
        Register ob=new Register(s);
      do{ 
          System.out.println("Press 1 for push , 2 for pop , 3 for display");
            System.out.println("Enter your choice:");
            int ch=sc.nextInt();
            switch(ch){
                case 1: System.out.println("Enter the element");
                         String x=sc.nextLine();
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