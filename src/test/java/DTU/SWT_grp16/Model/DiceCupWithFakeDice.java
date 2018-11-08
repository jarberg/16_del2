package DTU.SWT_grp16.Model;

public class DiceCupWithFakeDice extends DiceCup {

    private Die die1;
    private Die die2;

    DiceCupWithFakeDice(){
        this.die1 = new FakeDie();
        this.die2 = new FakeDie();
    }

}
