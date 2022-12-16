package com.fyiernzy.Lab9;

public class L9Q1 {
	public static void main(String[] args) {
		Shape[] shapes = new Shape[3];
		shapes[0] = new Rectangle(4, 5);
		shapes[1] = new Square(7);
		shapes[2] = new Circle(14);
		
		for(int i = 0; i < shapes.length; i++) {
			shapes[i].computeAreaAndPerimeter();
			shapes[i].showDetails();
			System.out.println("");
		}
	}
}

abstract class Shape {
	protected final String NAME;
	protected double perimeter;
	protected double area;
	
	Shape(String name) {
		this.NAME = name;
	}
	public void showDetails() {
		System.out.printf("%-10s: Perimeter = %-7.2f, Area = %-7.2f", this.NAME, this.perimeter, this.area);
	}
	
	abstract void computeAreaAndPerimeter();
}

class Rectangle extends Shape {
	private double length;
	private double height;
	
	Rectangle(double length, double height) {
		super("Rectangle");
		this.length = length;
		this.height = height;
	}
	
	@Override
	public void computeAreaAndPerimeter() {
		this.area = length * height;
		this.perimeter = 2 * (length + height);
	}
	
	public void setLengthAndHeight(double length, double height) {
		this.length = length;
		this.height = height;
	}
}

class Square extends Shape {
	private double side;
	
	Square(double side) {
		super("Square");
		this.side = side;
	}
	
	@Override
	public void computeAreaAndPerimeter() {
		this.area = side * 2;
		this.perimeter = 4 * side;
	}
	
	public void setSide(double side) {
		this.side = side;
	}
}

class Circle extends Shape {
	private double diameter;
	
	Circle(double diameter) {
		super("Circle");
		this.diameter = diameter;
	}
	
	@Override
	public void computeAreaAndPerimeter() {
		this.area = (Math.PI * diameter * diameter)/ 4;
		this.perimeter = Math.PI * diameter;
	}
	
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
}