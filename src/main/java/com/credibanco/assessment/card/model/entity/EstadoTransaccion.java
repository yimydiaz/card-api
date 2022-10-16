package com.credibanco.assessment.card.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADO_TRANSACCION", schema = "HR")
public class EstadoTransaccion implements Serializable {
	/**
	 *   
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_estado_transaccion") 
	private Long id;
	
	@Column(name = "estado")
	private String estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
