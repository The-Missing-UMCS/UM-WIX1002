package Lab5;

public class L5Q2A {
    public static void main(String[] args) {
        int min = 0, max = 20, range = max - min + 1, cnt = 0, n = 10;
        boolean[] set = new boolean[range];
        while(cnt < n) {
            int rand = (int)(Math.random() * range) + min;
            if(set[rand]) continue;
            set[rand] = true; cnt++;
        }
        for(int i = 0; i < range; i++) 
            if(set[i]) System.out.print(i + ", ");
    }
}
