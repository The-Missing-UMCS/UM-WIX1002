package PastYear2022.Q1;

import java.util.Random;

public class Main {
	static Random rand = new Random();
	
	public static void main(String[] args) {
		double[] prices = getRandomPrices(3, 100, 300);
		int[] years = getEvenNumberedYears(5, 1990, 2030);
		String carPlate = getCarPlate(5, 2);
		String randomWord = getRandomWord(8);
		
		displayRandomPrices(prices);
		displayEvenNumberedYear(years);
		displayString(carPlate, "Car Plate Number");
		displayString(randomWord, "Random Word");
	}
	
	public static void displayRandomPrices(double[] prices) {
		int N = prices.length;
		System.out.printf("%d random price values : ", N);
		for(double price : prices)
			System.out.printf("%.2f ", price);
		System.out.println();
	}
	
	public static void displayEvenNumberedYear(int[] years) {
		int N = years.length;
		System.out.printf("%d random even-numbered years : ", N);
		for(int year : years)
			System.out.printf("%d ", year);
		System.out.println();
	}
	
	public static void displayString(String str, String title) {
		System.out.printf("%s : %s\n", title, str);
	}
	
	
	public static double[] getRandomPrices(int N, double inclusiveStart, double inclusiveEnd) {
		double[] prices = new double[N];
		double range = inclusiveEnd - inclusiveStart;
		
		for(int i = 0; i < N; i++) {
			prices[i] = rand.nextDouble(range + 0.01) + inclusiveEnd;
		}
		
		return prices;
	}
	
	public static int[] getEvenNumberedYears(int N, int inclusiveStartYear, int inclusiveEndYear) {
		int[] years = new int[N];
		int range = inclusiveEndYear - inclusiveStartYear;
		
		for(int i = 0; i < N; i++) {
			years[i] = rand.nextInt(range + 1) + inclusiveStartYear;
		}
		
		return years;
	}
	
	public static String getCarPlate(int numOfDigit, int numOfChars) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < numOfDigit; i++) {
			sb.append(rand.nextInt(10));
		}
		
		int start = (int) 'A', end = (int) 'Z', range = end - start;
		
		for(int i = 0; i < numOfChars; i++) {
			char uppercase = (char) (rand.nextInt(range + 1) + start);
			sb.append(uppercase);
		}
		
		return sb.toString();
	}
	
	public static String getRandomWord(int maxChar) {
		int charCount = rand.nextInt(maxChar + 1) + 1;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < charCount; i++) {
			sb.append(getRandomChar());
		}
		
		return sb.toString();
	}
	
	public static char getRandomChar() {
		// if lowercaseFlag = 1, it will generate lowercase letter and vice versa
		int flag = rand.nextInt(2); 
		int tmp = rand.nextInt(26);
		return (char)(tmp + ((flag == 1) ? 'a' : 'A'));
	}
}
