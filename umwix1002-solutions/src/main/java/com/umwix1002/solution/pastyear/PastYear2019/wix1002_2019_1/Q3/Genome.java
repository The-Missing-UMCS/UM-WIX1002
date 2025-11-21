package com.umwix1002.solution.pastyear.PastYear2019.wix1002_2019_1.Q3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

public class Genome {
	private String genome;
	private static final String START_GENE = "ATG";
	private static final String[] END_GENE = {"TAG", "TGA", "TAA"};
	
	public Genome(String genome) {
		this.genome = genome;
	}
	
	public String getGenes() {
		ArrayList<String> ls = findGeneSet();
		if(ls.size() == 0) {
			return "No gene is found\n";
		} else {
			StringBuffer sb = new StringBuffer();
			ls.stream().forEach(gene -> sb.append(gene).append("\n"));
			return sb.toString();
		}
	}
	
	private ArrayList<String> findGeneSet() {
		ArrayList<String> ls = new ArrayList<>();
		
		int end, start, sp = 0, ep = 0;
		while((end = getEndGeneIndex(ep)) != -1) {
			if((start = getStartGeneIndex(sp, end)) != -1) {
				String gene = genome.substring(start + 3, end);
				if(gene.length() % 3 == 0 && gene.length() > 0)
					ls.add(gene);
				
				sp = start + 3;
			}
			
			ep = end + 3;
		}
		
		return ls;
	}
	
	private int getStartGeneIndex(int startIndex, int endIndex) {
		int fast, slow = -1, pointer = startIndex, limit = endIndex;
		
		while((fast = genome.indexOf(START_GENE, pointer)) != -1 && fast + 2 < limit) {	
			pointer = fast + 3;
			slow = fast;
		}
		
		return slow;
	}
	
	private int getEndGeneIndex(int startIndex) {
		return Arrays.stream(END_GENE)
					 .map(end -> genome.indexOf(end, startIndex))
					 .filter(index -> index != -1)
					 .min(Comparator.comparingInt(a -> a))
					 .orElse(-1);
	}
	
	
}
