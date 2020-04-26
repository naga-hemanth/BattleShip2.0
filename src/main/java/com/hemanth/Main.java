package com.hemanth;

import com.hemanth.Exceptions.InvalidInputException;
import com.hemanth.Game.Game;
import com.hemanth.GameFactory.BattleShipFactoryGame;
import com.hemanth.GameFactory.IFactoryGame;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException, InvalidInputException {
        IFactoryGame iFactoryGame = new BattleShipFactoryGame();
        Game game = iFactoryGame.getGame();
        iFactoryGame.setup(game);
    }


}
