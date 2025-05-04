package snakeAndLadder.util;

import snakeAndLadder.models.Board;
import snakeAndLadder.models.GameConfig;
import snakeAndLadder.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InputReader {

    private InputReader() {
        throw new AssertionError("Cannot create an Instance of InputReader");
    }

    public static GameConfig readConfig() {
        Scanner sc = new Scanner(System.in);

        int numSnakes = sc.nextInt();
        Map<Integer, Integer> snakeMapper = new HashMap<>();
        for (int i = 0; i < numSnakes; i++) {
            Integer head = sc.nextInt();
            Integer tail = sc.nextInt();
            snakeMapper.put(head, tail);
        }

        int numLadder = sc.nextInt();
        Map<Integer, Integer> ladderMapper = new HashMap<>();
        for (int i = 0; i < numLadder; i++) {
            Integer head = sc.nextInt();
            Integer tail = sc.nextInt();
            ladderMapper.put(head, tail);
        }

        int numPlayers = sc.nextInt();
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            String name = sc.next();
            Player player = new Player(name);
            players.add(player);
        }

        Board board = new Board(100, snakeMapper, ladderMapper);
        sc.close();

        return new GameConfig(board, players);
    }
}
