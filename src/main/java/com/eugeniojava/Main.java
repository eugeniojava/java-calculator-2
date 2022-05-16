package com.eugeniojava;

import com.eugeniojava.operation.Operation;

public class Main {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[2]);
        char operationSymbol = args[1].charAt(0);
        Operation operation = OperationUtil.getOperations().get(String.valueOf(operationSymbol));
        if (operation == null) {
            throw new IllegalArgumentException("Unknown operator: " + operationSymbol);
        }
        System.out.println(operation.calculate(a, b));
    }
}
