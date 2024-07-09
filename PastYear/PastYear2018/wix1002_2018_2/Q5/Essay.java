package wix1002_2018_2.Q5;

public class Essay extends GradedActivity {
    private int grammar;
    private int spelling;
    private int length;
    private int content;

    public Essay(int grammar, int spelling, int length, int content) {
        this.grammar = grammar;
        this.spelling = spelling;
        this.length = length;
        this.content = content;
        init();
    }

    void init() {
        setScore(grammar + spelling + length + content);
    }

    @Override
    public String toString() {
        return String.format(
                "Essay score:\nGrammar: %d\nSpelling: %d\nLength: %d\nContent: %d\n\nTotal Score: %d\nEssay grade: %c",
                grammar, spelling, length,
                content, score, getGrade());
    }
}
