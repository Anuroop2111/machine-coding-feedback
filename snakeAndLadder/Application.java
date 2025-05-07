package snakeAndLadder;

import snakeAndLadder.models.GameConfig;
import snakeAndLadder.service.GameEngine;
import snakeAndLadder.util.InputReader;

public class Application {

    public static void main(String[] args) {
        GameConfig gameConfig = InputReader.readRandomSnakeAndLaddersConfig();
        new GameEngine(gameConfig).startGame();
    }

}
