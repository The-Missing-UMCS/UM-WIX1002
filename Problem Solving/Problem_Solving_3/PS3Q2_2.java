package com.fyiernzy.ProblemSolving.PS3;

// Reference: https://www.baeldung.com/java-iterate-map
// Reference: https://docs.oracle.com/javase/8/docs/api/java/util/Map.Entry.html
// Reference: https://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values

import java.util.*;

public class PS3Q2_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int N; String teamName; int teamScores;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		System.out.print("Enter number of team: ");
		N = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 0; i < N; i++) {
			System.out.printf("Enter team %d name: ", (i + 1));
			teamName = scanner.nextLine();
			System.out.printf("Enter team %d score: ", (i + 1));
			teamScores = scanner.nextInt();
			scanner.nextLine();
			map.put(teamName, teamScores);
		}
		scanner.close();
		
		Map<String, Integer> sortedMap = sortedByValue(map);
		System.out.println("List of team with the highest team score first");
		for(Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			System.out.printf("%s (%d) | ", entry.getKey(), entry.getValue());
		}
	}
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortedByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
		list.sort(Map.Entry.comparingByValue(
				new Comparator<V>(){
					@Override 
					public int compare(V v1, V v2) {
						return -1 * (v1.compareTo(v2));
					}
				}));
		
		Map<K, V> sortedMap = new LinkedHashMap<>();
		for(Map.Entry<K, V> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		
		return sortedMap;
	}
}
