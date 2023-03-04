package PastYear2022.Q2;

import java.util.*;
import java.io.*;

public class Main {
	static final String[] LABELS = {"Gold", "Silver", "Bronze"};
	
	public static void main(String[] args) {
		final String FILE = "./src/PastYear2022/Q2/diving.txt";
		var divingList = new ArrayList<Diving>();
		
		try(Scanner sc = new Scanner(new FileInputStream(FILE))) {
			while(sc.hasNextLine()) {
				String name = sc.nextLine();
				String country = sc.nextLine();
				double[][] scores = new double[3][7];
				double[] difficulty = new double[3];
				
				for(int attempts = 0; attempts < 3; attempts++) {
					String[] line = sc.nextLine().split(" ");
					for(int judges = 0; judges < 7; judges++) {
						scores[attempts][judges] = Double.parseDouble(line[judges]);
					}
					difficulty[attempts] = Double.parseDouble(line[7]);
				}
				
				divingList.add(new Diving(name, country, scores, difficulty));
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		
		if(divingList.size() > 0) { 
			for(Diving diving : divingList) { 
				System.out.println(diving.toString());
			}
			
			Collections.sort(divingList);
			
			for(int i = 0; i < 3; i++) {
				Diving diving  = divingList.get(i);
				System.out.printf("%s : %s (%s)\n", LABELS[i], diving.getName(), diving.getCountry());
			}
		}
	}
}
