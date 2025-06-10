package strategy;

import model.*;

public class SimpleMoveStrategy implements MoveStrategy {
    @Override
    public Point computeNextPosition(Snake snake) {
        return snake.getHead().move(snake.getDirection());
    }
}
