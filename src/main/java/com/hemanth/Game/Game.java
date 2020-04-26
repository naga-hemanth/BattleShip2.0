package com.hemanth.Game;

import com.hemanth.Player.Player;

import java.util.List;

public abstract class Game implements IGame {
    private Player winner;
    private String name;
    private Player currPlayer;
    private Integer noOfParticipants;
    private List<Player> participants;

    public Integer getNoOfParticipants() {
        return noOfParticipants;
    }

    public void setNoOfParticipants(Integer noOfParticipants) {
        this.noOfParticipants = noOfParticipants;
    }


    public Player getCurrPlayer() {
        return currPlayer;
    }

    public void setCurrPlayer(Player currPlayer) {
        this.currPlayer = currPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }


    public void setParticipants(List<Player> participants) {
        this.participants = participants;
    }

    public List<Player> getParticipants() {
        return participants;
    }
}
