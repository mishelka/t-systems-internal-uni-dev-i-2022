public class ArrayCopyDemo {
    public static void main(String[] args) {
        int[] copyFrom = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 133, 14};
        int[] copyTo = new int[7];
        int[] copyFrom2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 133, 14};
        int[] copyTo2 = new int[7];

        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        for(int i : copyTo) {
            System.out.print(i + ",");
        }
        System.out.println();

        arraycopy(copyFrom2, 2, copyTo2, 0, 7);
        for(int i : copyTo) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    private static boolean arraycopy(int[] source, int srcIndex,
                                     int[] dest, int destIndex, int length) {
        return false;
    }
}
