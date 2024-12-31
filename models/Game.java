package TicTacToe.models;

import TicTacToe.stratergy.WinningStratergy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Integer nextPlayerIndex;
    private GameState gameState;
    private List<Move> moves;
    private List<WinningStratergy> winningStrategies;
    private Player winner;

    public Game(Integer size, List<Player> players, List<WinningStratergy> winningStrategies){
        board = new Board(size);
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.nextPlayerIndex = 0;
        this.gameState = GameState.IN_PROCESS;
        this.winner = null;
        this.moves = new ArrayList<>();
    }

    public static GameBuilder getBuilder(){

        return new GameBuilder();
    }

    public void displayBoard(){
        board.displayBoard();
    }

    public static class GameBuilder{
        private Integer size;
        private List<Player> players;
        private List<WinningStratergy> winningStrategies;

        public Game build(){
            return new Game(size,players,winningStrategies);
        }

        public Integer getSize() {
            return size;
        }

        public GameBuilder setSize(Integer size) {
            this.size = size;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<WinningStratergy> getWinningStrategies() {
            return winningStrategies;
        }

        public GameBuilder setWinningStrategies(List<WinningStratergy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Integer getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(Integer nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<WinningStratergy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStratergy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
