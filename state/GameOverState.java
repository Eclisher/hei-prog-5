package state;

import core.Game;

public class GameOverState implements GameState {
    @Override
    public void handle(Game game) {
        System.out.println(" GAME OVER ");
        System.exit(0);
    }
}
