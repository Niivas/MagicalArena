package org.magicalArena.models;

import org.magicalArena.controller.GameController;
import org.magicalArena.exceptions.InvalidPlayerConstructionException;

public class MagicalArena {
    private static GameController gameController = new GameController();

    public static void main(String[] args) {
        Player player1 = Player.builder().name("Player1").strength(2).health(100).attack(10).build();
        Player player2 = Player.builder().name("Player2").strength(1).health(100).attack(20).build();
        Match match = null;
        try {
            match = gameController.createMatch(player1, player2);
            gameController.fight(match);
            Player winner = gameController.getWinner(match);
            System.out.println("Winner is: " + winner.getName());
        } catch (InvalidPlayerConstructionException e) {
            System.out.println("Invalid player construction: " + e.getMessage());
        }
    }
}
