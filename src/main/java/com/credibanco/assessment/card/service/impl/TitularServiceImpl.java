package com.credibanco.assessment.card.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.dto.TitularDTO;
import com.credibanco.assessment.card.model.entity.Titular;
import com.credibanco.assessment.card.repository.ITitularRepository;
import com.credibanco.assessment.card.service.ITitularService;

@Service
public class TitularServiceImpl implements ITitularService {

	@Autowired
	private ITitularRepository titularRepository;

	@Override
	public List<TitularDTO> findAll() {
		return entityListToDtoList((List<Titular>) titularRepository.findAll());
	}

	@Override
	public TitularDTO save(TitularDTO titularDTO) {
		return entityToDto(titularRepository.save(dtoToEntity(titularDTO)));
	}

	public TitularDTO entityToDto(Titular titular) {
		if (titular != null) {
			TitularDTO titularDTO = new TitularDTO();
			titularDTO.setId(titular.getId());
			titularDTO.setCedula(titular.getCedula());
			titularDTO.setNombres(titular.getNombres());
			titularDTO.setApellido(titular.getApellido());
			titularDTO.setTelefono(titular.getTelefono());
			return titularDTO;
		} else
			return null;
	}

	public Titular dtoToEntity(TitularDTO titularDTO) {
		if (titularDTO != null) {
			Titular titular = new Titular();
			titular.setId(titularDTO.getId());
			titular.setCedula(titularDTO.getCedula());
			titular.setNombres(titularDTO.getNombres());
			titular.setApellido(titularDTO.getApellido());
			titular.setTelefono(titularDTO.getTelefono());
			return titular;
		} else
			return null;
	}

	private List<TitularDTO> entityListToDtoList(List<Titular> titularList) {
		return titularList.stream().map(this::entityToDto).collect(Collectors.toCollection(ArrayList::new));
	}

}
