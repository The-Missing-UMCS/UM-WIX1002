package com.umwix1002.solution.lab.lab3.l3q4.advanced;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * @author Ng Zhi Yang
 */
@AllArgsConstructor
public class DiceSystem {
    private List<@NotNull Player> players;
    public void play() {
        players.stream()
            .map(player -> new PlayerScore(player, player.rollDice()))
            .max(Comparator.comparingInt(PlayerScore::getScore))
            .ifPresentOrElse(
                playerScore -> System.out.println(playerScore.getPlayer().getId() + " won with a score of " + playerScore.getScore())
                , () -> System.out.println("No winner")
            );
    }
}
