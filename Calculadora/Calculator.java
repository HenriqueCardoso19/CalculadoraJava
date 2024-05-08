package Calculadora;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter:");
        System.out.println(" 1 - infix.");
        System.out.println(" 2 - postfix.");
        System.out.println(" 3 - prefix.");
        int choice = scanner.nextInt();

        ExpressionConverter converter = new ExpressionConverter();

        if (choice == 1) {
            System.out.print("Enter the infix expression: ");
            String infixExpression = scanner.next();
            String postfixExpression = converter.infixToPostfix(infixExpression);
            int infixResult = ExpressionEvaluator.evaluatePostfix(postfixExpression);
            System.out.println("Result: " + infixResult);
            System.out.println("Postfix expression: " + postfixExpression);;
            String prefixExpression = converter.infixToPrefix(infixExpression);
            System.out.println("Prefix expression: " + prefixExpression);
        } else if (choice == 2) {
            System.out.print("Enter the postfix expression: ");
            String postfixExpression = scanner.next();
            int postfixResult = ExpressionEvaluator.evaluatePostfix(postfixExpression);
            System.out.println("Result (postfix): " + postfixResult);
            String infixExpression = converter.postfixToInfix(postfixExpression);
            System.out.println("Infix expression: " + infixExpression);
            String prefixExpression = converter.infixToPrefix(infixExpression);
            System.out.println("Prefix expression: " + prefixExpression);
        } else if (choice == 3) {
            System.out.print("Enter the prefix expression: ");
            String prefixExpression = scanner.next();
            int prefixResult = ExpressionEvaluator.evaluatePrefix(prefixExpression);
            System.out.println("Result (prefix): " + prefixResult);
            String infixExpression = converter.prefixToInfix(prefixExpression);
            System.out.println("Infix expression: " + infixExpression);
            String postfixExpression = converter.infixToPostfix(infixExpression);
            System.out.println("Postfix expression: " + postfixExpression);
        }
    }
}
