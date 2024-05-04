package org.magicalArena.models;


public class Match {
    private Player attacker;
    private Player defender;

    private Player winner;

    public Match(Player attacker, Player defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public void fight() {
        while (attacker.getHealth() > 0 && defender.getHealth() > 0) {
            System.out.println("Attacker: " + attacker.getName() + " Defender: " + defender.getName());
            int attackValue = attacker.attack();
            System.out.println(attacker.getName() + " attacked " + defender.getName() + " with " + attackValue + " damage");
            int defendValue = defender.defend();
            System.out.println(defender.getName() + " defended a damage of " + defendValue);
            int damage = Math.max(0, attackValue - defendValue);
            defender.takeDamage(damage);
            System.out.println("Health Status:");
            System.out.println("Health of " + attacker.getName() + " is " + attacker.getHealth());
            System.out.println("Health of " + defender.getName() + " is " + defender.getHealth());
            System.out.println();
            if (defender.getHealth() <= 0) {
                winner = attacker;
            }
            this.playerSwap();
            System.out.println("------------------------------------------------------");
        }
    }

    public void playerSwap() {
        Player temp = attacker;
        attacker = defender;
        defender = temp;
    }

    public Player getWinner() {
        return winner;
    }
}
