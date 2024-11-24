package org.magicalArena.models;

public class Dice {
    private int sides;

    public int getSides() {
        return sides;
    }

    public Dice(int sides) {
        this.sides = sides;
    }
    public Dice() {
        this.sides = 6;
    }

    public int roll() {
        return (int) (Math.random() * sides + 1);
    }
}
