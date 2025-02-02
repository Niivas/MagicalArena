# **Magical Arena**

### Problem Statement:

Design a Magical Arena where two players can fight with each other in turns.
1.     Each player has attributes like health, attack, and strength.
2.     Each player can perform two actions: attack and defend.
3.     Any player whose health becomes 0 first will lose the game.
4.     The game will be played in turns. In each turn, the player can perform one action.
5.     Player with lower health will get the first turn. If both players have the same health, then the player1 will get the first turn.
6.     The player can attack the opponent player with an attack power equal to the (player's attack * roll of a die).
7.     The player can defend himself by reducing the damage equal to (player's strength * roll of a die).
8.     The match will be played until one of the player's health becomes 0.

# Overview:

The Project contains the following components:

## Models: 
This package contains the classes that represent the entities of the game.
* Player Class: This class contains the attributes of the player like health, attack, and strength. It also contains the methods to attack and defend the player.
* Match Class: This class contains the methods to start the match and play the match.
* Magical Arena Class: This class contains the main method to start the game. It is the entry point of the game.

## Controllers: 
This package contains the classes that control the flow of the game.
* GameController Class: This class contains the methods to create a match, start the match, and get the winner of the match.

## Exceptions: 
This package contains the classes that handle the exceptions to the game.
* InvalidPlayerConstructionException Class: This class contains the methods to handle the invalid input exception.

# Getting Started:
To run this project, you need to have opened this project in an IDE and run the MagicalArena class.

# Running the Application:
* Locate the MagicalArena class in models in the src folder.
* Run the MagicalArena class to start the game.
* Follow the prompts to play the game.

Each turn, the console will display the following information:

* Names of the Attacker and Defender.
* Die value rolled to determine the attack and defense power of the player.
* The player's attack and defense power will be shown.
* The damage inflicted on the defender will be displayed.
* The Health of both players will be shown after the turn.

At the start of the game, the console will display the following information:

* Names and attributes of both players.

After the game ends, the console will display the following information:
* Winner of the match.

Example:

```
Match started between Jake { strength= 1, Initial health= 15, attack= 2 } and John { strength= 2, Initial health= 10, attack= 2 }
------------------------------------------------------

Attacker: Jake Defender: John

Jake rolled a die and got 6
Jake attacked with a power of 12(2 * 6) damage
John rolled a die and got 1
John defended with a power of 2(2 * 1)
John took a damage of 10

Health Status:
Health of John is 0
Health of Jake is 15

------------------------------------------------------
Match ended between Jake and John
Match won by Jake with health 15
```

# Unit Testing:
* The project contains the test cases for the Player class and Match class.
* Navigate to the test folder in the src folder.
* Locate the PlayerTest and MatchTest classes.
* Run each test class or individual test methods using your IDE's testing framework.
