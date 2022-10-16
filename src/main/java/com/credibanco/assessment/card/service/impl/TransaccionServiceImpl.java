package com.credibanco.assessment.card.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.dto.EstadoTransaccionDTO;
import com.credibanco.assessment.card.dto.TransaccionDTO;
import com.credibanco.assessment.card.model.entity.EstadoTransaccion;
import com.credibanco.assessment.card.model.entity.Transaccion;
import com.credibanco.assessment.card.repository.IEstadoTransaccionRepository;
import com.credibanco.assessment.card.repository.ITarjetaRepository;
import com.credibanco.assessment.card.repository.ITransaccionRepository;
import com.credibanco.assessment.card.service.ITransaccionService;
import com.credibanco.assessment.card.util.Constants;

@Service
public class TransaccionServiceImpl implements ITransaccionService {

	@Autowired
	private ITransaccionRepository transaccionRepository;

	@Autowired
	private ITarjetaRepository tarjetaRepository;

	@Autowired
	IEstadoTransaccionRepository estadoTransaccionRepository;

	@Override
	public List<TransaccionDTO> findAll() {
		return entityListToDtoList((List<Transaccion>) transaccionRepository.findAll());
	}

	@Override
	public TransaccionDTO save(TransaccionDTO transaccionDto) {
		transaccionDto.setFechaTransaccion(
				transaccionDto.getId() == null ? new Date() : transaccionDto.getFechaTransaccion());
		transaccionDto.setIdEstadoTransaccion(transaccionDto.getId() == null ? Constants.TRANSACCIONES_APROBADA
				: transaccionDto.getIdEstadoTransaccion());
		transaccionDto.setIdTarjeta(tarjetaRepository.findByPan(transaccionDto.getTarjetaDTO().getPan()).getEstado()
				.equals(Constants.ESTADO_ENROLADA)
						? tarjetaRepository.findByPan(transaccionDto.getTarjetaDTO().getPan()).getId().intValue()
						: null);
		transaccionDto.setIdEstadoTransaccion(transaccionDto.getIdTarjeta() == null ? Constants.TRANSACCIONES_RECHAZADA
				: transaccionDto.getIdEstadoTransaccion());
		return entityToDto(transaccionRepository.save(dtoToEntity(transaccionDto)));
	}

	@Override
	public TransaccionDTO findByNumeroReferencia(Integer numRef) {
		return entityToDto(transaccionRepository.findByNumeroReferencia(numRef));
	}

	private TransaccionDTO entityToDto(Transaccion transaccion) {
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		transaccionDTO.setId(transaccion.getId());
		transaccionDTO.setIdTarjeta(transaccion.getIdTarjeta());
		transaccionDTO.setNumeroReferencia(transaccion.getNumeroReferencia());
		transaccionDTO.setIdEstadoTransaccion(transaccion.getIdEstadoTransaccion());
		transaccionDTO.setDireccionCompra(transaccion.getDireccionCompra());
		transaccionDTO.setTotalCompra(transaccion.getTotalCompra());
		transaccionDTO.setFechaTransaccion(transaccion.getFechaTransaccion());
		transaccionDTO.setTarjetaDTO(new TarjetaServiceImpl()
				.entityToDto(tarjetaRepository.findById(transaccion.getIdTarjeta().longValue()).orElse(null)));
		transaccionDTO.setEstadoTransaccionDTO(entityToDtoestadoTransaccion(
				estadoTransaccionRepository.findById(transaccion.getIdEstadoTransaccion().longValue()).orElse(null)));
		return transaccionDTO;
	}

	private Transaccion dtoToEntity(TransaccionDTO transaccionDTO) {
		Transaccion transaccion = new Transaccion();
		transaccion.setId(transaccionDTO.getId());
		transaccion.setIdTarjeta(transaccionDTO.getIdTarjeta());
		transaccion.setNumeroReferencia(transaccionDTO.getNumeroReferencia());
		transaccion.setIdEstadoTransaccion(transaccionDTO.getIdEstadoTransaccion());
		transaccion.setDireccionCompra(transaccionDTO.getDireccionCompra());
		transaccion.setTotalCompra(transaccionDTO.getTotalCompra());
		transaccion.setFechaTransaccion(transaccionDTO.getFechaTransaccion());
		// transaccion.setTarjeta(new
		// TarjetaServiceImpl().dtoToEntity(transaccionDTO.getTarjetaDTO()));
		// transaccion.setEstadoTransaccion(dtoToEntityestadoTransaccion(transaccionDTO.getEstadoTransaccionDTO()));
		return transaccion;
	}

	private List<TransaccionDTO> entityListToDtoList(List<Transaccion> TransaccionList) {
		return TransaccionList.stream().map(this::entityToDto).collect(Collectors.toCollection(ArrayList::new));
	}

	private EstadoTransaccionDTO entityToDtoestadoTransaccion(EstadoTransaccion estadoTransaccion) {
		if (estadoTransaccion != null) {
			EstadoTransaccionDTO estadoTransaccionDTO = new EstadoTransaccionDTO();
			estadoTransaccionDTO.setId(estadoTransaccion.getId());
			estadoTransaccionDTO.setEstado(estadoTransaccion.getEstado());
			return estadoTransaccionDTO;
		} else
			return null;
	}

	private EstadoTransaccion dtoToEntityestadoTransaccion(EstadoTransaccionDTO estadoTransaccionDTO) {
		if (estadoTransaccionDTO != null) {
			EstadoTransaccion estadoTransaccion = new EstadoTransaccion();
			estadoTransaccion.setId(estadoTransaccionDTO.getId());
			estadoTransaccion.setEstado(estadoTransaccionDTO.getEstado());
			return estadoTransaccion;
		} else
			return null;
	}
}
