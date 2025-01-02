package TicTacToe.stratergy;

import TicTacToe.models.*;
import java.util.*;

public class MediumBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board) {
        for(List<Cell> row:board.getGrid()){
            for(Cell cell:row){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    // Bot should make the move in this cell
                    return new Move(new Cell(cell.getRow(),cell.getCol()),null);
                }
            }
        }
        return null;
    }
}
