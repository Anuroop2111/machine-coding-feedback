package snakeAndLadder.models;

import java.util.Map;

public class Board {

    public final Integer totalCells;
    public final Integer minDiceValue = 1;
    public final Integer maxDiceValue = 6;
    public final Map<Integer, Integer> snakeMapper;
    public final Map<Integer, Integer> ladderMapper;

    public Board(Integer totalCells, Map<Integer, Integer> snakeMapper, Map<Integer, Integer> ladderMapper) {
        this.totalCells = totalCells;
        this.snakeMapper = snakeMapper;
        this.ladderMapper = ladderMapper;
    }

    // Getters
    public Integer getTotalCells() {return this.totalCells;}
    public Integer getMinDiceValue() {return this.minDiceValue;}
    public Integer getMaxDiceValue() {return this.maxDiceValue;}
    public Map<Integer, Integer> getSnakeMapper() {return this.snakeMapper;}
    public Map<Integer, Integer> getLadderMapper() {return this.ladderMapper;}

}
