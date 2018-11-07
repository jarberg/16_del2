package DTU.SWT_grp16.Controller;

import DTU.SWT_grp16.View.Input;
import DTU.SWT_grp16.View.Output;

public class ViewController {

    public static void printNextTurnMessage(String name){
        Output.printNextTurnMessage(name);
    }

    public static void waitForEnter(){
        Input.waitForEnter();
    }

    public static void printTurnResult(int diceSum, int id, int currentBalance, boolean bonusTurn, boolean isWinner){
        Output.printTurnResult(diceSum, id, currentBalance, bonusTurn, isWinner);
    }

    public static void closeScanner(){
        Input.closeScanner();
    }


}
