package org.magicalArena.models;


import org.magicalArena.exceptions.InvalidPlayerConstructionException;

public class Match {
    private Player attacker;
    private Player defender;

    private Player winner ;


    public Match(Player attacker, Player defender) {
        this.attacker = attacker.getHealth()<=defender.getHealth() ? attacker : defender; // Player1 will attack first if both have same health
        this.defender = attacker.getHealth()>defender.getHealth() ? attacker : defender;
    }

    public void fight() {
    System.out.println("Match started between " + attacker + " and " + defender);
    while (attacker.getHealth() >= 0 && defender.getHealth() >= 0) {
        executeTurn(attacker, defender);
        if (defender.getHealth() <= 0) {
            winner = attacker;
            break;
        }
        playerSwap();
    }
}

void executeTurn(Player attacker, Player defender) {
    System.out.println("------------------------------------------------------");
    System.out.println("Attacker: " + attacker.getName() + " Defender: " + defender.getName());
    System.out.println();
    int attackerDieResult = Math.max(rollDie(attacker), rollDie(attacker));
    int attackValue = executeAttack(attacker, attackerDieResult);
    int defenderDieResult = Math.max(rollDie(defender), Math.max(rollDie(defender), rollDie(defender)));
    int defendValue = executeDefend(defender, defenderDieResult);
    int damage = Math.max(0, attackValue - defendValue);
    defender.takeDamage(damage);
    System.out.println(defender.getName() + " took a damage of " + damage);
    System.out.println();
    System.out.println("Health Status:");
    System.out.println("Health of " + defender.getName() + " is " + defender.getHealth());
    System.out.println("Health of " + attacker.getName() + " is " + attacker.getHealth());
}

private int rollDie(Player player) {
    int dieResult = player.rollDie();
    System.out.println(player.getName() + " rolled a die and got " + dieResult);
    return dieResult;
}

private int executeAttack(Player player, int dieResult) {
    int attackValue = player.attack(dieResult);
    System.out.println(player.getName() + " attacked with a power of " + attackValue + "(" + player.getAttack() + " * " + dieResult + ")" + " damage");
    return attackValue;
}

private int executeDefend(Player player, int dieResult) {
    int defendValue = player.defend(dieResult);
    System.out.println(player.getName() + " defended with a power of " + defendValue + "(" + player.getStrength() + " * " + dieResult + ")");
    return defendValue;
}

    public void playerSwap() {
        Player temp = attacker;
        attacker = defender;
        defender = temp;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getAttacker() {
        return attacker;
    }

    public Player getDefender() {
        return defender;
    }
}
