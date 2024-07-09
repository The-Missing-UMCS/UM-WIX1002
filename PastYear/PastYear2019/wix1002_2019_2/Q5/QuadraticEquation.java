package wix1002_2019_2.Q5;

public class QuadraticEquation {
    private int a, b, c;

    public QuadraticEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public double discriminant() {
        return b * b - 4 * a * c;
    }

    public double calcRoot1() {
        return calcRoot(1);
    }

    public double calcRoot2() {
        return calcRoot(-1);
    }

    private double calcRoot(int flag) {
        double dis = discriminant();
        if (dis < 0)
            return 0;
        return (-1 * b + flag * Math.sqrt(dis)) / 2 * a;
    }

    @Override
    public String toString() {
        return String.format("%dx(^2) +(%d) x + (%d)", a, b, c);
    }

}
