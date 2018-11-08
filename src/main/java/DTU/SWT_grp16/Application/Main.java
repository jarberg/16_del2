package DTU.SWT_grp16.Application;
import DTU.SWT_grp16.Controller.GameController;
import DTU.SWT_grp16.Controller.ViewController;
import DTU.SWT_grp16.View.*;


import java.io.File;

public class Main {
    public static void main(String[] args) {

       GameController game = new GameController();


       game.setupGame();
       game.playGame();

    }
}
