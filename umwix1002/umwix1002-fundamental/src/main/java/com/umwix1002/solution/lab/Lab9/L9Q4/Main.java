package com.umwix1002.solution.lab.Lab9.L9Q4A;

public class Main {
	public static void main(String[] args) {
		DicePlayer one = new DicePlayer("Player 1");
		DicePlayer two = new DicePlayer("Player 2");
		
		new DiceGameTwo(one, two).gamePlay();
	}
}
