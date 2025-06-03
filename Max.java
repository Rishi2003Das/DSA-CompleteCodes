import java.util.*;
class Max{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number: ");
        int n1=sc.nextInt();
        System.out.println("Enter the Number: ");
        int n2=sc.nextInt();
        System.out.println("Enter the Number: ");
        int n3=sc.nextInt();
        System.out.println("Enter the Number: ");
        int n4=sc.nextInt();
        int max = (n1 > n2 && n1 > n3 && n1 > n4) ?
               n1 : ((n2 > n3 && n2 > n4) ?
               n2 : (n3 > n4 ? n3 : n4));
        System.out.println("Maximum of the 4 digits: "+ max);   
    }
}    