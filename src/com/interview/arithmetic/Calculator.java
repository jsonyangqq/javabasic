package com.interview.arithmetic;

import java.util.Stack;

/**
 * @author json.yang
 * @Description 计算运算符 (中缀波兰表达式)
 * @Date 2020-06-28
 */
public class Calculator {

    public static void main(String[] args) {
        String calculator = "7*2/2-5+1-5+30-4";
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Character> operationStack = new Stack<Character>();

        char[] chars = calculator.toCharArray();
        Integer num1;
        Integer num2;
        char operation;
        String keeperNum = "";

        for (int i = 0; i < chars.length; i++) {
            if(isOperation(chars[i])) {
                if(operationStack.empty()) {
                    operationStack.push(chars[i]);
                } else {
                    if(priority(chars[i]) > priority(operationStack.peek())) {
                        operationStack.push(chars[i]);
                    } else {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operation = operationStack.pop();
                        int result = calculator(num1, num2, operation);
                        numStack.push(result);
                        operationStack.push(chars[i]);
                    }
                }
            } else {
                // char 转int 的时候 依照ASCIL表 需要加 -48
//                numStack.push(Integer.parseInt(chars[i] + ""));

                keeperNum += chars[i];
                if(i == chars.length - 1) {
                    numStack.push(Integer.parseInt(keeperNum));
                } else {
                    if(isOperation(chars[i + 1])) {
                        numStack.push(Integer.parseInt(keeperNum));
                        keeperNum = "";
                    }
                }
            }
        }

        while(!operationStack.empty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            operation = operationStack.pop();
            int result = calculator(num1, num2, operation);
            numStack.push(result);
        }

        int result = numStack.pop();
        System.out.println("最后结果: " + result);
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

    public static int calculator(int num1, int num2, char operation) {
        int result = 0;

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }

    public static boolean isOperation(char symbol) {
        return symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/';
    }

}