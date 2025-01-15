package Lab4;

public class L4Q5 {
	public static void main(String[] args) {
		int p1 = 0, p2 = 0, dice; boolean isOneTurn = true;
		while(Math.max(p1, p2) <= 100) {
			dice = (int) (Math.random() * 6 + 1);
			if(isOneTurn) {
				p1 += dice;
				isOneTurn = dice == 6 ? true : false;
			} else {
				p2 += dice;
				isOneTurn = dice == 6 ? false : true;
			}
		}
		System.out.printf("%s win with %d points!\n", (p1 > p2 ? "Player 1" : "Player 2"), Math.max(p1, p2));
	}
} 

