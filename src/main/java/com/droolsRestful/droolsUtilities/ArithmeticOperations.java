package com.droolsRestful.droolsUtilities;

/**
 * Created by Anoop on 07-03-2017.
 */
public class ArithmeticOperations {

    private Double num1;
    private Double num2;
    private String operationType;
    private double result;

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(final String operationType) {
        this.operationType = operationType;
    }

    public Double getNum1() {
        return num1;
    }

    public void setNum1(final Double num1) {
        this.num1 = num1;
    }

    public Double getNum2() {
        return num2;
    }

    public void setNum2(final Double num2) {
        this.num2 = num2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(final double result) {
        this.result = result;
    }
}
