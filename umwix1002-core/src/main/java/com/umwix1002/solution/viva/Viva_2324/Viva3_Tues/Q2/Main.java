package com.umwix1002.solution.viva.Viva_2324.Viva3_Tues.Q2;
public class Main {
    public static void main(String[] args) {
        Pokemon moltres = new Pokemon("Moltres", "Flame", 85.0);
        Pokemon servine = new Pokemon("Servine", "Grass", 60.0);
        Pokemon charmander = new Pokemon("Charmander", "Flame", 92.0);
        Pokemon pansage = new Pokemon("Pansage", "Grass", 55.0);
        Pokemon araquanid = new Pokemon("Araquanid", "Water", 74.0);
        Pokemon flareon = new Pokemon("Flareon", "Flame", 65.0);
        Pokemon squirtle = new Pokemon("Squirtle", "Water", 63.0);
        Pokemon wooper = new Pokemon("Wooper", "Water", 42.0);

        Pokemon[] PokemonList = { moltres, servine, charmander, pansage, araquanid, flareon, squirtle, wooper };

        PokemonSortingSystem sortingSystem = new PokemonSortingSystem(PokemonList);

        System.out.println("List of Pokemon after Sorting: ");
        for (Pokemon pokemon : PokemonList) {
            System.out.println(pokemon);
        }

        System.out.println();

        // String opponentName = "Squirtle";
        // String[] winners = sortingSystem.determineWinner(opponentName, PokemonList);

        // System.out.print("Pokemon effective against " + opponentName + ": ");
        // for (String winner : winners) {
        // System.out.print(winner + " ");
        // }
        
        determineWinners("Squirtle", sortingSystem.determineWinner("Squirtle", PokemonList), PokemonList);
        determineWinners("Charmander", sortingSystem.determineWinner("Charmander", PokemonList), PokemonList);
        determineWinners("Flareon", sortingSystem.determineWinner("Flareon", PokemonList), PokemonList);
    }

    public static void determineWinners(String opponentName, String[] winners, Pokemon[] PokemonList) {
        System.out.println("Pokemon effective against " + opponentName + ":");

        System.out.printf("%15s%15s%15s\n", "Flame", "Grass", "Water");
        for (String winner : winners) {
            System.out.printf("%15s", winner);
        }
        System.out.println("\n");
    }
}
