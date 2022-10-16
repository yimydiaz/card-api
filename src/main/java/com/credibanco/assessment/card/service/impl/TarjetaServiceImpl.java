package com.credibanco.assessment.card.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.dto.TarjetaDTO;
import com.credibanco.assessment.card.dto.TipoDTO;
import com.credibanco.assessment.card.model.entity.Tarjeta;
import com.credibanco.assessment.card.model.entity.Tipo;
import com.credibanco.assessment.card.repository.ITarjetaRepository;
import com.credibanco.assessment.card.service.ITarjetaService;
import com.credibanco.assessment.card.util.Constants;
import com.credibanco.assessment.card.util.Util;

@Service
public class TarjetaServiceImpl implements ITarjetaService {

	@Autowired
	private ITarjetaRepository tarjetaRepository;

	@Override
	public List<TarjetaDTO> findAll() {
		return entityListToDtoList((List<Tarjeta>) tarjetaRepository.findAll());
	}

	@Override
	public TarjetaDTO findByPan(Long pan) {
		return entityToDto(tarjetaRepository.findByPan(pan));
	}

	@Override
	public TarjetaDTO save(TarjetaDTO tarjetaDto) {
		tarjetaDto.setEstado(tarjetaDto.getId() == null ? Constants.ESTADO_CREADA : Constants.ESTADO_ENROLADA);
		tarjetaDto.setNumValidacion(
				tarjetaDto.getId() == null ? Util.generarNumeroAzar() : tarjetaDto.getNumValidacion());
		Tarjeta tarjeta = tarjetaRepository.save(dtoToEntity(tarjetaDto));
		tarjeta.setIdTitular(tarjeta.getTitular().getId().intValue());
		return entityToDto(tarjetaRepository.save(tarjeta));

	}

	@Override
	public boolean delete(Long pan, Integer numVal) {
		try {
			tarjetaRepository.deleteById(tarjetaRepository.findByPan(pan).getId());
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public TarjetaDTO entityToDto(Tarjeta tarjeta) {
		TarjetaDTO tarjetaDTO = new TarjetaDTO();
		tarjetaDTO.setId(tarjeta.getId());
		tarjetaDTO.setNumValidacion(tarjeta.getNumValidacion());
		tarjetaDTO.setEstado(tarjeta.getEstado());
		tarjetaDTO.setPan(tarjeta.getPan());
		tarjetaDTO.setPanMask(Util.enmascararNumero(tarjeta.getPan()));
		tarjetaDTO.setIdTitular(tarjeta.getIdTitular());
		tarjetaDTO.setIdTipo(tarjeta.getIdTipo());
		tarjetaDTO.setFechaCreacion(tarjeta.getFechaCreacion());
		tarjetaDTO.setFechaVencimiento(tarjeta.getFechaVencimiento());
		tarjetaDTO.setTitularDTO(new TitularServiceImpl().entityToDto(tarjeta.getTitular()));
		tarjetaDTO.setTipoDTO(entityToDtoTipo(tarjeta.getTipo()));
		return tarjetaDTO;
	}

	public Tarjeta dtoToEntity(TarjetaDTO tarjetaDTO) {
		Tarjeta tarjeta = new Tarjeta();
		tarjeta.setId(tarjetaDTO.getId());
		tarjeta.setNumValidacion(tarjetaDTO.getNumValidacion());
		tarjeta.setEstado(tarjetaDTO.getEstado());
		tarjeta.setPan(tarjetaDTO.getPan());
		tarjeta.setIdTitular(tarjetaDTO.getIdTitular());
		tarjeta.setIdTipo(tarjetaDTO.getIdTipo());
		tarjeta.setFechaCreacion(tarjetaDTO.getFechaCreacion());
		tarjeta.setFechaVencimiento(tarjetaDTO.getFechaVencimiento());
		tarjeta.setTitular(new TitularServiceImpl().dtoToEntity(tarjetaDTO.getTitularDTO()));
		tarjeta.setTipo(dtoToEntityTipo(tarjetaDTO.getTipoDTO()));
		return tarjeta;
	}

	private List<TarjetaDTO> entityListToDtoList(List<Tarjeta> tarjetaList) {
		return tarjetaList.stream().map(this::entityToDto).collect(Collectors.toCollection(ArrayList::new));
	}

	private TipoDTO entityToDtoTipo(Tipo tipo) {
		if (tipo != null) {
			TipoDTO tipoDTO = new TipoDTO();
			tipoDTO.setId(tipo.getId());
			tipoDTO.setTipo(tipo.getTipo());
			return tipoDTO;
		} else
			return null;
	}

	private Tipo dtoToEntityTipo(TipoDTO tipoDTO) {
		if (tipoDTO != null) {
			Tipo tipo = new Tipo();
			tipo.setId(tipoDTO.getId());
			tipo.setTipo(tipoDTO.getTipo());
			return tipo;
		} else
			return null;
	}

}
