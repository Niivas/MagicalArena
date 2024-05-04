package org.magicalArena.models;

import org.magicalArena.exceptions.InvalidPlayerConstructionException;

public class Player {
    private String name;
    private int strength;
    private int health;
    private int attack;

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }

    public String toString() {
        return name+ " {" +
                " strength= " + strength +
                ", Initial health= " + health +
                ", attack= " + attack + " " +
                '}';
    }

    private Player(Builder builder) {
        this.name = builder.name;
        this.strength = builder.strength;
        this.health = builder.health;
        this.attack = builder.attack;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int attack(int dieResult){
        return dieResult * this.attack;
    }

    public int defend(int dieResult){
        return dieResult * this.strength;
    }

    public void takeDamage(int damage){
        this.health -= damage;
    }

    public int rollDie(){
        return (int) (Math.random() * 6 + 1);
    }

    protected static class Builder {
        private String name;
        private int strength;
        private int health;
        private int attack;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setStrength(int strength) {
            this.strength = strength;
            return this;
        }

        public Builder setHealth(int health) {
            this.health = health;
            return this;
        }

        public Builder setAttack(int attack) {
            this.attack = attack;
            return this;
        }

        public void validate() throws InvalidPlayerConstructionException {
            if (strength < 0) {
                throw new InvalidPlayerConstructionException("Strength cannot be negative");
            }
            if (health < 0) {
                throw new InvalidPlayerConstructionException("Health cannot be negative");
            }
            if (attack < 0) {
                throw new InvalidPlayerConstructionException("Attack cannot be negative");
            }
        }

        public Player build() throws InvalidPlayerConstructionException {
            this.validate();
            return new Player(this);
        }

    }
}
