package com.akaz.calculator.exceptions;

import java.io.Serializable;
import java.util.Date;

// essa classe será um template do que deve ser mostrado em tela quando ocorrer um erro, ela irá implementar o serializable
// para qua possa ser convertida em bitys e ser enviada atraves de uma requisiçção http;
public class ExceptionTemplate implements Serializable {
    // especifica a versão da serialziação
    private static final long serialVersionUID = 1;

    // variavel do tipo Data reposnsavel por recolher informações de quando ocorreu a excessão;
    private Date timestamp;

    // variavel responsavel por armazenar a mensagem peronalizada
    private String message;

    // variavel responsavel por armazenar informações sobre os detalhes da requisição HTTP;
    private String details;

    // criaçãoo de um construtor contendo os valores necessarios para serrem serializados
    public ExceptionTemplate(Date timestamp, String message, String details){
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }


    //getters para retornar os valores de campos privados
    public Date getTimestamp(){
        return timestamp;
    }

    public String getMessage(){
        return message;
    }

    public String getDetails(){
        return details;
    }


}
