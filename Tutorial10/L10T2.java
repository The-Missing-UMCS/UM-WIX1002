package Tutorial10;

public class L10T2 {
	public static void main(String[] args) {
		System.out.println("Saving Account = " + new SavingAccount(1000).computeInterest());
		System.out.println("Fixed Account = " + new FixedAccount(1000).computeInterest());
	}
}

interface Interest {
	double computeInterest();
}

abstract class Account implements Interest {
	protected double balance;
	protected final double INTERST_RATE;
	
	Account(int balance, double interestRate) {
		this.balance = balance;
		this.INTERST_RATE = interestRate;
	}
	
	@Override
	public double computeInterest() {
		return (this.balance * this.INTERST_RATE / 12);
	}
}

class SavingAccount extends Account implements Interest {
	SavingAccount(int balance) {
		super(balance, (0.5 / 100));
	}
}

class FixedAccount extends Account implements Interest {
	FixedAccount(int balance){
		super(balance, (3 / (double) 100));
	}
}