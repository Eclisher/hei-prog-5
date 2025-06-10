package builder;
import model.*;
import java.util.List;
import java.util.ArrayList;

public class SnakeBuilder {
    public Snake buildInitialSnake(){
        List<Point> initialBody = new ArrayList<>();
        initialBody.add(new Point(5, 5));
        initialBody.add(new Point(5, 6));
        initialBody.add(new Point(5, 7));
        Direction initialDirection = Direction.UP;
        return new Snake(initialBody, initialDirection);
    }
}