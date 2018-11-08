package DTU.SWT_grp16.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerlistTest {

    String player1 ="bob";
    String player2 = "ida";
    Playerlist playerList;
    FakePlayerList PlayerList = new FakePlayerList(player1, player2);

    @Test
    void getCurrentPlayer() {
        assertEquals(player1, PlayerList.getCurrentPlayer().getName());
    }

    @Test
    void changePlayerTurn() {
        assertEquals(player1, PlayerList.getCurrentPlayer().getName());
        PlayerList.changePlayerTurn();
        assertEquals(player2, PlayerList.getCurrentPlayer().getName());
        PlayerList.changePlayerTurn();
        assertEquals(player1, PlayerList.getCurrentPlayer().getName());
        PlayerList.changePlayerTurn();
        assertEquals(player2, PlayerList.getCurrentPlayer().getName());
        PlayerList.changePlayerTurn();
        assertEquals(player1, PlayerList.getCurrentPlayer().getName());
    }
}