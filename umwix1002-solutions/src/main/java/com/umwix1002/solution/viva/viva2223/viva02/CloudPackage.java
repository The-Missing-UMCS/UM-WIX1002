package com.umwix1002.solution.viva.viva2223.viva02;

public class CloudPackage extends Cloud {
	private final int CORE_NUM;
	private final int MEMORY;
	private final double HOUR_PRICE;
	
	CloudPackage(String cloudPackage, int core, int memory, double price) {
		super(cloudPackage);
		this.CORE_NUM = core;
		this.MEMORY = memory;
		this.HOUR_PRICE = price;
	}
	
	public boolean check(Job job) {
		return this.MEMORY >= job.getMemory();
	}
	
	public void totalCost(Job job) {
		this.totalCost = (job.getTaskNum() / this.CORE_NUM) * this.HOUR_PRICE;
	}
}
