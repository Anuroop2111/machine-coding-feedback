package snakeAndLadder.models;

import snakeAndLadder.util.RandomsUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Board {

    public static final int diceCount = 2;
    public static final int maxConsecutiveSix = 3;

    public final int totalCells;
    public final Map<Integer, Integer> snakeMapper;
    public final Map<Integer, Integer> ladderMapper;

    public static Board createRandomBoard(int totalCells, int numSnakes, int numLadders) {
        if (numLadders + numSnakes > totalCells-1) {
            throw new IllegalArgumentException("Too many snakes / ladders provides");
        }
        Map<Integer, Integer> snakeMapper = new HashMap<>();
        Map<Integer, Integer> ladderMapper = new HashMap<>();
        while (snakeMapper.size() < numSnakes) {
            int head = RandomsUtil.getRandomValueBetweenAAndBExclusive(2, totalCells);
            if (snakeMapper.containsKey(head)) continue;
            int tail = RandomsUtil.getRandomValueBetweenAAndBExclusive(1, head);
            snakeMapper.put(head, tail);
        }
        while (ladderMapper.size() < numLadders) {
            int top = RandomsUtil.getRandomValueBetweenAAndBInclusive(2, totalCells);
            int bottom = RandomsUtil.getRandomValueBetweenAAndBExclusive(1, top);
            if (ladderMapper.containsKey(bottom)) continue; // Two ladders cannot have the same bottom position
            if (snakeMapper.containsKey(bottom)) continue; // A snake head and ladder bottom cannot come together
            if (snakeMapper.containsKey(top) && Objects.equals(snakeMapper.get(top), bottom)) continue; // Snake and ladder shouldn't form an infinite loop
            ladderMapper.put(bottom, top);
        }
        return new Board(totalCells, snakeMapper, ladderMapper);
    }

    public Board(int totalCells, Map<Integer, Integer> snakeMapper, Map<Integer, Integer> ladderMapper) {
        this.totalCells = totalCells;
        this.snakeMapper = snakeMapper;
        this.ladderMapper = ladderMapper;
    }

    // Getters
    public int getTotalCells() {
        return this.totalCells;
    }

    public Map<Integer, Integer> getSnakeMapper() {
        return this.snakeMapper;
    }

    public Map<Integer, Integer> getLadderMapper() {
        return this.ladderMapper;
    }

    public int move(int initPos, int diceValue) {
        // Check if finalPos exceeds total cells or if it doesn't
        int finalPos = initPos + diceValue;
        if (finalPos > this.totalCells || (finalPos < this.totalCells && finalPos > this.totalCells - diceCount) || Objects.equals(finalPos, initPos)) {
            return initPos;
        }

        // Check if dice landed on a snake head or ladder tail
        if (this.snakeMapper.containsKey(finalPos)) {
            finalPos = this.snakeMapper.get(finalPos);
        } else if (this.ladderMapper.containsKey(finalPos)) {
            finalPos = this.ladderMapper.get(finalPos);
        }

        return finalPos;
    }
}
