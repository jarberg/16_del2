package DTU.SWT_grp16.View;

import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;

public class Output {

    private static int MAX_FIELD_COUNT = 30;
    private static int GAME_FIELD_COUNT = 12;
    private GUI_Field[] fields;
    private GUI gui;
    private GUI_Player player1;
    private GUI_Player player2;

    public Output(){
    }

    public void guiSetup(){
        Color color = new Color(52,204,4);
        this.fields = newGUIFieldArrayByColor(color);
    }

    private GUI_Field[] newGUIFieldArrayByColor(Color color){
        GUI_Field[] fields = new GUI_Field[MAX_FIELD_COUNT];
        fields[0] = new GUI_Start();
        fields[0].setBackGroundColor(Color.white);
        fields[0].setTitle("LOBBY");
        fields[0].setSubText("");
        for (int i = 1; i < MAX_FIELD_COUNT; i++) {
            GUI_Street street = new GUI_Street();
            street.setBorder(color);
            street.setBackGroundColor(color);
            street.setForeGroundColor(color);
            fields[i] = street;
        }
        return fields;
    }

    public void addPlayers(String name1, String name2){
        GUI_Car car1 = new GUI_Car();
        car1.setPrimaryColor(Color.blue);
        player1 = new GUI_Player(name1, 1000, car1);
        gui.addPlayer(player1);
        GUI_Car car2 = new GUI_Car();
        car2.setPrimaryColor(Color.pink);
        player2 = new GUI_Player(name2, 1000, car2);
        gui.addPlayer(player2);
        fields[0].setCar(player1, true);
        fields[0].setCar(player2, true);
    }

    public void addFieldToGUI(int id, String name, String description){
        GUI_Street street = new GUI_Street();
        street.setTitle(name);
        street.setSubText("");
        street.setDescription(description);
        fields[id] = street;
    }

    public GUI getGUI(){
        return this.gui;
    }

    public void updateGUI(){
        gui = new GUI(fields);
    }

    public void setGUIRules(String[] strings){
        StringBuilder stringBuilder = new StringBuilder();
        for(String s : strings){
            stringBuilder.append(s + "\n");
        }
        gui.displayChanceCard(stringBuilder.toString());
    }

    public void printTurnResult(int diceSum, int ID, int balance, boolean bonusTurn, boolean isWinner, String name, int points, String message){

        gui.showMessage("You rolled "+diceSum+"!"+" "+message);
        GUI_Player player;
        if(name.equals(player1.getName()))
            player = player1;
        else
            player = player2;

        for(GUI_Field field : fields){
            field.setCar(player,false);
        }
        fields[0].setCar(player,false);
        fields[ID].setCar(player,true);
        player.setBalance(balance);

        if(bonusTurn)
            gui.showMessage("You got a bonus turn!");

        if (isWinner){
            gui.showMessage(name +" is the winner!");
            gui.close();
        }
    }
    public void printNewTurnMessage(String name){
        gui.showMessage("It's "+name+"'s turn.");
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
