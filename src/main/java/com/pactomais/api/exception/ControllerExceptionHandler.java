package com.pactomais.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pactomais.api.model.dto.ErroDTO;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity handlerException(Exception exception) {
		ErroDTO erroDto = new ErroDTO(exception.getMessage(), 400);
		return ResponseEntity.badRequest().body(erroDto);
	}

}
