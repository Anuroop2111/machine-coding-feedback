package snakeAndLadder.models;

import java.util.List;

public class GameConfig {

    public final Board board;
    public final List<Player> players;
    public Integer currentRank = 0; // Ranks given till now for the Game
    public Boolean isGameOver = Boolean.FALSE;

    public GameConfig(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
    }

    // Getters
    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Integer getCurrentRank() {
        return currentRank;
    }

    public Boolean isGameOver() {
        return isGameOver;
    }

    // Setters
    public void setCurrentRank(Integer currentRank) {
        this.currentRank = currentRank;
    }

    public void setIsGameOver(Boolean isGameOver) {
        this.isGameOver = isGameOver;
    }
}
