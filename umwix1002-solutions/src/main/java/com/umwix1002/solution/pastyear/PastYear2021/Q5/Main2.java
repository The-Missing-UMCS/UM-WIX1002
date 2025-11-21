package com.umwix1002.solution.pastyear.PastYear2021.Q5;

import java.util.Scanner;

public class Main2 {
    private static final char FRONT = '1';
    private static final char BACK = '0';
    private static final char[] OPERATORS = {'+', '-', '*', '/'};
    private static final int TARGET_ANSWER = 18;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                int[] numbers = getNumbers(scanner);
                char[][] solutions = findSolutions(numbers);

                if (solutions.length == 0) {
                    System.out.println("No solution");
                } else {
                    printSolutions(numbers, solutions);
                }
            }
        }
    }

    private static int[] getNumbers(Scanner scanner) {
        System.out.print("Enter 3 numbers [1 - 9] : ");
        return new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
    }

    private static char[][] findSolutions(int[] numbers) {
        char[][] solutions = new char[16][3];
        int seq = 0;
        int a = numbers[0], b = numbers[1], c = numbers[2];

        for (char frontOperator : OPERATORS) {
            for (char endOperator : OPERATORS) {
                if (evaluate(endOperator, evaluate(frontOperator, a, b), c) == TARGET_ANSWER) {
                    solutions[seq][0] = FRONT;
                    solutions[seq][1] = frontOperator;
                    solutions[seq][2] = endOperator;
                    seq++;
                }

                if (evaluate(frontOperator, a, evaluate(endOperator, b, c)) == TARGET_ANSWER) {
                    solutions[seq][0] = BACK;
                    solutions[seq][1] = frontOperator;
                    solutions[seq][2] = endOperator;
                    seq++;
                }
            }
        }

        return java.util.Arrays.copyOf(solutions, seq);
    }

    private static void printSolutions(int[] numbers, char[][] solutions) {
        int a = numbers[0], b = numbers[1], c = numbers[2];

        for (char[] solution : solutions) {
            char status = solution[0];
            char frontOperator = solution[1];
            char endOperator = solution[2];
            boolean needParentheses;

            if (status == FRONT) {
                needParentheses = (frontOperator == '+' || frontOperator == '-') && (endOperator == '*' || endOperator == '/');
                System.out.printf("%s%d %c %d%s %c %d = %d%n",
                    needParentheses ? "(" : "", a, frontOperator, b, needParentheses ? ")" : "", endOperator, c, TARGET_ANSWER);
            } else {
                needParentheses = (endOperator == '+' || endOperator == '-') && (frontOperator == '*' || frontOperator == '/');
                System.out.printf("%d %c %s%d %c %d%s = %d%n",
                    a, frontOperator, needParentheses ? "(" : "", b, endOperator, c, needParentheses ? ")" : "", TARGET_ANSWER);
            }
        }
    }

    private static int evaluate(char operator, int a, int b) {
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> b != 0 ? a / b : 0;
            default -> 0;
        };
    }
}

