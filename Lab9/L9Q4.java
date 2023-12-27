package Lab9;

// Reference code: 
public class L9Q4 {
	public static void main(String[] args) {
		DicePlayer one = new DicePlayer("Player 1");
		DicePlayer two = new DicePlayer("Player 2");
		
		new DiceGameTwo(one, two).gamePlay();
	}
}

abstract class DiceGame {
	protected DicePlayer one; 
	protected DicePlayer two;
	
	DiceGame(DicePlayer one, DicePlayer two){
		this.one = one;
		this.two = two;
	}
	
	abstract void notifyTakeTurn(DicePlayer player);
	abstract void gamePlay();
}

class DiceGameOne extends DiceGame {
	
	DiceGameOne(DicePlayer one, DicePlayer two) {
		super(one, two);
	}
	
	@Override
	public void notifyTakeTurn(DicePlayer player) {
		if (player.rollDice() == player.rollDice()) {
			System.out.println("");
			this.notifyTakeTurn(player);
		} else {
			System.out.println("");
			System.out.printf("%s's points = %d\n", player, player.getPoints());
		}
	}
	
	@Override
	public void gamePlay() {
		while(true) {
			notifyTakeTurn(one); if (one.getPoints() >= 100) break;
			notifyTakeTurn(two); if (two.getPoints() >= 100) break;
		}
		
		System.out.printf("%s won!\n", (one.getPoints() >= 100) ? one : two);
	}
}

class DiceGameTwo extends DiceGame {
	DiceGameTwo(DicePlayer one, DicePlayer two) {
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
		
		System.out.println("");
		System.out.printf("%s's points = %d\n", player, player.getPoints());
	}
	
	@Override
	public void gamePlay() {
		while(true) {
			notifyTakeTurn(one); if (one.getPoints() == 100) break;
			notifyTakeTurn(two); if (two.getPoints() == 100) break;
		}
		
		System.out.printf("%s won!\n", (one.getPoints() == 100) ? one : two);
	}
	
}

class DicePlayer{
	protected final String NAME;
	private int points;
	
	DicePlayer(String name) {
		this.NAME = name;
	}
	
	public int rollDice() {
		int score = (int)(Math.random() * 6 + 1);
		this.points += score;
		System.out.printf("%s rolled %d ", this.NAME, score);
		return score;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	@Override 
	public String toString() {
		return this.NAME;
	}
}
