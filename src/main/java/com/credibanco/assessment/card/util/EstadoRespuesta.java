package com.credibanco.assessment.card.util;

public enum EstadoRespuesta {

	EXITOSO("00", "Éxito"),
	
	FALLIDO("01", "Fallido"),
	
	NO_TARJETA("01","Tarjeta no existe"),
	
	NUMEROVAL_INVALIDO("02","Número de validación inválido"),
	
	NO_ANULA_TRANSACC("02","No se puede anular transacción"),
	
		
	/**
	 * {@code 10 Ok}.
	 */
	OK("200", "Ok"),

	/**
	 * {@code 500 Error en la solicitud}.
	 */
	ERROR_SOLICITUD_RESPUESTA("500", "Error en la solicitud"),

	/**
	 * {@code 90 No hay resultados}.
	 */
	NO_RESULTADOS("99", "No hay resultados");

	private final String codigo;

	private final String descripcion;

	EstadoRespuesta(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public String toString() {
		return this.codigo + " " + getDescripcion();
	}

}
