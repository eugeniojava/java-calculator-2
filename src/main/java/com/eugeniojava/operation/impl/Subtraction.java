package com.eugeniojava.operation.impl;

import com.eugeniojava.Symbol;
import com.eugeniojava.operation.Operation;

@Symbol("-")
public class Subtraction implements Operation {
    @Override
    public double calculate(double number1, double number2) {
        return number1 - number2;
    }
}
