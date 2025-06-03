import java.util.*;
class StrSwap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string");
        String s = sc.nextLine();
        String d = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            d += ch;
        }
        System.out.println("s string: " + s);
        System.out.println("Copied string: " + d);
    }
}