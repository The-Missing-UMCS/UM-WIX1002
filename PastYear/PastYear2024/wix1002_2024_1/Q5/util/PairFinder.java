package wix1002_2024_1.Q5.util;

import java.util.Optional;
import wix1002_2024_1.Q5.model.Pair;
import wix1002_2024_1.Q5.model.Player;

public class PairFinder {
    private static final int ADDRESS_INDEX = 3;
    private static final int[][][] PAIR_COMBINATIONS = {
            { { 0, 1 }, { 2, 3 } },
            { { 0, 2 }, { 1, 3 } },
            { { 0, 3 }, { 1, 2 } }
    };

    public static Optional<Pair[]> findMatchingPairs(String[][] players) {
        if (!ParticipantInfoParser.isParticipantInfoValid(players))
            return Optional.empty();
        for (int[][] combination : PAIR_COMBINATIONS)
            if (areCombinationAddressesEqual(players, combination))
                return Optional.of(createPairs(players, combination));
        return Optional.empty();
    }

    private static boolean areCombinationAddressesEqual(String[][] players, int[][] combination) {
        return AddressUtil.areAddressesEqual(
                players[combination[0][0]][ADDRESS_INDEX],
                players[combination[0][1]][ADDRESS_INDEX]) &&
                AddressUtil.areAddressesEqual(
                        players[combination[1][0]][ADDRESS_INDEX],
                        players[combination[1][1]][ADDRESS_INDEX]);
    }

    private static Pair[] createPairs(String[][] players, int[][] combination) {
        return new Pair[] {
                new Pair(createPlayer(players[combination[0][0]]), createPlayer(players[combination[0][1]])),
                new Pair(createPlayer(players[combination[1][0]]), createPlayer(players[combination[1][1]]))
        };
    }

    private static Player createPlayer(String[] info) {
        String name = info[0];
        Integer age = Integer.parseInt(info[2]);
        String address = info[3];
        return new Player(name, age, address);
    }
}
