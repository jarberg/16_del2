package DTU.SWT_grp16.Controller;

import DTU.SWT_grp16.View.Input;
import DTU.SWT_grp16.View.Output;

import java.util.Scanner;

public class ViewController {

    private Output output = new Output();
    private Input input = new Input();

    public void printNextTurnMessage(String name){
        output.printNextTurnMessage(name);
    }

    public void waitForEnter(){
        input.waitForEnter();
    }

    public void printTurnResult(int diceSum, int id, int currentBalance, boolean bonusTurn, boolean isWinner){
        output.printTurnResult(diceSum, id, currentBalance, bonusTurn, isWinner);
    }

    public void closeScanner(){
        input.closeScanner();
    }

    public String askName(){
        return input.askPlayerName();
    }
}
