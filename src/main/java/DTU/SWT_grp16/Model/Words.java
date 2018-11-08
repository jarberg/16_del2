package DTU.SWT_grp16.Model;

public class Words {
    public String[] comments;
    public String[] fields;

    public String setupComments(String filepath, String[] reader, String language){
        comments = new String[reader.length] ;
        for (int i = 0; i <reader.length ; i++) {
            comments[i] = reader[i];
        }
        return filepath+"\\"+language+"\\comments.txt";
    }
    public String setupFields(String filepath, String[] reader, String language){
        fields = new String[reader.length] ;

        for (int i = 0; i <reader.length ; i++) {
            fields[i] = reader[i];
        }
        return filepath+"\\"+language+"\\comments.txt";
    }
}