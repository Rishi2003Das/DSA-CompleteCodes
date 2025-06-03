import java.util.Scanner;
public class IntegerArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total number of elements: ");
        int limit = scanner.nextInt();
        int[] array = new int[limit]; // Memory allocation
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < limit; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("The elements in the array are:");
        for (int i = 0; i < limit; i++) {
            System.out.print(array[i] + " ");
        }
        // Deallocate array memory not necessary in Java        
    }
}