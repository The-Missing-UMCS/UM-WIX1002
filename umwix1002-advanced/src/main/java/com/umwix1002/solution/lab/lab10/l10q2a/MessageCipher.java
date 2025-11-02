package com.umwix1002.solution.lab.lab10.l10q2a;

/**
 * @author Ng Zhi Yang
 */
public interface MessageCipher extends Encoder, Decoder {
    @Override
    String encode(String message);
    
    @Override
    String decode(String message);
}
