package com.umwix1002.solution.pastyear.PastYear2022.Q2;

import java.util.Arrays;
import java.util.stream.Collectors;

public record Diving(String name, String country, double[][] scores, double[] difficulty) {
    private static final String NAME_COUNTRY_FORMAT = "Diver : %s (%s)%n";
    private static final String SCORES_RATING_FORMAT = "Judges Scores : %s\nDifficulty Rating : %.1f%n";
    private static final String FINAL_SCORE_FORMAT = "Final score : %.1f%n";

    public double getFinalScore() {
        return Arrays.stream(scores)
            .mapToDouble(this::calculateScoreForAttempt)
            .sum();
    }

    private double calculateScoreForAttempt(double[] attemptScores) {
        double[] sortedScores = Arrays.copyOf(attemptScores, attemptScores.length);
        Arrays.sort(sortedScores);
        double sumOfMiddleScores = Arrays.stream(sortedScores, 2, sortedScores.length - 2).sum();
        return sumOfMiddleScores * difficulty[Arrays.asList(scores).indexOf(attemptScores)];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // 1. Add "Diver : Name (Country)"
        sb.append(String.format(NAME_COUNTRY_FORMAT, name, country));

        // 2. Add "Judges Scores : ... Difficulty Rating : "
        for (int i = 0; i < scores.length; i++) {
            String scoresString = Arrays.stream(scores[i])
                .mapToObj(score -> String.format("%.1f", score))
                .collect(Collectors.joining(" "));
            sb.append(String.format(SCORES_RATING_FORMAT, scoresString, difficulty[i]));
        }

        // 3. Add "Final score : "
        sb.append(String.format(FINAL_SCORE_FORMAT, getFinalScore()));
        return sb.toString();
    }
}
