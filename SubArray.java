import java.util.*;
class SubArray{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the target sum: ");
        int targetSum = sc.nextInt();
        int start = 0;
        int end = 0;
        int sum = arr[0];
        boolean found = false;
        while (end < n) {
            if (sum == targetSum) {
                found = true;
                break;
            }
            else if (sum < targetSum) {
                end++;
                if (end < n) {
                    sum += arr[end];
                }
            }
            else 
            {
                sum -= arr[start];
                start++;
            }
        }
        if (found) {
            System.out.print("Subarray with target sum: ");
            for (int i = start; i <= end; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.println("No subarray found with target sum.");
        }
    }
}