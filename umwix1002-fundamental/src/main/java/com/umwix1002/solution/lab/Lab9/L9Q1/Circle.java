package com.umwix1002.solution.lab.Lab9.L9Q1;

public class Circle extends Shape {
	private double diameter;

	Circle(double diameter) {
		super("Circle");
		this.diameter = diameter;
	}

	@Override
	public void computeAreaAndPerimeter() {
		this.area = (Math.PI * diameter * diameter) / 4;
		this.perimeter = Math.PI * diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
}
