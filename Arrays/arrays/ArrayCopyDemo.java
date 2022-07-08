package arrays;

public class ArrayCopyDemo {
    private static long startTime;
    private static long endTime;
    private static int iteration = 0;

    public static void main(String[] args) {
        int[] arrayToSort = {10, 5, 1, 6, 19};
        int[] copyFrom = new int[11000];
        int[] copyTo = new int[11000];
        int[] copyFrom2 = new int[11000];
        int[] copyTo2 = new int[11000];

        //populate array
        for (int i = 0; i < 1000; i++) {
            copyFrom[i] = i + 10;
            copyTo[i] = 0;
            copyFrom[i] = i + 10;
            copyTo[i] = 0;
        }

        recordStart();
        System.arraycopy(copyFrom, 2, copyTo, 0, 10000);
        recordAndWriteEnd();

//        for(int i : copyTo) {
//            System.out.print(i + ",");
//        }
//        System.out.println();

        recordStart();
        arraycopy(copyFrom2, 2, copyTo2, 4, 10000);
        recordAndWriteEnd();

//        for(int i : copyTo) {
//            System.out.print(i + ",");
//        }
//        System.out.println();

        bubbleSort(arrayToSort);
    }

    private static boolean arraycopy(int[] source, int srcIndex,
                                     int[] dest, int destIndex, int length) {
        if (srcIndex + length >= source.length
                || destIndex + length >= dest.length) {
            return false;
        }
        String abc = "";
        for (int i = 0; i < length; i++) {
            dest[destIndex + i] = source[srcIndex + i];

            //!!! nie !!!
            //abc += dest[destIndex + 1];
            //System.out.println(dest[destIndex + 1]);
        }
        System.out.println(abc);
        return true;
    }

    private static void recordStart() {
        startTime = System.currentTimeMillis();
    }

    private static void recordAndWriteEnd() {
        endTime = System.currentTimeMillis();
        System.out.println("Loop " + ++iteration + " duration: "
                + (endTime - startTime) + " milliseconds");
    }

    private static void bubbleSort(int[] array) {
        //zotriedit pole pomocou bubble sort
        //pomocna funkcia swap
    }

    private static void printArray(int[] array) {
        //vypisat polozky v poli
    }
}
