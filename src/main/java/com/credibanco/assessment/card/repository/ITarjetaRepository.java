package com.credibanco.assessment.card.repository;

import org.springframework.data.repository.CrudRepository;

import com.credibanco.assessment.card.model.entity.Tarjeta;

public interface ITarjetaRepository extends CrudRepository<Tarjeta, Long> {

	Tarjeta findByPan(Long pan);

}
