package com.umwix1002.solution.lab.lab8.l8q2;

import com.umwix1002.solution.lab.constants.CommonConstant;
import com.umwix1002.solution.lab.util.AssertUtil;
import lombok.*;

/**
 * @author Ng Zhi Yang
 */
@Data
@ToString(exclude = {"ic", "passport"})
public class BankAccount {
    private String name;
    private String ic;
    private String passport;
    
    @Setter(AccessLevel.NONE)
    private double balance;

    public void deposit(int amount) {
        AssertUtil.assertNonNegative(amount, "Amount must be positive");
        balance += amount;
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
    }
}
