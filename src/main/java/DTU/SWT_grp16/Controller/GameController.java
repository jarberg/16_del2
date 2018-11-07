package DTU.SWT_grp16.Controller;

import DTU.SWT_grp16.Model.*;
import DTU.SWT_grp16.Model.Board;
import DTU.SWT_grp16.Model.DiceCup;
import DTU.SWT_grp16.Model.Player;
import DTU.SWT_grp16.View.Input;

import java.util.Scanner;

public class GameController{

    private static int WIN_AMOUNT = 3000;
    private static Player player1;
    private static Player player2;
    private static Playerlist playerlist;
    private static DiceCup diceCup;
    private static Board board;
    private static Input input = new Input();
    private static Scanner scanner = new Scanner(System.in);

    public static void setupGame(){
        //player1 = new Player(input.askPlayerName(1));
        //player2 = new Player(input.askPlayerName(2));
        player1 = new Player("Tommy");
        player2 = new Player("Timme");

        playerlist = new Playerlist(player1, player2);

        diceCup = new DiceCup();
        board = new Board();
    }

    public static void playGame(){

        Player currentPlayer = playerlist.getNextPlayer();
        String currentName = currentPlayer.getName();

        ViewController.printNextTurnMessage(currentName);
        ViewController.waitForEnter();


        diceCup.roll();
        int sum = diceCup.getSum();
        Field currentField = getFieldByID(sum);

        int pointChange = currentField.getPoints();
        currentPlayer.addToBalance(pointChange);

        if(currentField.hasBonusTurn())
            currentPlayer.setBonusTurn(true);

        if(currentPlayer.getBalance() >= WIN_AMOUNT){
            currentPlayer.setWinner(true);
        }

        int id = currentField.getID();
        int balance = currentPlayer.getBalance();
        boolean bonusTurn = currentPlayer.hasBonusTurn();
        boolean isWinner = currentPlayer.isWinner();
        ViewController.printTurnResult(sum, id, balance, bonusTurn, isWinner);

        boolean gameIsNotOver = !currentPlayer.isWinner();
        if(gameIsNotOver){
            playerlist.changePlayerTurn();
            playGame();
        }
        ViewController.closeScanner();
    }

    private static Field getFieldByID(int ID){
        Field field = new Field();
        for(Field f : board.getFields()){
            if(ID == f.getID())
                field = f;
        }
        return field;
    }

}
