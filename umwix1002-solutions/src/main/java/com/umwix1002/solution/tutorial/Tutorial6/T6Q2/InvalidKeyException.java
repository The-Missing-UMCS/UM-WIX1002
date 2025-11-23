package com.umwix1002.solution.tutorial.Tutorial6.T6Q2;

public class InvalidKeyException extends Exception {
    @Override
    public String getMessage() {
        return "The valid key is only 1 and -1";
    }
}
