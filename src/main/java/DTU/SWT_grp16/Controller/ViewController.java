package DTU.SWT_grp16.Controller;

import DTU.SWT_grp16.View.Input;
import DTU.SWT_grp16.View.Output;

public class ViewController {

    public void printNextTurnMessage(String name){
        Output.printNextTurnMessage(name);
    }

    public void waitForEnter(){
        Input.waitForEnter();
    }

    public void printTurnResult(int diceSum, int id, int currentBalance, boolean bonusTurn, boolean isWinner){
        Output.printTurnResult(diceSum, id, currentBalance, bonusTurn, isWinner);
    }

    public void closeScanner(){
        Input.closeScanner();
    }


}
