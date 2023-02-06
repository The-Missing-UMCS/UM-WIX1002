package PastYear2020.Q5;

public class Cloud {
	protected final String CLOUD_PACKAGE;
	protected double totalCost;
	
	Cloud(String cloudPackage) {
		this.CLOUD_PACKAGE = cloudPackage;
	}
	
	public double getTotalCost() {
		return this.totalCost;
	}
	
	@Override
	public String toString() {
		return String.format("Cloud Package : %s  Total Cost= %.2f", this.CLOUD_PACKAGE, this.getTotalCost());
	}
}
