import java.util.Scanner;
class PalindromeChecker {
   public static void main(String args[]) {
      String O, rev = "";
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter a string to check if it is a palindrome:");
      O = scanner.nextLine();
      int len = O.length();
      for (int i = len - 1; i >= 0; i--)
         rev = rev + O.charAt(i);
      if (O.equals(rev))
         System.out.println("The entered string is a palindrome.");
      else
         System.out.println("The entered string is not a palindrome.");
   }
}
