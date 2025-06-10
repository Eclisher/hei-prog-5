package strategy;

import model.*;

public interface MoveStrategy {
    Point computeNextPosition(Snake snake);
}