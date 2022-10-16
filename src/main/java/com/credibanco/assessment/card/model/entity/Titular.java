package com.credibanco.assessment.card.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TITULAR", schema = "HR")
public class Titular implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TITLR_SEQ")
	@SequenceGenerator(sequenceName = "titular_SEQ", allocationSize = 1, name = "TITLR_SEQ")
	@Column(name = "id_titular")
	private Long id;

	@NotEmpty
	@Size(min = 10, max = 15, message = "cédula 10 a 15 caracteres")
	@Column(name = "cedula")
	private String cedula;

	@Column(name = "nombres")
	private String nombres;

	@Column(name = "apelido")
	private String apellido;

	@Digits(integer = 10, fraction = 0, message = "teléfono 10 dígitos")
	@Column(name = "telefono")
	private Long telefono;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
}
