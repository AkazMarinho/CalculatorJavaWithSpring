package com.akaz.calculator.exceptions.handler;

import com.akaz.calculator.exceptions.ExceptionTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

// calsse reponsavel manipular a ResponseEntity para mostrar excessoes personalizadas para diferentes problemas que podem ocorrer
// nas requisições HTTP;
// a classe ResponseEntityExceptionHandler é utilizada para criar manipuladores de excessoes personalizados que irão agir de
// diferentes maneiras de acordo com cada excessoes lancada em requisições HTTP;

// RestControllerAdvice - cria uma flag onde o spring identifica o tratamento de erros
// RestController - indica que a classe poderá lidar com requisições HTTP, e que os dados retornados podem ser serialziados
@RestControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // a anotação ExceptionHandler define qual o tipo de excessão será tratada no metodos
    // o metodo abaixo irá lidar com o modelo mais generico de excessões, gerando uma resposta HTTP de Internal server error;
    // reposnse entity é responsavel por gerar toda a resposta HTTP de uma requisição, como cabeçalho, corpo e codigos HTTP
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionTemplate> handlerAllExceptions(

            // irá armazenar os dados da excessão, essa excessão será resgatado do spring atraves da
            // anotação @RestControllerAdvice
            Exception exception,

            //resgata informções sobre a requisição HTTP como a rota e o cliente
            WebRequest request
    ){
        ExceptionTemplate exceptionTemplate = new ExceptionTemplate(

                //cria um objeto data com informações de quando ocorreu a excessão;
                new Date(),

                // recolhe a mensagem da excessão
                exception.getMessage(),

                //recolhe os dados da requisição http, nesse caso so será mostrado a rota, e false para os dados do ip do cliente
                request.getDescription(false)
        );

            // Será retornado um ResponseEntity do tipo ExceptionTemplate com a data de acorrencia, a mensagem e os
            // detalhes da requisção HTTP, e tambem um httpStatus que deifne o codigo da requisição, no exemplo INTERNAL_SERVER_ERROR, retorna 500
        return new ResponseEntity<>(exceptionTemplate, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    // o metodo abaixo irá lidar com o excessões do tipo runtimeException, gerando uma resposta HTTP de Internal server error;
   @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionTemplate> handlerRumtimeExceptions (
            Exception exception,
            WebRequest request
   ){
        ExceptionTemplate exceptionTemplate = new ExceptionTemplate(
                new Date(),
                exception.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(exceptionTemplate, HttpStatus.BAD_REQUEST);
   }

    // o metodo abaixo irá lidar com o excessões do tipo nullPointerException, gerando uma resposta HTTP de Internal server error;
//   @ExceptionHandler(NullPointerException.class)
//   public ResponseEntity<ExceptionTemplate> handlerNullPointerExceptions(
//           Exception exception,
//           WebRequest request
//   ){
//        ExceptionTemplate exceptionTemplate = new ExceptionTemplate(
//                new Date(),
//                exception.getMessage(),
//                request.getDescription(false)
//        );
//
//        return new ResponseEntity<>(exceptionTemplate, HttpStatus.BAD_REQUEST)
//   }


}
