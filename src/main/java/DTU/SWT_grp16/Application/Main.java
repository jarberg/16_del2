package DTU.SWT_grp16.Application;
import DTU.SWT_grp16.Model.Board;
import DTU.SWT_grp16.View.Input;
import DTU.SWT_grp16.Controller.GameController;
public class Main {
    public static void main(String[] args) {

        GameController.setupGame();
        GameController.playGame();

    }
}
