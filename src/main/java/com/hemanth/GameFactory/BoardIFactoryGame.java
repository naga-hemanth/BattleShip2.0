package com.hemanth.GameFactory;

import com.hemanth.Game.Game;
import com.hemanth.Player.Player;

public abstract class BoardIFactoryGame extends GameFactory {
    abstract void prepareBoards(Player player,Game game);

}
