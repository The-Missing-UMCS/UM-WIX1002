package Lab4;

public class WIX1002_Lab4_Q6 {
	public static void main(String[] args) {
		new GameSystem().playGame();
	}
}

class Player {
	private String name;
	private int points = 0;
	private int diceNum = 0;
	private int currentStreak = 0;
	private int highestStreak = 0;
	
	Player(String name){
		this.name = name;
	}
	
	public boolean play() {
		this.rollDice();
		this.printInfo();
		if (this.getDiceNum() == 6) {
			this.onFire();
			return true;
		} else {
			this.setStreakToZero();
			return false;
		}
	}
	public void rollDice() {
		diceNum = (int)(Math.random() * 6 + 1);
		points += diceNum;
	}
	
	
	public void printInfo() {
		System.out.printf("%s : DiceNum = %d // Points = %d\n", this.getName(), this.getDiceNum(), this.getPoints());
	}
	
	public int getDiceNum() {
		return this.diceNum;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public int getHighestStreak() {
		return this.highestStreak;
	}
	
	public void onFire() {
		this.currentStreak++;
		if (this.currentStreak > highestStreak) {
			this.highestStreak = this.currentStreak;
		}
	}
	
	public void setStreakToZero() {
		this.currentStreak = 0;
	}
}

class GameSystem {
	Player one;
	Player two;
	Player winner;
	String turn = "two";
	int count = 0;
	int oneCount = 0, twoCount = 0;
	
	
	GameSystem(){
		one = new Player("Player 1");
		two = new Player("Player 2");
	}
	
	public Player playGame() {
		while (true) {
			count++;
			System.out.printf("Round %2d = ", count);
			
			if (turn.equals("one")) {
				if (one.play() == false)
					turn = "two";
			} else {
				if (two.play() == false)
					turn = "one";
			}
			
			if (checkWinner() == true)
				break;
		}
		
		System.out.println(winner.getName() + " is the winner!");
		System.out.printf("Final result:\nPlayer 1 = %d\nPlayer 2 = %d\n", one.getPoints(), two.getPoints());
		System.out.println(winner.getName() + " highest streak = " + winner.getHighestStreak());
		
		return winner;
	}

	private boolean checkWinner() {
		if (one.getPoints() > 100) {
			winner = one;
			return true;
		} else if (two.getPoints() > 100){
			winner = two;
			return true;
		} else {
			return false;
		}
	}
	
	/*
	public void decideTurn() {
		if ((int)(Math.random()) == 1) {
			turn = "one";
		} else {
			turn = "two";
		}
	}
	
	public void collectData() {
		int num = 100;
		for(int i = 0; i < num; i++) {
			if (playGame() == one) {
				oneCount++;
			} else {
				twoCount++;
			}
			count = 0;
			winner = null;
		}
		System.out.printf("Player 1 = %d, Player 2 = %d\n", oneCount, twoCount);
		System.out.printf("Player 1 = %.2f, Player 2 = %.2f", (oneCount / (double) num), (twoCount / (double) num));
	}
	*/
	
	
}

