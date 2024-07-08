package wix1002_2017_2.Q5;

public class PartTimeStaff extends Staff {
    private static final int RATE = 40;

    private int workingHours;

    public PartTimeStaff(String name, String ic, int workingHours) {
        super(name, ic);
        this.workingHours = workingHours;
    }

    public int getSalary() {
        return RATE * workingHours;
    }

    @Override
    public String toString() {
        return String.format("\n%s\nNumber of working hours: %d\nSalary: RM %d\n", super.toString(), workingHours,
                getSalary());
    }

}
