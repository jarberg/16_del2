package DTU.SWT_grp16.Controller;

import DTU.SWT_grp16.View.Input;
import DTU.SWT_grp16.View.Output;

public class ViewController {

    private Output output = new Output();
    private Input input = new Input();

    public void printNewTurnMessage(String name){
        output.printNewTurnMessage(name);
    }

    public void waitForEnter(){
        input.waitForEnter();
    }

    public void printTurnResult(int diceSum, int id, int currentBalance, boolean bonusTurn, boolean isWinner, String name){
        output.printTurnResult(diceSum, id, currentBalance, bonusTurn, isWinner, name);
    }

    public void closeScanner(){
        input.closeScanner();
    }

    public String askName(){
        return input.askPlayerName();
    }

    public void printLanguageChoiceList(){
        output.printLanguageChoices(input.getLanguageChoices());
    }


    public String setlanguage(){
        String currentLanguage = input.setLanguage(input.getLanguageChoices());
        return currentLanguage;
    }
    public void printLanguage(){
        System.out.println(output.printLanguage(input.getLanguage()));
    }
    public void getFieldinfo(){

    }
}
