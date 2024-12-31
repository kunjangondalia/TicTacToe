package TicTacToe.stratergy;
import TicTacToe.models.*;
public interface WinningStratergy {
    boolean checkWinner(Board board, Move move);
}
