package org.magicalArena.controller;

import org.magicalArena.exceptions.InvalidPlayerConstructionException;
import org.magicalArena.models.Match;
import org.magicalArena.models.Player;

public class GameController {
    public Match createMatch(Player player1, Player player2) throws InvalidPlayerConstructionException {
        return new Match(player1, player2);
    }

    public void fight(Match match) {
        match.fight();
    }

    public Player getWinner(Match match) {
        return match.getWinner();
    }
}
