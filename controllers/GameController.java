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
        try{
            return Game.getBuilder()
                    .setSize(size)
                    .setPlayers(players)
                    .setWinningStrategies(winningStrategies)
                    .build();

        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Sorry. Please Try again with a valid input");
        }
        return null;
    }

    public GameState getGameState(Game game){

        return game.getGameState();
    }

    public void display(Game game){
        game.displayBoard();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public void undo(Game game){
        game.undo();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }
}
