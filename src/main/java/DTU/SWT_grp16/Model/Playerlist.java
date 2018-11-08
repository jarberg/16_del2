package DTU.SWT_grp16.Model;

import java.util.ArrayDeque;

public class Playerlist {

    private ArrayDeque<Player> playerList;

    public Playerlist(Player... players){
        playerList = new ArrayDeque<>();
        addPlayers(players);
    }

    private void addPlayers(Player... players){
        for(Player player : players){
            playerList.addLast(player);
        }
    }

    public Player getCurrentPlayer(){
        return playerList.getFirst();
    }

    public void changePlayerTurn(){
        Player currentPlayer = getCurrentPlayer();
        boolean playerHasBonusTurn = currentPlayer.hasBonusTurn();

        if(playerHasBonusTurn){
            currentPlayer.setBonusTurn(false);
            return;
        }

        // need to add descriptive names, sorry.
        // this line below takes the first player in the queue and puts him in the back of the queue.
        playerList.addLast(playerList.pollFirst());
    }


}
