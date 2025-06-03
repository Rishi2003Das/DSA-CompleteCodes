class RecurASum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = calcSum(array, array.length - 1);
        System.out.println("Sum of array elements: " + sum);
    }
    public static int calcSum(int[] array, int index) {
        if (index == 0) {
            return array[index];
        }
       return array[index] + calcSum(array, index - 1);
    }
}