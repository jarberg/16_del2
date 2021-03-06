package DTU.SWT_grp16.Model;
import DTU.SWT_grp16.View.Input;

public class Board {
    //Refactor to setupFieldsFromFile method in GameController?
    Input input = new Input();
    private Field[] fields;

    public Board(String filePath){
        setupFields(input.readFileField(filePath));
    }

    private void setupFields(String[][] input){
        //Better implementation uses a file and gives Fields a name variable.
        fields = new Field[input.length];
        for (int i = 0; i <fields.length ; i++) {
            int ID = i;
            String name = input[i][0];
            int points = Integer.valueOf(input[i][1]);
            boolean bonusTurn = Boolean.valueOf(input[i][2]);
            fields[i] = new Field(ID, points, name, bonusTurn);
        }
    }

    public Field[] getFields(){
        return this.fields;
    }
}
