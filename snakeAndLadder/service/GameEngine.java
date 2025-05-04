package snakeAndLadder.service;

import snakeAndLadder.models.Board;
import snakeAndLadder.models.GameConfig;
import snakeAndLadder.models.Player;
import snakeAndLadder.util.RandomGenerator;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GameEngine {

    public static void startGame(GameConfig gameConfig) {
        List<Player> players = gameConfig.getPlayers();
        Board board = gameConfig.getBoard();

        Integer maxCellValue = board.getTotalCells();
        while(! gameConfig.isGameOver()) {
            for (Player player : players) {
                Integer initPos = player.getPos();
                Integer maxDiceValue = board.getMaxDiceValue();
                Integer diceValue = RandomGenerator.generate(maxDiceValue);
                Integer finalPos = getFinalPos(initPos, diceValue, maxCellValue, board);
                player.setPos(finalPos);
                System.out.printf("%s rolled a %s and moved from %s to %s %n", player.getName(), diceValue, initPos, finalPos);

                // Check if the player won
                if (Objects.equals(finalPos, maxCellValue)) {
                    System.out.printf("%s wins the game %n", player.getName());
                    player.setHasWon(Boolean.TRUE);
                    player.setRank(gameConfig.getCurrentRank() + 1);
                    gameConfig.setIsGameOver(Boolean.TRUE);
                    break;
                }
            }
        }

    }

    private static Integer getFinalPos(Integer initPos, Integer diceValue, Integer maxCellValue, Board board) {
        Map<Integer, Integer> snakeMapper = board.getSnakeMapper();
        Map<Integer, Integer> ladderMapper = board.getLadderMapper();

        // Check if finalPos exceeds maxCellValue
        Integer finalPos = initPos + diceValue;
        if (finalPos > maxCellValue) {return initPos;}

        // Check if dice landed on a snake head or ladder tail
        if (snakeMapper.containsKey(finalPos)) {
            finalPos = snakeMapper.get(finalPos);
        } else if (ladderMapper.containsKey(finalPos)) {
            finalPos = ladderMapper.get(finalPos);
        }

        return finalPos;
    }
}
