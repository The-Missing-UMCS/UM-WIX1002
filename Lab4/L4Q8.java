package Lab4;

public class L4Q8 {

    public static void main(String[] args) {
        int n = (int) (Math.random() * 100);
        boolean isPrime = true;
        System.out.printf("First %d prime number%s:\n", n, (n > 1) ? "s" : "");

        for(int val = 2, cnt = 0; cnt < n; val++) {
            isPrime = true;
            for (int j = 2; j < val; j++) {
                if (val % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                System.out.printf("%3d%s%s", val, (cnt == n - 1) ? "" : ", ", ((cnt + 1) % 10 == 0) ? "\n" : "");
                cnt++;
            }
        }
    }
}