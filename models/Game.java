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

    private Game(Integer size, List<Player> players, List<WinningStratergy> winningStrategies){
        board = new Board(size);
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.nextPlayerIndex = 0;
        this.gameState = GameState.IN_PROCESS;
        this.winner = null;
        this.moves = new ArrayList<>();
    }

    private boolean validateMove(Move move){

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row<0 || row>= board.getSize() || col<0 || col>= board.getSize()){
            return false;
        }

        return board.getGrid().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

    private void updateGameState(Move move, Player currentPlayer){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToChange = board.getGrid().get(row).get(col);
        cellToChange.setCellState(CellState.FILLED);
        cellToChange.setSymbol(currentPlayer.getSymbol());

        move.setCell(cellToChange);
        move.setPlayer(currentPlayer);
        moves.add(move);

        nextPlayerIndex++;
        nextPlayerIndex %= players.size();
    }

    private boolean checkWinner(Move move){
        for(WinningStratergy winningStratergy: winningStrategies){
            if(winningStratergy.checkWinner(board , move)){
                return true;
            }
        }
        return false;
    }

    public void makeMove(){
        Player currentPlayer = players.get(nextPlayerIndex);

        System.out.println("It's "+currentPlayer.getName()+"'s turn. Please make a move");

        Move move = currentPlayer.makeMove(board);
        if(!validateMove(move)){
            System.out.println("This is invalid Move. Please try again!");
            makeMove();
            return;
        }

        updateGameState(move,currentPlayer);

        if(checkWinner(move)){
            winner = currentPlayer;
            gameState = GameState.SUCCESS;
        } else if(moves.size() == board.getSize() * board.getSize()){
            gameState = GameState.DRAW;
        }

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

        public boolean validate(){
            /*
                    Bot count should be only 1
                    Number of players = size -1
                    All players should have different symbol
             */
            return true;
        }
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
