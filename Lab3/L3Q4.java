package Lab3;

public class L3Q4 {
	public static void main(String[] args) {
		Player one = new Player("Amy");
		Player two = new Player("John");
		
		one.rollDice();
		two.rollDice();
		
		if (one.getScore() > two.getScore()) 
			System.out.println(one.getName() + " wins!");
		else if (one.getScore() < two.getScore())
			System.out.println(two.getName() + " wins!");
		else
			System.out.println("The game is tie");
	}
}

class Player {
	private String name;
	private int score = 0;
	
	Player(String name){
		this.name = name;
	}
	
	public void rollDice() {
		// System.out.println(this.name + " roll the dice twice");
		
		for(int i = 0; i < 2; i++) {
			System.out.println(this.name + " rolls the dice " );
			try {
				Thread.sleep(1500);
			} catch (Exception e) {}
			
			int diceNum = (int)(Math.random() * 6 + 1);
			System.out.println((i + 1) + " times " + this.name + " get " + diceNum);
			score += diceNum;
			
		}
			
		System.out.println(this.name + " get " + this.score);
		System.out.println("");
	}
	
	public int getScore() {
		return this.score;
	}
	
	public String getName() {
		return this.name;
	}
}