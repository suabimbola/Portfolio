package MiniMaxAgent;

import java.util.Scanner;

class Player {

    static int X0;
    static int Y0;
    static int X1;
    static int Y1;
    static int N;
    static int P;
    public static Cell agentPos;
    public static Cell oppPos;
    static Grid grid;

    static Player[] players;

    Player(int X0, int Y0, int X1, int Y1)
    {
        Player.X0 = X0;
        Player.Y0 = Y0;
        Player.X1 = X1;
        Player.Y1 = Y1;
    }

    public static void main(String args[]) {
        grid = new Grid();
        try (Scanner in = new Scanner(System.in)) {
            // game loop
            while (true) 
            {
                N = in.nextInt(); // total number of players (2 to 4).
                P = in.nextInt(); // your player number (0 to 3).
                players = new Player[N];

                for (int i = 0; i < N; i++) 
                {
                    X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)
                    Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)
                    X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
                    Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)
                    players[i] = new Player(X0, Y0, X1, Y1);
                
                    //simulate the players moves.
                    if( i == P)
                    {
                        grid.agentMove(players[i].getX1(), players[i].getY1());
                        agentPos = new Cell(players[i].getX1(), players[i].getY1());

                    }
                    else
                    {
                        grid.oppMove(players[i].getX1(), players[i].getY1());
                        oppPos = new Cell(players[i].getX1(), players[i].getY1());

                    }

                }

                long startTime = System.nanoTime();

                //call to minimax function
                grid.getMiniMax(0, CellState.AGENT);

                //move with max minmax value.
                Cell nextMove = grid.getNextMove();

                //get movement direction from currentPos to nextMove
                String currentMove = getMove(nextMove, agentPos);

                // Write an action using System.out.println()
                // To debug: System.err.println("Debug messages...");

                System.out.println(currentMove);
                long endTime = System.nanoTime() - startTime;
                System.err.println(endTime);

            }
        }
    }

    //function to return the correct movement from currentPos to nextMove.
    private static String getMove(Cell nextMove, Cell agentPos)
    {
        if(nextMove.getY() < agentPos.getY())
        {
            return "UP";
        }
        else if(nextMove.getY() > agentPos.getY())
        {
            return "DOWN";
        }
        else if(nextMove.getX() < agentPos.getX())
        {
            return "LEFT";
        }
        else if(nextMove.getX() > agentPos.getX())
        {
            return "RIGHT";
        }
        else{
            return "";

        }
    }

    int getX0()
    {
        return X0;

    }

    int getY0()
    {
        return Y0;

    }

    int getX1()
    {
        return X1;

    }

    int getY1()
    {
        return Y1;

    }

    int getN()
    {
        return N;

    }

    int getP()
    {
        return P;

    }

    static Cell getAgentPos()
    {
        return agentPos;

    }

	static Cell getOppPos() {
		return oppPos;
	}

}
