package com.credibanco.assessment.card.dto;

import com.credibanco.assessment.card.util.EstadoRespuesta;

public class RespuestaDTO<T> {

	private String codigoRespuesta;
	private String mensaje;
	private T resultado;

	public RespuestaDTO(EstadoRespuesta codigoRespuesta, Exception mensaje, T resultado) {
		this.codigoRespuesta = String.valueOf(codigoRespuesta.getCodigo());
		this.mensaje = mensaje.getMessage();
		this.resultado = resultado;
	}

	public RespuestaDTO(EstadoRespuesta status, T resultado) {
		this.codigoRespuesta = String.valueOf(status.getCodigo());
		this.mensaje = status.getDescripcion();
		this.resultado = resultado;
	}

	@SuppressWarnings("unchecked")
	public RespuestaDTO(EstadoRespuesta codigoRespuesta, Exception mensaje) {
		this.codigoRespuesta = String.valueOf(codigoRespuesta.getCodigo());
		this.mensaje = mensaje != null ? mensaje.getMessage() : codigoRespuesta.getDescripcion();
		this.resultado = (T) mensaje;
	}

	public RespuestaDTO(EstadoRespuesta codigoRespuesta) {
		this.codigoRespuesta = String.valueOf(codigoRespuesta.getCodigo());
		this.mensaje = codigoRespuesta.getDescripcion();
	}
	
	public RespuestaDTO(EstadoRespuesta codigoRespuesta, String mensaje) {
		this.codigoRespuesta = String.valueOf(codigoRespuesta.getCodigo());
		this.mensaje = mensaje;
	}

	public String getcodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setcodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getmensaje() {
		return mensaje;
	}

	public void setmensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public T getResultado() {
		return resultado;
	}

	public void setResultado(T resultado) {
		this.resultado = resultado;
	}
}
