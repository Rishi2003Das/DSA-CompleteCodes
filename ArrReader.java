import java.util.Scanner;
class ArrReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total number of elements: ");
        int l = scanner.nextInt();
        int[] arr = new int[l];
        System.out.println("Enter the elements of the arr:");
        for (int i = 0; i < l; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("The elements in the arr are:");
        for (int i = 0; i < l; i++) {
            System.out.print(arr[i] + " ");
        }
        arr = null;
    }
}