package state;

import core.Game;

public interface GameState{
    void handle(Game game);
}