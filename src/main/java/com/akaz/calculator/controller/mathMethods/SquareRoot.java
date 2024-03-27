package com.akaz.calculator.controller.mathMethods;

public class SquareRoot {
    public Double squareRoot(Double number, Double power){
        return Math.pow(number, 1.0 / power );
    }
}
