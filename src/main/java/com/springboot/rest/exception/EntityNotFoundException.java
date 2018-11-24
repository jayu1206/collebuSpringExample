package com.springboot.rest.exception;

/**
 * @author Jay Gagnani
 * @since 2018-11-24
 */
public class EntityNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(Class<?> entityClass, Object id) {
		super(String.format("%s was not found for parameter %s", entityClass.getSimpleName(), id));
	}
}
