package com.fyiernzy.Lab9;

public class L9Q4S {

}

abstract class Game {
	protected DicePlayer one; 
	protected DicePlayer two;
	
	Game(DicePlayer one, DicePlayer two){
		this.one = one;
		this.two = two;
	}
	
	abstract void notifyTakeTurn(DicePlayer player);
	abstract void gamePlay();
	abstract DicePlayer checkWinner(DicePlayer one, DicePlayer two);
}

class GameOne extends Game {
	
	GameOne(DicePlayer one, DicePlayer two) {
		super(one, two);
	}
	
	@Override
	public void notifyTakeTurn(DicePlayer player) {
		if (player.rollDice() == player.rollDice())
			this.notifyTakeTurn(player);
	}
	
	@Override
	public void gamePlay() {
		boolean isOneTurn = ((int)(Math.random()) == 1) ? true : false;
		DicePlayer winner = null;
		
		while(winner == null) {
			if (isOneTurn)
				this.notifyTakeTurn(one);
			else
				this.notifyTakeTurn(two);
			
			winner = checkWinner(one, two);
			
			isOneTurn = !isOneTurn;
		}
	}
	
	@Override
	public DicePlayer checkWinner(DicePlayer one, DicePlayer two) {
		if (one.getPoints() > 100)
			return one;
		else if (two.getPoints() > 100)
			return two;
		else
			return null;
	}
}

class GameTwo extends Game {
	GameTwo(DicePlayer one, DicePlayer two) {
		super(one, two);
	}
	
	@Override
	public void notifyTakeTurn(DicePlayer player) {
		int tmp = player.getPoints();
		
		if (player.rollDice() == 6) {
			if (player.rollDice() == 6)
				player.setPoints(tmp);
		}
			
		
		if (player.getPoints() > 100)
			player.setPoints(tmp);
	}
	
	@Override
	public void gamePlay() {
		boolean isOneTurn = ((int)(Math.random()) == 1) ? true : false;
		DicePlayer winner = null;
		
		while(winner == null) {
			if (isOneTurn)
				this.notifyTakeTurn(one);
			else
				this.notifyTakeTurn(two);
			
			winner = checkWinner(one, two);
			
			isOneTurn = !isOneTurn;
		}
	}
	
	@Override
	public DicePlayer checkWinner(DicePlayer one, DicePlayer two) {
		if (one.getPoints() == 100)
			return one;
		else if (two.getPoints() == 100)
			return two;
		else
			return null;
	}
	
}

abstract class Player {
	protected final String NAME;
	
	Player(String name) {
		this.NAME = name;
	}
}


