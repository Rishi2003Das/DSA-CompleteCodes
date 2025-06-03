import java.util.*;  
class SecLarge{
  public static void main(String args[]) {
      Scanner sc=new Scanner(System.in);
        System.out.print("Enter the first number:");
        int num1 = sc.nextInt(); 
        System.out.print("Enter the second number:");
        int num2 = sc.nextInt();
        System.out.print("Enter the third number:");
        int num3 =sc.nextInt(); 
        if (num1 > num2 && num1 < num3 || num1 > num3 && num1 < num2)
            System.out.println("The second largest number is "+num1);
        else if (num2 > num1 && num2 < num3 || num2 > num3 && num2 < num1)
            System.out.println("The second largest number is "+num2);
        else
            System.out.println("The second largest number is "+num3);
    }
}