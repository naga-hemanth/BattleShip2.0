package com.hemanth.Game;

import com.hemanth.Board.Board;
import com.hemanth.Board.BoardHelper;
import com.hemanth.Player.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BattleShipGame extends BoardGame {
    private static final Integer playersCount = 2;
    private HashMap<Player, BoardHelper> hashBoard = new HashMap<>();
    private Player oppPlayer;

    public Player getOppPlayer() {
        return oppPlayer;
    }

    public BattleShipGame() {
        super.setNoOfParticipants(playersCount);
    }

    public void setOppPlayer(Player oppPlayer) {
        this.oppPlayer = oppPlayer;
    }

    public void setBoardForPlayer(Player player, Board viewBoard, Board placingBoard) {

        this.hashBoard.put(player, new BoardHelper(viewBoard, placingBoard));
    }

    public Board getPlacingBoardForPlayer(Player player) {
        return this.hashBoard.get(player).getSnd();
    }

    public Board getViewingBoardForPlayer(Player player) {
        return this.hashBoard.get(player).getFst();
    }

    @Override
    public List<Board> getPlayerBoards(Player player) {
        return Arrays.asList(this.hashBoard.get(player).getFst(), this.hashBoard.get(player).getSnd());
    }


}
