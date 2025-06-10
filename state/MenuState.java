package state;

import core.Game;
import java.util.Scanner;
public class MenuState implements GameState {
     @Override
    public void handle(Game game) {
        System.out.println("=== SNAKE GAME ===");
        System.out.println("Appuyez sur Entrée pour démarrer...");
        new Scanner(System.in).nextLine();
        game.setState(new RunningState());
    }
}