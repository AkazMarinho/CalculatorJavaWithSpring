package com.akaz.calculator.controller;

import com.akaz.calculator.controller.mathMethods.ConvertToDouble;
import com.akaz.calculator.controller.mathMethods.ExceptionVerification;
import com.akaz.calculator.controller.mathMethods.IsNumeric;
import com.akaz.calculator.controller.mathMethods.SquareRoot;
import com.akaz.calculator.exceptions.UnsurpportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// marca uma classe como aplicação restful
@RestController
public class CalculatorController {

    ConvertToDouble convertToDouble = new ConvertToDouble();
    ExceptionVerification exceptionVerification = new ExceptionVerification();

    // cria uma requisição do tipo get, onde define tambem o caminho e variávies do tipo "path values"
    @GetMapping(value = "/sum/{n1}/{n2}")
    public Double sum(
            // recolhe os valores repassados na url e insere nas variaveis respectivas
            @PathVariable(value = "n1") String num1,
            @PathVariable(value = "n2") String num2
    ){
        // verificação para saber se os valores retornados pela URL são validos como numeros
//        if(!isNumeric.isNumeric(num1) || !isNumeric.isNumeric(num2)){
//            // caso alguns dos valores não seja um valor numerico valido, será lançado uma "excessão"
//            throw new UnsurpportedMathOperationException("Insira um valor numerico valido");
//        }
        exceptionVerification.exceptionVerification(num1, num2);

        return convertToDouble.convertToDouble(num1) + convertToDouble.convertToDouble(num2);
    }

    @GetMapping(value = "/subtraction/{n1}/{n2}")
    public Double subtraction(
            @PathVariable(value = "n1") String num1,
            @PathVariable(value = "n2") String num2
    ){
        exceptionVerification.exceptionVerification(num1, num2);

        return convertToDouble.convertToDouble(num1) - convertToDouble.convertToDouble(num2);
    }

    @GetMapping(value = "/multiplication/{n1}/{n2}")
    public Double multiplication(
            @PathVariable(value = "n1") String num1,
            @PathVariable(value = "n2") String num2
    ){
        exceptionVerification.exceptionVerification(num1, num2);

        return convertToDouble.convertToDouble(num1) * convertToDouble.convertToDouble(num2);
    }

    @GetMapping(value = "/division/{n1}/{n2}")
    public Double division(
            @PathVariable(value = "n1") String num1,
            @PathVariable(value = "n2") String num2
    ){
        exceptionVerification.exceptionVerification(num1, num2);

        return convertToDouble.convertToDouble(num1) / convertToDouble.convertToDouble(num2);
    }

    @GetMapping(value = "/mean/{n1}/{n2}")
    public Double mean(
            @PathVariable(value = "n1") String num1,
            @PathVariable(value = "n2") String num2
    ){
        exceptionVerification.exceptionVerification(num1, num2);

        return (convertToDouble.convertToDouble(num1) + convertToDouble.convertToDouble(num2))/2;
    }

    @GetMapping(value = "/sqrt/{number}/{power}")
    public Double squareRoot(
            @PathVariable(value = "number") String number,
            @PathVariable(value = "power") String power
    ){
        exceptionVerification.exceptionVerification(number, power);


        double numberConverted = convertToDouble.convertToDouble(number);
        double powerConverted = convertToDouble.convertToDouble(power);

        SquareRoot squareRoot = new SquareRoot();

        return squareRoot.squareRoot(numberConverted, powerConverted);
    }
    // função para tranformar os valores recebidos como "strings" da url em "double" e
    // poder ser realizado operações matematicas

    /*
    private Double parseToDoule(String strValue){
        // será realizado a tranforamção de uma valor "string" para um valor "double"
        return Double.parseDouble(strValue);
    }



    // função para verificar se o valor numerico repassado na "string" é realmente um valor valido, onde retornará um "boolean"
    private Boolean isNumeric(String number){
        // se o valor for nulo, ele retornará um "false"
        if(number == null){
            return false;
        }
        // se não for nulo, irá chamar a função replaceValues para substituir eventuais "," por "." e o valor será armazenado na
        // variavel "numberChange"
        String numberChange = replaceValues(number);

        //retorna valores que estejam inseridos no "regex" definido
        return numberChange.matches("[+-]?[0-9]*\\.?[0-9]+");
    }

    // realiza a troca de possiveis "," por ".", para se adequar ao sistema internacional, e retornará a alteração
    private String replaceValues(String value){
        return value.replace(",", ".");
    }

    */
}
