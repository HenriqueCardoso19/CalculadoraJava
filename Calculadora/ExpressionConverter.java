package Calculadora;
import java.util.Stack;

public class ExpressionConverter {
    public String infixToPostfix(String infix) {
        infix = infix.replaceAll("\\s+", "");
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    public String infixToPrefix(String infix) {
        StringBuilder prefix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = infix.length() - 1; i >= 0; i--) {
            char c = infix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                prefix.insert(0, c);
            } else if (c == ')') {
                stack.push(c);
            } else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    prefix.insert(0, stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) < precedence(stack.peek())) {
                    prefix.insert(0, stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            prefix.insert(0, stack.pop());
        }
        return prefix.toString();
    }

    public String postfixToInfix(String postfix) {
        Stack<String> stack = new Stack<>();
        for (char c : postfix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                stack.push("(" + operand1 + c + operand2 + ")");
            }
        }
        return stack.pop();
    }

    public String prefixToInfix(String prefix) {
        Stack<String> stack = new Stack<>();
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                stack.push("(" + operand1 + c + operand2 + ")");
            }
        }
        return stack.pop();
    }

    private int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
}
