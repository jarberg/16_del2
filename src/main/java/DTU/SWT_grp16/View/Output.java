package DTU.SWT_grp16.View;

public class Output {

    public Output(){
    }

    public void printFieldMessage(int fieldID){
        String fieldMessage = StringCollection.getFieldMessageByID(fieldID);
        System.out.println(fieldMessage);
    }
    public String getFieldName(String currentField){
        String fieldName ="";
        return fieldName;
    }

    public void printTurnResult(int diceSum, int ID, int balance, boolean bonusTurn, boolean isWinner, String name){
        System.out.println("du rullede "+diceSum);
        System.out.println("du landede på "+name);
        System.out.println("din balance er "+balance);
        if(bonusTurn) {
            System.out.println("vent lidt");
        }
        if (isWinner){
            System.out.println("Winner!");
        }
    }
    public void printNewTurnMessage(String name){

        System.out.println(name+"'s turn");
    }
    public String askForLanguage(String[] choices){
        String choice ="";
        for (int i = 0; i < choices.length ; i++) {
            System.out.print(choices+" : ");
        }
        return choice;
    }
    public String[] printLanguageChoices(String[] choiceList){
        for (int i = 0; i <choiceList.length ; i++) {
            System.out.print(choiceList[i]+"  ");
        }
        System.out.println(" ");
        return choiceList;
    }
    public String printLanguage(String language){
        return language;
    }
}
