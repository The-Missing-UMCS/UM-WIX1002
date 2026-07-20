package com.umwix1002.solution.viva.viva2526.viva02.set02;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class viva2526v2s2q6 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[][] board = readBoard(scanner);

            System.out.println(
                "\nEnter movement direction. Choose \"left\" or \"right\" or \"up\" or \"down\":");

            while (true) {
                String direction = scanner.nextLine().trim().toLowerCase();
                if (!isValidDirection(direction)) {
                    System.out.println(
                        "Invalid movement. Please choose \"left\" or \"right\" or \"up\" or \"down\":");
                    continue;
                }
                switch (direction) {
                    case "left" -> moveLeft(board);
                    case "right" -> moveRight(board);
                    case "up" -> moveUp(board);
                    case "down" -> moveDown(board);
                }
                break;
            }

            System.out.println("\nAfter movement:");
            printBoard(board);

            if (!hasEmptyCells(board)) {
                System.out.println(
                    "Note: No empty spaces left. Game would be over if no merges are possible.");
            }
        }
    }

    private static int[] @NotNull [] readBoard(Scanner scanner) {
        int[][] board = new int[4][4];

        for (int row = 0; row < 4; row++) {
            while (true) {
                try {
                    System.out.printf("Enter row %d of 4: ", (row + 1));
                    String line = scanner.nextLine().trim();
                    String[] numbers = line.split("[,\\s]+");
                    if (numbers.length != 4) {
                        throw new IllegalArgumentException(
                            "Enter exactly 4 integers. Please re-enter this row.");
                    }
                    for (int col = 0; col < 4; col++) {
                        try {
                            int val = getValidBoardValue(numbers[col]);
                            board[row][col] = val;
                        } catch (Exception e) {
                            Arrays.fill(board[row], -1);
                            if (e instanceof NumberFormatException) {
                                throw new IllegalArgumentException(
                                    "Invalid input. Please re-enter this row.");
                            }
                            throw e;
                        }
                    }
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return board;
    }

    private static boolean hasEmptyCells(int[][] board) {
        boolean hasEmpty = false;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col] == 0) {
                    hasEmpty = true;
                    break;
                }
            }
            if (hasEmpty) {
                break;
            }
        }
        return hasEmpty;
    }

    private static boolean isValidDirection(String direction) {
        return "left".equals(direction)
               || "right".equals(direction)
               || "up".equals(direction)
               || "down".equals(direction);
    }

    private static int getValidBoardValue(String numbers) {
        int val = Integer.parseInt(numbers.trim());
        if (!isValidNum(val)) {
            if (val < 0) {
                throw new IllegalArgumentException(
                    "Error: Negative numbers are not allowed. Please re-enter this row.");
            } else {
                throw new IllegalArgumentException(
                    "Error: %d is not a valid 2048 tile number. Please re-enter this row."
                        .formatted(val));
            }
        }
        return val;
    }

    private static boolean isValidNum(int n) {
        return n == 0 || n > 1 && (n & (n - 1)) == 0;
    }

    private static void printBoard(int[][] board) {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void moveLeft(int[][] board) {
        move(board, true, true);
    }

    private static void moveRight(int[][] board) {
        move(board, true, false);
    }

    private static void moveUp(int[][] board) {
        move(board, false, true);
    }

    private static void moveDown(int[][] board) {
        move(board, false, false);
    }

    private static void move(int[][] board, boolean horizontal, boolean fromStart) {
        int[][] original = new int[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(board[i], 0, original[i], 0, 4);
        }

        for (int lineIndex = 0; lineIndex < 4; lineIndex++) {
            int[] line = new int[4];

            for (int j = 0; j < 4; j++) {
                int idx = fromStart ? j : (3 - j);

                if (horizontal) {
                    line[j] = board[lineIndex][idx];
                } else {
                    line[j] = board[idx][lineIndex];
                }
            }

            line = compress(line);
            mergeOnce(line);
            line = compress(line);

            for (int j = 0; j < 4; j++) {
                int idx = fromStart ? j : (3 - j);

                if (horizontal) {
                    board[lineIndex][idx] = line[j];
                } else {
                    board[idx][lineIndex] = line[j];
                }
            }
        }

        if (boardChanged(original, board)) {
            randomlyAddNewTile(board);
        }
    }

    private static int[] compress(int[] line) {
        int[] result = new int[4];
        int pos = 0;

        for (int i = 0; i < 4; i++) {
            if (line[i] != 0) {
                result[pos] = line[i];
                pos++;
            }
        }
        return result;
    }

    private static int[] mergeOnce(int[] line) {
        for (int i = 0; i < 3; i++) {
            if (line[i] != 0 && line[i] == line[i + 1]) {
                line[i] *= 2;
                line[i + 1] = 0;
                i++;
            }
        }
        return line;
    }

    private static boolean boardChanged(int[][] original, int[][] current) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (original[i][j] != current[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }


    private static void randomlyAddNewTile(int[][] grid) {
        // Find empty cells
        int[] cells = new int[16];
        int index = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (grid[row][col] == 0) {
                    cells[index++] = row * 4 + col;
                }
            }
        }

        if (index == 0) {
            return;
        }

        Random rand = new Random();
        int code = cells[rand.nextInt(index)], row = code / 4, col = code % 4;
        grid[row][col] = rand.nextInt(10) < 9 ? 2 : 4;
    }
}
