package com.fyiernzy.Lab8;

public class L8Q5 {
	public static void main(String[] args) {
		new Game("One","Two").start();
	}
}

class Game {
	Player one;
	Player two;
	
	Game(String name_one, String name_two) {
		one = new Player(name_one);
		two = new Player(name_two);
	}
	public void start() {
		boolean isOneTurn = ((int)(Math.random()) == 1 ? true : false);
		
		while(Math.max(one.getPoints(), two.getPoints()) < 100) {
			if (isOneTurn) 
				one.rollDice();
			else
				two.rollDice();
			
			isOneTurn = !isOneTurn;
		}
		
		System.out.println(one + "'s points = " + one.getPoints());
		System.out.println(two + "'s points = " + two.getPoints());
		System.out.println(((one.getPoints() >= 100) ? one : two) + " wins!");
	}
}

class Player {
	private final String NAME;
	private int points = 0;
	
	Player(String name){
		this.NAME = name;
	}
	
	public void rollDice() {
		this.points += (int)(Math.random() * 6 + 1);
	}
	
	@Override
	public String toString() {
		return this.NAME;
	}
	
	public int getPoints() {
		return this.points;
	}
}
