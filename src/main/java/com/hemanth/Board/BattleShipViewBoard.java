package com.hemanth.Board;

import com.hemanth.ConsoleColors;

public class BattleShipViewBoard extends BattleShipBoard {
    private static final Integer hit = 1;
    private static final Integer miss = 2;

    public BattleShipViewBoard() {
        super();
    }

    public void placeHitOrMiss(Integer x, Integer y, Boolean value) {
        if (value){
            this.board[x][y] = hit;
        } else {
            this.board[x][y] = miss;
        }
    }

    public void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < this.board.length; i++) {
            System.out.print(+i + " | ");
        }
        System.out.println("");
        Character character = 'a';
        for (int i = 0; i < this.board.length; i++) {
            System.out.print(character + " ");
            character++;
            for (int j = 0; j < this.board[0].length; j++) {
                if (this.board[i][j] != null){
                    if (this.board[i][j] == 1)
                        System.out.print(ConsoleColors.RED + "H" + ConsoleColors.BLUE + " | ");
                    else
                        System.out.print(ConsoleColors.GREEN + "M" + ConsoleColors.BLUE + " | ");
                } else {
                    System.out.print(0 + " | ");
                }

            }
            System.out.println(" ");
        }
    }
}
