package com.credibanco.assessment.card.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TARJETAS", schema = "HR")
public class Tarjeta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TARJTS_SEQ")
	@SequenceGenerator(sequenceName = "TARJETAS_SEQ", allocationSize = 1, name = "TARJTS_SEQ")
	@Column(name = "id_tarjeta")
	private Long id;

	@Column(name = "numero_validacion")
	private Integer numValidacion;

	@Column(name = "estado")
	private String estado;

	//@NotEmpty
	//@Digits(integer = 16, fraction = 0, message = "Número de la tarjeta – 16 a 19 dígitos")
	@Column(name = "pan")
	private Long pan;

	@Column(name = "id_titular")
	private Integer idTitular;

	@Column(name = "id_tipo")
	private Integer idTipo;

	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Column(name = "fecha_vencimiento")
	private Date fechaVencimiento;

	@OneToOne
	@JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo", insertable = false, updatable = false)
	private Tipo tipo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_titular", referencedColumnName = "id_titular", insertable = false, updatable = false)
	private Titular titular;

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

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}

}
