# Insquidious

INTRODUCTION
------------

Insquidious is a game modeling the Netflix drama "Squid Games".
 * For a full description of the game, visit the project page:
   https://github.com/AgentKD6-37/Insquidious
   
 * To submit bug reports and feature suggestions, or track changes:
   https://github.com/AgentKD6-37/Insquidious/issues

CLASS DIAGRAM
-------------

![ClassDiagram_20211111](https://user-images.githubusercontent.com/35415559/141371183-76bc31de-ac95-42aa-81d7-e8935c277cbb.gif)

REQUIREMENTS
------------

This package requires no modules outside of Insquidious.

CONFIGURATION
-------------

The module has a menu to navigate the game. 
Using the New Story Game menu option allows creating a new player and customizing the name. Data is saved to save-game.properties. 
Continue will read customization data from save-game.properties.
The mini game selector allows jumping straight to the available games.

Red Light Green Light
---------------------

The point of this game is to make it across the field without being caught by the enemy. The Enemy is assigned a set "time" value. Each of the player types has a speed attribute
assigned at instantiation. The user player is allowed to input a desired distance to try and move across the board. The computer players have their distance determined by a 
random dice roll. All players' distances are divided by their speed resulting in a time to move that distance. If the calculated time is greater than the enemy's time that player is eliminated. The game ends when the user has made it across the field, or been eliminated from the game.
  
   
MAINTAINERS
-----------

Current maintainers:
 * Michael Stack (AgentKD6-37) - github.com/AgentKD6-37
 * Zrybea Whitfield (ZrybeaWhitfield) - github.com/ZrybeaWhitfield
 * Justin Hammel (thirdeye18) - github.com/thirdeye18

FAIR USE ACT DISCLAIMER
-----------------------

This game is intended for educational purposes only.

Fair Use

Copyright Disclaimer under section 107 of the Copyright Act of 1976, allowance is made for "fair use" for purposes such as criticism, comment, news reporting, teaching, scholarship, education, and research.
Fair use is a use permitted by copyright statute that might otherwise be infringing.

