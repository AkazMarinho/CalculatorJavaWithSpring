package com.akaz.calculator.exceptions;

//cria uma classe que extende o runtimException, de forma que agora essa classe pode acessar metodos desse objeto
public class UnsurpportedMathOperationException extends RuntimeException{

    // cria um construtor que aceita uma mensagem;
    // Essa classe so será chamada quando ocorrer um problema com relação a uma operação da calculadora,
    // ou seja, quando ocorrer uma excessão, e será enviado uma mensagem personalizada atraves do construtor,
    // que será inserida quando a classe for chamada;
    public UnsurpportedMathOperationException(String message){
        // a mensagem irá sobrescrever a mensagem padrão da excessão atraves do metodo super() de herança
        // que será recolhida quando para ser enviada via http;
        super(message);
    }
}
