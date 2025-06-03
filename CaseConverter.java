import java.util.*;
class CaseConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String input = sc.nextLine();
        String out = "";
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                out += Character.toLowerCase(currentChar);
            } else if (Character.isLowerCase(currentChar)) {
                out += Character.toUpperCase(currentChar);
            } else {
                out += currentChar;
            }
        }
        System.out.println("Output: " + out);
    }
}