package DTU.SWT_grp16.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerlistTest {

    String player1 ="bob";
    String player2 = "ida";
    Playerlist playerList = new Playerlist(player1, player2);

    @Test
    void getCurrentPlayer() {
        //positiv test
        assertEquals(player1, playerList.getCurrentPlayer().getName());
        //negativ test
        assertNotEquals(player2, playerList.getCurrentPlayer().getName());
    }

    @Test
    void changePlayerTurn() {
        //positiv unit test
        assertEquals(player1, playerList.getCurrentPlayer().getName());
        playerList.changePlayerTurn();
        assertEquals(player2, playerList.getCurrentPlayer().getName());
        playerList.changePlayerTurn();
        assertEquals(player1, playerList.getCurrentPlayer().getName());
        playerList.changePlayerTurn();
        assertEquals(player2, playerList.getCurrentPlayer().getName());
        playerList.changePlayerTurn();
        assertEquals(player1, playerList.getCurrentPlayer().getName());

        //negativ unit test
        assertNotEquals(player2, playerList.getCurrentPlayer().getName());
        playerList.changePlayerTurn();
        assertNotEquals(player1, playerList.getCurrentPlayer().getName());
        playerList.changePlayerTurn();
        assertNotEquals(player2, playerList.getCurrentPlayer().getName());
        playerList.changePlayerTurn();
        assertNotEquals(player1, playerList.getCurrentPlayer().getName());
        playerList.changePlayerTurn();
        assertNotEquals(player2, playerList.getCurrentPlayer().getName());
    }
}