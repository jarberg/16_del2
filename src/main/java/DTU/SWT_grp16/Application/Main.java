package DTU.SWT_grp16.Application;
import DTU.SWT_grp16.Controller.GameController;
import DTU.SWT_grp16.View.Input;

import java.io.File;

public class Main {
    public static void main(String[] args) {

       GameController game = new GameController();
       Input input = new Input();

       //System.out.println( input.directoryList()[0]);
       //System.out.println( input.directoryList()[1]);
       game.setupGame();
       game.playGame();

    }
}
