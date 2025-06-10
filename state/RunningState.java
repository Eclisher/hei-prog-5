package state;

import core.Game;
import model.*;
import factory.FoodFactory;
import strategy.MoveStrategy;

import java.util.Scanner;

public class RunningState implements GameState {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void handle(Game game) {
        game.printGrid();
        System.out.print("Direction (WASD) : ");
        String input = scanner.nextLine().toUpperCase();

        switch (input) {
            case "W" -> game.getSnake().setDirection(Direction.UP);
            case "S" -> game.getSnake().setDirection(Direction.DOWN);
            case "A" -> game.getSnake().setDirection(Direction.LEFT);
            case "D" -> game.getSnake().setDirection(Direction.RIGHT);
        }

        Point next = game.getMoveStrategy().computeNextPosition(game.getSnake());

        if (game.isCollision(next)) {
            game.setState(new GameOverState());
            return;
        }

        boolean isEating = next.equals(game.getFood());
        if (isEating) {
            game.getSnake().grow();
            game.setFood(FoodFactory.generateFood(game.getSnake()));
        }

        game.getSnake().move(next);
    }
}
