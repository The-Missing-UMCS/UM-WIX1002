package com.umwix1002.solution.lab.lab10.l10q2;

import com.umwix1002.solution.lab.constants.CommonConstant;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Function;

import static com.umwix1002.solution.lab.lab10.config.Constants.*;

/**
 * SubstitutionCipher is a simple implementation of a substitution cipher where each
 * character in the message is shifted by a specified number of positions in the alphabet.
 * This class supports both encoding and decoding of messages.
 */
@Setter
@Getter
public class SubstitutionCipher implements MessageCipher {
    private static final Integer DEFAULT_SHIFT_KEY = 3;

    private @Nullable Integer shiftKey;

    /**
     * Encodes the given message by shifting each alphabetic character by the shift key.
     * <p>
     * Non-alphabetic characters remain unchanged.
     * <p>
     * Example:
     *  <pre>
     *      SubstitutionCipher cipher = new SubstitutionCipher();
     *      String encoded = cipher.encode("hello"); // With default key (3), returns "khoor"
     * </pre>
     *
     * @param message the input string to encode.
     * @return the encoded string.
     *
     */
    @Override
    public String encode(String message) {
        return transform(message, (ch) -> encode(ch,
            shiftKey == null ? DEFAULT_SHIFT_KEY : shiftKey, 
            ((int) ch) < UPPER_A_ASCII ? UPPER_A_ASCII : LOWER_A_ASCII));
    }

    /**
     * Decodes the given message by reversing the shift of each alphabetic character.
     * <p>
     * Non-alphabetic characters remain unchanged.
     * <p>
     * Example:
     *  <pre>
     *      SubstitutionCipher cipher = new SubstitutionCipher();
     *      String decoded = cipher.decode("khoor"); // With default key (3), returns "hello"
     * </pre>
     *
     * @param message the encoded string to decode.
     * @return the original string before encoding.
     */
    @Override
    public String decode(String message) {
        return transform(message, (ch) -> decode(ch, 
            shiftKey == null ? DEFAULT_SHIFT_KEY : shiftKey, 
            ((int) ch) < UPPER_Z_ASCII ? UPPER_Z_ASCII : LOWER_Z_ASCII));
    }

    /**
     * Applies a transformation function to each character of the message. Alphabetic
     * characters are transformed using the provided function, while non-alphabetic
     * characters are appended as is.
     *
     * @param message the input string to transform.
     * @param func the transformation function to apply to alphabetic characters.
     * @return the transformed string.
     */
    private String transform(String message, Function<Character, Character> func) {
        StringBuilder sb = new StringBuilder();
        for(int i = CommonConstant.ZERO; i < message.length(); i++) {   
            char ch = message.charAt(i);
            sb.append(Character.isAlphabetic(ch) ? func.apply(ch) : ch);
        }
        return sb.toString();
    }

    /**
     * Encodes a single character by shifting it forward in the alphabet by the given shift key.
     * Wraps around if the end of the alphabet is reached.
     *
     * @param ch the character to encode.
     * @param shiftKey the number of positions to shift.
     * @param startKey the ASCII value of the start of the alphabet (uppercase or lowercase).
     * @return the encoded character.
     */
    private char encode(char ch, int shiftKey, int startKey) {
        return (char) (((int) ch + shiftKey - startKey) % NUM_OF_ALPHABET + startKey - ((int) ch + shiftKey - startKey) / NUM_OF_ALPHABET);
    }

    /**
     * Decodes a single character by shifting it backward in the alphabet by the given shift key.
     * Wraps around if the beginning of the alphabet is reached.
     *
     * @param ch the character to decode.
     * @param shiftKey the number of positions to shift backward.
     * @param endKey the ASCII value of the end of the alphabet (uppercase or lowercase).
     * @return the decoded character.
     */
    private char decode(char ch, int shiftKey, int endKey) {
        return (char) (endKey - (endKey - (int) ch + shiftKey) % NUM_OF_ALPHABET);
    }
}
