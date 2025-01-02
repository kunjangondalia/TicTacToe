package TicTacToe.models;

import TicTacToe.stratergy.BotPlayingStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(Integer id, String name, BotDifficultyLevel botDifficultyLevel, Symbol symbol){
        super(id,name,PlayerType.BOT,symbol);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public Move makeMove(Board board){
        return BotPlayingStrategyFactory
                .getBotPlayingStrategy(botDifficultyLevel)
                .makeMove(board);
    }
}
