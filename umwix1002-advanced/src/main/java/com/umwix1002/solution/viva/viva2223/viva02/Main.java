package com.umwix1002.solution.viva.Viva_2223.Viva2;

public class Main {
	public static void main(String[] args) {
		Job j1 = new Job("J1", 252, 20);
		Job j2 = new Job("J2", 108, 10);
		Job j3 = new Job("J3", 72, 25);
		
		CloudPackage[] cp = new CloudPackage[4];
		
		cp[0] = new CloudPackage("P2-15", 4, 15, 1.24);
		cp[1] = new CloudPackage("P2-30", 6, 30, 2.11);
		cp[2] = new CloudPackage("R5-20", 4, 20, 1.38);
		cp[3] = new CloudPackage("R6-20", 6, 20, 1.88);

		
		int index;
		double totalCost = 0;
		
		System.out.println(j1.toString());
		index = leastCost(cp,j1);
		totalCost+=cp[index].getTotalCost();
		System.out.println(cp[index].toString());
		
		System.out.println(j2.toString());
		index = leastCost(cp,j2);
		totalCost+=cp[index].getTotalCost();
		System.out.println(cp[index].toString());
		
		System.out.println(j3.toString());
		index = leastCost(cp,j3);
		totalCost+=cp[index].getTotalCost();
		System.out.println(cp[index].toString());
		
		System.out.println("Total Cost : " + totalCost);
		
	}
	
	public static int leastCost(CloudPackage[] a, Job b) {
		int index=0;
		double cost = Double.MAX_VALUE;
		for(int i = 0; i < a.length; i++) {
			if (a[i].check(b)) {
				a[i].totalCost(b);
				if (a[i].getTotalCost() < cost) {
					cost = a[i].getTotalCost();
					index = i;
				}
			}
		}
		return index;
	}
}
