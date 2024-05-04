package org.magicalArena.controller;

import org.magicalArena.exceptions.InvalidPlayerConstructionException;
import org.magicalArena.models.Match;
import org.magicalArena.models.Player;

public class GameController {
    public Match createMatch(Player player1, Player player2) throws InvalidPlayerConstructionException {
        if (player1.getHealth() == 0 && player2.getHealth() == 0) {
            throw new InvalidPlayerConstructionException("Atleast one of the players should have health greater than 0");
        }
        if (player1.getAttack() == 0 && player2.getAttack() == 0) { // Match can't be played if both players have attack 0
            throw new InvalidPlayerConstructionException("Atleast one of the players should have attack greater than 0");
        }
        return new Match(player1, player2);
    }

    public void fight(Match match) {
        match.fight();
    }

    public Player getWinner(Match match) {
        return match.getWinner();
    }
}
