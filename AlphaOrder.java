import java.util.*;
class AlphaOrder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String os = input.nextLine();
        input.close();
        char[] charArray = os.toCharArray();
        Arrays.sort(charArray);
        String ss = new String(charArray);
        System.out.println("Original string: " + os);
        System.out.println("String in alphabetical order: " + ss);
    }
}