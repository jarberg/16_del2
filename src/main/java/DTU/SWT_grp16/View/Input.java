package DTU.SWT_grp16.View;

import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);
    private static int playerNumber;
    private String language="Dansk";


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

    public String[][] readFileField(String filePath){
        String[] lineList = mReader(filePath).toArray(new String[0]);
        String[] endFields = new String[lineList.length+2];

        for (int i = 0; i < (endFields.length) ; i++) {
            if(i<2){
                endFields[i] = "nathing:0:false";
            }
            else{
                endFields[i] = lineList[i-2];
            }
        }
        String[][] finalFields = new String[lineList.length+2][3];

        for (int i = 0; i < finalFields.length; i++) {
            for (int j = 0; j <finalFields[i].length ; j++) {
                finalFields[i][j] = endFields[i].split(":")[0];
            }
            finalFields[i] = endFields[i].split(":");

        }
        return finalFields;
    }
    public String[] readFilecomments(String filePath) {
        String[] lineList = mReader(filePath+"\\").toArray(new String[0]);
        String[] endcomments = new String[lineList.length + 2];
        String[] finalComments = new String[endcomments.length];
        for (int i = 0; i < finalComments.length; i++) {
            finalComments = endcomments[i].split(":");
            
        }
        return finalComments;
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

    private String[] directoryList(){
        File[] directories = new File("src/main/textFiles/").listFiles(File::isDirectory);
        String[] shortLanguage = new String[directories.length];
        for (int i = 0; i <shortLanguage.length ; i++) {
            String path= String.valueOf(directories[i]);
            String[] languageListPath =path.split("\\\\");
            shortLanguage[i] = languageListPath[languageListPath.length-1];
        }
        return shortLanguage;
    }
    public String[] getLanguageChoices(){
        return directoryList();
    }

    public String setLanguage(String[] language){
        String languagechoice = getInput();

        boolean languageExists = false;
        for (int i = 0; i <language.length ; i++) {
            if (language[i].contains(languagechoice)) {
                languageExists = true;
                break;
            }
        }
            if(languageExists){

                this.language = languagechoice;
            }

        return languagechoice;
    }
    public String getLanguage(){return language;}

    public String getInput(){
        String getInput = scanner.nextLine();
        return getInput;
    }
}
