package org.magicalArena.models;
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


    private Player(Builder builder) {
        this.name = builder.name;
        this.strength = builder.strength;
        this.health = builder.health;
        this.attack = builder.attack;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int attack(){
        int dieResult = (int) (Math.random() * 6 + 1);
        return dieResult * this.attack;
    }

    public int defend(){
        int dieResult = (int) (Math.random() * 6 + 1);
        return dieResult * this.strength;
    }

    public void takeDamage(int damage){
        this.health -= damage;
    }

    protected static class Builder {
        private String name;
        private int strength;
        private int health;
        private int attack;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder strength(int strength) {
            this.strength = strength;
            return this;
        }

        public Builder health(int health) {
            this.health = health;
            return this;
        }

        public Builder attack(int attack) {
            this.attack = attack;
            return this;
        }

        public void validate() {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null or empty");
            }
            if (strength <= 0) {
                throw new IllegalArgumentException("Strength cannot be negative");
            }
            if (health <= 0) {
                throw new IllegalArgumentException("Health cannot be negative");
            }
            if (attack <= 0) {
                throw new IllegalArgumentException("Attack cannot be negative");
            }
        }

        public Player build() {
            this.validate();
            return new Player(this);
        }
    }
}
