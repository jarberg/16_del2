package DTU.SWT_grp16.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
private Account account = new Account();
    @Test
    void getBalance() {
        //positiv test
        assertEquals(1000,account.getBalance());
        //negativ test
        assertNotEquals(0,account.getBalance());
    }

    @Test
    void changeBalance() {
        //positiv test
        account.changeBalance(1000);
        assertEquals(2000,account.getBalance());
        account.changeBalance(-3000);
        assertEquals(0,account.getBalance());

    }

}