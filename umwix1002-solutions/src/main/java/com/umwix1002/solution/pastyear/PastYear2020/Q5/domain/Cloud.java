package com.umwix1002.solution.pastyear.PastYear2020.Q5.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Cloud {
	private final String cloudPackage;

	@Setter
	private double totalCost;

	public Cloud(String cloudPackage) {
		this.cloudPackage = cloudPackage;
	}

	public double calculateTotalCost() {
		return this.totalCost;
	}
}
