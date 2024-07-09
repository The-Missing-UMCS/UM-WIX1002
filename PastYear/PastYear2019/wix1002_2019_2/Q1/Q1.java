package wix1002_2019_2.Q1;

public class Q1 {
    public static void main(String[] args) {
        int[] num = { 66, 15, 20, 27, 74, 33 };
        int cnt = 0;
        for (int i = 0; i < num.length; i++) {
            if (isEven(num[i]))
                cnt++;
        }
        System.out.println("The number of even number is " + cnt);
        System.out.println("The biggest integer is " + findMax(num));
    }

    public static boolean isEven(int a) {
        return a % 2 == 0;
    }

    public static int findMax(int[] a) {
        int max = a[0];
        for (int n = 0; n < a.length; n++) {
            if (a[n] > max)
                max = a[n];
        }
        return max;
    }

}
