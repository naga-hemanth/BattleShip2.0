package com.hemanth.GameFactory;

import com.hemanth.Exceptions.InvalidInputException;
import com.hemanth.Game.Game;
import com.hemanth.Player.Player;

import java.util.List;

public interface IFactoryGame {
    void setup(Game game) throws InterruptedException, InvalidInputException;
    List<Player> createPlayers();
    Game getGame();
    void loopUntilWinnerFound(Game game) throws InterruptedException, InvalidInputException;
    void printStateofGameForPlayer(Game game,Player player);
}
