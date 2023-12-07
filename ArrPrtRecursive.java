class ArrPrtRecursive {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        printArr(array, 0);
    }
    public static void printArr(int[] arr, int i) {
        if (i >= arr.length) {
            return;
        }
        System.out.println(arr[i]);
        printArr(arr, i + 1);
    }
}
