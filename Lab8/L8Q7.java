package com.fyiernzy.Lab8;

// Credit to chatGPT

public class L8Q7 {
	public static void main(String[] args) {
		System.out.println(new Money(123.47).getNotesAndCoints());
	}
}

class Money {
	static final int[] NOTES = {100, 50, 10, 5, 1};
	static final int[] COINS = {50, 20, 10, 5};
	int[] counts = new int[NOTES.length + COINS.length];
	final int valueCent;
	
	Money(Double amount) {
		this.valueCent = round((int) (amount * 100));
	}
	
	public static int round(int value) {
		return ((value + 2) / 5 * 5);
	}
	
	public int getAmountAsCent() {
		return this.valueCent;
	}
	
	public double getAmountAsCash() {
		return this.valueCent / 100;
	}
	
	public String getNotesAndCoints() {
		int tmp = valueCent;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < NOTES.length; i++) {
			counts[i] = tmp / (NOTES[i] * 100);
			sb.append(counts[i]).append(" x RM ").append(NOTES[i]).append("\n");
			tmp %= (NOTES[i] * 100);
		}
		
		for(int i = 0; i < COINS.length; i++) {
			counts[NOTES.length + i] = tmp / COINS[i];
			sb.append(counts[NOTES.length + i]).append(" x ").append(COINS[i]).append(" cents\n");
			tmp %= COINS[i];
		}
		
		return sb.toString();
	}

}