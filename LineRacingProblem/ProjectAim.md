For my project I am attempting to solve the line racing challenge presented by [Codingame](https://www.codingame.com/multiplayer/bot-programming/tron-battle).

## Challenge Statement

"In this game your are a program driving the legendary tron light cycle. The light cycle moves in straight lines and only turns in 90° angles while leaving a solid light ribbon in its wake. Each cycle and associated ribbon features a different color.

Should a light cycle stop, hit a light ribbon or go off the game grid, it will be instantly deactivated. The last cycle in play wins the game."

## Rules

"Each battle is fought with 2 players. Each player plays in turn during a battle. When your turn comes, the following happens:
- Information about the location of players on the grid is sent on the standard input of your program. So your AI must read information on the standard input at the beginning of a turn.
- Once the inputs have been read for the current game turn, your AI must provide its next move information on the standard ouput. The output for a game turn must be a single line stating the next direction of the light cycle: either UP, DOWN, LEFT or RIGHT.
- Your light cycle will move in the direction your AI provided.
- At this point your AI should wait for your next game turn information and so on and so forth. In the mean time, the AI of the other players will receive information the same way you did.

If your AI does not provide output fast enough when your turn comes, or if you provide an invalid output or if your output would make the light cycle move into an obstacle, then your program loses.

If another AI loses before yours, its light ribbon disappears and the game continues until there is only one player left.

The game grid has a 30 by 20 cells width and height. Each player starts at a random location on the grid."

## Game input

###### "Input for one game turn:

- Two integers N and P. Where N is the total number of players and P is your player number for this game.
- One line per player. First line is for player 0, next line for player 1, etc. Each line contains four values X0, Y0, X1 and Y1. (X0, Y0) are the coordinates of the initial position of the light ribbon (tail) and (X1, Y1) are the coordinates of the current position of the light ribbon (head) of the player. Once a player loses, his/her X0 Y0 X1 Y1 coordinates are all equal to -1 (no more light ribbon on the grid for this player)."

## Aim

The aim of my project is to design an AI which is capabale of tackling this challenge and to better understand the use of pathfinding algorithms in games.
