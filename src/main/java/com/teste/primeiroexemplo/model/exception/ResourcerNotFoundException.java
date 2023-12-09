package com.teste.primeiroexemplo.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.NOT_FOUND)
public class ResourcerNotFoundException extends RuntimeException{

    public ResourcerNotFoundException(String mensagem){
        super(mensagem);
    }
  
}
