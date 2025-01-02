package TicTacToe.models;
import java.util.*;

public class HumanPlayer extends Player{
    private Integer level;
    private Integer coins;
    private Scanner scanner;

    public HumanPlayer(Integer id, String name, Symbol symbol){
        super(id,name,PlayerType.HUMAN_PLAYER,symbol);
        this.level = 1;
        this.coins = 0;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("Please enter the row in which you want to make the move");
        int row = scanner.nextInt();
        System.out.println("Please enter the col in which you want to make the move");
        int col = scanner.nextInt();

        return new Move(new Cell(row,col),this);
    }

}
