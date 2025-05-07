package snakeAndLadder.service;

import snakeAndLadder.models.Board;
import snakeAndLadder.models.GameConfig;
import snakeAndLadder.models.Player;
import snakeAndLadder.util.RollDice;

import java.util.ArrayDeque;
import java.util.Objects;

public class GameEngine {

    private final GameConfig gameConfig;

    public GameEngine(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public void startGame() {
        ArrayDeque<Player> players = new ArrayDeque<>(gameConfig.getPlayers());
        int nextRank = 1;
        Board board = gameConfig.getBoard();

        int maxCellValue = board.getTotalCells();
        while (players.size() > 1) {
            Player player = players.poll();
            int initPos = player.getPos();
            Integer diceValue = RollDice.roll(Board.diceCount, Board.maxConsecutiveSix);
            Integer finalPos = board.move(initPos, diceValue);
            player.setPos(finalPos);
            System.out.printf("%s rolled a %s and moved from %s to %s %n", player.getName(), diceValue, initPos, finalPos);

            // Check if the player won
            if (hasPlayerWon(player, maxCellValue)) {
                player.setHasWon(Boolean.TRUE);
                player.setRank(nextRank);
                System.out.printf("%s wins the game at rank %s %n", player.getName(), player.getRank());
                nextRank += 1;
            } else {
                players.offer(player);
            }
        }

        Player lastPlayer = players.poll();
        lastPlayer.setRank(nextRank);
    }

    private boolean hasPlayerWon(Player player, Integer maxCellValue) {
        return Objects.equals(player.getPos(), maxCellValue);
    }
}
