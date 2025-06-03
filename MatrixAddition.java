import java.util.Scanner;
class MatrixAddition {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the number of rows in the matrices: ");
      int rows = sc.nextInt();
      System.out.print("Enter the number of columns in the matrices: ");
      int cols = sc.nextInt();
      int[][] matrix1 = new int[rows][cols];
      int[][] matrix2 = new int[rows][cols];
      int[][] resultMatrix = new int[rows][cols];
      System.out.println("Enter the elements of matrix1:");
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            matrix1[i][j] = sc.nextInt();
         }
        }
      System.out.println("Enter the elements of matrix2:");
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            matrix2[i][j] = sc.nextInt();
         }
      }
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
         }
      }
      System.out.println("The result matrix is:");
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            System.out.print(resultMatrix[i][j] + " ");
         }
         System.out.println();
      }
   }
}