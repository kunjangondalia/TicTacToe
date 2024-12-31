package TicTacToe.controllers;
import TicTacToe.models.*;
import TicTacToe.stratergy.WinningStratergy;
import java.util.*;
public class GameController {

    public Game startGame(
            int size,
            List<Player> players,
            List<WinningStratergy> winningStrategies
    ){
        return new Game(size,players,winningStrategies);
    }

    public GameState getGameState(Game game){

        return GameState.IN_PROCESS;
    }

    public void display(Game game){
        game.displayBoard();
    }

    public void makeMove(Game game){

    }

    public void undo(Game game){

    }

    public Player getWinner(Game game){
        return null;
    }
}
