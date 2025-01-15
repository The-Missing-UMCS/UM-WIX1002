package com.umwix1002.solution.lab.lab3.l3q4.advanced;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

/**
 * @author Ng Zhi Yang
 */
@AllArgsConstructor
public class DiceSystem {
    private List<Player> players;

    public void play() {
        players.stream()
            .peek(Player::rollDice)
            .max(Comparator.comparingInt(Player::getScore))
            .ifPresentOrElse(
                player -> System.out.println(player.getId() + " won with a score of " + player.getScore())
                , () -> System.out.println("No winner")
            );
    }
}
