package com.credibanco.assessment.card.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TRANSACCIONES", schema = "HR")
public class Transaccion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSCCNS_SEQ")
	@SequenceGenerator(sequenceName = "TRANSACCIONES_SEQ", allocationSize = 1, name = "TRANSCCNS_SEQ")
	@Column(name = "id_transaccion")
	private Long id;

	@Column(name = "id_tarjeta")
	private Integer idTarjeta;

	//@NotEmpty
	@Digits(integer = 6, fraction = 0, message = "número de referencia 6 dígitos")
	@Column(name = "numero_referencia")
	private Integer numeroReferencia;

	@Column(name = "total_compra")
	private Integer totalCompra;

	@Column(name = "direccion_compra")
	private String direccionCompra;

	@Column(name = "fecha_transaccion")
	private Date fechaTransaccion;

	@Column(name = "id_estado_transaccion")
	private Integer idEstadoTransaccion;

	/*
	@OneToOne
	@JoinColumn(name = "id_tarjeta", referencedColumnName = "id_tarjeta", insertable = false, updatable = false)
	private Tarjeta tarjeta;

	@OneToOne
	@JoinColumn(name = "id_estado_transaccion", referencedColumnName = "id_estado_transaccion", insertable = false, updatable = false)
	private EstadoTransaccion estadoTransaccion;
*/
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

	/*
	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public EstadoTransaccion getEstadoTransaccion() {
		return estadoTransaccion;
	}

	public void setEstadoTransaccion(EstadoTransaccion estadoTransaccion) {
		this.estadoTransaccion = estadoTransaccion;
	}*/

}
