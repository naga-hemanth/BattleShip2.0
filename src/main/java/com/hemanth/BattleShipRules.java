package com.hemanth;

import com.hemanth.Board.BattleShipBoard;

import java.io.IOException;

public class BattleShipRules {

    public static Boolean checkIfPossible(Integer rowHead, Integer columnHeard, Boolean isHorizontal, Integer length) {
        if (isValid(rowHead, columnHeard, BattleShipBoard.boardLength)){
            if (isHorizontal){
                if (isValid(rowHead, columnHeard + length - 1, BattleShipBoard.boardLength)){
                    return true;
                }
            } else {
                if (isValid(rowHead + length - 1, columnHeard, BattleShipBoard.boardLength)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void clrscr() {


        try {

            if (System.getProperty("os.name").contains("Windows"))

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            else

                Runtime.getRuntime().exec("clear");

        } catch (IOException | InterruptedException ex) {
        }

    }

    public static void clearScreen() {

        System.out.print("\033[H\033[2J");

        System.out.flush();

    }

    public static Boolean checkIfShipHasClash(Helper helper, Boolean[][] board, Integer len) {
        if (helper.getHorizontal()){
            for (int i = helper.getHeadColumn(); i < helper.getHeadColumn() + len; i++) {
                if (board[helper.getHeadRow()][i]){
                    return false;
                }
            }
        } else {
            for (int i = helper.getHeadRow(); i < helper.getHeadRow() + len; i++) {
                if (board[i][helper.getHeadColumn()]){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(Integer x, Integer y, Integer length) {
        if (x >= 0 && x < length){
            if (y >= 0 && y < length){
                return true;
            }
        }
        return false;
    }
}
