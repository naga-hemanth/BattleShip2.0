package com.hemanth.Board;

public class Board {
    protected Integer[][] board;

    public Board(Integer[][] board) {
        this.board = board;
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
                if (this.board[i][j] != null)
                    System.out.print(this.board[i][j] + " | ");
                else
                    System.out.print(0 + " | ");

            }
            System.out.println(" ");
        }
    }

    public Integer geteExistance(Integer x, Integer y) {
        return board[x][y];
    }
}
