package com.hemanth.GameFactory;

import com.hemanth.BattleShipRules;
import com.hemanth.Board.BattleShipBoard;
import com.hemanth.Board.BattleShipPlacingBoard;
import com.hemanth.Board.BattleShipViewBoard;
import com.hemanth.Board.Board;
import com.hemanth.ConsoleColors;
import com.hemanth.Exceptions.InvalidInputException;
import com.hemanth.Game.BattleShipGame;
import com.hemanth.Game.Game;
import com.hemanth.Helper;
import com.hemanth.Player.BattleShipPlayer;
import com.hemanth.Player.Player;
import com.hemanth.Ships.BattleShip;
import com.hemanth.Ships.Carrier;
import com.hemanth.Ships.Cruiser;
import com.hemanth.Ships.Destroyer;
import com.hemanth.Ships.Submarine;
import com.hemanth.Utils.ValidationUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class BattleShipFactoryGame extends BoardIFactoryGame {
    @Override
        void prepareBoards(Player player, Game game) {
            BattleShipGame battleShipGame = (BattleShipGame) game;
            System.out.println("As this is Battle Ship game u will get 2 Board one for Reference of" +
                    " Miss hits and other for placing ships");
            Board viewBoard = new BattleShipViewBoard();
            Boolean[][] board = new Boolean[10][10];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    board[i][j] = false;
                }
            }
            List<Helper> store = new ArrayList<>();
        System.out.println(player.getName() + " Tell me where do u want to place Battleship");
        ValidationUtils.validateInputAndAddShips(player,board,store,BattleShip.len);
            System.out.println(player.getName() + " Tell me where do u want to place Carrier");
        ValidationUtils.validateInputAndAddShips(player,board,store,Carrier.len);
            System.out.println(player.getName() + " Tell me where do u want to place Cruiser");
        ValidationUtils.validateInputAndAddShips(player,board,store,Cruiser.len);
            System.out.println(player.getName() + " Tell me where do u want to place Destroyer");
        ValidationUtils.validateInputAndAddShips(player,board,store,Destroyer.len);
            System.out.println(player.getName() + " Tell me where do u want to place Submarine");
        ValidationUtils.validateInputAndAddShips(player,board,store,Submarine.len);

            Board placingBoard = new BattleShipPlacingBoard(store.get(0).getHeadRow(), store.get(0).getHeadColumn(), store.get(0).getHorizontal(),
                    store.get(1).getHeadRow(), store.get(1).getHeadColumn(), store.get(1).getHorizontal(),
                    store.get(2).getHeadRow(), store.get(2).getHeadColumn(), store.get(2).getHorizontal(),
                    store.get(3).getHeadRow(), store.get(3).getHeadColumn(), store.get(3).getHorizontal(),
                    store.get(4).getHeadRow(), store.get(4).getHeadColumn(), store.get(4).getHorizontal());
            battleShipGame.setBoardForPlayer(player, viewBoard, placingBoard);
            System.out.print("\033[H\033[2J");
        }


    @Override
    public void setup(Game game) throws InterruptedException, InvalidInputException {
        BattleShipGame battleShipGame = (BattleShipGame) game;
        System.out.println("Hii this is a 2 player Game register 2 players");
        battleShipGame.setParticipants(createPlayers());
        battleShipGame.getParticipants().stream()
                .forEach(v -> prepareBoards(v, battleShipGame));
        loopUntilWinnerFound(battleShipGame);
    }

    @Override
    public List<Player> createPlayers() {
        System.out.print("'Enter First Player name :");
        String firstName = this.scanner.nextLine();
        System.out.print("'Enter Second Player name :");
        String secondName = this.scanner.nextLine();
        Player player1 = new BattleShipPlayer(firstName, 20, 23l, new HashMap<>());
        Player player2 = new BattleShipPlayer(secondName, 20, 23l, new HashMap<>());
        return Arrays.asList(player1, player2);
    }

    @Override
    public Game getGame() {
        return new BattleShipGame();
    }

    @Override
    public void loopUntilWinnerFound(Game temp) throws InterruptedException {
        BattleShipGame game = (BattleShipGame) temp;
        Random random = new Random();
        game.setCurrPlayer(game.getParticipants().get(0));
        game.setOppPlayer(game.getParticipants().get(1));
        System.out.println("The game start in 5 sec with " + game.getCurrPlayer().getName());
        Thread.sleep(5000);
        while (game.getWinner() == null) {
            printStateofGameForPlayer(game, game.getCurrPlayer());
            System.out.println(game.getCurrPlayer().getName() + " Please choose a place to fire");
            String coOrdinate = this.scanner.nextLine();
            Integer x = coOrdinate.charAt(0) - 'a';
            Integer y = coOrdinate.charAt(1) - '0';
            try {
                checkForCorruptData(x, y);
            }
            catch (Exception ex){
                System.out.println("Enter Valid Input");
                continue;
            }
            // System.out.println(x+" "+y);
            BattleShipPlacingBoard opponentBattleShipPlacingBoard = (BattleShipPlacingBoard) game.getPlacingBoardForPlayer(game.getOppPlayer());
            BattleShipViewBoard battleShipViewBoard = (BattleShipViewBoard) game.getViewingBoardForPlayer(game.getCurrPlayer());
            if (opponentBattleShipPlacingBoard.geteExistance(x, y) != null){
                getStatsUpdated(opponentBattleShipPlacingBoard.geteExistance(x, y), opponentBattleShipPlacingBoard,
                        (BattleShipPlayer) game.getOppPlayer());
                opponentBattleShipPlacingBoard.changeValueAsHit(x,y);
                battleShipViewBoard.placeHitOrMiss(x, y, true);
            } else {
                System.out.println(ConsoleColors.RESET + "You had a miss");
                battleShipViewBoard.placeHitOrMiss(x, y, false);
            }
            BattleShipPlayer opp = (BattleShipPlayer) game.getOppPlayer();
            if (opp.getAliveShips() == 0){
                System.out.println(ConsoleColors.CYAN + "You Won " + game.getCurrPlayer().getName());
                game.setWinner(game.getCurrPlayer());
            }
            Thread.sleep(2000);
            System.out.print("\033[H\033[2J");
            System.out.println("Give the lap to Opponent");
             Thread.sleep(5000);
            Player t = game.getCurrPlayer();
            game.setCurrPlayer(game.getOppPlayer());
            game.setOppPlayer(t);
        }
    }

    private void checkForCorruptData(Integer x, Integer y) throws InvalidInputException {
        if (x >= 0 && x < BattleShipBoard.boardLength){
            if (y >= 0 && y < BattleShipBoard.boardLength){
                return;
            }
        }
        throw new InvalidInputException("Cant go out of Board");
    }

    private void getStatsUpdated(Integer id, BattleShipPlacingBoard battleShipPlacingBoard, BattleShipPlayer oppPlayer) {
        if (battleShipPlacingBoard.hitOnShipAndIsSunk(id)){
            oppPlayer.aliveShipsDecrementer();
        }
    }

    @Override
    public void printStateofGameForPlayer(Game game, Player player) {
        BattleShipGame battleShipGame = (BattleShipGame) game;
        List<Board> playerBoards = battleShipGame.getPlayerBoards(player);
        BattleShipViewBoard battleShipViewBoard = (BattleShipViewBoard) playerBoards.get(0);
        BattleShipPlacingBoard battleShipPlacingBoard = (BattleShipPlacingBoard) playerBoards.get(1);
        System.out.println(ConsoleColors.BLUE + "Viewing Board");
        battleShipViewBoard.printBoard();
        System.out.println(ConsoleColors.GREEN + "Placing Board");
        battleShipPlacingBoard.printBoard();

    }
}
