package com.interview.arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author json.yang
 * @Description 后缀表达式(逆波兰表达式(rpn))
 * @Date 2020-06-28
 */
public class PolandNotation {

    public static void main(String[] args) {
        List<String> infixExpression = toInfixExpressionList("1+((2+3)*4)-5");
        System.out.println(infixExpression);
        List<String> parseSuffixExpression = parseSuffixExpression(infixExpression);
        System.out.println(parseSuffixExpression);

//        String rpnExpression = "4 5 * 8 - 60 + 8 2 / +";
//        List<String> expressionList = getExpressionList(rpnExpression);
        int result = calculator(parseSuffixExpression);
        System.out.println("计算结果: " + result);
    }

    public static List<String> parseSuffixExpression(List<String> infixExpression) {
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();

        for (String item:infixExpression) {
            if(item.matches("\\d+")) {
                s2.add(item);
            } else if(item.equals("(")) {
                s1.add(item);
            } else if(item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                if(s1.empty()) {
                    s1.push(item);
                } else {
                    while(s1.size() != 0 && priority(item.charAt(0)) <= priority(s1.peek().charAt(0))) {
                        s2.add(s1.pop());
                    }
                    s1.push(item);
                }
            }
        }

        while(s1.size() != 0) {
            s2.add(s1.pop());
        }

        return s2;
    }

    public static List<String> toInfixExpressionList(String expression) {
        List<String> result = new ArrayList<>();
        char[] chars = expression.toCharArray();
        String keeperNum = "";

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] < 48 || chars[i] > 57) {
                result.add(chars[i] + "");
            } else {
                keeperNum += chars[i];
                if(i == chars.length - 1) {
                    result.add(keeperNum);
                } else {
                    if(chars[i + 1] < 48 || chars[i + 1] > 57) {
                        result.add(keeperNum);
                        keeperNum = "";
                    }
                }
            }
        }

        return result;
    }

    public static int priority(char operation) {
        if(operation == '*' || operation == '/') {
            return 1;
        } else if(operation == '+' || operation == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public static boolean isOperation(char symbol) {
        return symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/';
    }

    public static List<String> getExpressionList(String expression) {
        String[] split = expression.split(" ");
        List<String> result = new ArrayList<>();

        for (String item:split) {
            result.add(item);
        }

        return result;
    }

    public static int calculator(List<String> expression) {
        int result = 0;
        Stack<String> stack = new Stack<>();

        for (String item:expression) {
            // 正则判断是否为连续的数字
            if(item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());

                switch (item) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                    default:
                        break;
                }

                stack.push("" + result);
            }
        }

        return Integer.parseInt(stack.pop());
    }

}