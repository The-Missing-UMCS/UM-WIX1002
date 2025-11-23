package com.umwix1002.solution.pastyear.PastYear2021.Q5;

import java.util.Scanner;

/**
 * Main class for solving arithmetic expressions using given numbers and operators.
 */
public class Main {
    private static final char[] OPERATORS = {'+', '-', '*', '/'};
    private static final int TARGET_ANSWER = 18;

    /**
     * Main entry point of the program.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                int[] numbers = getNumbers(scanner);
                if (!findSolution(numbers)) {
                    System.out.println("No solution");
                }
            }
        }
    }

    /**
     * Prompts the user to enter three numbers and reads them from the scanner.
     *
     * @param scanner Scanner instance for user input.
     * @return An array of three integers entered by the user.
     */
    private static int[] getNumbers(Scanner scanner) {
        System.out.print("Enter 3 numbers [1 - 9] : ");
        return new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
    }

    /**
     * Tries to find a solution for the given numbers to match the target answer using two operators.
     *
     * @param numbers Array of three numbers.
     * @return True if a solution is found, otherwise false.
     */
    private static boolean findSolution(int[] numbers) {
        int a = numbers[0], b = numbers[1], c = numbers[2];

        for (char firstOperator : OPERATORS) {
            for (char secondOperator : OPERATORS) {
                if (evaluateExpression(a, b, c, firstOperator, secondOperator)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Evaluates two possible expressions with the given numbers and operators.
     *
     * @param a              First number.
     * @param b              Second number.
     * @param c              Third number.
     * @param firstOperator  Operator between the first and second numbers.
     * @param secondOperator Operator between the result of the first operation and the third number.
     * @return True if the evaluated expression matches the target answer, otherwise false.
     */
    private static boolean evaluateExpression(int a, int b, int c, char firstOperator, char secondOperator) {
        if (evaluate(secondOperator, evaluate(firstOperator, a, b), c) == TARGET_ANSWER) {
            printExpression(a, b, c, firstOperator, secondOperator, true);
            return true;
        }

        if (evaluate(firstOperator, a, evaluate(secondOperator, b, c)) == TARGET_ANSWER) {
            printExpression(a, b, c, firstOperator, secondOperator, false);
            return true;
        }

        return false;
    }

    /**
     * Prints the expression that evaluates to the target answer.
     *
     * @param a First number.
     * @param b Second number.
     * @param c Third number.
     * @param firstOperator Operator between the first and second numbers.
     * @param secondOperator Operator between the result of the first operation and the third number.
     * @param isOuterGrouped <ul>
     *     <li><b>true</b>: Parentheses are applied around the first operation (a and b).</li>
     *     <li><b>false</b>: Parentheses are applied around the second operation (b and c).</li>
     * </ul>
     */
    private static void printExpression(int a, int b, int c, char firstOperator, char secondOperator, boolean isOuterGrouped) {
        boolean needParentheses = isOuterGrouped
            ? (firstOperator == '+' || firstOperator == '-') && (secondOperator == '*' || secondOperator == '/')
            : (secondOperator == '+' || secondOperator == '-') && (firstOperator == '*' || firstOperator == '/');

        if (isOuterGrouped) {
            System.out.printf("%s%d %c %d%s %c %d = %d%n",
                needParentheses ? "(" : "", a, firstOperator, b, needParentheses ? ")" : "", secondOperator, c, TARGET_ANSWER);
        } else {
            System.out.printf("%d %c %s%d %c %d%s = %d%n",
                a, firstOperator, needParentheses ? "(" : "", b, secondOperator, c, needParentheses ? ")" : "", TARGET_ANSWER);
        }
    }

    /**
     * Evaluates a simple arithmetic operation between two numbers.
     *
     * @param op Operator to apply.
     * @param a  First operand.
     * @param b  Second operand.
     * @return The result of the operation.
     */
    private static int evaluate(char op, int a, int b) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> b != 0 ? a / b : 0;
            default -> 0;
        };
    }
}