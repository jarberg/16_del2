package DTU.SWT_grp16.View;

import java.io.BufferedReader;
import java.io.FileReader;

public class StringCollection {

    //Todo: refactor methods to avoid duplication.

    private static StringBuilder stringBuilder;
    private static String FIELD_TEXT_PATH = "fieldMessages.txt";
    private static String MESSAGE_PATH = "Messages.txt";



    public static String[] getRules(){
        String[] rules = {"rule1", "rule2", "rule3"};
        return rules;
    }

}
