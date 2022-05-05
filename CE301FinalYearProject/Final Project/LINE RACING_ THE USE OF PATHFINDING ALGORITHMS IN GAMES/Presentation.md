# Presentation

## Aims & Objectives

I would like to start this presentation by giving a breif overview as to what my project comprised of. The main topic of focus for my project was to learn about different pathfinding algorithms and their uses in artificial intelligence for games. I spent my time conducting research on the different ways AI is used to control non-player characters and have given an in depth review of several strategies used in modern-day game development. My secondary aim for my project was to solve the line racing problem proposed on codingame.com using the knowledge I had aquired from learning about the different pathfinding strategies.

## Why Did I Chose This Topic?

Artificial intelligence is used in various areas of computer science not just games, it's a very challenging concept which in reality still hasn't actually been solved. Alan turing defines AI as a computer that can mimic human responses under specific conditions. However, humans have the ability to think for themselves, where as computers are limited to their programming. For this reason it still hasn't been possible to develop what we would call a true AI because an AI's responses to a situation are dependent on its programming. There are few example of AI which are close to being labbelled as true AI such as the self driving cars by tesla and the example i gave in my report about AlphaGo.

The reason I decided to work on this project is because I find the concept of artificial intelligence very fascinating, it's as if you get to play God and design the rules of your own world. Additionally, my future aspiration is to enter into the world of game development so the link bettween AI and their use in games is a topic I'll need to consider even further as i progress with my career/education.

## What Did I Learn?
- What is AI in Games (4.1)
- Monte Carlo Tree Search (4.2)
- Finite State Machines (4.3)
- The Shortest Path Problem (5)
- Weighted Graphs (5.1)
- Directed Weighted Graphs (5.2)
- Breadth First Search (5.3)
- Dijkstra's Algorithm (5.4)
- A* Search Algorithm (5.5)
- Mini-Max Algorithm (5.6)

## Results
My solution to the Line racing problem executes efficiently with no errors. My agent choses moves based on the state that's most optimal by using a minimax algorithm. The algorithm evaluates winning states by checking if the move enters a cell already occupied by the oppoenet returning the scores of each move. Evaluating my algorithm, I would say that it makes efficient use of space as it doent make any wasteful change of directions if its not at threat of losing. On the other hand because of this, its moves are quite predictable and when going against an algorithm with a similar functionality, its visible that the algorithm is a little flawed.

## Summary
To summaries, after completing this project, I am now able to confidently describe differnt techniques used for AI in game in relation to pathfinding and decision making. I have a clear grasp of the miniamx algorithm and am confident in my ability to write a program which imlements it as seen by my solution to the line racing problem. In the future I would like to improve my algorithm and understanding by implementing other strategies which could yiled better results to the problem.
