package com.umwix1002.solution.lab.lab10.l10q2;

import com.umwix1002.solution.lab.CommonConstant;
import lombok.Data;

import java.util.function.Function;

import static com.umwix1002.solution.lab.lab10.config.Constants.*;

@Data
public class SubstitutionCipher implements MessageEncoder {
    private static final Integer DEFAULT_SHIFT_KEY = 3;
    
    private Integer shiftKey;
    
    @Override
    public String encode(String message) {
        return transform(message, (ch) -> encode(ch, 
            shiftKey == null ? DEFAULT_SHIFT_KEY : shiftKey, 
            ((int) ch) < UPPER_A_ASCII ? UPPER_A_ASCII : LOWER_A_ASCII));
    }

    @Override
    public String decode(String message) {
        return transform(message, (ch) -> decode(ch, 
            shiftKey == null ? DEFAULT_SHIFT_KEY : shiftKey, 
            ((int) ch) < UPPER_Z_ASCII ? UPPER_Z_ASCII : LOWER_Z_ASCII));
    }
    
    private String transform(String message, Function<Character, Character> func) {
        StringBuilder sb = new StringBuilder();
        for(int i = CommonConstant.ZERO; i < message.length(); i++) {   
            char ch = message.charAt(i);
            sb.append(Character.isAlphabetic(ch) ? func.apply(ch) : ch);
        }
        return sb.toString();
    } 

    private char encode(char ch, int shiftKey, int startKey) {
        return (char) (((int) ch + shiftKey - startKey) % NUM_OF_ALPHABET + startKey - ((int) ch + shiftKey - startKey) / NUM_OF_ALPHABET);
    }

    private char decode(char ch, int shiftKey, int endKey) {
        return (char) (endKey - (endKey - (int) ch + shiftKey) % NUM_OF_ALPHABET);
    }
}
