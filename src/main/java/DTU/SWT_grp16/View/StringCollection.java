package DTU.SWT_grp16.View;

import java.io.BufferedReader;
import java.io.FileReader;

public class StringCollection {

    //Todo: refactor methods to avoid duplication.

    private static StringBuilder stringBuilder;
    private static String FIELD_TEXT_PATH = "fieldMessages.txt";
    private static String MESSAGE_PATH = "Messages.txt";

    public static String getFieldMessageByID(int ID){
        stringBuilder = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(FIELD_TEXT_PATH))){
            while(reader.ready()){
                String lineRead = reader.readLine();
                if(lineRead.startsWith("id:"+ID)){
                    stringBuilder.append(lineRead.substring(5));
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return stringBuilder.toString();
    }

    /*
    public static String getSomeStringYouWant(){
        stringBuilder = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(FIELD_TEXT_PATH))){
            while(reader.ready()){
                String lineRead = reader.readLine();
                //if(lineRead.startsWith()){
                //    stringBuilder.append(lineRead.substring(5));
                //}
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return stringBuilder.toString();
    }
    */

}
