package PastYear.PastYear2016.Semester1.Q5;

import java.util.List;

public abstract class CreditCard {
	protected static final String TYPE_CASH_REBATE = "Cash Rebate";
	protected static final String type_POINT_REWARD = "Point Reward";

	protected String name;
	protected String cardNo;
	protected String type;
	protected double totalCashReward;

	CreditCard(String name, String cardNo, String type) {
		this.name = name;
		this.cardNo = cardNo;
		this.type = type;
	}

	abstract void getReward(List<Purchase> purchaseList);

	public double getTotalCashReward() {
		return totalCashReward;
	}

	public String getType() {
		return type;
	}

	public String toString() {
		return String.format(
			"Credit Card: %s (%s)\n" +
			"Card Type: %s\n" +
			"Total Cash Reward: %s", 
			name, cardNo, type, formatCashReward(totalCashReward));
	}

	public static String formatCashReward(double value) {
        // Check if the value has only one non-zero decimal place
        if (Math.round(value * 10) / 10.0 == value) 
            return String.format("%.1f", value);
		
		String formatted = String.format("%.4f", value);
		
        // Remove trailing zeros if there are more than one decimal places
        if (formatted.indexOf(".") > 0) 
            return formatted.replaceAll("0+$", "").replaceAll("\\.$", "");

        return formatted;
    }
	
}
