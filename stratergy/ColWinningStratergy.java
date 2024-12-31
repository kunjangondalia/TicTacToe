package TicTacToe.stratergy;
import TicTacToe.models.*;
import java.util.*;
public class ColWinningStratergy implements WinningStratergy{

    HashMap<Integer, HashMap<Character, Integer>> colCount = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {

        int col = move.getCell().getCol();
        Character symbol = move.getPlayer().getSymbol().getSymChar();

        if(!colCount.containsKey(col)){
            colCount.put(col,new HashMap<>());
        }

        HashMap<Character,Integer> count = colCount.get(col);
        count.put(symbol,count.getOrDefault(symbol,0)+1);

        if(count.get(symbol)==board.getGrid().size()){
            return true;
        }

        return false;
    }
}
