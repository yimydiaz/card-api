package com.credibanco.assessment.card.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CODIGOS_RESPUESTA", schema = "HR")
public class CodigoRespuesta implements Serializable {
	/**
	 *   
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_codigo") 
	private Long id;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "mensaje")
	private String mensaje;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}	
		    	   
}
