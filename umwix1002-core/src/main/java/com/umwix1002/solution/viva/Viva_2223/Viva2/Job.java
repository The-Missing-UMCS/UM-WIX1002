package com.umwix1002.solution.viva.Viva_2223.Viva2;

public class Job {
	private final String JOB_NAME;
	private final int NUM_OF_TASK;
	private final int MEMORY;
	
	Job(String name, int num, int memory) {
		this.JOB_NAME = name;
		this.NUM_OF_TASK = num;
		this.MEMORY = memory;
	}
	
	public String getName() {
		return this.JOB_NAME;
	}
	
	public int getTaskNum() {
		return this.NUM_OF_TASK;
	}
	
	public int getMemory() {
		return this.MEMORY;
	}
	
	@Override
	public String toString() {
		return String.format("Job Name : %s Memory = %sGB Number of Task = %s", this.JOB_NAME, this.MEMORY, this.NUM_OF_TASK);
	}
}
