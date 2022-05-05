package MiniMaxAgent;

enum CellState {
    AGENT("A"), OPPONENT("O"), EMPTY("#");

    private final String state;

    private CellState(String state)
    {
        this.state = state;

    }

    @Override
    public String toString() {
        return this.state;
    }

}