package wix1002_2018_2.Q4;

public class LinearEquation {
    private int a, b, c, d, e, f;
    private int det;

    public LinearEquation(int a, int b, int c, int d, int e, int f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        init();
    }

    private void init() {
        this.det = a * d - b * c;
    }

    @Override
    public String toString() {
        return String.format("%dx + %dy = %d\n%dx + %dy = %d", a, b, e, c, d, f);
    }

    public boolean isSolvable() {
        return det != 0;
    }

    public double computeX() {
        return (e * d - b * f) / det;
    }

    public double computeY() {
        return (a * f - e * c) / det;
    }
}
