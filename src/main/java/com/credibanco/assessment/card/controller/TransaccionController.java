package com.credibanco.assessment.card.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.card.dto.RespuestaDTO;
import com.credibanco.assessment.card.dto.TransaccionDTO;
import com.credibanco.assessment.card.service.ITransaccionService;
import com.credibanco.assessment.card.util.Constants;
import com.credibanco.assessment.card.util.EstadoRespuesta;

@CrossOrigin
@RestController
@RequestMapping("/transacciones")
public class TransaccionController {

	@Autowired
	private ITransaccionService transaccionService;

	@GetMapping("transacciones")
	public ResponseEntity<RespuestaDTO<List<TransaccionDTO>>> retornoBusquedaTransaccion() {

		RespuestaDTO<List<TransaccionDTO>> respuesta;
		try {
			respuesta = new RespuestaDTO<>(EstadoRespuesta.OK, transaccionService.findAll());
		} catch (Exception e) {
			respuesta = new RespuestaDTO<>(EstadoRespuesta.ERROR_SOLICITUD_RESPUESTA, e);
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(respuesta, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<RespuestaDTO<TransaccionDTO>> crearTransaccion(@RequestBody TransaccionDTO transaccion) {
		RespuestaDTO<TransaccionDTO> respuesta;
		try {
			respuesta = new RespuestaDTO<>(EstadoRespuesta.EXITOSO, transaccionService.save(transaccion));
		} catch (Exception e) {
			respuesta = new RespuestaDTO<>(EstadoRespuesta.FALLIDO, e.getCause().getCause().getLocalizedMessage());
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<RespuestaDTO<TransaccionDTO>> anularTransaccion(@RequestBody TransaccionDTO transaccion) {
		RespuestaDTO<TransaccionDTO> respuesta;
		Long cincoMinutos = 5 * 60 * 1000l;
		try {
			transaccion = transaccionService.findByNumeroReferencia(transaccion.getNumeroReferencia());
			if (cincoMinutos < new Date().getTime() - transaccion.getFechaTransaccion().getTime()) {
				respuesta = new RespuestaDTO<>(EstadoRespuesta.NO_ANULA_TRANSACC);
				return new ResponseEntity<>(respuesta, HttpStatus.OK);
			}
			transaccion.setIdEstadoTransaccion(Constants.TRANSACCIONES_ANULADA);
			respuesta = new RespuestaDTO<>(EstadoRespuesta.EXITOSO, transaccionService.save(transaccion));
		} catch (Exception e) {
			respuesta = new RespuestaDTO<>(EstadoRespuesta.FALLIDO, e);
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
	}
}
