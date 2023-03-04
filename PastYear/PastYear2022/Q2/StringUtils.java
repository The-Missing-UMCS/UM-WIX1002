package PastYear2022.Q2;

public class StringUtils {
	/**
	 * Returns a new String composed of {@code double elements} 
	 * joined together with whitespace
     *
     * <blockquote>For example,
     * <pre>{@code
     *     String message = 
     *     StringUtils.joinDouble(12.5, 13.6, 17.5);
     *     // message returned is: "12.5 13.6 17.5"
     * }</pre></blockquote>
     * 
	 * @param  elements the elements to join together.
	 * @return a new {@code String} that is composed of the {@code elements}
     *         separated by the whitespace
	 */
	
	public static String joinDouble(double... elements) {
		return joinDouble(" ", elements);
	}
	
	/**
	 * Returns a new String composed of {@code double elements} 
	 * joined together with the specified {@code delimiter}.
     *
     * <blockquote>For example,
     * <pre>{@code
     *     String message = 
     *     StringUtils.joinDouble("-", 12.5, 13.6, 17.5);
     *     // message returned is: "12.5-13.6-17.5"
     * }</pre></blockquote>
     * 
	 * @param  delimiter the delimiter that separates each element
	 * @param  elements the elements to join together.
	 * @return a new {@code String} that is composed of the {@code elements}
     *         separated by the {@code delimiter}
	 */
	
	public static String joinDouble(String delimiter, double... elements) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < elements.length - 1; i++) {
			sb.append(elements[i]).append(delimiter);
		}
		
		sb.append(elements[elements.length - 1]); // Append the last element without delimiter
		
		
		return sb.toString();
	}
}
