package DTU.SWT_grp16.View;

import gui_main.GUI;

import java.util.Arrays;
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);
    private static int playerNumber;
    private String language="Dansk";
    private String filePath ="";

    public void mWriter(String input, String filePath)  {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(input);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> mReader(String filePath)  {
        BufferedReader reader;
        String currentLine="";
        List<String> list = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(filePath));
            while((currentLine = reader.readLine()) != null){
                list.add(currentLine);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public String[][] readFileField(){

        List<String> test= mReader("src/main/textFiles/Dansk/Fields.txt");
        String[] fields = test.toArray(new String[0]);
        String[] endFields = new String[fields.length+2];

        for (int i = 0; i < (endFields.length) ; i++) {
            if(i<2){
                endFields[i] = "nathing:0:false";
            }
            else{
                endFields[i] = fields[i-2];
            }
        }
        String[][] finalFields = new String[fields.length+2][3];

        for (int i = 0; i < finalFields.length; i++) {
            for (int j = 0; j <finalFields[i].length ; j++) {
                finalFields[i][j] = endFields[i].split(":")[0];
            }
            finalFields[i] = endFields[i].split(":");

        }
        return finalFields;
    }

    public String askPlayerName(){
        playerNumber++;
        String playerName = "";
        System.out.println("player"+playerNumber+" : input name");
        while(waitForInput()){
            playerName = scanner.nextLine();
            break;
        }
        return playerName;
    }

    public String askPlayerName(GUI gui){
        playerNumber++;
        String name = gui.getUserString("Player "+playerNumber+". Insert your name.");
        return name;
    }

    public boolean waitForInput(){
        boolean doNext = scanner.hasNext();
        return doNext;
    }

    public void waitForEnter(){
        scanner.nextLine();
    }

    public void closeScanner(){
        scanner.close();
    }

    public String[] directoryList(){
        File[] directories = new File("src/main/textFiles/").listFiles(File::isDirectory);
        String[] shortLanguage = new String[directories.length];


        for (int i = 0; i <directories.length ; i++) {
            String path= String.valueOf(directories[i]);
            String[] languageListPath =path.split("\\\\");
            shortLanguage[i] = languageListPath[languageListPath.length-1];
        }
        return shortLanguage;
    }

    public void setLanguage(String language){

        this.language = language;
        this. filePath = ("src/main/textFiles/");

    }
    public String getLanguage(){return language;}

    public String getInput(){

        return null;
    }


}
