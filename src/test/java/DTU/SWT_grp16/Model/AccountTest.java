package DTU.SWT_grp16.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
private Account account = new Account();
    @Test
    void getBalance() {
        assertEquals(1000,account.getBalance());
    }

    @Test
    void changeBalance() {
        account.changeBalance(1000);
        assertEquals(2000,account.getBalance());
    }
}