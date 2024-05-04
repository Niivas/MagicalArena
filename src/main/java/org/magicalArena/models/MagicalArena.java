package org.magicalArena.models;

import org.magicalArena.controller.GameController;
import org.magicalArena.exceptions.InvalidPlayerConstructionException;

import java.util.Scanner;

public class MagicalArena {
    private static GameController gameController = new GameController();

    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("*** Player 1 ***");
        Player player1 = createPlayer(scanner1, "Player 1");
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("*** Player 2 ***");
        Player player2 = createPlayer(scanner2, "Player 2");
        System.out.println("------------------------------------------------------");
        Match match = null;
        try {
            match = gameController.createMatch(player1, player2);
            gameController.fight(match);
            Player winner = gameController.getWinner(match);
            System.out.println("------------------------------------------------------");
            System.out.println("Match ended between " + player1.getName() + " and " + player2.getName());
            System.out.println("Match won by " + winner.getName() + " with health of " + winner.getHealth());
        } catch (InvalidPlayerConstructionException e) {
            System.out.println("Invalid player construction: " + e.getMessage());
        }
    }

    private static Player createPlayer(Scanner scanner, String defaultName) {
        System.out.println("Enter "+ defaultName +"'s name: ");
        String playerName = scanner.nextLine();
        playerName = playerName.trim().isEmpty() ? defaultName : playerName;
        System.out.println("Enter "+ playerName +"'s strength: ");
        int playerStrength = scanner.nextInt();
        System.out.println("Enter "+ playerName +"'s health: ");
        int playerHealth = scanner.nextInt();
        System.out.println("Enter "+ playerName +"'s attack: ");
        int playerAttack = scanner.nextInt();
        return Player.builder()
                .setName(playerName)
                .setStrength(playerStrength)
                .setHealth(playerHealth)
                .setAttack(playerAttack)
                .build();
    }
}
