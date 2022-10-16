package com.credibanco.assessment.card.service;

import java.util.List;

import com.credibanco.assessment.card.dto.TitularDTO;

public interface ITitularService {
	public List<TitularDTO> findAll();

	public TitularDTO save(TitularDTO titularDTO);
}
