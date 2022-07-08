package arrays;

import java.util.Iterator;
import java.util.LinkedList;

//The difference between for, enhanced for and Iterator is only when using
// constructions such as LinkedList, where each list.get(i); has to traverse
// the list to get the item.
// In such cases, enhanced for or iterator is more efficient, because it
// only traverses the list/array once and always gets the next actual item.
public class EnhancedForTest {

	//this is used only for the sake of example, not a convention!
	private static long startTime;
	private static long endTime;
	private static int iteration = 0;

	public static void main(String[] args) {
		testEnhancedForLoop();
	}

	private static void testEnhancedForLoop() {
		LinkedList<Integer> list = new LinkedList<Integer>();

		int temp = 0;

		generateItems(list);

		// Loop 1 - for:
		recordStart();
		int size = list.size();
		for (int i = 0; i < size; i++) {
			Integer ii = list.get(i);
			temp = ii;

		}
		recordAndWriteEnd();

		// Loop 2 - enhanced for:
		recordStart();
		for (Integer ii : list) {
			temp = ii;
		}
		recordAndWriteEnd();

		// Loop 3 - Iterator:
		recordStart();
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			Integer ii = it.next();
			temp = ii;
		}
		recordAndWriteEnd();
	}

	private static void generateItems(LinkedList<Integer> list) {
		System.out.println("Generating items");
		for (int i = 0; i < 100000; i++) { // test different size
			list.add(new Integer(i));
		}
		System.out.println("Items generated");
	}

	private static void recordStart() {
		startTime = System.currentTimeMillis();
	}

	private static void recordAndWriteEnd() {
		endTime = System.currentTimeMillis();
		System.out.println("Loop " + ++iteration + " duration: "
				+ (endTime - startTime) + " milliseconds");
	}
}
