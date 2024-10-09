package com.umwix1002.solution.lab.lab8.l8q1;

/**
 * @author Ng Zhi Yang
 */
public class Main {
    public static void main(String[] args) {
        NumberProperty numberProperty = NumberProperty.builder().size(5).lowerBound(30).isDuplicateAllowed(true).build();
        Number number = Number.of(numberProperty);
        NumberPresenter presenter = new NumberPresenter(number);
        presenter.displayAll();
    }
}
