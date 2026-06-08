package LLD.easy.Calculator.factory;

import LLD.easy.Calculator.operation.*;

public class OperationsFactory {

    public static Operation getOperation(String operator){
        switch (operator){
            case "+":
                return new Addition();
            case  "-":
                return new Subtraction();
            case "*":
                return new Multiplication();
            case "/":
                return new Division();
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
