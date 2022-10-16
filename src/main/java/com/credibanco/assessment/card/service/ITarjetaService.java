package com.credibanco.assessment.card.service;

import java.util.List;

import com.credibanco.assessment.card.dto.TarjetaDTO;

public interface ITarjetaService {
	public List<TarjetaDTO> findAll();

	public TarjetaDTO save(TarjetaDTO tarjetaDto);

	public TarjetaDTO findByPan(Long pan);
	
	public boolean delete(Long pan, Integer numVal);
}
