package com.hemanth.Board;

public class BoardHelper {
    private Board fst;
    private Board snd;

    public BoardHelper(Board fst, Board snd) {
        this.fst = fst;
        this.snd = snd;
    }

    public Board getFst() {
        return fst;
    }

    public void setFst(Board fst) {
        this.fst = fst;
    }

    public Board getSnd() {
        return snd;
    }

    public void setSnd(Board snd) {
        this.snd = snd;
    }
}
