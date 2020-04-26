package com.hemanth.Board;

import com.hemanth.ConsoleColors;
import com.hemanth.Ships.BattleShip;
import com.hemanth.Ships.Carrier;
import com.hemanth.Ships.Cruiser;
import com.hemanth.Ships.Destroyer;
import com.hemanth.Ships.Ship;
import com.hemanth.Ships.Submarine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Try to use instace initializer here if time is avaiable
public class BattleShipPlacingBoard extends BattleShipBoard {

    private List<Ship> ships = new ArrayList<>();

    public BattleShipPlacingBoard(Integer battleShipHeadRow, Integer battleShipHeadColumn, Boolean isBattleShipHorizontal,
                                  Integer carrierHeadRow, Integer carrierHeadColumn, Boolean isCarrierHorizontal,
                                  Integer cruiserHeadRow, Integer cruiserHeadColumn, Boolean isCruiserHorizontal,
                                  Integer destroyerHeadRow, Integer destroyerHeadColumn, Boolean isDestroyerHorizontal,
                                  Integer submarineHeadRow, Integer submarineHeadColumn, Boolean isSubmarineHorizontal) {
        super();
        Ship battleShip = new BattleShip(battleShipHeadRow, battleShipHeadColumn, isBattleShipHorizontal);
        Ship carrier = new Carrier(carrierHeadRow, carrierHeadColumn, isCarrierHorizontal);
        Ship cruiser = new Cruiser(cruiserHeadRow, cruiserHeadColumn, isCruiserHorizontal);
        Ship destroyer = new Destroyer(destroyerHeadRow, destroyerHeadColumn, isDestroyerHorizontal);
        Ship submarine = new Submarine(submarineHeadRow, submarineHeadColumn, isSubmarineHorizontal);
        this.ships = Arrays.asList(battleShip, carrier, cruiser, destroyer, submarine);
        setAllTheShipsInBoard(battleShip, carrier, cruiser, destroyer, submarine);
    }

    public Boolean hitOnShipAndIsSunk(Integer id) {
        System.out.println("You hitted on Opponents " + this.ships.get(id - 1).getClass().getName());
        this.ships.get(id - 1).hitOnShip();
        if (this.ships.get(id - 1).getSunk()){
            System.out.println("Opponents " + this.ships.get(id - 1).getClass().getName() + "is sunk");
            return true;
        }
        return false;
    }

    private void setAllTheShipsInBoard(Ship battleShip, Ship carrier, Ship cruiser, Ship destroyer, Ship submarine) {
        placeShip(battleShip);
        placeShip(carrier);
        placeShip(cruiser);
        placeShip(destroyer);
        placeShip(submarine);
    }

    private void placeShip(Ship battleShip) {
        if (battleShip.getIshorizontal()){
            for (int i = battleShip.getHeadColumn(); i < battleShip.getHeadColumn() + battleShip.getLength(); i++) {
                this.board[battleShip.getHeadRow()][i] = Math.toIntExact(battleShip.getUniqueId());
            }
        } else {
            for (int i = battleShip.getHeadRow(); i < battleShip.getHeadRow() + battleShip.getLength(); i++) {
                this.board[i][battleShip.getHeadColumn()] = Math.toIntExact(battleShip.getUniqueId());
            }
        }
    }
   public void changeValueAsHit(Integer x,Integer y){
        this.board[x][y]=this.board[x][y]*-1;
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
                if (this.board[i][j] != null&&this.board[i][j]>0){
                    System.out.print(ConsoleColors.BLUE + this.board[i][j] + ConsoleColors.GREEN + " | ");
                }
                else if(this.board[i][j]!=null&&this.board[i][j]<0){
                    System.out.print(ConsoleColors.RED + this.board[i][j]*-1 + ConsoleColors.GREEN + " | ");
                }
                else {
                    System.out.print(0 + " | ");
                }

            }
            System.out.println(" ");
        }
    }


}
