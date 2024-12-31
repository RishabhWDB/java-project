import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input dimensions for the first matrix
        System.out.print("Enter the number of rows for the first matrix: ");
        int rows1 = scanner.nextInt();
        System.out.print("Enter the number of columns for the first matrix: ");
        int cols1 = scanner.nextInt();

        // Input dimensions for the second matrix
        System.out.print("Enter the number of rows for the second matrix: ");
        int rows2 = scanner.nextInt();
        System.out.print("Enter the number of columns for the second matrix: ");
        int cols2 = scanner.nextInt();

        // Ensure matrices can be multiplied
        if (cols1 != rows2) {
            System.out.println("Matrix multiplication is not possible. Columns of first matrix must equal rows of second matrix.");
            return;
        }

        // Input elements of the first matrix
        int[][] matrix1 = new int[rows1][cols1];
        System.out.println("Enter elements of the first matrix:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                System.out.printf("Element [%d][%d]: ", i, j);
                matrix1[i][j] = scanner.nextInt();
            }
        }

        // Input elements of the second matrix
        int[][] matrix2 = new int[rows2][cols2];
        System.out.println("Enter elements of the second matrix:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.printf("Element [%d][%d]: ", i, j);
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // Perform matrix multiplication
        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        // Display the resulting matrix
        System.out.println("The product of the matrices is:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
