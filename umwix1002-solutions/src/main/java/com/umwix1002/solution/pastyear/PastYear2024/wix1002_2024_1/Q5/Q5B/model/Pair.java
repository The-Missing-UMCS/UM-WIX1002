package com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q5.Q5B.model;

public record Pair(Player player1, Player player2) {
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Pair pair)) {
            return false;
        }
        return (player1.equals(pair.player1) && player2.equals(pair.player2)) ||
            (player1.equals(pair.player2) && player2.equals(pair.player1));
    }

    @Override
    public int hashCode() {
        return player1.hashCode() + player2.hashCode(); // Order-independent hash
    }
}
