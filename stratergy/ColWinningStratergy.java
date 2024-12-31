package TicTacToe.stratergy;
import TicTacToe.models.*;
public class ColWinningStratergy implements WinningStratergy{

    @Override
    public boolean checkWinner(Board board, Move move) {
        System.out.println("Checking the winner in row");
        return false;
    }
}
