package TicTacToe.models;
import java.util.*;

public class Board {
    private List<List<Cell>> grid;
    private int size;

    public Board(int size){
        this.size = size;
        grid = new ArrayList<>();
        for( int i=0;i<size;i++){
            grid.add(new ArrayList<>());
            for(int j=0;j<size;j++){
                grid.get(i).add(new Cell(i,j));
            }
        }
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }

    public void setGrid(List<List<Cell>> grid) {
        this.grid = grid;
    }


}
