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
            System.out.println(defender.getName() + " defended with " + defendValue + " damage");
            int damage = Math.max(0, attackValue - defendValue);
            defender.takeDamage(damage);
            System.out.println(defender.getName() + " took " + damage + " damage");
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
