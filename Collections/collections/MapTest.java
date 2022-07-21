package collections;

import java.util.*;

public class MapTest {
	public static void main(String[] args) {
		Map<String, Item> m1 = new HashMap<String, Item>();
		fillAndPrintMap(m1);

		Map<String, Item> m2 = new TreeMap<String, Item>();
		fillAndPrintMap(m2);

		Map<String, Item> m3 = new LinkedHashMap<String, Item>();
		fillAndPrintMap(m3);

		System.out.println(m1.keySet());
		System.out.println(m1.values());
	}

	private static void fillAndPrintMap(Map<String, Item> map){
		Item item;
		item = new Item("IPQ", "IPAQ", 22);
		map.put(item.getCode(), item);

		item = new Item("PPC", "POCKET PC", 33);
		map.put(item.getCode(), item);

		item = new Item("SPC", "SUPER PC", 44);
		map.put(item.getCode(),item);

		item = new Item("IPQ", "IPAQ2", 55);
		map.put(item.getCode(), item);

		System.out.println(map.get("IPQ"));

		System.out.print(map);
		System.out.println(":" + ((Object)map).getClass().getName());
	}
}
