package DTU.SWT_grp16.Controller;

import DTU.SWT_grp16.Model.*;
import DTU.SWT_grp16.Model.Board;
import DTU.SWT_grp16.Model.DiceCup;
import DTU.SWT_grp16.Model.Player;
import DTU.SWT_grp16.View.Input;

import java.util.Scanner;

public class GameController{

    private ViewController viewController = new ViewController();
    private int WIN_AMOUNT = 3000;
    private Playerlist playerlist;
    private DiceCup diceCup;
    private Board board;
    private Input input = new Input();
    private Scanner scanner = new Scanner(System.in);

    public void setupGame(){
        //player1 = new Player(input.askPlayerName(1));
        //player2 = new Player(input.askPlayerName(2));
        Player player1 = new Player("Tommy");
        Player player2 = new Player("Timme");

        playerlist = new Playerlist(player1, player2);

        diceCup = new DiceCup();
        board = new Board();
    }

    public void playGame(){

        Player currentPlayer = playerlist.getCurrentPlayer();
        String currentName = currentPlayer.getName();

        viewController.printNextTurnMessage(currentName);
        viewController.waitForEnter();


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
        viewController.printTurnResult(sum, id, balance, bonusTurn, isWinner);

        boolean gameIsNotOver = !currentPlayer.isWinner();
        if(gameIsNotOver){
            playerlist.changePlayerTurn();
            playGame();
        }
        viewController.closeScanner();
    }

    private Field getFieldByID(int ID){
        Field field = new Field();
        for(Field f : board.getFields()){
            if(ID == f.getID())
                field = f;
        }
        return field;
    }

}
