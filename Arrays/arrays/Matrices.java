package arrays;

public class Matrices {
    public static void main(String[] args) {
        //int[][] aMatrix = new int[4][];
        int[][] aMatrix = new int[4][5];
        int[][] bMatrix = new int[4][5];
        //{null, ..., null}
        //{{0, 0, 0, 0, 0}, ..., {0, 0, 0, 0, 0}}

        int[][] addition = addMatrices(aMatrix, bMatrix);
        int[][] transposed = transpose(aMatrix);
        int[][] multiplied = multiply(aMatrix, bMatrix);

        //print matrix
        printMatrix(aMatrix);
        printMatrix(bMatrix);
    }

    private static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int[][] matrixC = new int[4][];
        //sucet matic - kazdy prvok s kazdym prvkom
        //vysledok bude v matrixC
        return matrixC;
    }

    private static int[][] transpose(int[][] matrix) {
        int[][] transposed = new int[4][];
        //https://cs.wikipedia.org/wiki/Transpozice_matice
        //vysledok bude v matrixC
        return transposed;
    }

    private static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int[][] matrixC = new int[4][];
        //https://www.math.sk/skripta/node46.html
        //vysledok bude v matrixC
        return matrixC;
    }

    private static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
