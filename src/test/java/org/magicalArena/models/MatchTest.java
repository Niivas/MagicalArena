package org.magicalArena.models;

import org.magicalArena.controller.GameController;
import org.magicalArena.exceptions.InvalidPlayerConstructionException;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    @org.junit.jupiter.api.Test
    void fight() throws InvalidPlayerConstructionException {
        Player player1 = Player.builder().setName("Player1").setStrength(2).setHealth(10).setAttack(2).build();
        Player player2 = Player.builder().setName("Player2").setStrength(1).setHealth(10).setAttack(1).build();
        GameController gameController = new GameController();
        Match match = gameController.createMatch(player1, player2);
        gameController.fight(match);
        assertNotNull(match.getWinner());
    }

    @org.junit.jupiter.api.Test
    void fightWithSameHealth() throws InvalidPlayerConstructionException {
        Player player1 = Player.builder().setName("Player1").setStrength(2).setHealth(10).setAttack(2).build();
        Player player2 = Player.builder().setName("Player2").setStrength(1).setHealth(10).setAttack(1).build();
        GameController gameController = new GameController();
        Match match = gameController.createMatch(player1, player2);
        gameController.fight(match);
        assertNotNull(match.getWinner());
    }

    @org.junit.jupiter.api.Test
    void fightWithNegativeHealth() throws InvalidPlayerConstructionException {
        Player player1 = Player.builder().setName("Player1").setStrength(2).setHealth(-10).setAttack(2).build();
        Player player2 = Player.builder().setName("Player2").setStrength(1).setHealth(10).setAttack(1).build();
        GameController gameController = new GameController();
        assertThrows(InvalidPlayerConstructionException.class, () -> gameController.createMatch(player1, player2));
    }

    @org.junit.jupiter.api.Test
    void fightWithZeroHealth() throws InvalidPlayerConstructionException {
        Player player1 = Player.builder().setName("Player1").setStrength(2).setHealth(0).setAttack(2).build();
        Player player2 = Player.builder().setName("Player2").setStrength(1).setHealth(0).setAttack(1).build();
        GameController gameController = new GameController();
        assertThrows(InvalidPlayerConstructionException.class, () -> gameController.createMatch(player1, player2));
    }

    @org.junit.jupiter.api.Test
    void fightWithNegativeStrength() throws InvalidPlayerConstructionException {
        Player player1 = Player.builder().setName("Player1").setStrength(-2).setHealth(10).setAttack(2).build();
        Player player2 = Player.builder().setName("Player2").setStrength(1).setHealth(10).setAttack(1).build();
        GameController gameController = new GameController();
        assertThrows(InvalidPlayerConstructionException.class, () -> gameController.createMatch(player1, player2));
    }

    @org.junit.jupiter.api.Test
    void fightWithZeroStrength() throws InvalidPlayerConstructionException {
        Player player1 = Player.builder().setName("Player1").setStrength(0).setHealth(10).setAttack(2).build();
        Player player2 = Player.builder().setName("Player2").setStrength(0).setHealth(10).setAttack(1).build();
        GameController gameController = new GameController();
        Match match = gameController.createMatch(player1, player2);
        gameController.fight(match);
        assertNotNull(match.getWinner());
    }

    @org.junit.jupiter.api.Test
    void fightWithNegativeAttack() throws InvalidPlayerConstructionException {
        Player player1 = Player.builder().setName("Player1").setStrength(2).setHealth(10).setAttack(-2).build();
        Player player2 = Player.builder().setName("Player2").setStrength(1).setHealth(10).setAttack(1).build();
        GameController gameController = new GameController();
        assertThrows(InvalidPlayerConstructionException.class, () -> gameController.createMatch(player1, player2));
    }

    @org.junit.jupiter.api.Test
    void fightWithZeroAttack() throws InvalidPlayerConstructionException {
        Player player1 = Player.builder().setName("Player1").setStrength(2).setHealth(10).setAttack(0).build();
        Player player2 = Player.builder().setName("Player2").setStrength(1).setHealth(10).setAttack(0).build();
        GameController gameController = new GameController();
        assertThrows(InvalidPlayerConstructionException.class, () -> gameController.createMatch(player1, player2));
    }

}