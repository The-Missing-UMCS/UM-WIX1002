package com.umwix1002.solution.lab.lab3.l3q1.advanced;

import com.umwix1002.solution.lab.lab3.l3q1.advanced.strategy.Operation;
import com.umwix1002.solution.lab.lab3.l3q1.advanced.strategy.OperationEnum;
import com.umwix1002.solution.lab.lab3.l3q1.advanced.strategy.OperationFactory;

import java.util.Scanner;

/**
 * @author Ng Zhi Yang
 */
public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter two operands : ");
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            System.out.print("Enter the operator : ");
            char operator = scanner.next().charAt(0);
            OperationEnum operationEnum = OperationEnum.getByCode(operator);
            Operation operation = OperationFactory.getOperation(operationEnum);
            System.out.printf("%d %c %d = %d", num1, operator, num2, operation.execute(num1, num2));
        }
    }
}
