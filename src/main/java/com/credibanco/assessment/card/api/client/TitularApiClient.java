package com.credibanco.assessment.card.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.credibanco.assessment.card.dto.TitularDTO;

@FeignClient(name = "titulares", url = "${titulares.api.url}")
public interface TitularApiClient {

	@GetMapping(value = "/titulares/titulares")
	public @ResponseBody ResponseEntity<List<TitularDTO>> retornoBusquedaTitular();

}
