package wix1002_2017_2.Q2;

public class Team {
    private String name;
    private int score;

    public Team(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", name, score);
    }

}
