package com.hemanth.Utils;

import com.hemanth.BattleShipRules;
import com.hemanth.ConsoleColors;
import com.hemanth.Helper;
import com.hemanth.Player.Player;
import com.hemanth.Ships.Carrier;

import java.util.List;
import java.util.Scanner;

public class ValidationUtils {
    private final static Scanner scanner=new Scanner(System.in);
    public static void validateInputAndAddShips(Player player,   Boolean[][] board,   List<Helper> store,Integer len) {
        Boolean temp = true;
        Integer count = 0;
        while (temp) {
            if (count > 0){
                System.err.println(ConsoleColors.RED+"Please enter corrent details as per rules"+ConsoleColors.RESET);
            }
            Helper helper = takeInput();
            if (BattleShipRules.checkIfPossible(helper.getHeadRow(), helper.getHeadColumn(), helper.getHorizontal(), len)
                    && BattleShipRules.checkIfShipHasClash(helper, board, len)){
                placeShipInTempBoard(helper, board, len);
                store.add(helper);
                temp = false;
            }
            count++;
        }
        printState(board);
    }
    private static Helper takeInput() {

        try {
            System.out.print("Enter front row place :");
            Integer rowFront = Integer.valueOf(ValidationUtils.scanner.nextLine());
            System.out.print("Enter front column place:");
            Integer columnFront = Integer.valueOf(ValidationUtils.scanner.nextLine());
            System.out.print("Enter if its Horizontal :");
            Boolean isHorizontal = Boolean.valueOf(ValidationUtils.scanner.nextLine());
            return new Helper(rowFront, columnFront, isHorizontal);
        } catch (Exception e) {
            System.out.println("Please enter valid Input " + e.getMessage());
            return takeInput();
        }
    }
    private static void placeShipInTempBoard(Helper helper, Boolean[][] board, Integer len) {
        if (helper.getHorizontal()){
            for (int i = helper.getHeadColumn(); i < helper.getHeadColumn() + len; i++) {
                board[helper.getHeadRow()][i] = true;
            }
        } else {
            for (int i = helper.getHeadRow(); i < helper.getHeadRow() + len; i++) {
                board[i][helper.getHeadColumn()] = true;
            }
        }
    }

    private static void printState(Boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j]){
                    System.out.print(1 + " | ");
                } else {
                    System.out.print(0 + " | ");
                }
            }
            System.out.println(" ");
        }
    }
}
