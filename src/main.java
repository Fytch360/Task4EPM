import java.util.Scanner;
import java.util.Arrays;
import java.util.NavigableMap;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of matrix: ");
        int size = scanner.nextInt();
        int matrix[][] = new int[size][size];
        RandomedMatrix(matrix, size);
        matrix = RandomedMatrix(matrix, size);
        System.out.println("Matrix: ");
        printMatrix(matrix, size);
        matrixInIncreaseOrder(matrix, size);
        sumMatrixBetweenNegativeElem(matrix);

    }

    public static int[][] RandomedMatrix(int[][] matrix, int size) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 2 * size - size);
            }
        }
        return matrix;
    }

    private static int[][] printMatrix(int[][] matrix, int size) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        return matrix;
    }

    private static void matrixInIncreaseOrder(int[][] matrix, int size) {
        int[] vector = new int[size * size];
        int[][] matrixSort = new int[size][size];
        int n = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                vector[i * size + j] = matrix[i][j];
        Arrays.sort(vector);
        for (int m = 0; m < matrixSort.length; m++) {
            for (int l = 0; l < matrixSort[m].length; l++) {
                matrixSort[m][m] = vector[n];
                n++;
            }
        }
        System.out.println("Matrix in increase order: ");
        for (int i = 0; i < matrixSort.length; i++) {
            for (int j = 0; j < matrixSort[i].length; j++) {
                System.out.print(matrixSort[i][j] + "\t");
            }
            System.out.println();
        }

    }

    private static void sumMatrixBetweenNegativeElem(int[][] matrix) {

        int indexStart = 0;
        int indexEnd = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] < 0) {
                    indexStart = j;
                    break;

                }
            }

            for (int j1 = indexStart + 1; j1 < matrix[i].length; j1++) {
                if (matrix[i][j1] < 0) {
                    indexEnd = j1;
                    break;

                }
            }

            int sum = 0;
            for (int l = indexStart + 1; l < indexEnd; l++)
                sum += matrix[i][l];
            System.out.println("Elements: " + matrix[i][indexStart] + "," + matrix[i][indexEnd] + " " + "Sum: " + sum);

        }
    }
}





