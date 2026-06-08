package LLD.easy.Calculator.operation;

public class Division implements Operation{

    @Override
    public double execute(double num1, double num2) {
        if(num2 == 0){
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    }
}
