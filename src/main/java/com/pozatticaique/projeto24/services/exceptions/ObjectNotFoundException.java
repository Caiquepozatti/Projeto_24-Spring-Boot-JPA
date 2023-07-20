package com.pozatticaique.projeto24.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(Object id) {
		super("Resource not found: " + id);
	}
}
