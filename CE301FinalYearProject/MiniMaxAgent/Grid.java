package MiniMaxAgent;

import java.util.ArrayList;
import java.util.List;

class Grid {
    private List<Cell> emptyCells;
    private List<Cell> agentCells;
    private List<Cell> oppCells;
    private List<Cell> adjacentCells;
    private List<Cell> availableCells;
    private List<Cell> rootVals;
    private CellState[][] cellState;
    
    public Grid()
    {
        initGrid();
        setGrid();
    
    }

    //initialising the grid.
    private void initGrid()
    {
        this.cellState = new CellState[Constants.GRID_WIDTH][Constants.GRID_HEIGHT];
        this.rootVals = new ArrayList<>();

    }

    //first set all cells in grid to empty.
    public void setGrid()
    {
        for (int i=0; i < Constants.GRID_WIDTH; i++)
        {
            for (int j=0; j < Constants.GRID_HEIGHT; j++)
            {
                cellState[i][j] = CellState.EMPTY;

            }
        }
    }

    //evaluate who's winning. if player 2 contains a cell occupied by player 1. 
    public boolean isWinning(List<Cell> player1, List<Cell> player2)
    {
        if (player1.stream().anyMatch(Cell -> player2.contains(Cell)))
        {
            return true;
        }
        return false;
        
    }

    //returning empty cells and edding them to the arraylist.
    public List<Cell> getEmptyCells()
    {
        emptyCells = new ArrayList<>();

        for (int i=0; i < Constants.GRID_WIDTH; i++)
        {
            for (int j=0; j < Constants.GRID_HEIGHT; j++)
            {
                if (this.cellState[i][j] == CellState.EMPTY)
                {
                    emptyCells.add(new Cell(i, j));
                }
            }
        }
        return emptyCells;

    }

    //returning agent cells and adding them to the arraylist.
    public List<Cell> getAgentCells()
    {
        agentCells = new ArrayList<>();

        for (int i=0; i < Constants.GRID_WIDTH; i++)
        {
            for (int j=0; j < Constants.GRID_HEIGHT; j++)
            {
                if (this.cellState[i][j] == CellState.AGENT)
                {
                    agentCells.add(new Cell(i, j));
                }
            }
        }
        return agentCells;

    }

    //returning opponent cells and adding them to the arraylist.
    public List<Cell> getOppCells()
    {
        oppCells = new ArrayList<>();

        for (int i=0; i < Constants.GRID_WIDTH; i++)
        {
            for (int j=0; j < Constants.GRID_HEIGHT; j++)
            {
                if (this.cellState[i][j] == CellState.OPPONENT)
                {
                    oppCells.add(new Cell(i, j));
                    
                }
            }
        }
        return oppCells;

    }

    //return adjacent cells and add them to available cells arraylist.
    public List<Cell> getAdjacentCells(Cell cell)
    {
        adjacentCells = new ArrayList<>();

        adjacentCells.add(new Cell(cell.getX()+1, cell.getY()));
        adjacentCells.add(new Cell(cell.getX()-1, cell.getY()));
        adjacentCells.add(new Cell(cell.getX(), cell.getY()+1));
        adjacentCells.add(new Cell(cell.getX(), cell.getY()-1));

        return adjacentCells;

    }

    //Add cell to available cell list if it is both an adjacent and empty cell, then return the list.
	public List<Cell> getAvailableCells(List<Cell> adjacentCells, List<Cell> emptyCells)
    {
        availableCells = new ArrayList<>();

        for (int i = 0; i < adjacentCells.size(); i++)
        {
            Cell cell = new Cell(adjacentCells.get(i).getX(), adjacentCells.get(i).getY());
            for (int j = 0; j < emptyCells.size(); j++)
            {
                Cell cell2 = new Cell(emptyCells.get(j).getX(), emptyCells.get(j).getY());
                if (cell.getX() == cell2.getX() && cell.getY() == cell2.getY())
                {
                    availableCells.add(cell);

                }
            }
            
        }
        //System.err.println(availableCells);
        return availableCells;
        
    }

    //get the move with the max minimax value from rootVals.
    public Cell getNextMove()
    {
        int max = Integer.MIN_VALUE;
        int next = Integer.MIN_VALUE;

        //System.err.println(rootVals.size());

        for (int i=0; i < rootVals.size(); i++)
        {
        
            if (max < rootVals.get(i).getMinmaxVal())
            {
                max = rootVals.get(i).getMinmaxVal();
                next = i;

            }
        }
        return rootVals.get(next);
    
    }

    //function to move players on the grid.
    private void playerMove(Cell cell, CellState player)
    {
        this.cellState[cell.getX()][cell.getY()] = player;
    }

    //move agent.
    public void agentMove(int x, int y)
    {
        Cell cell = new Cell(x, y);
        playerMove(cell, CellState.AGENT);

    }

    //move opponent.
    public void oppMove(int x, int y)
    {
        Cell cell = new Cell(x, y);
        playerMove(cell, CellState.OPPONENT);

    }

    //return minimum value in a list.
    private int getMin(List<Integer> list)
    {
        int min = Integer.MAX_VALUE;
        int index = Integer.MIN_VALUE;

        for(int i=0; i < list.size(); i++)
        {
            if(list.get(i) < min)
            {
                min = list.get(i);
                index = i;
            }
        }
        return list.get(index);

    }

    //return maximum value in a list.
    private int getMax(List<Integer> list)
    {
        int max = Integer.MIN_VALUE;
        int index = Integer.MIN_VALUE;

        for(int i=0; i < list.size(); i++)
        {
            if(list.get(i) > max)
            {
                max = list.get(i);
                index = i;
            }
        }
        return list.get(index);
        
    }

    //function calls minimax.
    public void getMiniMax(int depth, CellState player)
    {
        rootVals.clear();
        minimax(depth, player);

    }

    //minimax function
    private int minimax(int depth, CellState player)
    {
        List<Integer> scores = new ArrayList<>();

        getAgentCells();
        getOppCells();
        getEmptyCells();

        //System.err.println(Player.getAgentPos());
        //System.err.println(Player.getOppPos());

        if(isWinning(agentCells, oppCells)) return +1; //agent is winning
        if(isWinning(oppCells, agentCells)) return -1; //opponent is winning
        
        switch(player) {
            case AGENT:
                //get availabe cells from the cells adjacent to the agent.
                //if cell is also empty.
                getAvailableCells(getAdjacentCells(Player.getAgentPos()), emptyCells);

                //if no cells are availabe, player loses.
                if (availableCells.isEmpty()) return -1;

                //iterrate through availableCells.
                for(int i=0; i < availableCells.size(); i++)
                {
                    Cell move = availableCells.get(i);

                    //simulate the agents available moves and calculating the score of each move.
                    playerMove(move, CellState.AGENT);
                    int currentScore = minimax(depth+1, CellState.OPPONENT);
                    scores.add(currentScore);

                    if(depth == 0)
                    {
                        //setting the minmax val of the cells and adding them to the rootVals.
                        move.setMinmaxVal(currentScore);
                        rootVals.add(move);
                    }
                    //resetting the grid
                    cellState[move.getX()][move.getY()] = CellState.EMPTY;

                }
                if(!isWinning(agentCells, oppCells)) return 0;
                
                //return max scores for the agent.
                return getMax(scores);

            case OPPONENT:
                //get adjacent cells for opponent.
                getAdjacentCells(Player.getOppPos());
                getAvailableCells(adjacentCells, emptyCells);

                //if no cells are availabe, player loses.
                if (availableCells.isEmpty()) return -1;

                //iterrate through availableCells.
                for(int i=0; i < availableCells.size(); i++)
                {
                    Cell move = availableCells.get(i);

                    //simulate the opponents available moves and calculating the score of each move.
                    playerMove(move, CellState.OPPONENT);
                    scores.add(minimax(depth+1, CellState.AGENT));
                    
                    //resetting the grid
                    cellState[move.getX()][move.getY()] = CellState.EMPTY;

                }
                if(!isWinning(oppCells, agentCells)) return 0;
                break;

			default:
				break;
                
        }
        //return min scores for the opponent.
        return getMin(scores);

    }

    public List<Cell> getRootVals()
    {
        return rootVals;

    }

    public void setRootVals(List<Cell> rootVals)
    {
        this.rootVals = rootVals;

    }

    public void setEmptyCells(List<Cell> emptyCells)
    {
        this.emptyCells = emptyCells;

    }

    public void setAgentCells(List<Cell> agentCells)
    {
        this.agentCells = agentCells;

    }

    public void setOppCells(List<Cell> oppCells)
    {
        this.oppCells = oppCells;

    }

    public void setAdjacentCells(List<Cell> adjacentCells) {
        this.adjacentCells = adjacentCells;

	}

    public void setAvailableCells(List<Cell> availableCells)
    {
        this.availableCells = availableCells;

    }

}
