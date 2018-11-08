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
    private String currentLanguage="";
    private String filePath ;
    ViewController view = new ViewController();

    public void setupGame(){

        view.printLanguageChoiceList();
        currentLanguage = view.setlanguage();
        System.out.println("du har valgt "+currentLanguage);
        setFilePath();


        String player1Name = viewController.askName();
        String player2Name = viewController.askName();

        playerlist = new Playerlist(player1Name, player2Name);
        diceCup = new DiceCup();
        board = new Board();
    }

    public void playGame(){

        Player currentPlayer = playerlist.getCurrentPlayer();
        String currentName = currentPlayer.getName();

        viewController.printNewTurnMessage(currentName);
        viewController.waitForEnter();

        diceCup.roll();
        int sum = diceCup.getSum();
        Field currentField = getFieldByID(sum);

        resolveTurnLogic(currentPlayer, currentField);

        int id = currentField.getID();
        int balance = currentPlayer.getBalance();
        boolean bonusTurn = currentPlayer.hasBonusTurn();
        boolean isWinner = currentPlayer.isWinner();
        String name = currentField.getName();
        viewController.printTurnResult(sum, id, balance, bonusTurn, isWinner, name);

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

    public void setFilePath(){
        filePath="src/main/textFiles/"+currentLanguage;
    }

}
