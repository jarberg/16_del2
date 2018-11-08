package DTU.SWT_grp16.Controller;

import DTU.SWT_grp16.Model.*;
import DTU.SWT_grp16.Model.Board;
import DTU.SWT_grp16.Model.DiceCup;
import DTU.SWT_grp16.Model.Player;

public class GameController{

    private ViewController viewController = new ViewController();
    private int WIN_AMOUNT = 3000;
    private Playerlist playerlist;
    private DiceCup diceCup;
    private Board board;


    public void setupGame(){
        diceCup = new DiceCup();
        board = new Board();
        viewController.guiSetup();
        for(Field field : board.getFields()){
            int fieldID = field.getID();
            String name = field.getName();
            if(fieldID >= 2)
                viewController.addFieldToGUI(fieldID,name);
        }
        viewController.makeGUI();

        String player1Name = viewController.askName();
        String player2Name = viewController.askName();
        if(player1Name.equals(player2Name))
            player2Name = player1Name + "#2";

        playerlist = new Playerlist(player1Name, player2Name);

        viewController.addPlayers(player1Name, player2Name);
    }

    public void playGame(){

        Player currentPlayer = playerlist.getCurrentPlayer();
        String currentName = currentPlayer.getName();

        viewController.printNewTurnMessage(currentName);
        //viewController.waitForEnter();

        diceCup.roll();
        int sum = diceCup.getSum();
        Field currentField = getFieldByID(sum);

        resolveTurnLogic(currentPlayer, currentField);

        int id = currentField.getID();
        int balance = currentPlayer.getBalance();
        boolean bonusTurn = currentPlayer.hasBonusTurn();
        boolean isWinner = currentPlayer.isWinner();
        viewController.printTurnResult(sum, id, balance, bonusTurn, isWinner, currentPlayer.getName());

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

    private void resolveTurnLogic(Player player, Field field){
        int pointChange = field.getPoints();
        player.addToBalance(pointChange);

        if(field.hasBonusTurn())
            player.setBonusTurn(true);

        if(player.getBalance() >= WIN_AMOUNT){
            player.setWinner(true);
        }
    }

}
