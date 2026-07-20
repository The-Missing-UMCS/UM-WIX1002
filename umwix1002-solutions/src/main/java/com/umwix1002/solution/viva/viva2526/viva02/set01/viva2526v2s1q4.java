package com.umwix1002.solution.viva.viva2526.viva02.set01;

import java.util.Arrays;
import java.util.Scanner;

public class viva2526v2s1q4 {

    public static void main(String[] args) {
        String input = """
            X..
            XOO
            X..
            XXX
            OOO
            ...
            XXX
            O..
            ...
            ...
            ...
            ...
            XOX
            OXO
            OXO
            """;
        try (Scanner scanner = new Scanner(input)) {
            char[][] board;
            int index = 0;
            while ((board = readBoard(scanner)) != null) {
                System.out.println(System.lineSeparator() + ++index);
                System.out.print(boardToString(board));

                boolean xWin = hasWin(board, 'X');
                boolean oWin = hasWin(board, 'O');

                if (xWin && oWin) {
                    System.out.println("[Invalid board]: Two winners.");
                    continue;
                }

                if (!xWin && !oWin) {
                    System.out.println("No winners.");
                    continue;
                }

                char winner = xWin ? 'X' : 'O';
                int xMoves = countMoves(board, 'X'), oMoves = countMoves(board, 'O');

                boolean isValid = winner == 'X' && xMoves == oMoves + 1
                                  || winner == 'O' && oMoves == xMoves + 1;

                if (!isValid) {
                    System.out.printf(
                        "[Invalid board]: Invalid moves (X moves=%d, O moves=%d)%n", xMoves, oMoves
                    );
                    continue;
                }

                System.out.println("Winner: " + winner);
            }
        }
    }

    /*
     * The method will read three lines continuously
     */
    private static char[][] readBoard(Scanner scanner) {
        char[][] board = new char[3][3];
        boolean valid = true;
        for (int i = 0; i < 3; i++) {
            if (!scanner.hasNextLine()) {
                return null; // indicates the board is not complete
            }
            if (!valid) {
                continue;
            }
            String[] values = scanner.nextLine().split("\\s*");

            // If more than 3 values are provided, then the line is incorrect
            // We simply assume that the board
            if (values.length != 3) {
                valid = false;
                board = null;
                continue;
            }
            for (int j = 0; j < 3; j++) {
                board[i][j] = values[j].charAt(0);
            }
        }
        return board;
    }


    /*
     * Determine if the player has win
     */
    private static boolean hasWin(char[][] board, char player) {
        // Horizontal
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // Vertical
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // Main diagonal and Anti-diagonal
        return board[0][0] == player && board[1][1] == player && board[2][2] == player
               || board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }

    private static int countMoves(char[][] board, char player) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == player) {
                    count++;
                }
            }
        }
        return count;
    }

    private static String boardToString(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
