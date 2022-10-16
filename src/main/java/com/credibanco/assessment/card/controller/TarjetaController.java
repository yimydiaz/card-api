package com.credibanco.assessment.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.card.dto.RespuestaDTO;
import com.credibanco.assessment.card.dto.TarjetaDTO;
import com.credibanco.assessment.card.service.ITarjetaService;
import com.credibanco.assessment.card.util.EstadoRespuesta;

@CrossOrigin
@RestController
@RequestMapping("/tarjetas")
public class TarjetaController {

	@Autowired
	private ITarjetaService tarjetaService;

	@GetMapping("tarjeta")
	public ResponseEntity<RespuestaDTO<List<TarjetaDTO>>> retornoBusquedaTarjeta() {
		RespuestaDTO<List<TarjetaDTO>> respuesta;
		try {
			respuesta = new RespuestaDTO<>(EstadoRespuesta.OK, tarjetaService.findAll());
		} catch (Exception e) {
			respuesta = new RespuestaDTO<>(EstadoRespuesta.ERROR_SOLICITUD_RESPUESTA, e);
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<RespuestaDTO<TarjetaDTO>> crearTarjeta(@RequestBody TarjetaDTO tarjeta) {
		RespuestaDTO<TarjetaDTO> respuesta;
		try {
			respuesta = new RespuestaDTO<>(EstadoRespuesta.EXITOSO, tarjetaService.save(tarjeta));
		} catch (Exception e) {
			respuesta = new RespuestaDTO<>(EstadoRespuesta.FALLIDO, e.getCause().getCause().getLocalizedMessage());
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
	}

	@PutMapping("enrolar")
	public ResponseEntity<RespuestaDTO<TarjetaDTO>> enrolarTarjeta(@RequestBody TarjetaDTO tarjeta) {
		RespuestaDTO<TarjetaDTO> respuesta = null;
		int numeroVal = tarjeta.getNumValidacion().intValue();
		try {
			tarjeta = tarjetaService.findByPan(tarjeta.getPan());
			if (tarjeta != null && tarjeta.getNumValidacion().equals(numeroVal)) {
				respuesta = new RespuestaDTO<>(EstadoRespuesta.EXITOSO, tarjetaService.save(tarjeta));
			}
		} catch (Exception e) {
			respuesta = new RespuestaDTO<>(EstadoRespuesta.FALLIDO);
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (tarjeta == null) {
			respuesta = new RespuestaDTO<>(EstadoRespuesta.NO_TARJETA);
			return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
		} else if (!tarjeta.getNumValidacion().equals(numeroVal)) {
			respuesta = new RespuestaDTO<>(EstadoRespuesta.NUMEROVAL_INVALIDO);
			return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
	}

	@GetMapping("gettarjeta/{pan}")
	public ResponseEntity<RespuestaDTO<TarjetaDTO>> consultarTarjeta(@PathVariable("pan") Long pan) {
		RespuestaDTO<TarjetaDTO> respuesta;
		try {
			respuesta = new RespuestaDTO<>(EstadoRespuesta.OK, tarjetaService.findByPan(pan));
		} catch (Exception e) {
			respuesta = new RespuestaDTO<>(EstadoRespuesta.ERROR_SOLICITUD_RESPUESTA);
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<RespuestaDTO<?>> eliminarTarjeta(@RequestBody TarjetaDTO tarjeta) {
		RespuestaDTO<?> respuesta;
		try {
			respuesta = new RespuestaDTO<>(EstadoRespuesta.OK,
					tarjetaService.delete(tarjeta.getPan(), tarjeta.getNumValidacion()));
		} catch (Exception e) {
			respuesta = new RespuestaDTO<>(EstadoRespuesta.ERROR_SOLICITUD_RESPUESTA);
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(respuesta, HttpStatus.OK);

	}
}
