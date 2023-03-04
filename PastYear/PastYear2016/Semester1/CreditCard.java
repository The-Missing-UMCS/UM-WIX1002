package PastYear2016.S1;

import java.util.*;

public class CreditCard {
	protected String name;
	protected String cardNo;
	protected String type;
	
	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer e1, Integer e2) {
				return -Integer.compare(e1, e2);
			}
		});
		map.put(5, "Hello");
		map.put(2, "Guys");
		map.put(3, "Java");
		map.forEach((x, y) -> System.out.println(x + " = " + y));
	}
}
