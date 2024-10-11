package com.umwix1002.solution.lab.lab10.l10q3;

import com.umwix1002.solution.lab.CommonConstant;
import com.umwix1002.solution.lab.lab10.l10q2.MessageEncoder;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Function;

import static com.umwix1002.solution.lab.CommonConstant.*;

/**
 * @author Ng Zhi Yang
 */
@Getter @Setter
public class ShuffleCipher implements MessageEncoder {
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
        for(int i = CommonConstant.ZERO; i < (this.shuffleCount == null ? DEFAULT_SHUFFLE_COUNT : shuffleCount); i++) {
            sb = func.apply(sb);
        }
        return sb.toString();
    }

    public StringBuilder shuffle(StringBuilder str) {
        StringBuilder sb = new StringBuilder();
        int mid = str.length() / TWO;
        
        String left = str.substring(CommonConstant.ZERO, mid);
        String right = str.substring(mid); 

        for(int i = CommonConstant.ZERO; i < mid; i++) {
            sb.append(left.charAt(i)).append(right.charAt(i));
        }
        
        sb.append((right.length() > left.length()) ? right.charAt(mid) : "");

        return sb;
    }

    public StringBuilder unshuffle(StringBuilder str) {
        StringBuilder sb = new StringBuilder();

        int length = (str.length() / TWO) * TWO;

        for(int i = CommonConstant.ZERO; i < length; i += TWO) {
            sb.append(str.charAt(i));
        }
        
        for(int i = ONE; i < length; i += TWO) {
            sb.append(str.charAt(i));
        }
        
        sb.append((str.length() % TWO == ONE) ? str.charAt(str.length() - ONE) : BLANK);
        return sb;
    }
}
