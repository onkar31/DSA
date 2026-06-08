package LLD.easy.Calculator.service;

import LLD.easy.Calculator.operation.Operation;

public class CalculatorService {
    public double calculate(double num1, double num2, Operation operation){
        return operation.execute(num1, num2);
    }
}
