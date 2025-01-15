package Lab3;

public class L3Q4 {
	public static void main(String[] args) {
        int p1 = 0, p2 = 0;
        p1 += (int) (Math.random() * 11 + 2);
        p2 += (int) (Math.random() * 11 + 2);
        System.out.printf("Player %d wins\n", (p1 > p2) ? 1 : 2);
	}
}