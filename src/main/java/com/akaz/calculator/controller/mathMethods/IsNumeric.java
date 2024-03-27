package com.akaz.calculator.controller.mathMethods;

public class IsNumeric {
    public Boolean isNumeric(String argument){
        if (argument == null){
            throw new NullPointerException();
        }

        String dotNumber = argument.replace(",", ".");

        return dotNumber.matches("[+-]?[0-9]*\\.?[0-9]+");
    }

}
