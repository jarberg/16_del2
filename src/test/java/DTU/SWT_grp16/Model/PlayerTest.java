package DTU.SWT_grp16.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
Player player = new Player("bob");
    @Test
    void getName() {
        assertEquals("bob",player.getName());
    }

    @Test
    void addToBalance() {
        player.addToBalance(500);
        assertEquals(1500, player.getBalance());
    }
    @Test

    void getBalance() {
        assertEquals(1000,player.getBalance());
    }

    @Test
    void setBonusTurn() {
    }

    @Test
    void hasBonusTurn() {
        player.setBonusTurn(true);
        assertEquals(true, player.hasBonusTurn());
    }

    @Test
    void isWinner() {
        assertEquals(false, player.isWinner());
    }

    @Test
    void setWinner() {
        player.setWinner(true);
        assertEquals(true, player.isWinner());
    }
}