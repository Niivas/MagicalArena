package org.magicalArena.models;

public class DiceService {
    private Dice dice;

    public DiceService(Dice dice) {
        this.dice = dice;
    }

    public int rollDie() {
        return (int) (Math.random() * dice.getSides() + 1);
    }
}
