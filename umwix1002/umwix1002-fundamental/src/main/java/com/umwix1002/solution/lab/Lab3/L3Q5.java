package Lab3;

import java.util.Scanner;
public class L3Q5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("Crammer's rule:\n" + 
                            "ax + by = e, cx + dy = f\n" +
                            "x = (ed-bf) / (ad-bc) y=(af-ec) / (ad-bc)\n");
        int[] val = new int[6];
        for(int i = 0; i < 6; i++) {
            System.out.printf("Enter the value of %c : ", i + 'a');
            val[i] = sc.nextInt();
        }
        sc.close();
        int a = val[0], b = val[1], c = val[2], d = val[3], e = val[4], f = val[5];
	    int denom = a * d - b * c;
        if(denom == 0)
            System.out.println("no solution");
        else 
            System.out.printf("x = %d, y = %d\n", (e * d - b * f) / denom, (a * f - e * c) / denom);
	}
}
