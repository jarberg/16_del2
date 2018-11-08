package DTU.SWT_grp16.Controller;

import DTU.SWT_grp16.View.Input;
import DTU.SWT_grp16.View.Output;
import DTU.SWT_grp16.View.StringCollection;

public class ViewController {

    private Output output = new Output();
    private Input input = new Input();

    public void guiSetup(){
        output.guiSetup();
    }

    public void addFieldToGUI(int id, String name){
        String description = input.getFieldMessageByID(id);
        output.addFieldToGUI(id, name, description);
    }

    public void makeGUI(){
        output.updateGUI();
        String[] rules = StringCollection.getRules();
        output.setGUIRules(rules);
    }

    public void addPlayers(String name1, String name2){
        output.addPlayers(name1, name2);
    }

    public void printNewTurnMessage(String name){
        output.printNewTurnMessage(name);
    }

    public void printTurnResult(int diceSum, int id, int currentBalance, boolean bonusTurn, boolean isWinner, String name, int points){
        output.printTurnResult(diceSum, id, currentBalance, bonusTurn, isWinner, name, points);
    }

    public void closeScanner(){
        input.closeScanner();
    }


    public String askName(){
        return input.askPlayerName(output.getGUI());
    }


    public void printLanguageChoiceList(){
        output.printLanguageChoices(input.getLanguageChoices());
    }


    public String setlanguage(){
        String currentLanguage = input.setLanguage(input.getLanguageChoices());
        return currentLanguage;
    }

}
