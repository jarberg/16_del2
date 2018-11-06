package DTU.SWT_grp16.Model;

public class Player {
    private String name;
    private Account account;
    private boolean winner;
    private boolean bonusTurn;


    public Player(String name){
        this.name = name;
        this.account = new Account();

    }

    public String getName() {
        return name;
    }

    public int getBalance(){
        return account.getBalance();
    }

    public void addToBalance(int amount){
        account.changeBalance(amount);
    }

    public boolean hasBonusTurn(){
        return bonusTurn;
    }

    public boolean isWinner(){
        return winner;
    }

    public void setWinner(boolean a){
        this.winner = a;
    }

    public void setBonusTurn(boolean b){
        this.bonusTurn = b;
    }
}
