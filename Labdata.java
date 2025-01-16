package com.mycompany.labdata;

import java.util.ArrayList;
import java.util.Stack;

public class Labdata {

    public static boolean isblanced(String a) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                s.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (s.isEmpty()) {
                    return false;
                }
                char ch = s.pop();
                if ((c == ')' && ch != '(') || (c == '}' && ch != '{') || (c == ']' && ch != '[')) {
                    return false;
                }

            }

        }
        return s.isEmpty();
    }

    static public class EvaluateRPN {

        public static double evaluateRPN(String expression) {

            String[] tokens = expression.split("\\s+");
            Stack<Double> stack = new Stack<>();

            for (String token : tokens) {
                if (isNumeric(token)) {
                    stack.push(Double.parseDouble(token));
                } else {

                    if (stack.size() < 2) {
                        throw new IllegalArgumentException("Invalid RPN expression: insufficient operands.");
                    }

                    double b = stack.pop();
                    double a = stack.pop();

                    switch (token) {
                        case "+":
                            stack.push(a + b);
                            break;
                        case "-":
                            stack.push(a - b);
                            break;
                        case "*":
                            stack.push(a * b);
                            break;
                        case "/":
                            if (b == 0) {
                                throw new ArithmeticException("Division by zero.");
                            }
                            stack.push(a / b);
                            break;
                        case "^":
                            stack.push(Math.pow(a, b));
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid operator: " + token);
                    }
                }
            }

            if (stack.size() != 1) {
                System.out.println("Invalid RPN expression: extra operands or operators.");
            }

            return stack.pop();
        }

        private static boolean isNumeric(String str) {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

    static public class InfixToPostfix {

        private static int precedence(char opretor) {
            switch (opretor) {
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                case '^':
                    return 3;
                default:
                    throw new AssertionError();
            }
        }

        private static boolean isOperator(char o) {
            return (o == '+' || o == '-' || o == '*' || o == '/' || o == '^');
        }

        public static String infixToPostfix(String infix) {
            Stack<Character> s = new Stack<>();
            String postfix = " ";
            for (int i = 0; i < infix.length(); i++) {
                char c = infix.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    postfix += c;
                } else if (c == '(') {
                    s.push(c);
                } else if (c == ')') {
                    while (!s.isEmpty() && s.peek() != '(') {
                        postfix += s.pop();
                    }
                    s.pop();
                } else if (isOperator(c)) {
                    while (!s.isEmpty() && precedence(s.peek()) >= precedence(c)) {
                        postfix += s.pop();
                    }
                    s.push(c);
                }
            }
            while (!s.isEmpty()) {
                postfix += s.pop();
            }
            return postfix;
        }
    }

    static public class Arraylistlab {

        public static <Integer> void swap(ArrayList<Integer> list, int i, int j) {
            if (i >= 0 && i < list.size() && j >= 0 && j < list.size()) {
                Integer temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        public static void reverse(ArrayList<Integer> list) {
            int n = list.size();
            for (int i = 0; i < n / 2; i++) {

                int temp = list.get(i);
                list.set(i, list.get(n - i - 1));
                list.set(n - i - 1, temp);
            }
        }

        public static void maregetwoarray(ArrayList<Integer> list1, ArrayList<Integer> list2) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < list1.size(); i++) {
                list.add(list1.get(i));
            }
            for (int i = 0; i < list2.size(); i++) {
                list.add(list2.get(i));
            }
            sort(list);
            System.out.println("the list after mareged : " + list);;

        }

        public static void sort(ArrayList<Integer> list) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(i) < list.get(j)) {
                        Integer temp = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, temp);

                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        System.out.println("EXERCISE 1");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Check  if  The  String  isblanced  or  not ");
        String examples1 = "{[]}";
        String examples2 = "{[(]";
        System.out.println(" The " + examples1 + " is " + isblanced(examples1));
        System.out.println(" The " + examples2 + " is " + isblanced(examples2));
        System.out.println("----------------------------------------------------------------");
        String expression = "3 4 + 2 * 7 /";
        double result = EvaluateRPN.evaluateRPN(expression);
        System.out.println("The result of the RPN expression \"" + expression + "\"" + "\nis: " + result);
        System.out.println("----------------------------------------------------------------");
        System.out.println("EXERCISE 2");
        String infixExpression = "1+3*6-7*9";
        System.out.println("in  infix: " + infixExpression);
        System.out.println("in  postfix: " + InfixToPostfix.infixToPostfix(infixExpression));
    }
}
