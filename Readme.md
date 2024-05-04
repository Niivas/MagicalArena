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
8.     8The match will be played until one of the player's health becomes 0.

### Overview:

The Project contains the following components:

Models: This package contains the classes that represent the entities of the game.
1.     **Player Class**: This class contains the attributes of the player like health, attack, and strength. It also contains the methods to attack and defend the player.
2.     **Match Class**: This class contains the methods to start the match and play the match.
3.     **Magical Arena Class**: This class contains the main method to start the game. It is the entry point of the game.

Controllers: This package contains the classes that control the flow of the game.
1.     **GameController Class**: This class contains the methods to create a match, start the match, and get the winner of the match.

Exceptions: This package contains the classes that handle the exceptions to the game.
1.     **InvalidPlayerConstructionException Class**: This class contains the methods to handle the invalid input exception.


