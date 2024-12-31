package TicTacToe.models;

public class Cell {
    private Integer row;
    private Integer col;
    private Symbol symbol;
    private CellState cellState;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        this.symbol = null;
        this.cellState = CellState.EMPTY;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }
}
