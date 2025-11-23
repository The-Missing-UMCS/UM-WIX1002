package com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q5.Q5B;

import com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q5.Q5B.model.Address;
import com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q5.Q5B.model.Grouping;
import com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q5.Q5B.model.Pair;
import com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q5.Q5B.model.Player;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.umwix1002.solution.Properties.PAST_YEAR;

public class CheckPairing {
    private static final String file = PAST_YEAR + "PastYear2024/wix1002_2024_1/Q5/Q5B/participants.txt";

    public static void main(String[] args) {
        // 1. Read file
        String content = readFile(file);
        Validate.notNull(content, "File not found.");

        // 2. Parse players
        List<Player> players = parsePlayers(content);
        Validate.isTrue(!players.isEmpty(), "No participants found.");
        Validate.isTrue(players.size() % 2 == 0, "Odd number of participants.");

        // 3. Find matching pairs
        //    A pair consists of two players with the same address but different gender
        List<Pair> pairs = findMatchingPairs(players);

        // 4. Form groupings
        //    A grouping consists of two pairs of players
        List<Grouping> groupings = formGroupings(pairs);
        displayGroupings(groupings);
    }

    private static void displayGroupings(List<Grouping> groupings) {
        if (groupings.isEmpty()) {
            System.out.println("No matching pairs found.");
            return;
        }

        String seatingArrangement = groupings.stream()
            .map(grouping -> formatGrouping(grouping.pair1(), grouping.pair2()))
            .collect(Collectors.joining(System.lineSeparator()));

        System.out.println("Matching pairs found:\n" + seatingArrangement);
    }

    private static String formatGrouping(Pair pair1, Pair pair2) {
        return String.format("Seat A: %s\nSeat B: %s\nSeat C: %s\nSeat D: %s",
            pair1.player1(), pair2.player1(), pair1.player2(), pair2.player2());
    }

    private static List<Player> parsePlayers(String content) {
        return Arrays.stream(content.split(System.lineSeparator()))
            .map(CheckPairing::parsePlayer)
            .filter(Objects::nonNull)
            .toList();
    }

    private static Player parsePlayer(String line) {
        try {
            String[] info = line.split(",");
            Validate.isTrue(info.length == 4, "Invalid participant info: %s", Arrays.toString(info));
            return new Player(info[0].trim(), info[1].trim(), info[2].trim(), new Address(info[3].trim()));
        } catch (Exception e) {
            System.out.printf("Skipping invalid player data: %s%n", line);
            return null;
        }
    }

    private static List<Grouping> formGroupings(List<Pair> pairs) {
        return IntStream.range(0, pairs.size() / 2)
            .mapToObj(i -> new Grouping(pairs.get(i * 2), pairs.get(i * 2 + 1)))
            .toList();
    }

    public static List<Pair> findMatchingPairs(List<Player> players) {
        return players.stream()
            .flatMap(player1 -> players.stream()
                .filter(player2 -> !player1.equals(player2) && isValidPairing(player1, player2))
                .map(player2 -> new Pair(player1, player2)))
            .distinct()
            .toList();
    }

    private static boolean isValidPairing(Player p1, Player p2) {
        boolean hasSameAddress = p1.address().sameAs(p2.address());
        boolean hasDiffGender = !StringUtils.equals(p1.gender(), p2.gender());
        return hasSameAddress && hasDiffGender;
    }

    public static String readFile(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

}
