import java.util.*;
class SumDigit{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the 4 digit number: ");
        int n=sc.nextInt();
        System.out.println("The sum of the 1st and the last digit of the number is: "+((n/1000)+(n%10)));
    }
}