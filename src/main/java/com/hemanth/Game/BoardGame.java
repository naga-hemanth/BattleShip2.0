package com.hemanth.Game;

import com.hemanth.Board.Board;
import com.hemanth.Player.Player;

import java.util.List;

public abstract class BoardGame extends Game {
    protected List<Board> boards;

    public abstract List<Board> getPlayerBoards(Player player);
}
