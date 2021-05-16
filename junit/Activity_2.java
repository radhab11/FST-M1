package activities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import mainPrograms.BankAccount;
import mainPrograms.NotEnoughFundsException;
public class Activity_2 {

    @Test
    void notEnoughFunds() {
        BankAccount account = new BankAccount(9);

        assertThrows(NotEnoughFundsException.class, () -> account.withdraw(10),
                "Balance must be greater than amount of withdrawal");
    }

    @Test
    void enoughFunds() {
        BankAccount account = new BankAccount(100);
        assertDoesNotThrow(() -> account.withdraw(100));
    }
}