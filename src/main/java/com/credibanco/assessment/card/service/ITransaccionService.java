package com.credibanco.assessment.card.service;

import java.util.List;

import com.credibanco.assessment.card.dto.TransaccionDTO;

public interface ITransaccionService {
	public List<TransaccionDTO> findAll();

	public TransaccionDTO save(TransaccionDTO transaccion);
	
	public TransaccionDTO findByNumeroReferencia(Integer numRef);
}
