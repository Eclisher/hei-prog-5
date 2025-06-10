package factory;

import model.*;

import java.util.Random;

public class FoodFactory {
    private static final Random random =  new Random();
    public static Point generateFood(Snake snake) {
        Point p;
        do {
            p = new Point(random.nextInt(10), random.nextInt(10));
        } while (snake.contains(p));
        return p;
    }
    
}