import java.util.*;
class CharSen {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        String str= s.toUpperCase();
        System.out.print("Enter a character in upper case to search for: ");
        char ch = sc.next().charAt(0);
        int c = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                c++;
                System.out.println("Found at index " + i);
            }
        }
        if (c == 0) {
            System.out.println("Character not found in string.");
        } else {
            System.out.println("Total occurrences of " + ch + " in string: " + c);
        }
    }
}

