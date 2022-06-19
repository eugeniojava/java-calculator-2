package com.eugeniojava.web;

import com.eugeniojava.OperationUtil;
import com.eugeniojava.operation.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operations")
public class Controller {
    private static final String ADDITION_SYMBOL = "+";
    private static final String DIVISION_SYMBOL = "/";
    private static final String MULTIPLICATION_SYMBOL = "*";
    private static final String SUBTRACTION_SYMBOL = "-";

    @GetMapping("/addition/{a}/{b}")
    public Double doAddition(@PathVariable("a") Double a, @PathVariable("b") Double b) {
        return getCalculationResultOf(ADDITION_SYMBOL, a, b);
    }

    @GetMapping("/division/{a}/{b}")
    public Double doDivision(@PathVariable("a") Double a, @PathVariable("b") Double b) {
        return getCalculationResultOf(DIVISION_SYMBOL, a, b);
    }

    @GetMapping("/multiplication/{a}/{b}")
    public Double doMultiplication(@PathVariable("a") Double a, @PathVariable("b") Double b) {
        return getCalculationResultOf(MULTIPLICATION_SYMBOL, a, b);
    }

    @GetMapping("/subtraction/{a}/{b}")
    public Double doSubtraction(@PathVariable("a") Double a, @PathVariable("b") Double b) {
        return getCalculationResultOf(SUBTRACTION_SYMBOL, a, b);
    }

    private Double getCalculationResultOf(String operationSymbol, Double a, Double b) {
        Operation operation = OperationUtil.getOperations().get(operationSymbol);
        if (operation == null) {
            throw new IllegalArgumentException("Unknown operator: " + operationSymbol);
        }
        return operation.calculate(a, b);
    }
}
