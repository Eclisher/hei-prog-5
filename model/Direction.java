package model;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    public static Direction fromString(String dir) {
        return switch (dir.toUpperCase()) {
            case "UP" -> UP;
            case "DOWN" -> DOWN;
            case "LEFT" -> LEFT;
            case "RIGHT" -> RIGHT;
            default -> throw new IllegalArgumentException("Invalid direction: " + dir);
        };
    }

    public Direction opposite() {
        return switch (this) {
            case UP -> DOWN;
            case DOWN -> UP;
            case LEFT -> RIGHT;
            case RIGHT -> LEFT;
        };
    }
}