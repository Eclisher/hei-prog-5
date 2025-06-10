package model;
import java.util.List;
import java.util.LinkedList;

public class Snake{
    private LinkedList<Point> body;
    private Direction currentDirection;
    private boolean shouldGrow = false;

    public Snake(List<Point> initialBody, Direction direction) {
        this.body = new LinkedList<>(initialBody);
        this.currentDirection = direction;
    }

    public void setDirection(Direction direction) {
        if (direction != null && direction != currentDirection.opposite()) {
            this.currentDirection = direction;
        }
    }
    public Direction getDirection() {
        return currentDirection;
    }
    public List<Point> getBody() {
        return List.copyOf(body);
    }

    public Point getHead() {
        return body.getFirst();
    }
    public void move(Point nextPosition){
        body.addFirst(nextPosition);
        if (!shouldGrow) {
            body.removeLast();
        } else {
            shouldGrow = false;
        }
    }

    public boolean contains(Point p){
     return body.contains(p);
    }
    public void grow() {
        shouldGrow = true;
    }
}