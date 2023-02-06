package PastYear2020.Q3;

import java.util.Scanner;
import java.io.*;

public class FrequencyTable {
	private File file;
	private int[] freq;
	
	public FrequencyTable(String file) {
		this.file = new File(file);
		this.freq = new int[] {0, 0, 0, 0, 0};
		load();
	}
	
	private void load() {
		try (Scanner scanner = new Scanner(file)) {
			while(scanner.hasNextInt()) {
				int i = scanner.nextInt() / 2 - 1;
				freq[i] = freq[i] + 1;
			}
		} catch (IOException ex) {
			freq = new int[] {0, 0, 0, 0, 0};
		} 
		
	}
	
	public void print() {
		System.out.println("Frequency Distribution Table");
		for(int i = 0; i < freq.length; i++) {
			System.out.printf("%d : %d\n", (i + 1) * 2, freq[i]);
		}
		System.out.println("The mode of the data set is: " + findMode());
	}
	
	public int findMode() {
		int max = freq[0], index = 0;
		for(int i = 1; i < freq.length; i++) {
			if(freq[i] > max) {
				max = freq[i];
				index = i;
			}
		}
		
		return (index + 1) * 2;
	}
}
