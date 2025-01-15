package com.umwix1002.solution.pastyear.PastYear2020.Q2.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Position {
	protected char direction;
	protected int degree;
	protected int minute;
	protected int second;
	
	public double getValue() {
		int flag = isPositiveDirection() ? 1 : -1;
		return flag * (degree + (minute * 60 + second) / (double) 3600);
	}

	protected abstract boolean isPositiveDirection();
}
