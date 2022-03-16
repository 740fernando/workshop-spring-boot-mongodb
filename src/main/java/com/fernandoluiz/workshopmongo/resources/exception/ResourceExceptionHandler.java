package com.fernandoluiz.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fernandoluiz.workshopmongo.service.exception.ObjectNotFoundException;

/**
 * Classe responsavel por tratar as exceptions das requicisoes
 * 
 * Foi utilizado a anotacao ControllerAdvice :  
 * Especialização de @Component para classes que declaram métodos @ExceptionHandler, @InitBinder 
 * ou @ModelAttribute a serem compartilhados entre várias classes @Controller.
 * @author Fernando
 *
 */
@ControllerAdvice
public class ResourceExceptionHandler {

	/**
	 * Quando o erro foi propagado pela ObjectNotFoundException, no pacote de service,
	 * irá ser tratado neste método
	 * 
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(ObjectNotFoundException.class) // Identificador do Spring, significa que quando ocorrer a excecao ObjectNotFoundException, vai executar o metodo abaixo de tratamento
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(),status.value(),e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
