package com.umwix1002.solution.lab.lab10.l10q3a;

import com.umwix1002.solution.lab.lab10.l10q2a.MessageCipher;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.function.Function;

import static com.umwix1002.solution.lab.constants.CommonConstant.BLANK;

/**
 * @author Ng Zhi Yang
 */
@Getter
@Setter
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
        int count = Objects.requireNonNullElse(shuffleCount, DEFAULT_SHUFFLE_COUNT);
        for (int i = 0; i < count; i++) {
            sb = func.apply(sb);
        }
        return sb.toString();
    }

    /**
     * Shuffles a string by alternating characters from the left and right halves of the input
     * string.
     * If the string length is odd, the extra character from the right half will be appended at the
     * end.
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
        int mid = str.length() / 2;

        String left = str.substring(0, mid);
        String right = str.substring(mid);

        for (int i = 0; i < mid; i++) {
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

        int length = (str.length() / 2) * 2;

        for (int i = 0; i < length; i += 2) {
            sb.append(str.charAt(i));
        }

        for (int i = 1; i < length; i += 2) {
            sb.append(str.charAt(i));
        }

        sb.append((str.length() % 2 == 1) ? str.charAt(str.length() - 1) : BLANK);
        return sb;
    }
}
