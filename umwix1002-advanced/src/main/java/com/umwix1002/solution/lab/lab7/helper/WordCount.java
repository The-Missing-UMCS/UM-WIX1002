package com.umwix1002.solution.lab.lab7.helper;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Ng Zhi Yang
 */
@Getter
@NoArgsConstructor
public class WordCount {
    private int charCount;
    private int wordCount;
    private int lineCount;

    /**
     * Increment the char count by n.
     * @param n The amount to increment by.
     */
    public void incrementCharCount(int n) {
        charCount += n;
    }

    /**
     * Increment the word count by 1.
     */
    public void incrementWordCount() {
        wordCount++;
    }

    /**
     * Increment the line count by 1.
     */
    public void incrementLineCount() {
        lineCount++;
    }
}
