package DTU.SWT_grp16.View;

import DTU.SWT_grp16.View.StringCollection;

public class Output {

    public Output(){
    }

    public void printFieldMessage(int fieldID){
        String fieldMessage = StringCollection.getFieldMessageByID(fieldID);
        System.out.println(fieldMessage);
    }
    public void printTurnResult(int diceSum, int ID, int balance, boolean bonusTurn, boolean isWinner){
        System.out.println("du rullede "+diceSum);
        System.out.println("du landede "+ID);
        System.out.println("din balance er "+balance);
        if(bonusTurn) {
            System.out.println("vent lidt");
        }
        if (isWinner){
            System.out.println("taber!");
        }
    }
    public void printNewTurnMessage(String name){

        System.out.println(name);
    }
}
