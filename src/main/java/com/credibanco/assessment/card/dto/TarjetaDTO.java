package com.credibanco.assessment.card.dto;

import java.util.Date;

public class TarjetaDTO {

	private Long id;

	private Integer numValidacion;

	private String estado;

	private Long pan;
	
	private String panMask;

	private Integer idTitular;

	private Integer idTipo;

	private Date fechaCreacion;

	private Date fechaVencimiento;

	private TipoDTO tipoDTO;

	private TitularDTO titularDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumValidacion() {
		return numValidacion;
	}

	public void setNumValidacion(Integer numValidacion) {
		this.numValidacion = numValidacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getPan() {
		return pan;
	}

	public void setPan(Long pan) {
		this.pan = pan;
	}

	public Integer getIdTitular() {
		return idTitular;
	}

	public void setIdTitular(Integer idTitular) {
		this.idTitular = idTitular;
	}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public TipoDTO getTipoDTO() {
		return tipoDTO;
	}

	public void setTipoDTO(TipoDTO tipoDTO) {
		this.tipoDTO = tipoDTO;
	}

	public TitularDTO getTitularDTO() {
		return titularDTO;
	}

	public void setTitularDTO(TitularDTO titularDTO) {
		this.titularDTO = titularDTO;
	}

	public String getPanMask() {
		return panMask;
	}

	public void setPanMask(String panMask) {
		this.panMask = panMask;
	}

}
