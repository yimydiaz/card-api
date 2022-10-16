package com.credibanco.assessment.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.card.api.client.TitularApiClient;
import com.credibanco.assessment.card.dto.TitularDTO;
import com.credibanco.assessment.card.service.ITitularService;

@CrossOrigin
@RestController
@RequestMapping("api/titular")
public class TitularController {

	@Autowired
	private ITitularService titularService;

	@Autowired
	private TitularApiClient titularApiClient;

	@GetMapping("titulares")
	public ResponseEntity<List<TitularDTO>> retornoBusquedaTitular() {
		return titularApiClient.retornoBusquedaTitular();
	}

	@PostMapping
	public ResponseEntity<TitularDTO> crearTitular(@RequestBody TitularDTO titular) {
		return new ResponseEntity<>(titularService.save(titular), HttpStatus.OK);
	}
}
