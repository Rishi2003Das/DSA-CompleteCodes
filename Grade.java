import java.util.*;
class Grade{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the marks of the student: ");
        int m=sc.nextInt();
        if(m<50)
        System.out.println("F");
        else if(m>=50 && m<60)
        System.out.println("C");
        else if(m>=60 && m<70)
        System.out.println("B");
        else if(m>=70 && m<80)
        System.out.println("B+");
        else if(m>=80 && m<90)
        System.out.println("A");
        else
        System.out.println("A+");
}
}