package Q2;
import java.util.*;

public class PokemonSortingSystem {
    final static int FLAME = 0, GRASS = 1, WATER = 2;
    final static Map<String, Integer> TYPE_MAP = Map.of("Flame", FLAME, "Grass", GRASS, "Water", WATER);

    final static double[][] FACTOR = new double[][] {
            { 1, 1.5, 1 },
            { 1, 1, 1.25 },
            { 1.4, 1, 1 }
    };

    final Pokemon[] POKEMON_LIST;

    public PokemonSortingSystem(Pokemon[] pokemonList) {
        this.POKEMON_LIST = pokemonList;
        Arrays.sort(POKEMON_LIST);
    }

    public String[] determineWinner(String opponentName, Pokemon[] pokemonList) {
        Pokemon opponent = findOpponent(opponentName, pokemonList);
        if (opponent == null) return new String[0];
        List<Pokemon> winners = findWinners(pokemonList, opponent);
        return formatResults(winners, true);
    }

    Pokemon judgeBattle(Pokemon p1, Pokemon p2) {
        double p1Value = p1.getStrength() * FACTOR[typeInt(p1)][typeInt(p2)];
        double p2Value = p2.getStrength() * FACTOR[typeInt(p2)][typeInt(p1)];
        return p1Value > p2Value ? p1 : p2;
    }

    private String[] formatResults(List<Pokemon> winners, boolean isModified) {
        String[] result;
        if (!isModified) {
            result = winners.stream()
                    .map(Pokemon::getName)
                    .toArray(String[]::new);
        } else {
            Collections.sort(winners, Collections.reverseOrder());
            result = new String[3];
            for (Pokemon p : winners) {
                if (result[typeInt(p)] == null)
                    result[typeInt(p)] = p.getName();
                if (result[0] != null && result[1] != null && result[2] != null)
                    break;
            }
            for (int i = 0; i < 3; i++)
                if (result[i] == null)
                    result[i] = "no Pokemon";
        }
        return result;
    }

    private List<Pokemon> findWinners(Pokemon[] pokemonList, Pokemon opponent) {
        List<Pokemon> winners = new ArrayList<>();
        Pokemon pokemon;
        for (int i = pokemonList.length - 1; i >= 0; i--)
            if (isWinner((pokemon = pokemonList[i]), opponent))
                winners.add(pokemon);
        return winners;
    }

    private boolean isWinner(Pokemon pokemon, Pokemon opponent) {
        return pokemon != opponent && judgeBattle(pokemon, opponent) == pokemon;
    }

    private int typeInt(Pokemon pokemon) {
        return TYPE_MAP.get(pokemon.getType());
    }

    private Pokemon findOpponent(String opponentName, Pokemon[] pokemonList) {
        for (Pokemon pokemon : pokemonList)
            if (pokemon.getName().equals(opponentName))
                return pokemon;
        return null;
    }
}
