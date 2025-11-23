package com.umwix1002.solution.tutorial.Tutorial9;

public class T9Q3 {
	
}

class PaySystem {
	protected double payRate;
	protected double hourCount;
	
	PaySystem(double rate, double hour) {
		this.payRate = rate;
		this.hourCount = hour;
	}
	
	public double getToTalPay() {
		return this.payRate * this.hourCount;
	}
}

class RegularPay extends PaySystem {
	RegularPay(double rate, double hour) {
		super(rate, hour);
	}
}

class SpecialPay extends PaySystem {
	SpecialPay(double rate, double hour) {
		super(rate, hour);
	}
	
	@Override
	public double getToTalPay() {
		return this.payRate * this.hourCount * 1.3;
	}
}
