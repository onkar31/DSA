package LLD.easy.Calculator;

import LLD.easy.Calculator.factory.OperationsFactory;
import LLD.easy.Calculator.operation.Operation;
import LLD.easy.Calculator.service.CalculatorService;

public class Main {
    public static void main(String[] args) {

        CalculatorService calculatorService = new CalculatorService();
        Operation operation = OperationsFactory.getOperation("+");

        double result = calculatorService.calculate(10, 20, operation);
        System.out.println(result);
    }
}
