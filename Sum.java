class Sum{
int sum(int[] arr, int length) {
    int total = 0;
    for (int i = 0; i < length; i++) {
        total += arr[i];
    }
    return total;
}
public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int length = arr.length;
    Sum ob=new Sum();
    int result = ob.sum(arr, length);
    System.out.println("Sum of all elements in the array: " + result);
}
}