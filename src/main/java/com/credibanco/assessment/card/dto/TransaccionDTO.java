package com.credibanco.assessment.card.dto;

import java.util.Date;

public class TransaccionDTO {

	private Long id;

	private Integer idTarjeta;

	private Integer numeroReferencia;

	private Integer totalCompra;

	private String direccionCompra;

	private Date fechaTransaccion;

	private Integer idEstadoTransaccion;

	private TarjetaDTO tarjetaDTO;

	private EstadoTransaccionDTO estadoTransaccionDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(Integer idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public Integer getNumeroReferencia() {
		return numeroReferencia;
	}

	public void setNumeroReferencia(Integer numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}

	public Integer getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(Integer totalCompra) {
		this.totalCompra = totalCompra;
	}

	public String getDireccionCompra() {
		return direccionCompra;
	}

	public void setDireccionCompra(String direccionCompra) {
		this.direccionCompra = direccionCompra;
	}

	public Date getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(Date fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public Integer getIdEstadoTransaccion() {
		return idEstadoTransaccion;
	}

	public void setIdEstadoTransaccion(Integer idEstadoTransaccion) {
		this.idEstadoTransaccion = idEstadoTransaccion;
	}

	public TarjetaDTO getTarjetaDTO() {
		return tarjetaDTO;
	}

	public void setTarjetaDTO(TarjetaDTO tarjetaDTO) {
		this.tarjetaDTO = tarjetaDTO;
	}

	public EstadoTransaccionDTO getEstadoTransaccionDTO() {
		return estadoTransaccionDTO;
	}

	public void setEstadoTransaccionDTO(EstadoTransaccionDTO estadoTransaccionDTO) {
		this.estadoTransaccionDTO = estadoTransaccionDTO;
	}



}
