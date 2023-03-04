package PastYear2022.Q2;

import java.util.Arrays;

public class Diving implements Comparable<Diving> {
	// Using predefined format to enhance readability
	private static final String NAME_COUNTRY_FORMAT = "Diver : %s (%s)\n";
	private static final String SCORES_RATING_FORMAT = "Judges Scores : %s\nDifficulty Rating : %.1f\n";
	private static final String FINAL_SCORE_FORMAT = "Final score : %.1f\n";
	
	private String name;
	private String country;
	private double[][] scores;
	private double[] difficulty;
	
	Diving(String name, String country, double[][] scores, double[] difficulty){
		this.name = name;
		this.country = country;
		this.scores = scores;
		this.difficulty = difficulty;
	}
	
	@Override
	public int compareTo(Diving o) {
		return -Double.compare(this.getFinalScore(), o.getFinalScore());
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCountry() {
		return this.country;
	}
	
	public double getFinalScore() {
		int N = scores[0].length;
		double sum = 0; 
		
		for(int row = 0; row < scores.length; row++) {
			double value = 0;
			double[] copiedScores = Arrays.copyOf(scores[row], N); // avoid in-place sorting
			
			Arrays.sort(copiedScores); 
			// Now, the lowest score will be on the left
			// while the highest score will be on the right
			
			for(int column = 0 + 2; column < N - 2; column++) {
				// The The score is calculated by removing the
				// top two scores and the bottom two scores
				value += copiedScores[column];
			}
			
			// the remaining three scores are
			// added together and multiplied by the difficulty rating in each attempt
			sum += value * difficulty[row];
		}
		
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		// Adding "Diver : Name (Country)"
		String basicInfo = String.format(NAME_COUNTRY_FORMAT, this.name, this.country);
		sb.append(basicInfo); 
		
		// Adding "Judges Scores : ... Difficulty Rating : "
		for(int i = 0; i < scores.length; i++) {
			String score = StringUtils.joinDouble(scores[i]);
			String scoresAndRating = String.format(SCORES_RATING_FORMAT, score, difficulty[i]);
			sb.append(scoresAndRating);
		}
		
		// Adding "Final Score : ..."
		String finalScores = String.format(FINAL_SCORE_FORMAT, getFinalScore());
		sb.append(finalScores);
		
		return sb.toString();
	}
}
