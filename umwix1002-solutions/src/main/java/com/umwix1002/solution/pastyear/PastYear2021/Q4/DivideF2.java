package com.umwix1002.solution.pastyear.PastYear2021.Q4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DivideF2 extends Eleven {

    public DivideF2(int[] data) {
        super(data);
    }

    @Override
    protected String getRuleName() {
        return "Divisibility Rule 2";
    }

    @Override
    public String checkDivisibility(int value) {
        List<State> states = generateStates(value);
        int finalValue = states.getLast().calculateDifference();
        int mod = finalValue % 11;

        return formResult(value, finalValue, mod, () -> {
            String stateString = states.stream()
                .map(State::toString)
                .collect(Collectors.joining(", "));
            return String.format("%d : %s", value, stateString);
        });
    }

    private List<State> generateStates(int value) {
        List<State> states = new ArrayList<>();
        int current = value;

        while (current > 100) {
            State state = new State(current / 10, current % 10);
            states.add(state);
            current = state.calculateDifference();
        }

        return states;
    }

    private record State(int beforeLast, int lastDigit) {

        public int calculateDifference() {
            return beforeLast - lastDigit;
        }

        @Override
        public String toString() {
            return String.format("%d - %d = %d", beforeLast, lastDigit, calculateDifference());
        }
    }
}
