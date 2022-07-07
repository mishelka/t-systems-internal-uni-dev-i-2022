public class ArrayOfArrays {
    public static void main(String[] args) {
        int[][] aMatrix = new int[4][];
        //int[][] aMatrix = new int[4][5];
        //{null, ..., null}
        //{{0, 0, 0, 0, 0}, ..., {0, 0, 0, 0, 0}}

        //populate matrix
        for (int r = 0; r < aMatrix.length; r++) {
            aMatrix[r] = new int[r+1];	//create sub-array
            for (int c = 0; c < aMatrix[r].length; c++) {
                aMatrix[r][c] = r + c;
            }
        }

        //print matrix
        for (int r = 0; r < aMatrix.length; r++) {
            for (int c = 0; c < aMatrix[r].length; c++) {
                System.out.print(aMatrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
