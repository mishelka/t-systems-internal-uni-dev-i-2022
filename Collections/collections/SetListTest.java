package collections;

import java.util.*;

public class SetListTest {
	public static void main(String[] args) {
		Set<String> s1 = new HashSet<String>();
		fillAndPrintCollection(s1);

		Set<String> s2 = new TreeSet<String>();
		fillAndPrintCollection(s2);

		Set<String> s3 = new LinkedHashSet<String>();
		fillAndPrintCollection(s3);

		List<String> l1 = new ArrayList<String>();
		fillAndPrintCollection(l1);

		List<String> l2 = new LinkedList<String>();
		fillAndPrintCollection(l2);

		//Testovanie hashCode
		Item item1 = new Item("IPQ", "IPAQ", 22);
		Item item2 = new Item("IPQ", "IPAQ", 44);

        //Set<Item> s = new HashSet<Item>();
		Set<Item> s = new TreeSet<Item>();
		s.add(item1);

		System.out.println("Equals: " + item1.equals(item2));
		System.out.println("Hash codes: " + item1.hashCode() + " " + item2.hashCode());

		System.out.println("Contains item1: " + s.contains(item1));
		System.out.println("Contains item2: " + s.contains(item2));
	}

	private static void fillAndPrintCollection(Collection<String> c){
		c.add("Jano");
		c.add("Vlado");
		c.add("Fero");
		c.add("Jano");
		c.add("Jozo");
		c.add("Peter");
		c.add("Vlado");
		c.add("Laco");

		System.out.print(c);
		System.out.print(":" + ((Object)c).getClass().getName());
		System.out.println(" size=" + c.size());
	}
}
