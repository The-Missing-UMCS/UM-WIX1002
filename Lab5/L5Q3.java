package Lab5;

import java.util.stream.IntStream;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Questions:
 * Write a program that randomly generate the seven day work hours (1-8 hours) for N 
 * employee. Then, display the work hours in seven days and the total hours for each 
 * employee.
 */

public class L5Q3 {
	ArrayList<Employee> list = new ArrayList<Employee>();
	
	int counter = 0;
	JFrame frameWelcome, framePage;
	JPanel panelWelcome, panelPage, mainPanel;
	JTextField enterNumber;

	public static void main(String[] args) {
		Employee one = new Employee();
		one.getWorkingHours();
		// new L5Q3().run();
	}
	
	public void run() {
		// Page 1
		frameWelcome = new JFrame("Worker Generation");
		panelWelcome = new JPanel(new BorderLayout());
		
		Box enterBox = new Box(BoxLayout.Y_AXIS);
		
		JLabel valueGuidance = new JLabel("Enter the value of n: ");
		enterBox.add(valueGuidance);
		
		enterNumber = new JTextField();
		enterBox.add(enterNumber);
		
		JButton generateIt = new JButton("Generate It");
		generateIt.addActionListener(new MyGenerateItListener());
		panelWelcome.add(BorderLayout.CENTER, enterBox);
		panelWelcome.add(BorderLayout.SOUTH, generateIt);
		
		frameWelcome.getContentPane().add(panelWelcome);
		frameWelcome.setSize(400, 400);
		
		// Run
		frameWelcome.setVisible(true);
	}
	
	public void start() {
		Employee employee = list.get(counter);
		framePage = new JFrame("Report checking");
		GridLayout grid = new GridLayout(3, 2);
		panelPage = new JPanel(grid);
		mainPanel = new JPanel(new BorderLayout());
		
		JLabel userID = new JLabel("User ID: ");
		JTextField userIDDisplay = new JTextField(employee.getUserID());
		userIDDisplay.setEditable(false);
		
		JLabel workingHours = new JLabel("Working Hours: ");
		JTextField workingHoursDisplay = new JTextField(employee.getWorkingHours());
		workingHoursDisplay.setEditable(false);
		
		JLabel totalHours = new JLabel("Total hours: ");
		JTextField totalHoursDisplay = new JTextField(Integer.toString(employee.getTotalHours()));
		totalHoursDisplay.setEditable(false);
		
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		
		JButton previous = new JButton("Previous");
		previous.addActionListener(new MyPreviousListener());
		buttonBox.add(previous);
		
		JButton next = new JButton("Next");
		next.addActionListener(new MyNextListener());
		buttonBox.add(next);
		
		panelPage.add(userID); panelPage.add(userIDDisplay); 
		panelPage.add(workingHours); panelPage.add(workingHoursDisplay); 
		panelPage.add(totalHours); panelPage.add(totalHoursDisplay); 
		
		mainPanel.add(BorderLayout.CENTER, panelPage);
		mainPanel.add(BorderLayout.SOUTH, buttonBox);
		
		framePage.getContentPane().add(mainPanel);
		framePage.setSize(400, 400);
	}
	
	class MyGenerateItListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent a) {
			try {
				int n = Integer.parseInt(enterNumber.getText());
				for(int i = 0; i < n; i++) {
					list.add(new Employee());
				}
				frameWelcome.dispose();
				start();
				framePage.setVisible(true);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(
						frameWelcome, 
						"Please enter an integer in the text field", 
						"Alert",
						JOptionPane.WARNING_MESSAGE);
			}
			
		}
	}
	
	class MyNextListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent a) {
			if (counter < list.size() - 1) {
				counter++;
				framePage.dispose();
				start();
				framePage.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(
						frameWelcome, 
						"This is the last page!", 
						"Alert",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	class MyPreviousListener implements ActionListener {
		@Override	
		public void actionPerformed(ActionEvent a) {
			if (counter > 0) {
				counter--;
				framePage.dispose();
				start();
				framePage.setVisible(true);	
			} else {
				JOptionPane.showMessageDialog(
						frameWelcome, 
						"This is the last page!", 
						"Alert",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
}

class Employee {
	private int[] workingHours;
	private String userID;
	static long serialNumber = 10000;
	
	Employee() {
		this.getWorkingHours();
		this.userID = Long.toString(++serialNumber); // Increments the number and use the new one
	}
	
	public String getWorkingHours() {
		String str = "";
		workingHours = new Random().ints(7, 1, 8).toArray();		
		IntStream.of(workingHours).forEach(x -> System.out.print(x + " "));
		for(int n : workingHours) str += " " + n;
		return str;
		// IntStream.toArray() = https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#toArray--
		// Random().ints() = https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#ints--
	}
	
	public void printWorkingHours() {
		IntStream.of(workingHours).forEach(x -> System.out.printf(x + " "));
	}
	
	public int getTotalHours() {
		return IntStream.of(workingHours).sum();
	}
	
	public String getUserID() {
		return this.userID;
	}
	
}