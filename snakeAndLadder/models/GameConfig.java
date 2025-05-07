package snakeAndLadder.models;

import java.util.List;

public class GameConfig {

    public final Board board;
    public final List<Player> players;

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

}
