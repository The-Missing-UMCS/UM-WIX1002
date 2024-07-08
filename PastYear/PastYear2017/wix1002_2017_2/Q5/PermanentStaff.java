package wix1002_2017_2.Q5;

public class PermanentStaff extends Staff {
    private GradeEnum grade;

    public PermanentStaff(String name, String ic, GradeEnum grade) {
        super(name, ic);
        this.grade = grade;
    }

    public int getSalary() {
        return grade.getSalary();
    }

    @Override
    public String toString() {
        return String.format("\n%s\nGrade: %s\nSalary: RM %d\n", super.toString(), grade.getGrade(), grade.getSalary());
    }
}

enum GradeEnum {
    EM01("EM01", 7000),
    EM02("EM02", 5000),
    EM03("EM03", 3000),
    EM04("EM04", 1000);

    final String GRADE;
    final int SALARY;

    GradeEnum(String grade, int salary) {
        this.GRADE = grade;
        this.SALARY = salary;
    }

    public String getGrade() {
        return GRADE;
    }

    public int getSalary() {
        return SALARY;
    }
}
