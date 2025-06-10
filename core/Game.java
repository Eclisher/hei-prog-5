package core;

import builder.SnakeBuilder;
import factory.FoodFactory;
import model.*;
import state.*;
import strategy.*;

public class Game {
    private Snake snake;
    private Point food;
    private GameState currentState;
    private MoveStrategy moveStrategy;

    public Game() {
        snake = new SnakeBuilder().buildInitialSnake();
        food = FoodFactory.generateFood(snake);
        moveStrategy = new SimpleMoveStrategy();
        currentState = new MenuState();
    }

    public void setState(GameState state) {
        currentState = state;
    }

    public Snake getSnake() {
        return snake;
    }

    public Point getFood() {
        return food;
    }

    public void setFood(Point food) {
        this.food = food;
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public boolean isCollision(Point p) {
        return p.x < 0 || p.y < 0 || p.x >= 10 || p.y >= 10 || snake.contains(p);
    }

    public void printGrid() {
        System.out.println("\n");
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                Point p = new Point(x, y);
                if (p.equals(snake.getHead())) {
                    System.out.print("O ");
                } else if (snake.contains(p)) {
                    System.out.print("* ");
                } else if (p.equals(food)) {
                    System.out.print("@ ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public void run() {
        while (true) {
            currentState.handle(this);
        }
    }
}
