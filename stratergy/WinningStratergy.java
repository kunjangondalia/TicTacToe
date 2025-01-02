package TicTacToe.stratergy;
import TicTacToe.models.*;
public interface WinningStratergy {
    boolean checkWinner(Board board, Move move);
    void handleUndo(Board board, Move move);
}
