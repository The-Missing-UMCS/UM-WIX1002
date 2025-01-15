package com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_2;

import org.apache.commons.lang3.Validate;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.IntStream;

import static com.umwix1002.solution.Properties.PAST_YEAR;

public class Q1 {
    public static final String X = "X";
    public static final String O = "O";
    private static final String FILE = PAST_YEAR + "PastYear2024/wix1002_2024_2/tictactoe.txt";

    public static void main(String[] args) {
        String content = readFile();
        Validate.notNull(content, "File not found.");
        String[][][] ticTacToeGames = parseTicTacToeGames(content);
        displayAllGames(ticTacToeGames);
    }

    private static void displayAllGames(String[][][] ticTacToeGames) {
        IntStream.range(0, ticTacToeGames.length)
            .forEach(i -> {
                System.out.println("Game " + (i + 1) + ":");
                displayGame(ticTacToeGames[i]);
                System.out.println();
            });
    }

    private static void displayGame(String[][] ticTacToe) {
        printBoard(ticTacToe);
        System.out.println("Winner: " + determineResult(ticTacToe));
    }

    private static void printBoard(String[][] ticTacToe) {
        System.out.println("Tic-Tac-Toe Board:");
        Arrays.stream(ticTacToe)
            .map(row -> String.join(" ", row))
            .forEach(System.out::println);
    }

    private static String determineResult(String[][] ticTacToe) {
        if (hasWinner(ticTacToe, X)) {
            return X;
        }
        if (hasWinner(ticTacToe, O)) {
            return O;
        }
        if (hasEmptyCells(ticTacToe)) {
            return "None (on going)";
        }
        return "Draw";
    }

    private static boolean hasWinner(String[][] ticTacToe, String player) {
        return hasWinningRow(ticTacToe, player) ||
            hasWinningColumn(ticTacToe, player) ||
            hasWinningDiagonal(ticTacToe, player);
    }

    private static boolean hasWinningRow(String[][] ticTacToe, String player) {
        return Arrays.stream(ticTacToe)
            .anyMatch(row -> Arrays.stream(row).allMatch(cell -> cell.equals(player)));
    }

    private static boolean hasWinningColumn(String[][] ticTacToe, String player) {
        return IntStream.range(0, ticTacToe.length)
            .anyMatch(col -> Arrays.stream(ticTacToe).allMatch(row -> row[col].equals(player)));
    }

    private static boolean hasWinningDiagonal(String[][] ticTacToe, String player) {
        return IntStream.range(0, ticTacToe.length)
            .allMatch(i -> ticTacToe[i][i].equals(player)) ||
            IntStream.range(0, ticTacToe.length)
                .allMatch(i -> ticTacToe[i][ticTacToe.length - i - 1].equals(player));
    }

    private static boolean hasEmptyCells(String[][] ticTacToe) {
        return Arrays.stream(ticTacToe)
            .flatMap(Arrays::stream)
            .anyMatch(cell -> cell.equals("."));
    }

    private static String[][][] parseTicTacToeGames(String content) {
        return Arrays.stream(content.split("#" + System.lineSeparator()))
            .map(Q1::parseGame)
            .filter(Q1::isValidGame)
            .toArray(String[][][]::new);
    }

    private static String[][] parseGame(String board) {
        return Arrays.stream(board.split(System.lineSeparator()))
            .map(row -> row.split(""))
            .toArray(String[][]::new);
    }

    private static boolean isValidGame(String[][] game) {
        return game.length == 3 && Arrays.stream(game).allMatch(row -> row.length == 3);
    }

    private static String readFile() {
        try {
            return Files.readString(Path.of(FILE));
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }
}
