package org.magicalArena.models;

import org.junit.jupiter.api.Test;
import org.magicalArena.exceptions.InvalidPlayerConstructionException;


import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void builderShouldThrowExceptionWhenNameIsEmpty() {
        assertThrows(InvalidPlayerConstructionException.class, () -> {
            Player.builder().setName("").setStrength(2).setHealth(10).setAttack(2).build();
        });
    }

    @Test
    void builderShouldThrowExceptionWhenStrengthIsNegative() {
        assertThrows(InvalidPlayerConstructionException.class, () -> {
            Player.builder().setName("Player1").setStrength(-1).setHealth(10).setAttack(2).build();
        });
    }

    @Test
    void builderShouldThrowExceptionWhenHealthIsNegative() {
        assertThrows(InvalidPlayerConstructionException.class, () -> {
            Player.builder().setName("Player1").setStrength(2).setHealth(-1).setAttack(2).build();
        });
    }

    @Test
    void builderShouldThrowExceptionWhenAttackIsNegative() {
        assertThrows(InvalidPlayerConstructionException.class, () -> {
            Player.builder().setName("Player1").setStrength(2).setHealth(10).setAttack(-1).build();
        });
    }

    @Test
    void attackShouldReturnZeroWhenDieResultIsZero() throws InvalidPlayerConstructionException {
        Player player = Player.builder().setName("Player1").setStrength(2).setHealth(10).setAttack(2).build();
        assertEquals(0, player.attack(0));
    }

    @Test
    void defendShouldReturnZeroWhenDieResultIsZero() throws InvalidPlayerConstructionException {
        Player player = Player.builder().setName("Player1").setStrength(2).setHealth(10).setAttack(2).build();
        assertEquals(0, player.defend(0));
    }

    @Test
    void takeDamageShouldNotReduceHealthBelowZero() throws InvalidPlayerConstructionException {
        Player player = Player.builder().setName("Player1").setStrength(2).setHealth(10).setAttack(2).build();
        player.takeDamage(20);
        assertEquals(0, player.getHealth());
    }

    @Test
    void rollDieShouldNeverReturnZero() throws InvalidPlayerConstructionException {
        Player player = Player.builder().setName("Player1").setStrength(2).setHealth(10).setAttack(2).build();
        int dieResult = player.rollDie();
        assertTrue(dieResult > 0);
    }

    @Test
    void rollDieShouldNeverReturnMoreThanSix() throws InvalidPlayerConstructionException {
        Player player = Player.builder().setName("Player1").setStrength(2).setHealth(10).setAttack(2).build();
        int dieResult = player.rollDie();
        assertTrue(dieResult <= 6);
    }
}