package wix1002_2017_1.Q4;

public class Complex {
    double real, imaginary;

    public Complex() {
        this(0, 0);
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex add(Complex o) {
        return new Complex(this.real + o.real, this.imaginary + o.imaginary);
    }

    public Complex subtract(Complex o) {
        return new Complex(this.real - o.real, this.imaginary - o.imaginary);
    }

    public static Complex addComplexNum(Complex o1, Complex o2) {
        return o1.add(o2);
    }

    public static Complex subtractComplexNum(Complex o1, Complex o2) {
        return o1.subtract(o2);
    }

    @Override
    public String toString() {
        return String.format("(%.0f + %.0fi)", real, imaginary);
    }

}
