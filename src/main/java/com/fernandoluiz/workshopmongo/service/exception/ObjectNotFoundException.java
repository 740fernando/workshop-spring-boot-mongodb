package com.fernandoluiz.workshopmongo.service.exception;

/**
 * Responsável por excecoes.
 * Por que usar o RunTime? As excecoes lancadas, nao serao obrigadas a ser tratadas. Foi
 * criado uma classe auxiliar no pacote resource.exception para tratar excecoes
 * 
 * @author Fernando
 *
 */
public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
