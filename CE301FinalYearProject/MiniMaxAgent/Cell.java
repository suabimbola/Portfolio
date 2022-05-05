package MiniMaxAgent;

//cell class holds x, y coordinates of a cell and its minimax value.
class Cell {
    private int x;
    private int y;
    private int minmaxVal;

    public Cell(int x, int y)
    {
        this.x = x;
        this.y = y;

    }

    public int getX()
    {
        return x;

    }

    public void setX(int x)
    {
        this.x = x;

    }

    public int getY()
    {
        return y;

    }

    public void setY(int y)
    {
        this.y = y;

    }

    public int getMinmaxVal()
    {
        return minmaxVal;

    }

    public void setMinmaxVal(int minmaxVal)
    {
        this.minmaxVal = minmaxVal;
        
    }

    @Override
    public String toString() {
        return "[" + this.x + "," + this.y + "]";

    }

}
