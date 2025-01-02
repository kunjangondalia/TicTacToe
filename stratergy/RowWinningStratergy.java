package TicTacToe.stratergy;
import TicTacToe.models.*;
import java.util.*;

public class RowWinningStratergy implements WinningStratergy{

    private HashMap<Integer, HashMap<Character,Integer>> rowCounts = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        Character symbol = move.getPlayer().getSymbol().getSymChar();

        if(!rowCounts.containsKey(row)){
            rowCounts.put(row,new HashMap<>());
        }

        HashMap<Character,Integer> counts = rowCounts.get(row);

        if(!counts.containsKey(symbol)){
            counts.put(symbol,0);
        }

        counts.put(symbol, counts.get(symbol)+1);

        if(counts.get(symbol)==board.getGrid().size()){
            return true;
        }
        return false;
    }
    @Override
    public void handleUndo(Board board, Move move) {
        int row = move.getCell().getRow();
        Character sym = move.getPlayer().getSymbol().getSymChar();

        rowCounts.get(row).put(sym,rowCounts.get(row).get(sym)-1);
    }
}
