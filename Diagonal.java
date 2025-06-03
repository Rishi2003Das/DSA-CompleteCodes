import java.util.*;
class Diagonal{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows in the matrix: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns in the matrix: ");
        int col = sc.nextInt();
        int matrix[][]= new int[rows][col];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Original matrix:");
        displayMatrix(matrix, rows, col);
        for (int i = 0; i < rows; i++) {
            int temp = matrix[i][i];
            matrix[i][i] = matrix[i][col-i-1];
            matrix[i][col-i-1] = temp;
        }
        System.out.println("Matrix after diagonal interchange:");
        displayMatrix(matrix, rows, col);
    }
    public static void displayMatrix(int[][] matrix, int rows, int col) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
