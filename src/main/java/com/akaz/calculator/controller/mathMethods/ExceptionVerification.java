package com.akaz.calculator.controller.mathMethods;

import com.akaz.calculator.exceptions.UnsurpportedMathOperationException;

public class ExceptionVerification {
    IsNumeric isNumeric = new IsNumeric();
    public boolean exceptionVerification(String num1, String num2){

        if (!isNumeric.isNumeric(num1) || !isNumeric.isNumeric(num2)){
            throw new UnsurpportedMathOperationException("Insira um valor numérico valido");
        }

        return true;
    }
}
