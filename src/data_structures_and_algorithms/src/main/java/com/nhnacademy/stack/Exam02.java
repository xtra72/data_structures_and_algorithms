package com.nhnacademy.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Exam02 {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                String input = in.nextLine();
                String[] tokens = input.split("\\s");
                for (String token : tokens) {
                    if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                        double y = Double.parseDouble(stack.pop());
                        double x = Double.parseDouble(stack.pop());
                        double z = 0;
                        switch (token) {
                            case "+":
                                z = x + y;
                                break;
                            case "-":
                                z = x - y;
                                break;
                            case "*":
                                z = x * y;
                                break;
                            case "/":
                                z = x / y;
                                break;
                        }
                        System.out.printf("\t%.2f %s %.2f = %.2f%n", x, token, y, z);
                        stack.push(String.valueOf(z));
                    } else if (token.equals("q") || token.equals("Q")) {
                        return;
                    } else {
                        stack.push(token);
                    }
                }
            }
        }
    }
}