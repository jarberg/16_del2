package DTU.SWT_grp16.Application;
import DTU.SWT_grp16.Controller.GameController;

public class Main {
    public static Boolean stubs = false;
    public static void main(String[] args) {
        if (stubs){

        }
        else{
            GameController game = new GameController();
            game.setupGame();
            game.playGame();

        }
    }
}
