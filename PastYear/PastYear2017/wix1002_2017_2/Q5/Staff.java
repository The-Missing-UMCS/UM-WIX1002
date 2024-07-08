package wix1002_2017_2.Q5;

public class Staff {
    protected String name;
    protected String ic;

    public Staff(String name, String ic) {
        this.name = name;
        this.ic = ic;
    }

    public String toString() {
        return String.format("Full Name: %s\nIC: %s", name, ic);
    }
}
