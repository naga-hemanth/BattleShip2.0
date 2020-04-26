package com.hemanth.Game;

import com.hemanth.Player.Player;

public interface IGame {
      Player getCurrPlayer();
       void setWinner(Player player);
       Player getWinner();
}
