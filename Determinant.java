import java.util.*;
class Determinant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows;
        int cols;
        do{
        System.out.print("Enter the number of rows in the matrix: ");
        rows = sc.nextInt();
        System.out.print("Enter the number of columns in the matrix: ");
        cols = sc.nextInt();
        }while(rows!=cols);
        System.out.println("Enter the elements of the matrix:");
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
        System.out.println("Determinant of the matrix is: " + determinant(matrix));
    }
    public static double determinant(double[][] matrix) {//Recursion
    int n = matrix.length;
    if (n == 1) {
        return matrix[0][0];
    }
    if (n == 2) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }
    double det = 0;
    for (int j = 0; j < n; j++) {
        double[][] submatrix = new double[n - 1][n - 1];
        for (int i = 1; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (k < j) {
                    submatrix[i - 1][k] = matrix[i][k];
                } 
                else if (k > j) {
                    submatrix[i - 1][k - 1] = matrix[i][k];
                }
            }
        }
        double sign = (j % 2 == 0) ? 1 : -1;
        det += sign * matrix[0][j] * determinant(submatrix);
    }
    return det;
    }
}
