package lab8.l8q2;

import com.umwix1002.solution.lab.lab8.l8q2.BankAccount;
import com.umwix1002.solution.lab.lab8.l8q2.InsufficientBalanceException;
import com.umwix1002.solution.lab.util.exception.NegativeValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
        bankAccount = new BankAccount();
    }

    @Test
    public void testDepositPositiveAmount() {
        bankAccount.deposit(100);
        assertEquals(100.0, bankAccount.getBalance(), 0.001);
    }

    @Test
    public void testDepositZeroAmount() {
        assertThatThrownBy(() -> bankAccount.deposit(-1))
            .rootCause()
            .isInstanceOf(NegativeValueException.class)
            .hasMessage("Amount must be positive");
    }

    @Test
    public void testDepositNegativeAmount() {
        assertThatThrownBy(() -> bankAccount.deposit(-50))
            .rootCause()
            .isInstanceOf(NegativeValueException.class)
            .hasMessage("Amount must be positive");
    }

    @Test
    public void testWithdrawValidAmount() {
        bankAccount.deposit(200);
        bankAccount.withdraw(100);
        assertEquals(100.0, bankAccount.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        bankAccount.deposit(50);
        assertThatThrownBy(() -> bankAccount.withdraw(100))
            .isInstanceOf(InsufficientBalanceException.class)
            .hasMessage("Insufficient balance");
    }

    @Test
    public void testWithdrawExactBalance() {
        bankAccount.deposit(100);
        bankAccount.withdraw(100);
        assertEquals(0.0, bankAccount.getBalance(), 0.001);
    }
}