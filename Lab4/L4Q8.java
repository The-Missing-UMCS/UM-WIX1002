package Lab4;

public class L4Q8 {

    public static void main(String[] args) {

        int n = 0, ni = 0, thisNum = 2;
        n = (int) (Math.random() * 100);

        System.out.printf("First %d prime number%s:\n", n, (n > 1) ? "s" : "");

        while (ni < n) {

            boolean isPrime = true;

            for (int j = 2; j < thisNum; j++) {

                if (thisNum % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.printf("%3d%s%s", thisNum, (ni == n - 1) ? "" : ", ", ((ni + 1) % 10 == 0) ? "\n" : "");
                ni++;
            }

            thisNum++;
        }
    }
}