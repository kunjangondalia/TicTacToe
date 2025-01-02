package TicTacToe;

import TicTacToe.controllers.GameController;
import TicTacToe.models.*;
import TicTacToe.stratergy.ColWinningStratergy;
import TicTacToe.stratergy.RowWinningStratergy;
import TicTacToe.stratergy.WinningStratergy;

import java.util.*;

public class Client {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]){
        GameController gameController = new GameController();
        /*
            Things to start game
                Size of board
                List of players
                winning strategies
         */
        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer(1,"Kunjan",new Symbol('X')));
        players.add(new Bot(2,"Bot",BotDifficultyLevel.EASY,new Symbol('O')));

        int size = 3;

        List<WinningStratergy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStratergy());
        winningStrategies.add(new ColWinningStratergy());

        Game game = gameController.startGame(
                size,
                players,
                winningStrategies
        );

        gameController.display(game);

        while(gameController.getGameState(game).equals(GameState.IN_PROCESS)){
            gameController.makeMove(game);
            gameController.display(game);
            /*
                    makeMove
                    take the input to make the move
                    update the gameState if required
                    update the turn
             */
            System.out.println("Do you want to Undo? [Y/N]");
            String undoAnswer = scanner.nextLine();
            if(undoAnswer.equals("Y")){
                gameController.undo(game);
                System.out.println("Undo Successful");
                gameController.display(game);
            }
        }

        if(gameController.getGameState(game).equals(GameState.SUCCESS)){
            System.out.println("Winner: "+gameController.getWinner(game).getName());
        }else if(gameController.getGameState(game).equals(GameState.DRAW)){
            System.out.println("Game has ended in Draw");
        }
    }
}


/*
    Display Board
    ask current player to make Move
    checkWinner || draw (After making the move if the game state changes then we should stop the game)
            if yes game over
            else game continues
 */