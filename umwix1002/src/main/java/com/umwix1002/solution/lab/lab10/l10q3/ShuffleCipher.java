package com.umwix1002.solution.lab.lab10.l10q3;

import com.umwix1002.solution.lab.constants.CommonConstant;
import com.umwix1002.solution.lab.lab10.l10q2.MessageCipher;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.function.Function;

import static com.umwix1002.solution.lab.constants.CommonConstant.*;

/**
 * @author Ng Zhi Yang
 */
@Getter @Setter
public class ShuffleCipher implements MessageCipher {
    private static final Integer DEFAULT_SHUFFLE_COUNT = 3;
    
    private Integer shuffleCount;
    
    @Override
    public String encode(String message) {
        return transform(message, this::shuffle);
    }

    @Override
    public String decode(String message) {
        return transform(message, this::unshuffle);
    }
    
    private String transform(String message, Function<StringBuilder, StringBuilder> func) {
        StringBuilder sb = new StringBuilder(message);
        for(int i = CommonConstant.ZERO; i < Objects.requireNonNullElse(shuffleCount, DEFAULT_SHUFFLE_COUNT); i++) {
            sb = func.apply(sb);
        }
        return sb.toString();
    }

    /**
     * Shuffles a string by alternating characters from the left and right halves of the input string.
     * If the string length is odd, the extra character from the right half will be appended at the end.
     * It can be implemented using {@code String.toCharArray()} as well.
     * <p>
     * For example:
     * <pre>
     *     {@code 
     *      - Input: "abcdef", Result: "adbcef"
     *      - Input: "abcde", Result: "adbce"
     *     }
     *     {@code }
     * </pre>
     * 
     * @param str the string to shuffle.
     * @return the shuffled string as a {@link StringBuilder}.
     */
    public StringBuilder shuffle(StringBuilder str) {
        StringBuilder sb = new StringBuilder();
        int mid = str.length() / TWO;
        
        String left = str.substring(ZERO, mid);
        String right = str.substring(mid); 

        for(int i = ZERO; i < mid; i++) {
            sb.append(left.charAt(i)).append(right.charAt(i));
        }
        
        sb.append((right.length() > left.length()) ? right.charAt(mid) : BLANK);

        return sb;
    }

    /**
     * Unshuffles a string by separating alternating characters back into the left and right halves.
     * If the string length is odd, the last character will be placed at the end.
     *
     * For example:
     * <pre>
     *     {@code 
     *      - Input: "adbcef", Result: "abcdef"
     *      - Input: "adbce", Result: "abcde"
     *     }
     * </pre>
     *
     * @param str the string to unshuffle.
     * @return the unshuffled string as a {@link StringBuilder}.
     */
    public StringBuilder unshuffle(StringBuilder str) {
        StringBuilder sb = new StringBuilder();

        int length = (str.length() / TWO) * TWO;

        for(int i = ZERO; i < length; i += TWO) {
            sb.append(str.charAt(i));
        }
        
        for(int i = ONE; i < length; i += TWO) {
            sb.append(str.charAt(i));
        }
        
        sb.append((str.length() % TWO == ONE) ? str.charAt(str.length() - ONE) : BLANK);
        return sb;
    }
}
